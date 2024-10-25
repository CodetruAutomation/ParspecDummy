package Excel_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility_ForgotModule {

	
	public  String invalidemail1 = null;
	public String numericdata = null;
	public String invalidemail2 = null;
	public String validemail = null;

	public String onechar = null;

	public String invalidcriteria = null;

	public String validcriteria = null;

	public String invalidnewpassword = null;
	public String invalidconfpass = null;
	public String validpassword = null;
	public String passnotmatch = null;

	public void forgot_excel() throws IOException {
	
		File file = new File("C:\\Users\\Codetru\\Downloads\\Parspec_Updated3\\Parspec_Updated3\\src\\test\\resources\\TestData\\ForgotPasswordExcelData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
	

		invalidemail1 = sheet.getRow(1).getCell(0).getStringCellValue();
		numericdata = sheet.getRow(2).getCell(0).getStringCellValue();
		invalidemail2 = sheet.getRow(3).getCell(0).getStringCellValue();
		validemail = sheet.getRow(4).getCell(0).getStringCellValue();

		onechar = sheet.getRow(5).getCell(1).getStringCellValue();

		invalidcriteria = sheet.getRow(6).getCell(1).getStringCellValue();

		validcriteria = sheet.getRow(7).getCell(1).getStringCellValue();

		invalidnewpassword = sheet.getRow(8).getCell(1).getStringCellValue();
		invalidconfpass = sheet.getRow(8).getCell(2).getStringCellValue();

		validpassword = sheet.getRow(9).getCell(1).getStringCellValue();

		passnotmatch = sheet.getRow(10).getCell(2).getStringCellValue();
		

		wb.close();

}
}
