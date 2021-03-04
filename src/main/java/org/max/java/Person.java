package org.max.java;

/**
 * @description:
 * @author: Max Zhou
 * @create: 2020-09-24 15-12
 */
public class Person {
	
	private String name;
    private int age;
    private Attribute attribute;
    
	public Person() {
		super();
	}

	public Person(String name, int age, Attribute attribute) {
		super();
		this.name = name;
		this.age = age;
		this.attribute = attribute;
	}
	
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(final int age) {
		this.age = age;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(final Attribute attribute) {
		this.attribute = attribute;
	}
    
}
