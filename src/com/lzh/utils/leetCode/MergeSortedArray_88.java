package com.lzh.utils.leetCode;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[10];
//		nums1[0] = 0;
//		nums1[1] = 3;
//		nums1[2] = 5;
		int[] nums2 = new int[]{1};
		int[] is  = merge(nums1,0,nums2,1);
		for(int j=0;j<is.length;j++)
			System.out.println(is[j]);
	}
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if( nums1 == null || m==0)
            nums1 = nums2;
        if( nums2 == null ||n==0)
            return nums1;
        int i = m;
        int j = n;
        while(i>0 && j>0 ){
        	if(nums1[i-1]>=nums2[j-1]){
        		nums1[i+j-1] = nums1[i-1];
        		i--;
        	}else{
        		nums1[i+j-1] = nums2[j-1];
        		j--;
        	}
        }
        return nums1;
    }
}
