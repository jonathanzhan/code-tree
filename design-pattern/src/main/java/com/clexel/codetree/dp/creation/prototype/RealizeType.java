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

package com.clexel.codetree.dp.creation.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象原型之浅克隆
 *
 * @author Jonathan
 * @version 1.0.0
 * @date 2019/8/20 15:08
 * @since 1.0.0+
 */
public class RealizeType implements Cloneable {
    private String name;

    private List<String> list = new ArrayList<>();

    RealizeType()
    {
        System.out.println("具体原型创建成功！");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

//    /**
//     * 浅度克隆
//     * @return Object
//     * @throws CloneNotSupportedException
//     */
//    @Override
//    public Object clone() throws CloneNotSupportedException
//    {
//        System.out.println("具体原型复制成功！");
//        return (RealizeType)super.clone();
//    }

    /**
     * 深度克隆
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("具体原型复制成功！");
        RealizeType cloneType = (RealizeType)super.clone();
        if(cloneType.getList() != null) {
            List<String> list = new ArrayList<>();
            for (String str:cloneType.getList()) {
                list.add(str);
            }
            cloneType.setList(list);
        }
        return cloneType;
    }


}
