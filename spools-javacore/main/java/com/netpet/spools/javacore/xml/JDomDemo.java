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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * Created with IntelliJ IDEA.
 * User: trigger
 * Date: 13-10-21
 * Time: 上午9:51
 * JDOM 生成与解析XML文档
 */
public class JDomDemo implements XmlDocument {

    public static void main(String[] args) {
        JDomDemo demo = new JDomDemo();
//        demo.createXml("F://a.xml");
        demo.parserXml("F://a.xml");
    }

    public void createXml(String fileName) {
        Document document;
        Element  root;
        root=new Element("employees");
        document=new Document(root);
        Element employee=new Element("employee");
        root.addContent(employee);
        Element name=new Element("name");
        name.setText("ddvip");
        employee.addContent(name);
        Element sex=new Element("sex");
        sex.setText("m");
        employee.addContent(sex);
        Element age=new Element("age");
        age.setText("23");
        employee.addContent(age);
        XMLOutputter XMLOut = new XMLOutputter();
        try {
            XMLOut.output(document, new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void parserXml(String fileName) {
        SAXBuilder builder=new SAXBuilder(false);
        try {
            Document document=builder.build(fileName);
            Element employees=document.getRootElement();
            List employeeList=employees.getChildren("employee");
            for(int i=0;i<employeeList.size();i++) {
                Element employee=(Element)employeeList.get(i);
                List employeeInfo=employee.getChildren();

                for(int j=0;j<employeeInfo.size();i++) {
                    System.out.println(((Element)employeeInfo.get(j)).getName()+":"+((Element)employeeInfo.get(j)).getValue());
                }
            }

        } catch (JDOMException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}