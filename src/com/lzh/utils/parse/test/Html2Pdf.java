package com.lzh.utils.parse.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

public class Html2Pdf {

	
	public   static  void  main(String [] args){  
		Html2Pdf html2Pdf =new Html2Pdf();  
		try {  
			convert2Html("C:/Users/Administrator/Desktop/parse/single.doc","C:/Users/Administrator/Desktop/parse/single.html");
			html2Pdf.convertHtmlToPdf("C:/Users/Administrator/Desktop/parse/single.html","C:/Users/Administrator/Desktop/parse/single.pdf");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}  
	
	 public boolean convertHtmlToPdf(String inputFile, String outputFile)  
	            throws Exception {  
	  
	        OutputStream os = new FileOutputStream(outputFile);  
	        ITextRenderer renderer = new ITextRenderer();  
//	        String url = new File(inputFile).toURI().toURL().toString(); 
	        File file = new File(inputFile);
//	        Rectangle pageSize = new Rectangle(800, 610);
//	        renderer.setDocument(document, url);
//	         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
//	         Document doc = builder.parse(file); 
	        renderer.setDocument(file);  
	        // 解决中文支持问题  
	        ITextFontResolver fontResolver = renderer.getFontResolver();  
	        fontResolver.addFont("C:/Windows/Fonts/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
	        //解决图片的相对路径问题  
	        renderer.getSharedContext().setBaseURL("C:/Users/Administrator/Desktop/parse");  
	        renderer.layout();  
	        renderer.createPDF(os,true,0); 
	        os.flush();  
	        os.close();  
	        return true;  
	    }  
	  
	     
	   //word 转 html   
	     public static void convert2Html(String fileName, String outPutFile)  
	             throws TransformerException, IOException,  
	             ParserConfigurationException {  
	   
	         HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));//WordToHtmlUtils.loadDoc(new FileInputStream(inputFile));  
//	          兼容2007 以上版本  
//	         XSSFWorkbook  xssfwork=new XSSFWorkbook(new FileInputStream(fileName));  
	         WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(  
	                 DocumentBuilderFactory.newInstance().newDocumentBuilder()  
	                         .newDocument());  
	         wordToHtmlConverter.setPicturesManager( new PicturesManager()  
	         {  
	             public String savePicture( byte[] content,  
	                                        PictureType pictureType, String suggestedName,  
	                                        float widthInches, float heightInches )  
	             {  
	                 return "test/"+suggestedName;  
	             }  
	         } );  
	         wordToHtmlConverter.processDocument(wordDocument);  
	         //save pictures  
	         List pics=wordDocument.getPicturesTable().getAllPictures();  
	         if(pics!=null){  
	             for(int i=0;i<pics.size();i++){  
	                 Picture pic = (Picture)pics.get(i);  
	                 System.out.println();  
	                 try {  
	                     pic.writeImageContent(new FileOutputStream("D:/test/"  
	                             + pic.suggestFullFileName()));  
	                 } catch (FileNotFoundException e) {  
	                     e.printStackTrace();  
	                 }  
	             }  
	         }  
	         Document htmlDocument = wordToHtmlConverter.getDocument();  
	   
	         ByteArrayOutputStream out = new ByteArrayOutputStream();  
	         DOMSource domSource = new DOMSource(htmlDocument);  
	         StreamResult streamResult = new StreamResult(out);  
	   
	   
	         TransformerFactory tf = TransformerFactory.newInstance();  
	         Transformer serializer = tf.newTransformer();  
	         serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
	         serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
	         serializer.setOutputProperty(OutputKeys.METHOD, "HTML");  
	         serializer.transform(domSource, streamResult);  
	         out.close();  
	     }  
}
