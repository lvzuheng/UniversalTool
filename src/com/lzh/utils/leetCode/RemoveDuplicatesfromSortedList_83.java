package com.lzh.utils.leetCode;

public class RemoveDuplicatesfromSortedList_83 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode = new ListNode(2);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(2);
		System.out.println(deleteDuplicates(listNode).val);
		System.out.println(deleteDuplicates(listNode).next.val);
		System.out.println(deleteDuplicates(listNode).next.next.val);
	}
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null )
    		return head;
    	head.next = helper(head.next, head.val);
    	return head;
    }
    
    public static ListNode helper(ListNode head,int lastValue) {
    	if(head == null)
    		return head;
    	if(head.val == lastValue){
    		head = helper(head.next, head.val);
    	}else{
    		head.next = helper(head.next, head.val);
    	}
    	return head;
    }
}

