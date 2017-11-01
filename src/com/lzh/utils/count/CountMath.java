package com.lzh.utils.count;

public class CountMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(twoSum(new String[]{"0123","0134","01322","01011234"}));
	}
	public static String twoSum(String[] strs) {

      	int minLength = strs[0].length();
		int minStr= 0;
		for(int i = 0;i<strs.length;i++)
			if(strs[i].length()<=minLength){
				minLength = strs[i].length();
				minStr = i;
			}
		
		while(minLength>0){
			boolean flag = false;
			for(int m = 0;m<strs.length;m++){
				System.out.println(minLength+","+strs[m].substring(0, minLength)+","+strs[minStr].substring(0, minLength));
				if(!strs[m].substring(0, minLength).equals(strs[minStr].substring(0, minLength))){
					minLength--;
					flag = true;
				}
			}
			if(!flag)
				break;
		}

		return strs[minStr].substring(0, minLength);
    }


}
