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
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO demo
 * BIO线程模型 每个客户端对应一个线程，是同步阻塞模型
 * 缺点：IO代码里read操作是阻塞操作，如果连接不做读写操作，那么会导致线程阻塞，浪费资源
 * 如果客户端多的话，会导致服务器线程多，压力大
 * 应用场景：BIO方式用于连接数据比较小且固定的架构，这种方式对服务器资源要求比较高。
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/18 14:27
 * @since 1.0.0+
 */
public class BIOSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("有客户端链接");
            new Thread(()->{
                try {
                    handler(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    private static void handler(Socket socket) throws IOException {
        System.out.println("thread id="+Thread.currentThread().getId());
        byte[] bytes = new byte[1024];
        System.out.println("准备read..");
        int read = socket.getInputStream().read(bytes);
        if(read!=-1) {
            System.out.println("读取到客户端数据："+new String(bytes,0,read));
            System.out.println("thread id="+Thread.currentThread().getId());
        }
        socket.getOutputStream().write("HelloClient".getBytes());
        socket.getOutputStream().flush();
    }
}
