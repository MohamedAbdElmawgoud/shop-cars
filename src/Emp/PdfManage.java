/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emp;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;



public class PdfManage {
    private static String FILE = "filepdf.pdf";
     private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    String  pdf (CustomerRecord cus, int value) throws FileNotFoundException, DocumentException{
        Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.addTitle("CustomerRecord");
            document.addSubject("Renting a car");
            document.add(new Paragraph("Name : "+cus.Name));
        document.add(new Paragraph("ID : "+cus.ID));
        document.add(new Paragraph("Address : "+cus.Address));
        document.add(new Paragraph("Gender : "+cus.Gender));
        document.add(new Paragraph("Phone Num : "+cus.PhoneNum));
        document.add(new Paragraph("Rent Date : "+cus.RentDate));
        document.add(new Paragraph("VehicleNum : "+cus.VehicleNum));
        document.add(new Paragraph("Number of Rent Days : "+cus.NofRentingDays));
        document.add(new Paragraph("car rent value : "+value));
        document.add(new Paragraph("Payment : "+cus.NofRentingDays*value));
        document.add(new Paragraph("Car Used as : "+cus.UsedAs));
        if(cus.Driver==false){
        document.add(new Paragraph("Driver State : "+cus.Driver));
        }else{
            document.add(new Paragraph("Driver State : "+cus.Driver));
            document.add(new Paragraph("Driver name : "+cus.DriverName));
        }
        document.add(new Paragraph(" Emailexampe@Example.com"));
        document.close();
        return FILE;
    }
}
