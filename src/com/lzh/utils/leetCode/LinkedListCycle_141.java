package com.lzh.utils.leetCode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		System.out.println(hasCycle(node1));
	}
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		Set<ListNode> set = new HashSet<>();
		ListNode listNode = head;
		while (listNode != null) {
			System.out.println(listNode.val);
			if(set.contains(listNode)){
				return true;
			}
			set.add(listNode);
			listNode = listNode.next;
		}
		return false;
	}

	public static boolean equipNode(ListNode node,ListNode next){
		if(node== null || next == null || next.next == null){
			return false;
		}
		if(node == next || node == next.next){
			return true;
		}
		return equipNode(node, next.next);
	}
}
