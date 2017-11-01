package com.lzh.utils.leetCode;

public class SqrtX_69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(15));
	}

	public static int mySqrt(int x) {
		if (x == 0) return 0;  
		double max = x;
		double min =0;
		double y =x/2;
		while(y*y != x){
			if(y*y>x){
				max = y;
				y = (y+min)/2;
			}
			else{
				min = y;
				y = (y+max)/2;
			}
			if (y== max || y == min)
				break;
		}
		return (int)(y);  
	}
}
