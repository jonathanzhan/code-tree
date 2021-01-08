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
import java.net.Socket;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/18 14:36
 * @since 1.0.0+
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        //创建链接
        Socket socket = new Socket("localhost",9000);
        //发送数据
        socket.getOutputStream().write("hello server".getBytes());
        socket.getOutputStream().flush();
        //
        System.out.println("向服务器端发数据结束");
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        System.out.println("服务端返回数据:"+new String(bytes));
        socket.close();
    }
}
