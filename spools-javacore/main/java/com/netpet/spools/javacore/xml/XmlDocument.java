/*
 * Copyright [2016]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netpet.spools.javacore.xml;

/**
 * Created with IntelliJ IDEA.
 * User: trigger
 * Date: 13-10-21
 * Time: 上午9:54
 * 定义XML文档建立与解析的接口
 */
public interface XmlDocument {
    /**
     * 建立XML文档
     * @param fileName 文件全路径名称
     */
    public void createXml(String fileName);
    /**
     * 解析XML文档
     * @param fileName 文件全路径名称
     */
    public void parserXml(String fileName);
}
