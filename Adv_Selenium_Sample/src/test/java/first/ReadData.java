package first;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
//     FileInputStream fs=new FileInputStream("src/test/resources/Book3.xlsx");
//     Workbook wb=WorkbookFactory.create(fs);
//        Sheet sh = wb.getSheet("mobail");
//         int count=sh.getLastRowNum();
//         for(int i=1;i<=count;i++)
//         {
//        String data1=sh.getRow(i).getCell(0).toString();
//        String data2=sh.getRow(i).getCell(1).toString();
//        System.out.println(data1+"\t"+data2);
//         }
         
         
         // base on some condotion
         
		FileInputStream fs=new FileInputStream("./src/test/resources/Book5.xlsx");
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Sheet1");
		int count=sh.getLastRowNum();
		String data1="";
		String data2="";
		String data3="";
		String Id="5.0";
		Boolean flag=false;
		
		for(int i=1;i<=count;i++)
		{
			String data="";
			try {
				 data=sh.getRow(i).getCell(0).toString();
				 if(data.equals(Id))
				 {
					 flag=true;
					 data1=sh.getRow(i).getCell(1).toString();
					 data2=sh.getRow(i).getCell(2).toString();
					 data3=sh.getRow(i).getCell(3).toString();
				 }
			}
			catch(Exception e) {}
			 
		
		System.out.println(data);
		} 
		if(flag==true)
		{
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		}
		else
		{
			System.out.println("is not availabel"+Id);
		}
        
	}
}
