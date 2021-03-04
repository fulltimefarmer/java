package org.max.java;

import java.util.regex.Pattern;

public class RegexMain {

	private static final String PHONE_REG_EXP = "^(([0-9]|\\s|-|\\)|\\(|\\+|\\.)){7,50}$";
	private static final String EMAIL_REG_EXP = "^\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}$";
	
	public static void main(String[] args) {
		String content1 = "123456";
		boolean result1 = Pattern.matches(PHONE_REG_EXP, content1);
		System.out.println(result1);
		
		String content2 = "";
		boolean result2 = Pattern.matches(EMAIL_REG_EXP, content2);
		System.out.println(result2);
	}

}
