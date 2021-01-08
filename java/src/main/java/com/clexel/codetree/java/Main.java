package com.clexel.codetree.java;


import java.util.*;

//一副牌中发五张扑克牌给你：让你判断数字的组成：
// 同花顺 12345
// 四条 4+1
// 葫芦 3+2
// 同花 5个花色一样
// 顺子 10，J，Q，K，A
// 三条
// 两对
// 一对
// 其他

// ABBBB AAAAB AAABB AABBB
// 放集合里 如果size = 1 error
// =2 (4+1 或者3+2)
// =3 AABBC AAABC 三条或者两对
// =4 一对

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int[] num = new int[13];
            int[] aa = new int[5];
            for (int i = 0; i < 5; i++) {
                int temp = sc.nextInt();
                aa[i] = temp;
                num[temp - 1]++;
            }

            Arrays.sort(num);
            Arrays.sort(aa);
            for (int i = 0; i < 13; i++) {
                System.out.println(num[i]);
            }

            if (num[12] == 4) {
                System.out.println("四条");
            } else if (num[12] == 3 && num[11] == 2) {
                System.out.println("三条带 一对");
            } else if (num[12] == 3 && num[11] == 1) {
                System.out.println("三条带两张不相同数值的牌");
            } else if (num[12] == 2 && num[11] == 2) {
                System.out.println("两对");
            } else if (num[12] == 2 && num[11] == 1) {
                System.out.println("一对");
            } else {
                boolean flag = true;
                for (int i = 1; i < 5; i++) {
                    if (aa[i] != aa[0] + i) {
                        System.out.println("什么都不是");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("顺子");
                }
            }

        }

    }

}
