package Excel_Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel_Utility_LoginModule
{
	WebDriver driver;

	public static String  invalidemail1 = null;
	public	String	validpassword1= null;
	public	String	validemail2 = null;
	public	String	invalidpassword2= null;
	public	String	invalidemail3= null;
	public	String	invalidpassword3= null;
	public	String	validemail4= null;
	public	String	withoutpassword4= null;
	public	String	withoutemail5= null;
	public	String	validpassword5= null;
	public	String	withoutemail6= null;
	public	String	withoutpassword6= null;

	public void excel1() throws Exception {

		File  file=new File("C:\\Users\\Codetru\\Downloads\\Parspec_Updated3\\Parspec_Updated3\\src\\test\\resources\\TestData\\logindata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		

		invalidemail1 = sheet.getRow(1).getCell(0).getStringCellValue();
		validpassword1 = sheet.getRow(1).getCell(1).getStringCellValue();		
		validemail2 = sheet.getRow(2).getCell(0).getStringCellValue();
		invalidpassword2 = sheet.getRow(2).getCell(1).getStringCellValue();	
		invalidemail3 = sheet.getRow(3).getCell(0).getStringCellValue();
		invalidpassword3 = sheet.getRow(3).getCell(1).getStringCellValue();		
		validemail4 = sheet.getRow(4).getCell(0).getStringCellValue();
		withoutpassword4 = sheet.getRow(4).getCell(1).getStringCellValue();		
		withoutemail5 = sheet.getRow(5).getCell(0).getStringCellValue();
		validpassword5 = sheet.getRow(5).getCell(1).getStringCellValue();		
		withoutemail6 = sheet.getRow(6).getCell(0).getStringCellValue();
		withoutpassword6 = sheet.getRow(6).getCell(1).getStringCellValue();
		
		 wb.close();
	}
}
