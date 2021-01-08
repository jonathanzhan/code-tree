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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * executor创建线程池
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/16 15:21
 * @since 1.0.0+
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            executorService.execute(myRunnable);
        }
        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }
}
