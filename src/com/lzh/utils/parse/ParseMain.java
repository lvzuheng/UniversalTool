package com.lzh.utils.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.lzh.utils.parse.test.Html2Pdf;
import com.lzh.utils.parse.test.ParseWordToPDF;

public class ParseMain {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		  try {
//			new ParseWordToPDF().convert2Html("C:/Users/Administrator/Desktop/parse/single.doc","C:/Users/Administrator/Desktop/parse/single.html");
//			new Html2Pdf().convertHtmlToPdf("C:/Users/Administrator/Desktop/parse/single.html", "C:/Users/Administrator/Desktop/parse/singlePDF.pdf");
//			  WORD2PDF.transFormation("C:/Users/Administrator/Desktop/parse/纳税人证书业务申请表.docx", "C:/Users/Administrator/Desktop/parse/纳税人证书业务申请表.pdf");
//		  } catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		 Map<String, Object> param = new HashMap<String, Object>(); 
		 param.put("dianming", "百安达");
		 param.put("gongsiming", "中正鑫");
		 param.put("dizhi", "南山区");
		 param.put("mianji", "100平米");
		 param.put("fanwei", "很大");
		   Map<String,Object> header = new HashMap<String, Object>();  
	        header.put("width", 200);  
	        header.put("height", 75);  
	        header.put("type", "jpg");  
	        try {
				header.put("content", WordUtil.inputStream2ByteArray(new FileInputStream("C:/Users/Administrator/Desktop/parse/asd.jpg"), true));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        param.put("jianjie",header);  
	        WordUtil.generateWord(param, "C:/Users/Administrator/Desktop/parse/网站业务推广申请表.docx", "C:/Users/Administrator/Desktop/parse/网站业务推广申请表2.docx");
	}
	

}
