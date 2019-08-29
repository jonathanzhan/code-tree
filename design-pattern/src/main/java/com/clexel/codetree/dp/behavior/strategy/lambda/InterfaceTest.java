/*
 * Copyright  2014-2019 zhan.chang@outlook.com(Jonathan)
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

package com.clexel.codetree.dp.behavior.strategy.lambda;

import org.junit.Test;

/**
 * 自定义lambda测试
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/6/12 16:02
 * @since 1.0.0+
 */
public class InterfaceTest {


    public void fun(Interface1 interface1) {
        interface1.method();
    }

    @Test
    public void test1() {
        fun(()-> System.out.println("test"));
    }

    public int fun(Interface2 interface2) {
        return interface2.method(2);
    }


    @Test
    public void test2() {
        int i = fun(x->x*2);
        System.out.println(i);
    }

    public void fun3(Interface3 interface3) {
        interface3.method(2);
    }

    @Test
    public void test3() {
        fun3((x) -> System.out.println(x));
    }
}
