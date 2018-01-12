package com.lzh.utils.decoder;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;

import com.lzh.utils.decoder.BaseLineDecoder.DecodeListener;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		byte[] bs = "dddddddddddddddd\r\ndqweqweqweqwed\r\n\1adasdasda111".getBytes();
//		ByteBuffer buffer = ByteBuffer.wrap(bs);
//		long time = System.nanoTime();
//		BaseLineDecoder baseLineDecoder = new BaseLineDecoder();
//		int result = baseLineDecoder.decoder(buffer, new DecodeListener() {
//			
//			@Override
//			public void onDecoderLister(byte[] msg) {
//				// TODO Auto-generated method stub
////				System.out.println(new String(msg));
//			}
//		});
//		
//		System.out.println("时间 "+(System.nanoTime() - time));
//		 time = System.nanoTime();
//		String str = new String(bs);
//		String[] strings = str.split("\r\n");
//		for (int i = 0; i < strings.length; i++) {
////			System.out.println(strings[i]);
//		}
//		System.out.println("时间 "+(System.nanoTime() - time));
////		System.out.println("读了多少："+result);
//		parseWeb parseWeb = new parseWeb();
		byte[] bs = new byte[20480000];
		for(int i =0;i<bs.length;i++){
			Integer a = (int) (Math.random() *100);
			bs[i] = a.toString().getBytes()[0];
		}
		System.out.println("result:"+(strcopy(bs)<strqn(bs)));
	}

	public static long  strcopy(byte[] b2){
		byte[] b1 = new byte[20480000];
		long start = System.currentTimeMillis();
		System.arraycopy(b2, 0, b1, 0, b1.length);
		long end = System.currentTimeMillis();
		System.out.println("copy:"+(end-start));
		return  (end-start);
	}
	public static long strqn(byte[] b2){
		byte[] b1 = new byte[20480000];
		long start = System.currentTimeMillis();
		for(int i=0;i<b1.length;i++){
			b1[i] = b2[i];
		}
		long end = System.currentTimeMillis();
		System.out.println("strqn:"+(end - start));
		return  (end-start);
	}
}
