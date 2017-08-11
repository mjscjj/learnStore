package com.basis.File;  
  
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

//import java.io.File;  


  
public class CreatePDF {  
    public static void main(String[] args) throws IOException{  
        PDDocument document = new PDDocument();  
        PDPage page = new PDPage();  
        document.addPage(page);  
          
//      PDFont font = PDTrueTypeFont.loadTTF(document, new File("SIMSUN.TTC"));  
        PDFont font = PDType1Font.HELVETICA_BOLD;  
          
        PDPageContentStream contentStream = new PDPageContentStream(document, page);  
        contentStream.beginText();  
        contentStream.setFont(font, 14);  
        contentStream.moveTextPositionByAmount(100, 700);  
        contentStream.drawString("Hello World");  
//      contentStream.drawString("中文");  
        contentStream.endText();  
          
        contentStream.close();  
          
        try {  
            document.save("D:/test.pdf");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        document.close();  
    }  
}  