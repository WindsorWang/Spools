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

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: trigger
 * Date: 13-10-31
 * Time: 下午3:23
 */
public class XmlFormatter {
    public String format(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);
            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception{
        //未格式化前的xml
        String s = "<?xml version=\"1.0\" encoding=\"gb2312\"?><response><content><head><responseCode>0000</responseCode><responseMessage>成功</responseMessage></head><body><record><recordInfo><paramInfo><paramCode>CompId</paramCode><paramValue><value>1001</value></paramValue></paramInfo><paramInfo><paramCode>AreaCode</paramCode><paramValue><value>020</value></paramValue></paramInfo><paramInfo><paramCode>ServNum</paramCode><paramValue><value>1234</value></paramValue></paramInfo><paramInfo><paramCode>ProdTypeId</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ProdTypeName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ServState</paramCode><paramValue><value>F0A</value></paramValue></paramInfo><paramInfo><paramCode>PayMode</paramCode><paramValue><value>1</value></paramValue></paramInfo><paramInfo><paramCode>ServCompleteDate</paramCode><paramValue><value>20011021000000</value></paramValue></paramInfo><paramInfo><paramCode>ServTypeId</paramCode><paramValue><value>1060</value></paramValue></paramInfo><paramInfo><paramCode>ServTypeName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>BillAreaId</paramCode><paramValue><value>100</value></paramValue></paramInfo><paramInfo><paramCode>BillAreaName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>BillTypeId</paramCode><paramValue><value>4</value></paramValue></paramInfo><paramInfo><paramCode>BillTypeName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>CertType</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>CertId</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>CustAddress</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ContactName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ContactTel</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ContactPostcode</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ContactAddr</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>AcctName</paramCode><paramValue><value>汪宪军</value></paramValue></paramInfo><paramInfo><paramCode>AcctAccNbr</paramCode><paramValue><value>86416220</value></paramValue></paramInfo><paramInfo><paramCode>AcctNbr</paramCode><paramValue><value>86416220</value></paramValue></paramInfo></recordInfo><recordInfo><paramInfo><paramCode>PricePlanId</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>EffDate</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>ExpDate</paramCode><paramValue><value></value></paramValue></paramInfo></recordInfo><recordInfo><paramInfo><paramCode>AttrName</paramCode><paramValue><value></value></paramValue></paramInfo><paramInfo><paramCode>AttrValue</paramCode><paramValue><value></value></paramValue></paramInfo></recordInfo></record></body></content><validateCode>345316d7092356d42b49238453cac6e5</validateCode></response>";
        System.out.println(new XmlFormatter().format(s));

    }
}
