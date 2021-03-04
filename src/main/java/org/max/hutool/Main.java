package org.max.hutool;

import org.apache.commons.lang.StringEscapeUtils;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.http.HtmlUtil;

public class Main {

//	static String test = "IF(SUBSTR(@@version,1,1)<5,BENCHMARK(2600000,SHA1(0xDEADBEEF)),SLEEP(5))/*'XOR(IF(SUBSTR(@@version,1,1)<5,BENCHMARK(2600000,SHA1(0xDEADBEEF)),SLEEP(5)))OR'|\"XOR(IF(SUBSTR(@@version,1,1)<5,BENCHMARK(2600000,SHA1(0xDEADBEEF)),SLEEP(5)))OR\"*/";
	static String test = "'and 1 ==1'";
//	static String test = "紫华佳苑";
//	static String test = "<html><body>123'123'</body></html>";
	
	
	public static void main(String[] args) {
		String after1 = StringEscapeUtils.escapeHtml(test);
		System.out.println("StringEscapeUtils.escapeHtml():" + after1);
		String after2 = StringEscapeUtils.escapeXml(test);
		System.out.println("StringEscapeUtils.escapeXml(): " + after2);
		String after3 = EscapeUtil.escape(test);
		System.out.println("EscapeUtil.escape(): " + after3);
		String after4 = HtmlUtil.escape(after3);
		System.out.println("HtmlUtil.escape(): " + after4);
	}

}
