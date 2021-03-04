package org.max.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	@SuppressWarnings("all")
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		/*
		 * �÷���+ע����Demo�����ע��@MyJunit�ķ�������
		 * 
		 * */
		Class clazz = Demo.class;
		
		Method[] methods = clazz.getMethods();//�õ����еķ���
		
		//�ñ�ע��ע��ķ�������
		for (Method method : methods) {
			//�жϷ����Ϸ��Ƿ���ע��ı��
			boolean flag = method.isAnnotationPresent(MyJunit.class);
//			System.out.println(method.getName()+"..."+flag);
			//�еĻ���ִ�и÷���
			if(flag) {
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
	
	
	@MyAnno(name="zs",age=18,clazz=String.class,c=Color.RED,adds= {"bj","sh"},anno=@MyAnno2(name="ls"))
	@MyAnno3(value="hh",age=19)
	@MyAnno4("aaa")
	public void method() {
		//�����ȡע�������������Ϣ  ���似��
	}

}
