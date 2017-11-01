package com.lzh.utils.decoder;

import java.nio.ByteBuffer;

/**
 * 
 * 基础行解码器
 * 作用：解析\r\n的缓存流
 * 
 * */
public class BaseLineDecoder {
	

	public int decoder(ByteBuffer buffer,DecodeListener decodeListener){
		int matchCount = 0;
		int oldPos = buffer.position();
//		int oldLimit = buffer.limit();
		byte[] data = null;
		boolean matched = false;
		while (buffer.hasRemaining()) {
			byte b = buffer.get();
			switch (b) {
			case '\r':
				matchCount++;
				break;
			case '\n':
				matchCount++;
				matched = true;
				break;
			default:
				matchCount = 0;
			}
			if (matched) {
				int pos = buffer.position();
				buffer.position(oldPos);
				data = new byte[pos-oldPos-matchCount];
				buffer.get(data);
				buffer.position(pos);
				oldPos = pos;
				matchCount = 0;
				matched = false;
				decodeListener.onDecoderLister(data);
			}
		}
		return oldPos;
	}
	
	interface DecodeListener{
		void onDecoderLister(byte[] msg);
	}
}


