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
 * 线程死锁，比如线程1拥有资源A，线程2拥有资源B，他们都想申请对方拥有的资源。，从而相互等待，进入死锁状态
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/16 14:34
 * @since 1.0.0+
 */
public class DeadLockDemo {
    /**
     * 资源1
     */
    private static Object resource1 = new Object();

    /**
     * 资源2
     */
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized(resource1){
                System.out.println(Thread.currentThread()+"get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting get resource2");
                synchronized(resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        },"线程1").start();

        new Thread(()->{
            synchronized(resource2){
                System.out.println(Thread.currentThread()+"get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get resource1");
                }
            }
        },"线程2").start();
    }
}
