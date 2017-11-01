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
		parseWeb parseWeb = new parseWeb();
	}

}
