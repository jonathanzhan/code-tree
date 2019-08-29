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

package com.clexel.codetree.dp.structural.proxy.staticproxy;

/**
 * 代理对象
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/29 10:09
 * @since 1.0.0+
 */
public class Proxy implements Subject {

    private RealSubject realSubject;

    /**
     * 待具体实现的方法
     */
    @Override
    public void request() {
        if(realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void postRequest() {
        System.out.println("访问真实主题以后的后续处理");
    }

    private void preRequest() {
        System.out.println("访问真实主题之前的预处理");
    }

}
