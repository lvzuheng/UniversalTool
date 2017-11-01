package com.lzh.utils.leetCode;

import java.math.BigInteger;
import java.util.Stack;

public class ReverseInteger_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
	}
		
    public static int reverse(int x) {
    	char[] ch =  (x+"").toCharArray();
    	StringBuilder sb = new StringBuilder();
    	int i = sb.append(x<0?ch[0]:"").length();
    	for(int j = ch.length-1;j>=i;j--){
    		sb.append(ch[j]);
    	}
    	if(Double.valueOf(sb.toString())>Integer.MAX_VALUE || Double.valueOf(sb.toString())<Integer.MIN_VALUE)
    		return 0;
    	return Integer.valueOf(sb.toString());
   }
}
