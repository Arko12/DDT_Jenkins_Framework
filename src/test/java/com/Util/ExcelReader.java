package com.Util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelReader(String path) {
		try {
			fis=new FileInputStream(path);
			wb=new XSSFWorkbook(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getRowCount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int rows=sheet.getLastRowNum();
		return rows+1;
	}
	
	
	public static int getColCount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int cols=sheet.getRow(0).getLastCellNum();
		return cols;
	}
	
	public static String getCellValue(String sheetName,int row,int col) {
		sheet=wb.getSheet(sheetName);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	
}
