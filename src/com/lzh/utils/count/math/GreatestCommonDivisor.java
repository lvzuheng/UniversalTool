package com.lzh.utils.count.math;

/**
 * @author lzh
 *
 *求最大公约数：更相减损术
 *
 *两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。比如10和25，25减去10的差是15,那么10和25的最大公约数，等同于10和15的最大公约数。
 */
public class GreatestCommonDivisor {

	public static int getGCD(int a,int b){
		int resule = 1;
		if(a == b)
			resule =  a;
		if(a >b)
			resule =  gcd(a, b);
		if(a < b)
			resule =  gcd(b, a);
		return resule;
	}
	
	private static int gcd(int a,int b){
		if(a%b == 0)
			return b;
		return gcd(b, a%b);
	}
}
