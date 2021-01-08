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

package com.clexel.codetree.java.thread;

/**
 * 分三个线程依次打印ABC
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/19 15:28
 * @since 1.0.0+
 */
public class LockPrint {
    public static class ThreadPrinter implements Runnable {

        private String name;

        private Object pre;

        private Object self;

        private ThreadPrinter(String name, Object pre, Object self) {
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count>0) {
                synchronized (pre){
                    synchronized (self) {
                        System.out.println(name);
                        count--;
                        self.notifyAll();
                    }
                    try{
                        if(count==0) {
                            pre.notifyAll();
                        } else {
                            pre.wait();
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);
        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pc).start();

    }
}
