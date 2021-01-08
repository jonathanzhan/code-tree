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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理调用测试
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 18:25
 * @since 1.0.0+
 */
public class HandlerTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new ProxyHandler(subject);
        Class<?> clazz = subject.getClass();
        Subject proxy = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),handler);
        proxy.request("name").getTime();
        proxy.test();
        System.out.println("代理对象的类型为:"+ proxy.getClass().getName());
        System.out.println(Proxy.getProxyClass(clazz.getClassLoader(), clazz.getInterfaces()));
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
        System.out.println(Proxy.getInvocationHandler(proxy));
    }
}
