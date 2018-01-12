//package com.lzh.utils.test;
//
//public class compareUtils {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		String news = "0200001C0135585138370000000000000000000201CAD2A90630CB77000000780058171023135016";
//
//
//
//		byteeh(news);
//		
//	}
//
//
//	public static void bytesingleeh(String str){
//		byte[] data = str.getBytes();
//		byte code = 0 ;
//		for(int i = data.length;i>0;i-=1){
//			//		String str3 = news.substring(news.length() - i, news.length() - i + 1);
//			System.out.println("string1:"+code+",string2:"+data[data.length - i]+","+(data.length - i)+","+news.length());
//			code = (byte)(code ^ data[data.length - i]);
//		}
//		System.err.println(String.format("%02X", code));
//	}
//
//	public static void streh(String str){
//		byte code = 0 ;
//
//		for(int i = str.length();i>0;i-=1){
//			String str3 = str.substring(str.length() - i, str.length() - i + 1);
//			System.out.println("string1:"+code+",string2:"+str3+","+i+","+str.length());
//			code = (byte)(code ^ Short.parseShort(str3,16));
//		}
//
//		System.err.println(String.format("%02X", code));
//	}
//}
