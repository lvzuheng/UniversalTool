package com.lzh.utils.parse.test;
//package com.lzh.utils.parse;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.POIXMLDocument;
//import org.apache.poi.POIXMLTextExtractor;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;
//import org.apache.poi.hwpf.usermodel.Range;
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.xwpf.converter.core.BasicURIResolver;
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//
//public class ParseWord {
//
//	public ParseWord() {
//		// TODO Auto-generated constructor stub
////		parseWord("C:/Users/Administrator/Desktop/testDoc.docx");
//	}
//
//	private void parseWord(){
//		try {
//			//			InputStream is = new FileInputStream(new File("C:/Users/Administrator/Desktop/testDoc.docx"));
//			//			WordExtractor ex = new WordExtractor(is);
//			//			String textDoc = ex.getText();
//			//			textDoc.replace("${input}", "替换了以后的内容在这里");
//
//			OPCPackage opcPackage = POIXMLDocument.openPackage("C:/Users/Administrator/Desktop/testDoc.docx");
//			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//			String textDoc = extractor.getText();
//			String newText = textDoc.replace("${input}", "替换了以后的内容在这里");
//			System.out.println(newText);
//			File file = new File("C:/Users/Administrator/Desktop/testDoc2.doc");
//			if(!file.exists()){
//				file.createNewFile();
//			}
//			FileOutputStream fOutputStream = new FileOutputStream(file);
//			fOutputStream.write(newText.getBytes(), 0, textDoc.getBytes().length);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void parseWord(String path){
//		String templatePath = path;  
//		InputStream is;
//		try {
//			is = new FileInputStream(templatePath);
//			XWPFDocument  doc = new XWPFDocument (is);  
//			List<XWPFParagraph> listParagraphs = doc.getParagraphs();//得到段落信息
//			for(int i=0;i<listParagraphs.size();i++){
//				System.out.println(listParagraphs.get(i).getRuns().size());
//				if(listParagraphs.get(i).getRuns().size()>0){
//					System.out.println(listParagraphs.get(i).getRuns().get(listParagraphs.get(i).getRuns().size()-1).getText(0));
//					listParagraphs.get(i).getRuns().get(listParagraphs.get(i).getRuns().size()-1).getText(0).replace("${input2}", "哪里哪里哪里");
//				} 
//			}
//			OutputStream os = new FileOutputStream("C:/Users/Administrator/Desktop/write.docx");  
//			doc.write(os);  
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//
//	}
//	
//	public String parseWordToHtml(String filePath){
//		try {
//			System.out.println(filePath);
//			FileInputStream is = new FileInputStream(filePath);
//			XWPFDocument document = new XWPFDocument(is); 
//			File file  = new File("C:/Users/Administrator/Desktop/parse/writeToHtml.html");
//			if(!file.exists())
//				file.createNewFile();
//			OutputStream out = new FileOutputStream(file); 
////			    File imgFolder = new File("C:/Users/Administrator/Desktop/parse");
////			    XHTMLOptions options = XHTMLOptions.create();
////			    options.setExtractor(new FileImageExtractor(imgFolder));
////			    //html中图片的路径 相对路径 
////			    options.URIResolver(new BasicURIResolver("image"));
////			    options.setIgnoreStylesIfUnused(false); 
////			    options.setFragment(true); 
//
//			XHTMLConverter.getInstance().convert(document, out,null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return "C:/Users/Administrator/Desktop/parse/writeToHtml.html";
//	}
//}
