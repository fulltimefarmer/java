package org.max.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//CLASS
@SuppressWarnings("rawtypes")
@Retention(value=RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnno {
	String name();
	int age();

//	Date d();
	Class clazz();
	Color c();
	String[] adds();
	MyAnno2 anno();
}

enum Color{
	RED,YELLOW
}

@interface MyAnno2{
	String name();
}



@interface MyAnno3{
	String value();
	int age();
}

@interface MyAnno4{
	String[] value();
}
