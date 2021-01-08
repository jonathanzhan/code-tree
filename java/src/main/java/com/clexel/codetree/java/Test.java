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

import java.util.*;

/**
 * TODO 关于此类的描述
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/10 22:03
 * @since 1.0.0+
 */
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
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<Card> cardList = new ArrayList<>();
        int[] count = new int[13];
        String[] ss = line.split("\\s+");
        for (String s:ss) {
            String[] c = s.split(",");
            int num = Integer.parseInt(c[0]);
            Card card = new Card(num,c[1]);
            count[num-1]++;
            cardList.add(card);
        }
        Arrays.sort(count);
        if(count[12]==4) {
            System.out.println("四条 4+1");
        }else if(count[12]==3&& count[11]==2){
            System.out.println("葫芦 3+2");
        }else if(count[12]==3&& count[11]!=2){
            System.out.println("三条");
        }else if(count[12]==2&& count[11]==2){
            System.out.println("两对");
        }else if(count[12]==2&& count[11]!=2){
            System.out.println("一对");
        }else{
            // 判断同花 顺子
            Collections.sort(cardList, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.getNum()-o2.getNum();
                }
            });
            boolean flag = true;
            for (int i = 1; i < 5; i++) {
                if(cardList.get(i).getNum()!=cardList.get(0).getNum()+i){
                    System.out.println("什么都不是");
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("顺子");
            }

        }
    }


}

class Card{
    private int num;
    private String type;

    public Card(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
