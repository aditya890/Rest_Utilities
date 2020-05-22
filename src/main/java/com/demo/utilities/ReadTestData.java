package com.demo.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

/***
 * This class will be used for reading the test input
 * @author Aditya
 *
 */

/**
 * @author Aditya
 *
 */

public class ReadTestData extends ReadTestDataFromExcel {
	ReadConfig rc =new ReadConfig();
	private String fileName;
	private String sheetName;
	
	public ReadTestData(String fileName,String sheetName) throws Throwable, IOException {
		String rootPath = System.getProperty("user.dir");
		fileName = rootPath+ "\\Data\\"+rc.getKeyValues("TestDataFileName");
		sheetName=rc.getKeyValues("TestDataSheetName");
		this.fileName=fileName;
		this.sheetName=sheetName;
	}

	
	public ReadTestData() throws Throwable, IOException {
		String rootPath = System.getProperty("user.dir");
		fileName = rootPath+ "\\Data\\"+rc.getKeyValues("TestDataFileName");
		sheetName=rc.getKeyValues("TestDataSheetName");
		this.fileName=fileName;
		this.sheetName=sheetName;
	}


	public static Object[][] getTableArray(String fileName, String sheetName) throws Exception
	{
		System.out.println("getTableArray");
		return getTableArray( fileName, sheetName);
		
	}
	public static String[] getHeaders(String fileName, String sheetName) throws Exception{
		return getHeaders(fileName, sheetName);
		
		
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		return getCellData(RowNum,  ColNum);
		
	}
	
	
}
