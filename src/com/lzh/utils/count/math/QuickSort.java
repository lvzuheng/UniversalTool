package com.lzh.utils.count.math;

import java.util.Arrays;

import org.junit.runner.manipulation.Sortable;

import com.lzh.utils.apk.apkMain;

public class QuickSort {

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
		int i = start;
		int j = end;
		int in = (i + j)/2;
		int index = array[in];
		while(i<j){
			while(i<in && array[i]<index) i++;
			if(i<in ) array[in] = array[i];
			in = i;
			while (j>in && array[j] >= index) j--;
			if(j>in) array[in] = array[j];
			in = j;
		}
		array[i] = index;
		sort(array, start, i-1);
		sort(array, i+1, end);
	}

}
