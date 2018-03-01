package com.lzh.utils.count.math;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{2,4,3,1,5};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void sort(int[] array){
		int temp ;
		for(int i = 1;i<array.length;i++){
			temp = array[i];
			for( int j = i-1;j>=0 && temp < array[j];j--){
				array[j+1] = array[j];
				array[j] = temp;
			}
		}
	}
}
