package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constantClasses.ConstantData;



public class FetchDataFromExcel {
	
	public static String readData(int x,int y) throws IOException
	{
		FileInputStream fs=new FileInputStream(ConstantData.EXCEL_PATH);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell val=sheet.getRow(x).getCell(y);
		String URL=val.toString();
		return URL;		
	}
	
	public static void writeData(int i, int j, String ActualNewAccountOpenId) throws IOException {
		FileInputStream fis = new FileInputStream(ConstantData.EXCEL_PATH);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		 // Create row if not exists
	    if (sheet.getRow(i) == null) {
	        sheet.createRow(i);
	    }

	    // Create cell if not exists
	    if (sheet.getRow(i).getCell(j) == null) {
	        sheet.getRow(i).createCell(j);
	    }

	    // Set value
	    sheet.getRow(i).getCell(j).setCellValue(ActualNewAccountOpenId);

	    // Close input stream BEFORE writing
	    fis.close();

	    // Save file
	    FileOutputStream fos = new FileOutputStream(ConstantData.EXCEL_PATH);
	    workbook.write(fos);

	    // Properly close everything
	    fos.close();
	    workbook.close();

	    System.out.println("Excel updated successfully");
	
	}

}
