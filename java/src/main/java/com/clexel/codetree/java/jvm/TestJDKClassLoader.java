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

package com.clexel.codetree.java.jvm;

import sun.misc.Launcher;

import java.net.URL;

/**
 * 类加载器示例
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/10/19 22:03
 * @since 1.0.0+
 */
public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.AESKeyGenerator.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());

        System.out.println();

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println("the bootClassLoader:"+ bootClassLoader);
        System.out.println("the extClassLoader:"+ extClassLoader);
        System.out.println("the appClassLoader:"+ appClassLoader);

        System.out.println();
        System.out.println("bootstrapLoader加载以下文件:");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }

        System.out.println();
        System.out.println("extClassLoader加载以下文件:");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件:");
        System.out.println(System.getProperty("java.class.path"));

    }
}
