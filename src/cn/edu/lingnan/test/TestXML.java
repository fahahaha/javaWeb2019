package cn.edu.lingnan.test;

import java.util.HashMap;


import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidator;

public class TestXML {

	public static void main(String[] args) {

		String xmlPath ="database.conf.xml";
		String xsdPath ="database.conf.xsd";
		if(XmlValidator.validate(xmlPath, xsdPath)) {
			HashMap<String, String> hm=XmlParser.parser(xmlPath);
			System.out.println(hm.get("driver"));
			System.out.println(hm.get("password"));
			System.out.println("连接成功！");


		}
		else {
			System.out.println("连接失败！");

		}

		
	}

}
