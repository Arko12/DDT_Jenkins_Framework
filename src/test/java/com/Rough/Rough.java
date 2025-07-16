package com.Rough;

import com.Utilities.ExcelUtil;

public class Rough {

	public static void main(String args[]) {
		ExcelUtil excel = new ExcelUtil(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestData.xlsx");
		
		String sheetName="TestCase002_AddCustomerTest";
		int rows=excel.getRowcount(sheetName);
		int cols=excel.getColumncount(sheetName);
		
		System.out.println("rows="+rows);
		System.out.println("cols="+cols);
		
		String [][] data= new String[rows-1][cols];
		
			for(int i=1;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					data[i-1][j]=excel.getCellValue(sheetName, i, j);
				System.out.print(data[i-1][j]+" ");
				}
				System.out.println();
			}
		
		
	}
}
