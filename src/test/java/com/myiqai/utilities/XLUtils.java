package com.myiqai.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		int row_count = sh.getLastRowNum();
		return row_count;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		int cell_count = sh.getRow(0).getLastCellNum();
		return cell_count;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(xlsheet);
		row = sh.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		// DataFormatter format = new DataFormatter();
		try {
			data = cell.getStringCellValue();

		} catch (Exception e) {

			data = "";

		}
		return data;
	}
	public static void setCellData(String xlfile, String xlsheet, int rownum, int cellnum,String createData) throws IOException {
		// String data="";
		
		/*fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		//int row=sh.getLastRowNum();
		//int cell_num=sh.getRow(rownum).getLastCellNum();
		row=sh.getRow(rownum);
		cell=row.getCell(cellnum);
		data=cell.getStringCellValue();*/
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(createData);
		
		
		FileOutputStream fo= new FileOutputStream(xlfile);
		wb.write(fo);
	}
	public static void fillColour(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		
		
		
		
	}

}
