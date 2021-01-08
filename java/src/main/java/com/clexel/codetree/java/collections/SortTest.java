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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/11 11:30
 * @since 1.0.0+
 */
public class SortTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        List<User1> list1 = new ArrayList<>();
        List<User2> list2 = new ArrayList<>();
        for (int i = 5; i >=0; i--) {
            list.add(new User(i,"name"+i));
            list1.add(new User1(i,"name"+i));
            list2.add(new User2(i,"name"+i));
        }

        Collections.sort(list,new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId()-o2.getId();
            }
        });

        Collections.sort(list1);
        Collections.sort(list2,User2.INCREASE);

        for (int i = 0; i <=5 ; i++) {
            System.out.println(list.get(i).toString());
            System.out.println(list1.get(i).toString());
            System.out.println(list2.get(i).toString());
        }
    }
}
