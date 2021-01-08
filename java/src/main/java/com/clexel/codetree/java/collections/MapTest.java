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
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

/**
 * map集合类
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/17 15:07
 * @since 1.0.0+
 */
public class MapTest {

    @Test
    public void hashMapTest() {
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("key"+i,"value"+i);
        }
        Set<String> keySet = map.keySet();
        assertEquals(keySet.size(),100);
        // 迭代器
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> me = iterator.next();
            System.out.println(me.getKey());
        }
        // 映射中包含的映射关系的 Set 视图
        for (Map.Entry<String,String> me:map.entrySet()){
            System.out.println(me.getKey());
        }
        //lambda表达式遍历 map Jdk8新特性
        map.forEach((key,value)->{
            System.out.println(key);
        });
    }

    @Test
    public void hashTableTest() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        for (int i = 0; i < 100; i++) {
            hashtable.put("key"+i,"value"+i);
        }
        hashtable.forEach((key,value)->{
            System.out.println(key);
        });
        Set<Map.Entry<String,String>> set = hashtable.entrySet();
        for (Map.Entry<String,String> me:set) {
            System.out.println(me.getKey());
        }
        System.out.println(hashtable.size());
    }

    @Test
    public void concurrentMapTest() {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("key"+i,"value"+i);
        }
        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> me:set) {
            System.out.println(me.getKey());
        }
        System.out.println(map.size());
        System.out.println(set.size());

    }
}
