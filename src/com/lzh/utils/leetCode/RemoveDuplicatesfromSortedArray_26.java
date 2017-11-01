package com.lzh.utils.leetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesfromSortedArray_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,2,2,3,3,4,5,6}));
	}
    public static int removeDuplicates(int[] nums) {
    	int count =1;
        for(int i =0;i<nums.length-1;i++)
        	if(nums[i+1]!=nums[i]){
        		nums[count] = nums[i+1];
        		count++;
        	}

        return count;
    }
}
