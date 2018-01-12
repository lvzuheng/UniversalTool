package com.lzh.utils.buffer;

import java.nio.ByteBuffer;

import org.dom4j.Element;

public class ByteBufferUtils {

	private ByteBuffer buffer;
	public ByteBufferUtils(int bufferSize) {
		// TODO Auto-generated constructor stub
		buffer = ByteBuffer.allocate(bufferSize);
	}

	public void put(byte[] b,int off ,int len){
		if(!checkeBuffer(len-off)){
			buffer.compact();
			if(!checkeBuffer(len-off)){
				buffer.put(b,off,buffer.remaining());
				return;
			}
		}
		buffer.put(b,off,len);
	}
	public void put(byte[] b){
		System.out.println("buffer0:"+b.length);
		if(!checkeBuffer(b.length)){
			System.out.println("buffer1:"+buffer.remaining());
			buffer.put(b,0,buffer.remaining());
			return;
		}
		System.out.println("buffer2:"+buffer.remaining());
		buffer.put(b);
	}

	public int readBuffer(byte[] b){
		buffer.flip();
		int i;
		System.out.println("tas:"+buffer+","+buffer.remaining()+","+b.length);
		if(checkeBuffer(b.length)){
			i = b.length;
			buffer.get(b);
		}else {
			buffer.get(b,0,i = buffer.remaining());
		}
		if(buffer.hasRemaining()){
			buffer.compact();
		}else {
			buffer.clear();
		}
		return i;
	}
	public int readBuffer(byte[] b,int off ,int len){
		buffer.flip();
		int i;
		if(checkeBuffer(len-off)){
			buffer.get(b,off,i = len);
			if(buffer.hasRemaining()){
				buffer.compact();
			}else {
				buffer.clear();
			}
		}else {
			buffer.get(b,off,i = buffer.remaining());
			buffer.clear();
		}
		return i;
	}
	
	public int remaining(){
		return buffer.remaining();
	}
	
	public int bufferSize(){
		return buffer.capacity();
	}

	public void clear(){
		buffer.clear();
	}

	private boolean checkeBuffer(int length){
		return (buffer.remaining()>=length);
	}
}
