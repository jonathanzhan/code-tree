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

package com.clexel.codetree.dp.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 事件管理器,代理类的调用程序
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 11:14
 * @since 1.0.0+
 */
public class DynamicProxy implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private Object target;

    /**
     * 构造函数
     * @param target 真实对象
     */
    public DynamicProxy(Object target) {
        super();
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理的类(真实代理对象)
     * @param method 被代理的类的方法
     * @param args 方法的参数列表
     * @return 代理对象方法的返回结果或者真实代理对象(com.sun.proxy.$Proxy0)
     * @throws Throwable Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 动态代理");
        method.invoke(target, args);
        System.out.println("after 动态代理");
        return null;
    }
}
