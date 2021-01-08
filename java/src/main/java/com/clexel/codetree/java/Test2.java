/*
 * Copyright  2014-2021 jonathan.zhan.chang@gmail.com(Jonathan)
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

package com.clexel.codetree.java;

import java.util.Scanner;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2021/1/4 20:06
 * @since 1.0.0+
 */
public class Test2 {

    //价格数组
    // 买入 卖出  租金 每天1
    //最大利润
    public static void main(String[] args) {
        int[] prices = new int[3];
        prices[0] = 2;
        prices[1] = 1;
        prices[2] = 5;
        // 收益
        int result =0;
        for (int i=0;i<prices.length;i++) {
            for (int j = i;j<prices.length;j++) {
                // 本次收益
                int num = prices[j]-prices[i]-(j-i);
                if(result<=num) {
                    result = num;
                }
            }
        }
        System.out.println(result);
    }
}
