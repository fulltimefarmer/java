package org.max.algorithms.model;

public class ListDoubleNode {

	public int value;
	public ListDoubleNode last = null;
	public ListDoubleNode next = null;
	
	public ListDoubleNode(int value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return " " + this.value + " ";
	}
	
}
