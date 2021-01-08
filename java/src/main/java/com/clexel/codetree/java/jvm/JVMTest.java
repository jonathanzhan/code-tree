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

/**
 * JVM内存模型实例代码
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/4 19:39
 * @since 1.0.0+
 */
public class JVMTest {

    public static final int data = 100;

    public int compute() {
        int a = 1;
        int b = 2;
        int c = a*b;
        return c;
    }

    public static void main(String[] args) {
        JVMTest jvmTest = new JVMTest();
        jvmTest.compute();
    }
}
