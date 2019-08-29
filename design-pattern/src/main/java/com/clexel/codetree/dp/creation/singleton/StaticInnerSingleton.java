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

package com.clexel.codetree.dp.creation.singleton;

/**
 * 静态内部类的实现方式,完成了懒汉式的延迟加载，同时static保证了线程安全
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/19 18:39
 * @since 1.0.0+
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton(){}

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.singleton;
    }

    /**
     * 私有静态类,初始化的时候,不调用getInstance()方法则不会加载
     */
    private static class SingletonHolder{
        /**
         * 利用static final关键字的同步机制，初始化后就无法修改保证了线程安全
         */
        private static final StaticInnerSingleton singleton = new StaticInnerSingleton();
    }
}
