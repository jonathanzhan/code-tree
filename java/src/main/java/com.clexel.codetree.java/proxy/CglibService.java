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
 * 业务类,注意没有实现任何接口
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/30 11:22
 * @since 1.0.0+
 */
public class CglibService {

    public CglibService() {
        System.out.println("CglibService构造函数");
    }

    public void test1() {
        System.out.println("CglibService:test1");
    }

    final public String test2() {
        System.out.println("CglibService:test2");
        return null;
    }
}
