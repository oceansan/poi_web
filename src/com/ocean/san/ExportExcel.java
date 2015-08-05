package com.ocean.san;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {

	public static void main(String[] args) {

		ExportExcel ee = new ExportExcel();
		try {
			Product product = new Product();
			product.setId(100l);
			product.setName("金发");
			product.setType('a');
			product.setEndDt(new Date());
			product.setStartDt(new Date());

			List<Product> list = new ArrayList<Product>();
			for (int i = 0; i < 3; i++) {
				list.add(product);
			}
			String filePath = "e://test.xlsx";
			ee.export(list, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void export(List list, String filePath) throws Exception,
			IllegalAccessException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		for (int i = 0; i < list.size(); i++) {

			Object obj = list.get(i);

			Row row = sheet.createRow(i);

			Class<? extends Object> cc = obj.getClass();

			Field[] fields = cc.getDeclaredFields();

			int cellIndex = 0;

			for (Field field : fields) {

				if (field.getModifiers() == Modifier.PRIVATE) {

					String fieldName = field.getName();

					String methodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);

					

					Cell cell = row.createCell(cellIndex++);
					
					Method method = cc.getMethod(methodName);

					checkReturnType(obj, method, cell);
				}
			}
		}

		FileOutputStream fos = new FileOutputStream(new File(filePath));
		wb.write(fos);
		fos.close();

	}

	/**
	 * javabean 类型检测与格式化
	 * 
	 * 
	 * @param obj
	 * @param method
	 * @param cell
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void checkReturnType(Object obj, Method method, Cell cell) throws IllegalAccessException,
			InvocationTargetException {
		Object returnObj = method.invoke(obj);

		if (returnObj instanceof Date) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			cell.setCellValue(method.invoke(obj) == null ? "" : sdf
					.format((Date) method.invoke(obj)));

		} else if (returnObj instanceof Long) {
			
			cell.setCellValue(Long.parseLong(method.invoke(obj).toString()));

		} else if (returnObj instanceof Integer) {
			
			cell.setCellValue(String.valueOf(method.invoke(obj)));

		} else if (returnObj instanceof Short) {
			
			cell.setCellValue(String.valueOf(method.invoke(obj)));

		} else if (returnObj instanceof Byte) {
			
			cell.setCellValue(String.valueOf(method.invoke(obj)));

		} else if (returnObj instanceof Double)
		{
			cell.setCellValue(String.valueOf(method.invoke(obj)));

		} else if (returnObj instanceof Float) {

			cell.setCellValue(String.valueOf(method.invoke(obj)));
			
		} else if (returnObj instanceof Boolean) {

			cell.setCellValue(String.valueOf(method.invoke(obj)));
			
		} else if (returnObj instanceof Character) {

			cell.setCellValue(String.valueOf(method.invoke(obj)));
			
		} else {

			cell.setCellValue(String.valueOf(method.invoke(obj)));
		}
	}
}
