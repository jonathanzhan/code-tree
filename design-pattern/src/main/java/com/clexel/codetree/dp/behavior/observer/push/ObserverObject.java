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
 * 具体观察者对象
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/6/12 19:52
 * @since 1.0.0+
 */
public class ObserverObject implements Observer {
    /**
     * 观察者名称
     */
    private String name;

    /**
     * 被通知的消息数据
     */
    private String dataInfo;

    public ObserverObject(String name) {
        this.name = name;
    }

    /**
     * 观察者响应
     *
     * @param info 数据内容
     */
    @Override
    public void response(String info) {
        this.dataInfo = info;
        System.out.println(name + " 收到推送消息： " + dataInfo);
    }

}
