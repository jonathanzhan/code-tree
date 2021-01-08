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

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2021/1/4 20:19
 * @since 1.0.0+
 */
public class Test3 {
    public static void main(String[] args) {
        //判断连续  true false
        // 每次+1
        String str = "110011";
        boolean result = check(str);
        if(result) {
            //返回str
            System.out.println(str);
        }else {
            // 返回不包含连续1的，并且大于该值得最小二进制
            //二进制转换为Integer,每次+1后，转换为二进制，继续判断是否连续，
            //不连续则返回，连续则继续累加1,直接不连续为止
            Integer i = Integer.parseInt(str,2)+1;
            String str1 = Integer.toBinaryString(i);
            // 包含连续,继续+1
            while(!check(str1)){
                i++;
                str1 = Integer.toBinaryString(i+1);
            }
            System.out.println(str1);
        }

    }

    private static boolean check(String str) {
        char[] chars = str.toCharArray();
        int firstIndex = 0;
        for (int i = 0; i < chars.length-1; i++) {
            // 判断当前下标的char与当前下标+1的char是否相等，相等，返回false ,并且break;
            if(chars[i] == '1' && chars[i+1] =='1'){
                return false;
            }
        }
        return true;
    }


}
