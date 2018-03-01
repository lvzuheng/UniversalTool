package com.lzh.utils.leetCode;

import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.formula.ptg.IntPtg;

public class SingleNumber_136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = new int[]{1,2,3,3,1,4,5,5,4,6,7,7,6};
		System.out.println(singleNumber(is));
	}
	public static int singleNumber(int[] nums) {
		if(nums == null || nums.length ==0){
			return Integer.MIN_VALUE;
		}
		int res = nums[0];
		for(int i =1;i<nums.length;i++){
			res ^= nums[i];
		}
		return res;
	}
}
