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
 * 懒汉式单例
 * 多线程并发的时候会失效，getInstance不同步，
 * 例子：一个线程在创建mInstance时，还未创建完成，另一个线程访问mInstance此时还是为空，又创建了一个
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/19 18:07
 * @since 1.0.0+
 */
public class SafeLazySingleton {

    private static SafeLazySingleton single = null;

    /**
     * 构造函数私有化
     */
    private SafeLazySingleton(){
    }

    /**
     * 静态工厂方法,线程安全，同步
     * @return Singleton
     */
    public static synchronized SafeLazySingleton getInstance() {
        if(single == null) {
            single = new SafeLazySingleton();
        }
        return single;
    }

    /**
     * 静态工厂方法,线程安全，同步代码块
     * @return SafeLazySingleton
     */
    public static SafeLazySingleton getmInstance() { //同步代码块
        synchronized (SafeLazySingleton.class) {
            if (single == null) {
                single = new SafeLazySingleton();
            }
            return single;
        }
    }
}
