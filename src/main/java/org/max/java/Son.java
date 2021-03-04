package org.max.java;

/**
 * @description:
 * @author: Max Zhou
 * @create: 2020-09-24 15-12
 */
public class Son extends Person {
    public int age =1;

	@Override
	public void setName(String name) {
		super.setName(name + "1");
	}

	@Override
	public void setAge(int age) {
		super.setAge(age + 1);
	}
    
}
