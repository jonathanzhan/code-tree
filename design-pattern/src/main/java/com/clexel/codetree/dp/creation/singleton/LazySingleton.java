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
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/19 18:07
 * @since 1.0.0+
 */
public class LazySingleton {

    private static LazySingleton single = null;

    /**
     * 构造函数私有化
     */
    private LazySingleton(){
    }

    /**
     * 静态工厂方法(线程不安全,不同步)
     * @return singleton
     */
    public static LazySingleton getInstance() {
        if(single == null) {
            single = new LazySingleton();
        }
        return single;
    }


}
