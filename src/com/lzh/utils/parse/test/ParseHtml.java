package com.lzh.utils.parse.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseHtml {

	public ParseHtml(String file) {
		// TODO Auto-generated constructor stub
		
		parsr("C:/Users/Administrator/Desktop/parse/single.html");
//		parsr(new ParseWord().parseWordToHtml("C:/Users/Administrator/Desktop/parse/single.docx"));
	}

	private void parsr(String file){
		File file0 = new File(file);
//		System.out.println(file0);
		Document doc = null;
		try {
			doc = Jsoup.parse(file0, "GBK");
			String element = doc.outerHtml();
			String newele = replace(element);
			FileOutputStream fileOutputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/parse/single2.html"));
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK"); 
			outputStreamWriter.write(newele);
//			printWriter.append(newele.getBytes(), 0, newele.getBytes().length);
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Elements elements =  doc.getElementsContainingOwnText("${input}");
		
	}
	private String replace(String oldData){
		String newData = oldData
				.replace("${department}", setInputStyle("工商管理"))
				.replace("${major}", setInputStyle("营销系"))
				.replace("${name}",setInputStyle("庄东明"));
		return newData;
	}
	
	private String setInputStyle(String value){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<input type = \"text\"  style=\"border: none;border-bottom:solid 1px black;outline: none; background-color:transparent; text-align: center;font-size:20; width:100px\" value = \"")
				.append(value) 
				.append("\">");
		return stringBuilder.toString();
	}
}
