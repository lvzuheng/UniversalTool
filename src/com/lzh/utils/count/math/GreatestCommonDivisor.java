package com.lzh.utils.count.math;

/**
 * @author lzh
 *存疑
 *求最大公约数：辗转相除法结合更相减损术
 *
 *两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。比如10和25，25减去10的差是15,那么10和25的最大公约数，等同于10和15的最大公约数。
 */
public class GreatestCommonDivisor {

	public static int getGCD(int a,int b){
		return gcd(a, b);
	}
	
	private static int gcd(int a,int b){
		if(a == b)
			return b;
		if(b>a){
			return gcd(b, a);
		}
		if((a&1) == 0 && (b & 1) ==0){
			return gcd(a >> 1, b >> 1) << 1;
		}else if((a&1)==0 && (b&1) ==1){
			return gcd(a >> 1, b);
		}else if ((a&1)==1 && (b&1) ==0) {
			return gcd(a, b>>1);
		}else {
			return gcd(a-b, b);
		}
	}
}
