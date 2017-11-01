package com.lzh.utils.decoder;

import java.util.Arrays;
import java.util.List;

public class parseWeb {
	
	public parseWeb() {
		// TODO Auto-generated constructor stub
		String html = "http://www.baidu.com/web/20160101/20110213/123456425.mp4";
		System.out.println(parseHtml(html, "web/"));
		
	}
	
	
	public List<String> parseHtml(String html,String indexOf){
		int index = html.indexOf(indexOf);
		String data = html.substring(index+indexOf.length(),html.length());
		String[] str = data.split("/");
		return Arrays.asList(str);
	}
}
