package org.max.algorithms.model;

public class ListNode {
	
	public int value;
	public ListNode next = null;
	
	public ListNode(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return " " + this.value + " ";
	}
	
}
