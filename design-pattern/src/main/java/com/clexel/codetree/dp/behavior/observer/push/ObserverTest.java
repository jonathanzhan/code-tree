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

package com.clexel.codetree.dp.behavior.observer.push;

/**
 * 观察者模式测试调用
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/6/12 19:32
 * @since 1.0.0+
 */
public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ObserverObject object1 = new ObserverObject("张三");
        ObserverObject object2 = new ObserverObject("李四");
        subject.add(object1);
        subject.add(object2);

        subject.notifyObserver("mess1");

        subject.notifyObserver("mess2");

        subject.remove(object1);
        subject.notifyObserver("mess3");
    }
}
