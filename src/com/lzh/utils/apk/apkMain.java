package com.lzh.utils.apk;

import java.util.List;

public class apkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApkUtils apkUtils = new ApkUtils("C:\\Users\\Administrator\\Desktop\\jar\\app-debug.apk");
		List<String> vList = apkUtils.parseAttrbute("versionCode");
		for(String iString : vList){
			System.out.println(iString);
		}
	}

}
