package com.lzh.utils.test;

import java.nio.ByteBuffer;

import com.lzh.utils.leetCode.ListNode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer integer = new Integer(5);
		fuzhi(integer);
		System.out.println(integer.intValue());
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

}
