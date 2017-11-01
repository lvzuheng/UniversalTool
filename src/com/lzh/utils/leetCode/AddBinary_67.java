package com.lzh.utils.leetCode;

public class AddBinary_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1", "111"));
//		int x = '2'-'1';
//		System.out.println(x );

	}
	public static String addBinary(String a, String b) {
		if(a.length() ==0 || b.length() ==0)
			return a+b;
		int index = 0;
		StringBuilder sBuilder = new StringBuilder();
		int alength = a.length();
		int blength = b.length();
		while(alength>0 || blength >0 || index>0){
			int ar = alength>0?a.charAt(alength-1) - '0':0;
			int br = blength>0?b.charAt(blength-1) - '0':0;
			sBuilder.insert(0,ar + br +index >=2?ar + br +index-2:ar + br +index);
			index = ar + br +index >=2?1:0;
			alength --;
			blength --;
		}
		
		return sBuilder.toString();
	}

}
