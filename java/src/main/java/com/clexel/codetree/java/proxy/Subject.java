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

/**
 * 代理模式中的抽象主题对象
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 18:14
 * @since 1.0.0+
 */
public interface Subject {

    /**
     * 方法无具体含义,为了测试参数及返回值类型
     * @param name String
     * @return Subject
     */
    Subject request(String name);

    /**
     * 方法无具体含义,为了测试方法的返回值
     * @return String
     */
    String getTime();

    /**
     * 方法无具体含义,为了测试方法无返回值
     */
    void test();

}
