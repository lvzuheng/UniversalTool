package com.lzh.utils.decoder;

import java.nio.ByteBuffer;
import java.sql.Date;

import org.dom4j.Element;

/**
 * 
 * 基础行解码器
 * 作用：解析\r\n的缓存流
 * 
 * */
public class BaseLineDecoder {
	

	private DecodeListener decodeListener;
	private ByteBuffer buffer;
	
	public BaseLineDecoder(Integer size,DecodeListener decodeListener) {
		// TODO Auto-generated constructor stub
		this.decodeListener = decodeListener;
		this.buffer = ByteBuffer.allocate(size);
	}
	
	public void decode(byte[] bs){
		buffer.put(bs);
		parseLine2(buffer);
	}
	
	public int parseLine(ByteBuffer buffer){
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
				buffer.position(pos+matchCount);
				oldPos = pos;
				matchCount = 0;
				matched = false;
				decodeListener.onDecoderLister(data);
			}
		}
		if(buffer.position() == oldPos){
			buffer.clear();
			buffer.position(oldPos);
		}else{
			buffer.position(oldPos);
		}
		return oldPos;
	}
	
	private void parseLine2(ByteBuffer buffer){
		buffer.flip();
		int matchCount = 0;
		buffer.mark();
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
				System.out.println("de:"+","+buffer.position());
				int pos = buffer.position();
				buffer.reset();
				data = new byte[pos-buffer.position()-matchCount];
				buffer.get(data);
				buffer.position(pos);
				buffer.mark();
				matchCount = 0;
				matched = false;
				decodeListener.onDecoderLister(data);
			}
		}
		buffer.reset();
		buffer.compact();
	}

	
	public interface DecodeListener{
		void onDecoderLister(byte[] msg);
	}
}


