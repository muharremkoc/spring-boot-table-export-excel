/*
package com.export.excel.exporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.export.excel.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UserExcelExporterTest {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<User> listStudent;
	
	
	public UserExcelExporterTest(List<User> listStudent) {
		this.listStudent=listStudent;
		workbook = new XSSFWorkbook();
		
	}
	
	private void createCell(Row row,int columnCount, Object value,CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell=row.createCell(columnCount);
		if(value instanceof Long) {
			cell.setCellValue((Long) value);
		}else if(value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}else if(value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		}else if (value instanceof Enum){
			cell.setCellValue(String.valueOf((Enum) value));
		}
		else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	private void writeHeaderLine() {
		sheet=workbook.createSheet("User");
		
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCell(row,0,"Student Information",style);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
		font.setFontHeightInPoints((short)(10));
		
		row=sheet.createRow(1);
		font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "User Id", style);
        createCell(row, 1, "Username", style);
        createCell(row, 2, "Email", style);
        createCell(row, 3, "Password", style);
        createCell(row, 4, "Social Media", style);
        
	}
	
	private void writeDataLines() {
		int rowCount=listStudent.size();
		
		CellStyle style=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for(User stu:listStudent) {
			Row row=sheet.createRow(rowCount++);
			int columnCount=0;
			createCell(row, columnCount++, stu.getId(), style);
			createCell(row, columnCount++, stu.getUsername(), style);
			createCell(row, columnCount++, stu.getEmail(), style);
			createCell(row, columnCount++, stu.getPassword(), style);
			createCell(row, columnCount++, stu.getSocialMedia(), style);
		}
	}
	
	public void export(HttpServletResponse response) throws IOException{
		writeHeaderLine();
		writeDataLines();
		
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	
}
*/
