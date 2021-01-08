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
 * 锁的粗化和锁消除
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/28 12:02
 * @since 1.0.0+
 */
public class LockCoarseningAndElimination {
    private static Object object = new Object();
    public static void main(String[] args) {
        synchronized(object) {
            System.out.println("");
        }
        synchronized(object) {
            System.out.println("");
        }
        synchronized(object) {
            System.out.println("");
        }
        // 以上三个同步块，JVM的流程大概是获取Object对象锁，执行方法，释放锁，然后再获取锁，执行，释放，完全可以在一个加锁解锁里面，执行所有的方法，如下
        synchronized(object) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }


    public void method1() {
        //Object1是在方法内部定义的，只能被当前线程访问，并不会被其他线程所竞争，因此这个加锁是没有意义的
        // jvm通过逃逸分析，发现锁没有用的时候，会把当前锁消除掉
        Object object1 = new Object();
        synchronized (object1) {
            System.out.println("");
        }
    }

}
