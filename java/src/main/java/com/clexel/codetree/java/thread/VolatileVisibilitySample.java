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

package com.clexel.codetree.java.thread;

/**
 * volatile可见性分析
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2020/12/17 19:58
 * @since 1.0.0+
 */
public class VolatileVisibilitySample {
    volatile boolean initFlag = false;
    public void save(){
        this.initFlag = true;
        String threadname = Thread.currentThread().getName();
        System.out.println("线程："+threadname+":修改共享变量initFlag");
    }

    public void load(){
        String threadname = Thread.currentThread().getName();
        while (!initFlag){
            //线程在此处空跑，等待initFlag状态改变
        }
        System.out.println("线程："+threadname+"当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args){
        VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread threadA = new Thread(()->{
            sample.save();
        },"threadA");

        Thread threadB = new Thread(()->{
            sample.load();
        },"threadB");
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }

}
