package com.lzh.utils.leetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome_125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "abcd[e.fg]hi[Ihgfe';dc,ba"	;
		System.out.println(isPalindrome(a));
	}
    public static boolean isPalindrome(String s) {
    	if(s == null || s.length() ==0){
    		return false;
    	}
       String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      char[]cs = s.toCharArray();
      List<String> list = new ArrayList<>();
      for(int i = 0;i<cs.length;i++){
    	  if(string.indexOf(cs[i])>=0){
    		  list.add(cs[i]+"");
    	  }
      }
      for(int i =0;i<list.size();i++){
    	  System.out.println(list.get(i)+","+list.get(list.size()-i-1));
    	  if(!list.get(i).equalsIgnoreCase(list.get(list.size()-i-1))){
    		  System.err.println(list.get(i)+","+list.get(list.size()-i-1));
    		  return false;
    	  }
      }
      return true;
    }
}
