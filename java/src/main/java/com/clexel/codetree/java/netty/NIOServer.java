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
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO模型
 * 同步非阻塞，服务器实现方式为一个线程可以处理多个请求(连接)，客户端发送的请求都会注册到多路复用器selector上，多路复用器轮询到连接有IO请求就进行处理
 * NIO方式用于客户端链接多，且比较短的架构，比如聊天服务器，弹幕系统，服务器之间通讯
 * NIO有三大核心组件  buffer(缓冲区) channel(通道) selector(选择器)
 * channel类似于流，每个channel对应一个缓冲区，buffer底层就是一个数组
 * channel会注册到selector上，由selector根据channel读写事件的发生将其交由某个空闲的线程处理
 * selector对应一个或者多个线程
 * NIO的buffer和channel都是既可以读也可以写
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/18 15:03
 * @since 1.0.0+
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建一个在本地端口进行监听的服务socker通道，并设置为非阻塞
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 必须配置为非阻塞才能往selector上注册，否则会报错，selector模式本身就是非阻塞的
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(9000));
        // 创建一个selector选择器
        Selector selector = Selector.open();
        // 把serverSockerChannnel注册到selector上，并且selector对客户端的accept链接操作感兴趣
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("等待事件发生。。");
            // 轮询监听channel里的key，select是阻塞的，accept也是阻塞的
            int select = selector.select();
            System.out.println("有事件发生了。");
            // 有客户端请求，被轮询监听到
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while(it.hasNext()) {
                SelectionKey selectionKey = it.next();
                // 删除本次已经处理的key，防止下次selector重复轮询
                it.remove();
                handle(selectionKey);
            }
        }
    }

    private static void handle(SelectionKey key) throws IOException {
        if(key.isAcceptable()) {
            System.out.println("有客户端链接事件发生。");
            ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
            // NIO非阻塞体现：此处accept是阻塞的，但是因为这里发生了链接事件，所以这个方法会马上执行完，不会阻塞
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            // 通过selector监听channel对读事件感兴趣
            sc.register(key.selector(),SelectionKey.OP_READ);
        } else if(key.isReadable()) {
            System.out.println("有客户端数据可读事件发生");
            SocketChannel sc =(SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //NIO非阻塞体现:首先read方法不会阻塞，其次这种事件响应模型，当调用到read方法时肯定是发生了客户端发送数据的事件
            int len = sc.read(buffer);
            if (len!=-1) {
                System.out.println("读取到客户端发送的数据:"+new String(buffer.array(),0,len));
            }
            ByteBuffer bufferWrite = ByteBuffer.wrap("hello client".getBytes());
            sc.write(bufferWrite);
            key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
        } else if(key.isWritable()) {
            System.out.println("WRITE事件发生");
            // NIO事件触发是水平触发
            // 使用Java的NIO编程的时候，在没有数据可以往外写的时候要取消写事件，
            // 在有数据往外写的时候再注册写事件
            key.interestOps(SelectionKey.OP_READ);
        }
    }

}
