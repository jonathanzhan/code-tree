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
 * 具体的主题对象
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/12 16:55
 * @since 1.0.0+
 */
public class ConcreteSubject extends Subject {

    /**
     * 传递的少量消息
     */
    private String version;

    /**
     * 更多消息内容
     */
    private String description;

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    protected void changeInfo(String version, String description) {
        this.version = version;
        this.description = description;
        System.out.println("版本变更为:" + this.version + ",更新内容为:" + this.description);
        //消息发生改变,通知给各个观察者
        this.notifyObserver();
    }
}
