package com.lzh.utils.count.location;

public class Accurate {


	public static double parseCount(double[] d){

		double average = d[0];//平均数
		int sum = 1;//里程段数
		double sumDistance = d[0];//均匀段数的总里程
		double total =d[0];//总里程
		double singleDistance =d[0];//前一段的里程

		for(int i= 1;i<d.length;i++){
			if(errerCount(d[i],average)){//判断这一段长度是否与平均数在误差之内
				System.out.println("平均数："+average+"，前一位数："+singleDistance+",正常的值："+d[i]);
				total = total + d[i];//加入总里程
				sum++;//里程段数增加
				sumDistance = sumDistance+d[i];//均匀段内总里程增加
				average = sumDistance/sum;//计算平均数
			}else if(errerCount(d[i],singleDistance)){//判断与前一段里程是否在误差之内，成立则说明行动速度改变，均匀段重新计算
				System.out.println("平均数："+average+"，前一位数："+singleDistance+",不正常的值："+d[i]);
				sumDistance = singleDistance + d[i];//均匀段内总里程加上前一段不均匀的里程
				sum =2;
				total = total + sumDistance;
				average = sumDistance/sum;
			}else {//出现第一段不均匀的里程，或者是连续不均匀的里程
				System.out.println("平均数："+average+"，前一位数："+singleDistance+"，异常值："+d[i]);
			}
			singleDistance = d[i];
		}

		return total;
	}

	public static boolean errerCount(double count,double standard){
			return count<(standard*2) && count>(standard*0.2) ;
	}
}