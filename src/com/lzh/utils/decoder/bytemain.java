package com.lzh.utils.decoder;

import java.nio.ByteBuffer;

import com.lzh.utils.decoder.BaseLineDecoder.DecodeListener;

public class bytemain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		write();
	}
	static BaseLineDecoder baseLineDecoder = new BaseLineDecoder(1024, new DecodeListener() {
		
		@Override
		public void onDecoderLister(byte[] msg) {
			// TODO Auto-generated method stub
			System.out.println("msg:"+new String(msg));
		}
	});
	private static void write(){
		byte[] bs = "123456789\r\nabcdefg".getBytes();
		byte[] bs2 = "hizklmn\r\n".getBytes();
		byte[] bs3 = "ddddddddd\r\n".getBytes();
		
		for(int i = 0;i<50;i++){
			baseLineDecoder.decode(bs);
		}

		
	}

}
