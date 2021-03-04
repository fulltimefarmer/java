package org.max.algorithms.structure;

import java.util.ArrayList;

import org.max.algorithms.model.ListDoubleNode;
import org.max.algorithms.model.ListNode;

public class ListUtil {
	
	public static void main(String[] args) {
		int len = 50;
		int value = 100;
		int testTime = 100000;
		for (int i = 0; i < testTime; i++) {
			ListNode node1 = ListUtil.generateRandomLinkedList(len, value);
			ListNode reverse1 = ListUtil.reverseLinkedList(node1);
			ListNode back1 = ListUtil.testReverseLinkedList(reverse1);
			if (!ListUtil.checkLinkedListEqual(node1, back1)) {
				System.out.println("oops!");
				break;
			}
			ListDoubleNode node2 = ListUtil.generateRandomDoubleList(len, value);
			ListDoubleNode reverse2 = ListUtil.reverseDoubleList(node2);
			ListDoubleNode back2 = ListUtil.testReverseDoubleList(reverse2);
			if (!ListUtil.checkDoubleListEqual(node2, back2)) {
				System.out.println("oops!");
				break;
			}
		}
		System.out.println("finish!");
	}
	
	public static ListNode generateRandomLinkedList(int len, int value) {
		int size = (int) (Math.random() * (len + 1));
		if (size == 0) {
			return null;
		}
		size--;
		ListNode head = new ListNode((int) (Math.random() * (value + 1)));
		ListNode pre = head;
		while (size != 0) {
			ListNode cur = new ListNode((int) (Math.random() * (value + 1)));
			pre.next = cur;
			pre = cur;
			size--;
		}
		return head;
	}

	public static ListDoubleNode generateRandomDoubleList(int len, int value) {
		int size = (int) (Math.random() * (len + 1));
		if (size == 0) {
			return null;
		}
		size--;
		ListDoubleNode head = new ListDoubleNode((int) (Math.random() * (value + 1)));
		ListDoubleNode pre = head;
		while (size != 0) {
			ListDoubleNode cur = new ListDoubleNode((int) (Math.random() * (value + 1)));
			pre.next = cur;
			cur.last = pre;
			pre = cur;
			size--;
		}
		return head;
	}
	
	public static ListNode reverseLinkedList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static ListDoubleNode reverseDoubleList(ListDoubleNode head) {
		ListDoubleNode pre = null;
		ListDoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static ListNode testReverseLinkedList(ListNode head) {
		if (head == null) {
			return null;
		}
		ArrayList<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		list.get(0).next = null;
		int N = list.size();
		for (int i = 1; i < N; i++) {
			list.get(i).next = list.get(i - 1);
		}
		return list.get(N - 1);
	}

	public static ListDoubleNode testReverseDoubleList(ListDoubleNode head) {
		if (head == null) {
			return null;
		}
		ArrayList<ListDoubleNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		list.get(0).next = null;
		ListDoubleNode pre = list.get(0);
		int N = list.size();
		for (int i = 1; i < N; i++) {
			ListDoubleNode cur = list.get(i);
			cur.last = null;
			cur.next = pre;
			pre.last = cur;
			pre = cur;
		}
		return list.get(N - 1);
	}

	// 要求无环，有环别用这个函数
	public static boolean checkLinkedListEqual(ListNode head1, ListNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.value != head2.value) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1 == null && head2 == null;
	}

	// 要求无环，有环别用这个函数
	public static boolean checkDoubleListEqual(ListDoubleNode head1, ListDoubleNode head2) {
		boolean null1 = head1 == null;
		boolean null2 = head2 == null;
		if (null1 && null2) {
			return true;
		}
		if (null1 ^ null2) {
			return false;
		}
		if (head1.last != null || head2.last != null) {
			return false;
		}
		ListDoubleNode end1 = null;
		ListDoubleNode end2 = null;
		while (head1 != null && head2 != null) {
			if (head1.value != head2.value) {
				return false;
			}
			end1 = head1;
			end2 = head2;
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 != null || head2 != null) {
			return false;
		}
		while (end1 != null && end2 != null) {
			if (end1.value != end2.value) {
				return false;
			}
			end1 = end1.last;
			end2 = end2.last;
		}
		return end1 == null && end2 == null;
	}
	
	public static ListNode removeValue(ListNode head, int num) {
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		// head来到 第一个不需要删的位置
		ListNode pre = head;
		ListNode cur = head;
		// 
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
}
