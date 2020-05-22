package com.demo.utilities;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Aditya
 *
 */
public class ReadTestDataFromExcel {
 
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	/***
	 * This method will be used to get the Data from excel as object array
	 * @param FilePath
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public static Object[][] getTableArray(String fileName, String sheetName) throws Exception {

		System.out.println("File Name : " + fileName + " Sheet Name : " + sheetName);
		String[][] tabArray = null;
		FileInputStream ExcelFile = new FileInputStream(fileName);

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(sheetName);

		int startRow = 1;

		int startCol = 0;

		int totalRows = ExcelWSheet.getLastRowNum();

		int totalCols = ExcelWSheet.getRow(0).getLastCellNum();

		tabArray = new String[totalRows][totalCols];

		int ci = 0;
		for (int i = startRow; i <= totalRows; ci++) {
			int cj = 0;
			for (int j = startCol; j < totalCols; cj++) {
				tabArray[ci][cj] = getCellData(i, j);
				System.out.println(tabArray[ci][cj]);
				j++;
			}
			i++;
		}
		System.out.println("MYDATA " + tabArray.toString());
		return tabArray;

	}
	
	/**
	 * Gets only col values
	 * @param fileName
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static String[] getHeaders(String fileName, String sheetName) throws Exception{
		
		String[] keyArray = null;
		
//		int startRow = 0;

		int startCol = 0;

		int totalRows = ExcelWSheet.getLastRowNum();

		int totalCols = ExcelWSheet.getRow(0).getLastCellNum();

		keyArray = new String[totalCols];

		int ci = 0;
		for(int i = startCol; i < totalCols; ci++){
			keyArray[ci] = getCellData(0, i);
			System.out.println(keyArray[ci]);
			i++;
		}
		/*for (int i = startRow; i <= totalRows; ci++) {
			int cj = 0;
			for (int j = startCol; j <= totalCols; cj++) {
				keyArray[ci][cj] = getCellData(i, j);

				System.out.println(keyArray[ci][cj]);
				j++;
			}
			i++;
		}*/
		System.out.println("Headers: " + keyArray.toString());
		return keyArray;
	}

	/***
	 * This method is for getting data from particular cell
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		CellType dataType = Cell.getCellTypeEnum();

		if (dataType == CellType._NONE) {
			return "";
		} else if (dataType == CellType.NUMERIC) {
			Cell.setCellType(CellType.STRING);
		}
		return Cell.getStringCellValue();
	}
}
