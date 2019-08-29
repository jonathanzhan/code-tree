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

package com.clexel.codetree.dp.behavior.observer.extend;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者,关注公众号的用户
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/12 18:29
 * @since 1.0.0+
 */
public class User implements Observer {
    private String name;

    private String mess;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object mess) {
        this.mess = mess.toString();
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + mess);
    }
}
