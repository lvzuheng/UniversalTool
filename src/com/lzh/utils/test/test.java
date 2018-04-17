package com.lzh.utils.test;

import java.nio.ByteBuffer;

import org.jsoup.select.Evaluator.Id;

import com.lzh.utils.leetCode.ListNode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer integer = new Integer(5);
//		fuzhi(integer);
//		System.out.println(tuzi(2));
		innernn i=new innernn();
		i.id = "1";
		change(i);
		System.out.println(i.id);
	}

	public static void fuzhi(Integer integer){
		ByteBuffer buffer = ByteBuffer.allocate(512);
		byte[] bs1 = "abcefgh".getBytes();
		byte[] bs2 = new byte[2];
		buffer.put(bs1);
		buffer.flip();
		buffer.get(bs2);
		buffer.compact();
		byte[] bs3 = new byte[7];
		buffer.clear();
		//		System.out.println(buffer.remaining());
		buffer.get(bs3);
		System.out.println(new String(bs3));
	}
	public static double tuzi(int mouth){
		int in = (mouth - 3)>0?(mouth-mouth%3)/3:0;
		return (int)Math.pow(2, in);
	}

	public static class innernn{
		public String id;
	}
	
	public static void change(innernn name){
		name.id = "2";
	}

}
