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

/**
 * 用户对象1
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/11 11:16
 * @since 1.0.0+
 */
public class User1 implements Serializable, Comparable<User1> {
    private int id;

    private String name;

    public User1() {
    }

    public User1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(User1 o) {
        // 正序
        return this.id - o.getId();
        // 倒序
        // return o.getId() - this.id;
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

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
