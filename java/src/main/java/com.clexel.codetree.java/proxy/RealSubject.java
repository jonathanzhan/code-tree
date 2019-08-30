/*
 * Copyright  2014-2019 jonathan.zhan.chang@gmail.com(Jonathan)
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

package com.clexel.codetree.java.proxy;

import java.util.Date;

/**
 * 具体实现
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 18:17
 * @since 1.0.0+
 */
public class RealSubject implements Subject {
    /**
     * 方法无具体含义,为了测试参数及返回值类型
     *
     * @param name String
     * @return Subject
     */
    @Override
    public Subject request(String name) {
        System.out.println("调用request方法");
        return this;
    }

    /**
     * 方法无具体含义,为了测试方法的返回值
     *
     * @return String
     */
    @Override
    public String getTime() {
        System.out.println("调用getTime方法");
        return new Date().toString();
    }

    /**
     * 方法无具体含义,为了测试方法无返回值
     */
    @Override
    public void test() {
        System.out.println("调用test方法");
    }
}
