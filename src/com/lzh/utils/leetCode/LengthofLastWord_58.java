package com.lzh.utils.leetCode;

public class LengthofLastWord_58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("hello ppp"));
	}

	
    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if(str.length<=0 || str[str.length-1] ==" ")
        	return 0;
        String[] st = str[str.length-1].split("/");
        if(st.length<=0 || st[st.length-1]=="/")
            return 0;
        return st[st.length-1].length();
    }  
}
