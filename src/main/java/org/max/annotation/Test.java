package org.max.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	@SuppressWarnings("all")
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		/*
		 * 用反射+注解让Demo里面标注了@MyJunit的方法运行
		 * 
		 * */
		Class clazz = Demo.class;
		
		Method[] methods = clazz.getMethods();//得到所有的方法
		
		//让标注了注解的方法运行
		for (Method method : methods) {
			//判断方法上方是否有注解的标记
			boolean flag = method.isAnnotationPresent(MyJunit.class);
//			System.out.println(method.getName()+"..."+flag);
			//有的话就执行该方法
			if(flag) {
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
	
	
	@MyAnno(name="zs",age=18,clazz=String.class,c=Color.RED,adds= {"bj","sh"},anno=@MyAnno2(name="ls"))
	@MyAnno3(value="hh",age=19)
	@MyAnno4("aaa")
	public void method() {
		//如何提取注解里面的配置信息  反射技术
	}

}
