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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 结果小于等于10000
 * 多线程共享资源的不安全性
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/23 16:00
 * @since 1.0.0+
 */
public class MultiThreadAndUnsafe {

    private static int total = 0;

    private static Object object = new Object();

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    // 让所有线程等待，等其他线程创建好了，一起执行total++
                    countDownLatch.await();
                    for (int j = 0; j < 1000; j++) {
                        total++;
                        // 安全性 JVM内置锁，隐式锁，加锁 解锁是JVM自己处理的
//                        synchronized(object) {
//                            total++;
//                        }
                        // 显式锁 互斥锁
//                        try {
//                            lock.lock();
//                            total++;
//                        }catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } finally {
//                            lock.unlock();
//                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        Thread.sleep(500);
        // 所有线程起跑，进行total++
        countDownLatch.countDown();
        Thread.sleep(20000);
        System.out.println(total);
    }
}
