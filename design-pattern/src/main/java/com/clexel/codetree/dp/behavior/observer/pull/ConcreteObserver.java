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
 * 具体的观察者对象(拉模式)
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/12 16:54
 * @since 1.0.0+
 */
public class ConcreteObserver implements Observer {
    /**
     * 观察者名称
     */
    private String name;

    /**
     * 主题对象
     */
    private Subject subject;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    /**
     * 观察者响应
     *
     * @param subject 抽象主题对象
     */
    @Override
    public void response(Subject subject) {
        this.subject = subject;
        // 将主题对象传给观察者,观察者就可以在响应方法中获取想要的信息,比如version,description
        String version = ((ConcreteSubject) subject).getVersion();
        String description = ((ConcreteSubject) subject).getDescription();
        // 疑问
        // ((ConcreteSubject) subject).changeInfo("1.0.0","观察者自己更改了通知内容");
        System.out.println(name + " 接收到了新版本: " + version + "通知,变更记录为:"+description);
    }
}
