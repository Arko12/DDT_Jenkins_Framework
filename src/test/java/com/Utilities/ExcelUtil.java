package com.Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	
	public ExcelUtil(String excelPath) {
		try {
		fis= new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int getRowcount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int rows=sheet.getLastRowNum();
		return rows+1;
	}
	
	public static int getColumncount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int colms=sheet.getRow(0).getLastCellNum();
		return colms;
	}
	
	public static String getCellValue(String sheetName,int rows,int col) {
		sheet=wb.getSheet(sheetName);
		String data=sheet.getRow(rows).getCell(col).getStringCellValue();
		return data;
	
	}
}


