package com.lzh.utils.leetCode;

import java.util.List;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		System.out.println(addTwoNumbers(l1, l2).next.val);
	}
	
		static int i =0;
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode ln = null;
	       return addNumbers(l1,l2,ln);
	    }
	    
	    public static ListNode addNumbers(ListNode l1, ListNode l2,ListNode lnext){
	        int l1v = l1==null?0:l1.val;
	        int l2v = l2==null?0:l2.val;
	        if(l1==null && l2==null && i==0)
	          return null; 
	        int result = i+l1v+l2v>=10?(i+l1v+l2v-10):i+l1v+l2v;
	        i = i+l1v+l2v>=10?1:0;
	        lnext = new ListNode(result);
	        lnext.next = addNumbers(l1==null?null:l1.next,l2==null?null:l2.next,lnext.next);
	        return lnext;
	    }

}
