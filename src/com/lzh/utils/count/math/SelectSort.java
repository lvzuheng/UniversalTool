package com.lzh.utils.count.math;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = new int[]{2,3,5,4,3,1,5};
		sort(is,0,is.length-1);
		System.out.println("aaa:"+Arrays.toString(is));
	}
	
	public static void sort(int[] array,int start,int end){
		if(start >=end){
			return ;
		}
		int in,out,min,temp;
		for(out = start;out<end;out++){
			min = out;
			for(in = out+1;in<end;in++){
				if(array[min] > array[in]){
					min = in;
				}
			}
			System.out.println("aaa:"+out);
			temp = array[min];
			array[min] = array[out];
			array[out] = temp;
		}
	}
}
