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

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分三个线程依次打印abc
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/19 15:41
 * @since 1.0.0+
 */
public class LockPrint1 {

    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();


    private static int count =0;


    static class ThreadA extends Thread {
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count%3!=0) {
                        a.await();
                    }
                    System.out.print("A");
                    count++;
                    b.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count%3!=1) {
                        b.await();
                    }
                    System.out.print("B");
                    count++;
                    c.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count%3!=2) {
                        c.await();
                    }
                    System.out.print("C");
                    count++;
                    a.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadB().start();
        new ThreadA().start();
        new ThreadC().start();
    }
}
