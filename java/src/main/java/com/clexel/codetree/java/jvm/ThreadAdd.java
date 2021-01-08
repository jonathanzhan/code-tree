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

package com.clexel.codetree.java.jvm;

import java.util.concurrent.CountDownLatch;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/14 19:26
 * @since 1.0.0+
 */
public class ThreadAdd {

    private static int total = 0;


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i =0; i<10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    for (int j = 0; j < 10; j++) {
                        total++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);
        countDownLatch.countDown();
        Thread.sleep(2000);
        System.out.println(total);

    }
}
