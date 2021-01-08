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

import org.junit.Test;

import java.util.*;

/**
 * set
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/17 19:05
 * @since 1.0.0+
 */
public class SetTest {

    @Test
    public void hashSetTest() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add("value"+i);
        }
        Iterator<String> itertor = set.iterator();
        while (itertor.hasNext()) {
            System.out.println(itertor.next());
        }
        for (String num:set) {
            System.out.println(num);
        }
    }


    @Test
    public void linkHashSetTest() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add("value"+i);
        }
        for (String str:set) {
            System.out.println(str);
        }
    }

    @Test
    public void treeSetTest() {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 10; i >=0; i--) {
            set.add("value"+i);
        }
        for (String str:set) {
            System.out.println(str);
        }
    }

    @Test
    public void treeSetSortTest() {
        TreeSet<User> set = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for (int i = 10; i >=0; i--) {
            set.add(new User(i,"test"+i));
        }
        for (User user:set) {
            System.out.println(user.toString());
        }

    }
}
