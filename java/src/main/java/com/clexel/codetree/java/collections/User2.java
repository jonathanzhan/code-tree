/*
 * Copyright  2014-2020 jonathan.zhan.chang@gmail.com(Jonathan)
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

package com.clexel.codetree.java.collections;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 用户对象2
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/11 11:21
 * @since 1.0.0+
 */
public class User2 implements Serializable {

    private int id;

    private String name;

    public static final Comparator<User2> INCREASE = new increase();

    public User2() {
    }

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static class increase implements Comparator<User2> {
        @Override
        public int compare(User2 o1, User2 o2) {
            return o1.getId()-o2.getId();
        }
    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


