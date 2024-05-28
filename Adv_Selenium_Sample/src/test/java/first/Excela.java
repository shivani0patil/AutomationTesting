package first;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Excela {

	public static void main(String[] args) throws Throwable, IOException {

		// TODO Auto-generated method stub
		
		
		FileInputStream fs=new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Sheet2");
		Row row=sh.getRow(1);
		Cell cel=row.getCell(3);
		String data=cel.toString();
		System.out.println(data);
		wb.close();
		
//		FileInputStream fis=new FileInputStream("‪./Adv_Selenium/Book1.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh=wb.getSheet("Sheet1");
//		Row row=sh.getRow(0);
//		Cell cell1=row.getCell(0);
//		System.out.println(cell1.getStringCellValue());
//		
		
		
		
		
		
		
		
		
		
		
		
		
      
//		FileInputStream fs=new FileInputStream("‪./src/test/resources/organization.xlsx");
//		
//		Workbook bk=WorkbookFactory.create(fs);
//		Sheet sh=bk.getSheet("Sheet1");
//	    Row row=	sh.getRow(1);
//	    Cell cel=row.getCell(2);
//	    String data=cel.getStringCellValue();
//	    System.out.println(data);
//	    bk.close();
	}

}
