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

package com.clexel.codetree.java;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/16 20:27
 * @since 1.0.0+
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 货币数量(5,10,20)
        int left1 = 0;
        int left2 = 0;
        int left3 = 0;

        String line = sc.nextLine();
        String[] strings = line.split("\\s+");
        for (String s:strings) {
            int num = Integer.parseInt(s);
            if(num==5) {
                //不做任何处理
                left1++;
            }else if(num==10) {
                left2++;
                left1--;
            }else {
                left3++;
                //优先10
                if(left2>0) {
                    left2--;
                    left1--;
                }else {
                    left1 = left1-3;
                }
            }
            if(left1<0 || left2<0 || left3<0) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
