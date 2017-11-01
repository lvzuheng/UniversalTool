package com.lzh.utils.leetCode;

public class MaximumSubarray_53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray2(new int[]{-1,-2,-3,2,4,5,-2,-4}));
	}
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0;i<nums.length;i++){
            int count =nums[i];
            if(count>max)
                max = count;
            for(int j=i+1;j<nums.length;j++){
                count = count+nums[j];
                if(count>max)
                    max = count;
            }

        }
        return max;
    }
    
    public static int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for (int i=0; i<nums.length; i++) {
            if (sum<0)
                sum = nums[i];
            else
                sum += nums[i];
            if ( max<sum)
                max = sum;
        }
        return max;
    }
}
