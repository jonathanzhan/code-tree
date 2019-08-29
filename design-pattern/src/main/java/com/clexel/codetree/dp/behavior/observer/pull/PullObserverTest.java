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

package com.clexel.codetree.dp.behavior.observer.pull;


/**
 * 拉模式测试类
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/12 17:18
 * @since 1.0.0+
 */
public class PullObserverTest {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver object1 = new ConcreteObserver("张三");
        ConcreteObserver object2 = new ConcreteObserver("李四");
        subject.add(object1);
        subject.add(object2);
        subject.changeInfo("1.0","1.0变更记录");
        subject.changeInfo("1.1","1.1变更记录");

        subject.remove(object1);
        subject.changeInfo("1.2","1.2变更记录");
    }
}
