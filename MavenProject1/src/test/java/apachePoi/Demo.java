package apachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Demo {
	@Test
	public void test() throws Exception
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\91970\\Desktop\\Demo.xlsx");
	
	XSSFWorkbook book=new XSSFWorkbook(fis);
	
	XSSFSheet sheet=book.getSheet("demoSheet");
	
	sheet.createRow(0).createCell(0).setCellValue("HI"); 
	
	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	
	Row r;
	r=sheet.createRow(1);
	for(int i=1;i<=10;i++)
	{
		r.createCell(i).setCellValue(i); // it will insert at row 1 but 10 columns 
	}	
	
	for(int i=2;i<=10;i++)
	{
		sheet.createRow(i).createCell(1).setCellValue(i); // it will insert at 2nd row to 10 rows but at column 1
	}
	for(int i=2;i<=10;i++)
	{
		System.out.println((int)sheet.getRow(i).getCell(1).getNumericCellValue());
	}
	FileOutputStream fos=new FileOutputStream("C:\\Users\\91970\\Desktop\\Demo.xlsx");
	
	book.write(fos);
	
	
	
	
	
	
	}
	

}
