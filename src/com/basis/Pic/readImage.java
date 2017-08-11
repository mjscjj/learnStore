package com.basis.Pic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;



public class readImage {
	
	
	public static void main(String[] args) {
	}
	

	
	public static void readImage(){
	
	        // 待解析PDF
	        File pdfFile = new File("C:\\Users\\weidx\\Documents\\My Access-IS Data\\PDFs\\in.pdf");      
	        // 空白PDF
	        File pdfFile_out = new File("C:\\Users\\weidx\\Documents\\My Access-IS Data\\PDFs\\out.pdf");
	
	        PDDocument document = null;  
	        PDDocument document_out = null;  
	        try {  
	            document = PDDocument.load(pdfFile);  
	            document_out = PDDocument.load(pdfFile_out);  
	        } catch (IOException e) {  
	            e.printStackTrace();
	        }  
	
	        int pages_size = document.getNumberOfPages();
	
	        System.out.println("getAllPages==============="+pages_size);  
	        int j=0;
	
	        for(int i=0;i<pages_size;i++) {  
	            PDPage page = document.getPage(i);
	            PDPage page1 = document_out.getPage(0);
	            PDResources resources = page.getResources();  
	            Iterable xobjects = resources.getXObjectNames();
	
	            if (xobjects != null) {  
	                Iterator imageIter = xobjects.iterator();  
	                while (imageIter.hasNext()) {  
	                    COSName key = (COSName) imageIter.next();  
	                    if(resources.isImageXObject(key)){              
	                        try {
	                            PDImageXObject image = (PDImageXObject) resources.getXObject(key);
	
	                            // 方式一：将PDF文档中的图片 分别存到一个空白PDF中。
	                            PDPageContentStream contentStream = new PDPageContentStream(document_out,page1,AppendMode.APPEND,true);
	
	                            float scale = 1f;
	                            contentStream.drawImage(image, 20,20,image.getWidth()*scale,image.getHeight()*scale);
	                            contentStream.close();
	                            document_out.save("C:\\Users\\weidx\\Documents\\My Access-IS Data\\PDFs\\"+j+".pdf");
	
	                            System.out.println(image.getSuffix() + ","+image.getHeight() +"," + image.getWidth());
	
	                            /**
	                            // 方式二：将PDF文档中的图片 分别另存为图片。
	                            File file = new File("/Users/xiaolong/Downloads/123"+j+".png");
	                            FileOutputStream out = new FileOutputStream(file);
	
	                            InputStream input = image.createInputStream();                   
	
	                            int byteCount = 0;
	                            byte[] bytes = new byte[1024];
	
	                            while ((byteCount = input.read(bytes)) > 0)
	                            {                       
	                                out.write(bytes,0,byteCount);       
	                            }
	
	                            out.close();
	                            input.close();
	                            **/
	
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        } 
	                        j++;  
	                    }                 
	                }  
	            } 
	        } 
	
	        System.out.println(j);
	    }  
}

