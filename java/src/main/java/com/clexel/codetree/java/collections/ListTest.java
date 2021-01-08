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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * list
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/17 18:58
 * @since 1.0.0+
 */
public class ListTest {

    @Test
    public void arrayListTest(){
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<9;i++) {
            list.add(i);
        }
        list.add(9);
        list.add(10,10);
        System.out.println(list.size());
        for (Integer num:list) {
            System.out.println(num);
        }
    }

    @Test
    public void linkListTest() {
        List<Integer> list = new LinkedList<>();
        for(int i =0;i<9;i++) {
            list.add(i);
        }
        list.add(9,9);
        list.add(10,10);
        for (Integer num:list) {
            System.out.println(num);
        }
    }

    @Test
    public void vectorList() {
        List<Integer> list = new Vector<>();
        for(int i =0;i<9;i++) {
            list.add(i);
        }
        list.add(9,9);
        list.add(10,10);
        for (Integer num:list) {
            System.out.println(num);
        }
    }

}
