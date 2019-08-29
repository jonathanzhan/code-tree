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

package com.clexel.codetree.dp.behavior.strategy.lambda;

import org.junit.Test;

import java.util.function.*;

/**
 * function 接口lambda
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/6/12 15:42
 * @since 1.0.0+
 */
public class LambdaTest {

    @Test
    public void test() {
        Function<Integer, Integer> function = x -> x * 2;
        System.out.println(function.apply(2));

        Function<Long, Long> function1 = (x) -> {
            Long result = x * 2;
            return result;
        };
        System.out.println(function1.apply(2L));

        Function<String, String> function2 = (str) -> new String(str);
        System.out.println(function2.apply("test"));

        Function<Integer, String[]> function3 = (num) -> new String[num];
        String[] strs = function3.apply(2);
        System.out.println(strs.length);

        LongFunction<Long> function4 = (x) -> x * 2;
        System.out.println(function4.apply(2L));
    }

    @Test
    public void test1() {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("test");
    }


    @Test
    public void test2() {
        Predicate<String> predicate = (s -> s.equals("str"));
        System.out.println(predicate.test("str"));
    }

    @Test
    public void test3() {
        Supplier<String> supplier = () -> "str";
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());
    }


}
