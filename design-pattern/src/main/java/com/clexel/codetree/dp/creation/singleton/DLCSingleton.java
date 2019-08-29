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
 * DLC双重检查单例
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/19 18:30
 * @since 1.0.0+
 */
public class DLCSingleton {

    private static volatile DLCSingleton single = null;

    private DLCSingleton() {}

    public static DLCSingleton getInstance() {
        //第一次检查,先检查实例是否存在，如果不存在才进入下面的同步块
        if(single == null) {
            //同步块，线程安全的创建实例
            synchronized (DLCSingleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(single == null) {
                    single = new DLCSingleton();
                }
            }
        }
        return single;
    }
}
