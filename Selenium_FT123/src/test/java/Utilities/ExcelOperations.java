package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	XSSFWorkbook wb;
	public ExcelOperations(String path) throws IOException {
		FileInputStream f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		
	}
	public String getData(int row,int column,String sheetName) {
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(column));
	}
	public int getRowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public int getColumnCount(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
}
