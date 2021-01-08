/*
 * Copyright  2014-2020 jonathan.zhan.chang@gmail.com(Jonathan)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clexel.codetree.java.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/18 15:30
 * @since 1.0.0+
 */
public class NIOClient {
    // 选择器
    private Selector selector;

    public static void main(String[] args) throws IOException {
        NIOClient client = new NIOClient();
        client.initClient("127.0.0.1",9000);
        client.connect();
    }

    private void connect() throws IOException {
        while (true) {
            selector.select();
            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            while ((it.hasNext())) {
                SelectionKey key = it.next();
                it.remove();
                // 连接事件发生
                if(key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 如果正在连接，则完成连接
                    if(channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    //设置为非阻塞
                    channel.configureBlocking(false);
                    //发送消息
                    ByteBuffer buffer = ByteBuffer.wrap("helloserver".getBytes());
                    channel.write(buffer);
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    channel.register(this.selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    read(key);
                }
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = channel.read(buffer);
        if(len!=-1) {
            System.out.println("客户端收到信息："+new String(buffer.array(),0,len));
        }
    }

    private void initClient(String ip, int port) throws IOException {
        // 获取一个socket通道
        SocketChannel channel = SocketChannel.open();
        // 设置通道为非阻塞
        channel.configureBlocking(false);
        // 获取一个通道管理器
        this.selector = Selector.open();
        //客户端链接，方法并没有实现链接，需要再listen()方法中调用channel.finishConnect()才能完成链接
        channel.connect(new InetSocketAddress(ip,port));
        channel.register(selector, SelectionKey.OP_CONNECT);
    }


}
