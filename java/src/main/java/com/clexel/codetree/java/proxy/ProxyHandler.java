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
import java.lang.reflect.Method;

/**
 * 代理类的调用
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 18:19
 * @since 1.0.0+
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    /**
     * invoke方法
     * @param proxy 代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * @param method 所要调用某个真实对象的方法的Method对象
     * @param args 所要调用某个真实对象的方法的传递的参数
     * @return 所要调用某个真实对象的方法的返回值或者返回代理对象
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 动态代理");
        System.out.println("invoke()方法参数一的类型为:"+proxy.getClass().getName());
        if(method.getName().equals("request")){
            method.invoke(this.object, args);
            System.out.println("after 动态代理");
            return proxy;
        } else if (method.getName().equals("getTime")){
            System.out.println("after 动态代理");
            return method.invoke(this.object, args);
        } else {
            System.out.println("after 动态代理");
            method.invoke(this.object, args);
            return proxy;
        }
    }
}
