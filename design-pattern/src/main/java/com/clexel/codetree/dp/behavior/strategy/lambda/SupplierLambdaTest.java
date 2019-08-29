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

import java.util.function.Supplier;

/**
 * 关于实体类对象的lambda表达式
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/6/12 15:05
 * @since 1.0.0+
 */
public class SupplierLambdaTest {

    public static void main(String[] args) {
        Employee employee = new Employee("张三",12);

        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = () -> new Employee("张三",12);
        System.out.println(supplier1.get());

        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());
    }
}
