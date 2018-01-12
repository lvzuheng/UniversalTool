package com.lzh.utils.buffer;

public class BufferMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ByteBufferUtils bufferUtils = new ByteBufferUtils(32);
		byte[] bs1  = "abcdefghijklmnopqrstuvwxyz".getBytes();
		byte[] bs2  = "1234567890".getBytes();
		bufferUtils.put(bs1);
		bufferUtils.put(bs2);
		byte[] bs3 = new byte[46];
		bufferUtils.readBuffer(bs3);
		bufferUtils.readBuffer(bs3,0,10);
		System.out.println(new String(bs3));
	}
	

}
