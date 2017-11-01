package com.lzh.utils.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.poi.ss.formula.functions.Index;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	 public static boolean isValid(String s) {
	        Stack<Character> stk = new Stack<Character>();
	        for(int i = 0; i < s.length(); i++){
	            Character c = s.charAt(i);
	            switch(c){
	                case '(': case '[': case '{':
	                    stk.push(c);
	                    break;
	                case ')':
	                	 if(stk.isEmpty() || (int)stk.pop()!=40)
	                		 return false;
	                	 break;
	                case ']':
	                	 if(stk.isEmpty() || (int)stk.pop()!=91)
	                		 return false;
	                	 break;
	                case '}':
	                	 if(stk.isEmpty() || (int)stk.pop()!=123)
	                		 return false;
	                	 break;
	            }
	        }
	        return stk.isEmpty();
	    }
}
