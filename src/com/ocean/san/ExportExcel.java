package com.ocean.san;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	/**
	 * 导出excel
	 * */
	public void export() throws Exception {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("test sheet1");

		Row row = sheet1.createRow(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		row.createCell(0).setCellValue(sdf.format(new Date()));
		Cell cell1 = row.createCell(1);
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell1 = row.createCell((short) 1);
		cell1.setCellValue("X");
		cell1.setCellStyle(style);

		FileOutputStream fos = new FileOutputStream(new File("d://test.xlsx"));

		wb.write(fos);
		wb.close();

	}
	/**
	 * */

	public static void main(String[] args) {
		ExportExcel ee = new ExportExcel();

		try {
			ee.export();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
