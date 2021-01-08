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

import java.util.concurrent.Callable;

/**
 * 实现callable接口创建线程
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/16 15:15
 * @since 1.0.0+
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+ "call()方法正在执行");
        return 1;
    }
}
