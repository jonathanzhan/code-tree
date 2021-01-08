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
 * public pbxj917对所有人说 (17:41)
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 *
 * 示例 1：
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *  a
 * 示例 2：
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 *
 * 提示：
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/19 17:43
 * @since 1.0.0+
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] ss = line.split(",");
        List<Word> list = new ArrayList<>();
        List<String> single = new ArrayList<>();
        for (String s : ss) {
            list.add(new Word(s.length(), s));
            if (s.length() == 1) {
                single.add(s);
            }
        }
        Collections.sort(list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getLength() - o2.getLength();
            }
        });
        String result = list.get(0).getName();
        for (int i = list.size() - 1; i > 0; i--) {
            String output = list.get(i).getName();
            int[] check = new int[output.length() - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (output.contains(list.get(j).getName()) && output.length() > list.get(j).getLength()) {
                    check[list.get(j).getLength() - 1] = 1;
                }
            }
            int count = 0;
            for (int num : check) {
                count += num;
            }
            if (count == check.length && output.length() >= result.length()) {
                result = output;
            }
        }
        System.out.println(result);
    }
}
//该单词是由words词典中其他单词逐步添加一个字母组成。
class Word{
    // 字符长度
    private int length;
    private String name;

    public Word(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}