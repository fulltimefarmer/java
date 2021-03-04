package org.max.java;

import java.util.Objects;

public class Attribute {

	private String a;
	private String b;
	
	public Attribute(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Attribute)) {
			return false;
		}

		final Attribute attribute = (Attribute) obj;
		return Objects.equals(this.a, attribute.a)
				&& Objects.equals(this.b, attribute.b);
	}

	@Override
	public String toString() {
		return getA() + '\n'
				+ getB();
	}
	
}
