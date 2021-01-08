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


import org.junit.Test;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/17 19:25
 * @since 1.0.0+
 */
public class SynchronizedTest {
    public static int num =0;

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread,"thread1");
        Thread thread2 = new Thread(syncThread,"thread2");
        thread1.start();
        thread2.start();
    }




}
