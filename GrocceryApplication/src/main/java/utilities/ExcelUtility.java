package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;



public class ExcelUtility {

	// TODO Auto-generated method stub
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public static String getStringData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constant.EXCELPATH);
		wb = new XSSFWorkbook(f);// to get values from workbook present inside file
		sh = wb.getSheet(sheet);// to get values from sheet
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();// to get string value
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constant.EXCELPATH);
		wb = new XSSFWorkbook(f);// to get values from workbook present inside file
		sh = wb.getSheet(sheet);// to get values from sheet
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int s = (int) c.getNumericCellValue();// to get string value
		return String.valueOf(s);

	}

	public static String getFloatData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constant.EXCELPATH);
		wb = new XSSFWorkbook(f);// to get values from workbook present inside file
		sh = wb.getSheet(sheet);// to get values from sheet
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		float m = (float) c.getNumericCellValue();// to get string value
		return String.valueOf(m);

	}

}