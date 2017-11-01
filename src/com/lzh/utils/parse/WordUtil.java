package com.lzh.utils.parse;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;





public class WordUtil {

	private static String prefix ="${";
	private static String stuffix = "}";


	public static void main(String[] args) {
//		// TODO Auto-generated method stub
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

	/** 
	 * 根据指定的参数值、模板，生成 word 文档 
	 * 
	 * @param param 需要替换的变量 ,key为要替换的占位符,value:String为替换文字，Map为替换图片
	 * @param template 模板 
	 */  
	public static CustomXWPFDocument generateWord(Map<String, Object> param, String template,String outputFile) {  
		CustomXWPFDocument doc = null;  
		try {  
			OPCPackage pack = POIXMLDocument.openPackage(template);  
			doc = new CustomXWPFDocument(pack);  
			if (param != null && param.size() > 0) {  

				//处理段落  
				List<XWPFParagraph> paragraphList = doc.getParagraphs();  
				processParagraphs(paragraphList, param, doc);  

				//处理表格  
				Iterator<XWPFTable> it = doc.getTablesIterator();  
				while (it.hasNext()) {  
					XWPFTable table = it.next();  
					List<XWPFTableRow> rows = table.getRows();  
					for (XWPFTableRow row : rows) {  
						List<XWPFTableCell> cells = row.getTableCells();  
						for (XWPFTableCell cell : cells) { 	
							List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();  
							processParagraphs(paragraphListTable, param, doc);  
						}  
					}  
				}  
			}
			FileOutputStream outputStream = new FileOutputStream(new File(outputFile));
			doc.write(outputStream);
			outputStream.close();
		} catch (Exception e) {  
			e.printStackTrace();  
		}  

		return doc;  
	}  

	/** 
	 * 处理段落 
	 * @param paragraphList 
	 */  
	public static void processParagraphs(List<XWPFParagraph> paragraphList,Map<String, Object> param,CustomXWPFDocument doc){  
		Map<Integer, Map<String, Object>> pMap = new HashMap<>();
		if(paragraphList == null || paragraphList.size() <= 0) 
			return;

		Iterator<XWPFParagraph> iterator = paragraphList.iterator();
		XWPFParagraph paragraph;
		while(iterator.hasNext() && (paragraph = iterator.next()).getText()!=null){

			for (Entry<String, Object> entry : param.entrySet()) {  
				String key =prefix+ entry.getKey() +stuffix; 
				if(paragraph.getText().indexOf(key)!=-1){  
					Object value = entry.getValue();
					Iterator<XWPFRun> ite  = paragraph.getRuns().iterator();
					while(ite.hasNext()){
						ite.next().setText("",0);
					}
					if (value instanceof String ) {//文本替换 
						paragraph.createRun().setText(value.toString());
					} else if (value instanceof Map) {//图片替换
						Map pic = (Map)value;  
						int width = Integer.parseInt(pic.get("width").toString());  
						int height = Integer.parseInt(pic.get("height").toString());  
						int picType = getPictureType(pic.get("type").toString());  
						byte[] byteArray = (byte[]) pic.get("content");  
						ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteArray);  
						try {  
							String ind = doc.addPictureData(byteInputStream,picType);
							doc.createPicture(doc.getAllPictures().size()-1,width,height,paragraph);  
						} catch (Exception e) {  
							e.printStackTrace();  
						}  
					}  
				}  
			}  
		}

	}  

	/** 
	 * 根据图片类型，取得对应的图片类型代码 
	 * @param picType 
	 * @return int 
	 */  
	private static int getPictureType(String picType){  
		int res = CustomXWPFDocument.PICTURE_TYPE_PICT;  
		if(picType != null){  
			if(picType.equalsIgnoreCase("png")){  
				res = CustomXWPFDocument.PICTURE_TYPE_PNG;  
			}else if(picType.equalsIgnoreCase("dib")){  
				res = CustomXWPFDocument.PICTURE_TYPE_DIB;  
			}else if(picType.equalsIgnoreCase("emf")){  
				res = CustomXWPFDocument.PICTURE_TYPE_EMF;  
			}else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){  
				res = CustomXWPFDocument.PICTURE_TYPE_JPEG;  
			}else if(picType.equalsIgnoreCase("wmf")){  
				res = CustomXWPFDocument.PICTURE_TYPE_WMF;  
			}  
		}  
		return res;  
	}  

	/** 
	 * 将输入流中的数据写入字节数组 
	 * @param in 
	 * @return 
	 */  
	public static byte[] inputStream2ByteArray(InputStream in,boolean isClose){  
		byte[] byteArray = null;  
		try {  
			int total = in.available();  
			byteArray = new byte[total];  
			in.read(byteArray);  
		} catch (IOException e) {  
			e.printStackTrace();  
		}finally{  
			if(isClose){  
				try {  
					in.close();  
				} catch (Exception e2) {  
					System.out.println("关闭流失败");  
				}  
			}  
		}  
		return byteArray;  
	}  
}
