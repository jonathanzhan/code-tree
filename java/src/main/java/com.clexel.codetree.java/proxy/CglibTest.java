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

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * cglib动态代理测试类
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/30 11:37
 * @since 1.0.0+
 */
public class CglibTest {
    public static void main(String[] args) {
        // 设置编译文件的存放路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/jonathan/code/test");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(CglibService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibMethodInterceptor());
        // 创建代理对象
        CglibService service = (CglibService) enhancer.create();
        service.test1();
        service.test2();

    }
}
