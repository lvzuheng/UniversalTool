package com.lzh.utils.parse.test;
//package com.lzh.utils.parse;
//
//import java.io.File;
//import java.io.InputStream;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.io.SAXReader;
//
//public class parseXML {
//
//	
//	public parseXML(String file) {
//		// TODO Auto-generated constructor stub
//		parseDocument(getDocument(file));
//	}
//	
//	private Document getDocument(String file){
//		  SAXReader saxReader = new SAXReader();  
//          Document document = null;  
//          try {  
//              document = saxReader.read(file);  
//          } catch (DocumentException e) {  
//              e.printStackTrace();  
//          }  
//          return document;  
//	}
//	
//	private Document parseDocument(Document document){
//		
//		String documentStr =document.asXML();
//		documentStr.replace("${input}", "这是一个输入框的输入函数");
//		Document newDoucument = null;
//		try {
//			 newDoucument = DocumentHelper.parseText(documentStr);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return newDoucument;
//	}
//	
//	private void writeToWord(){
//		   File file = null;  
//	       InputStream fin = null;  
//	}
//}
