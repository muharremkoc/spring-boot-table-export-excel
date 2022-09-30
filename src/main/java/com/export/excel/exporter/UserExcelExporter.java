package com.export.excel.exporter;


import com.export.excel.model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserExcelExporter {

 private XSSFWorkbook workbook;
 private XSSFSheet xssfSheet;

 private List<User> userList;

 public UserExcelExporter(List<User> userList) {
  this.userList = userList;
  workbook=new XSSFWorkbook();
 }

 private void createCell(Row row, int columnCount, Object value, CellStyle cellStyle){
  xssfSheet.autoSizeColumn(columnCount);
  Cell cell= row.createCell(columnCount);
  if (value instanceof Long){
   cell.setCellValue((Long) value);
  }else if (value instanceof Integer){
   cell.setCellValue((Integer) value);
  }else if (value instanceof Boolean){
   cell.setCellValue((Boolean) value);
  }else if (value instanceof Enum){
   cell.setCellValue(String.valueOf((Enum) value));
  }
  else if (value instanceof Date){
      cell.setCellValue(String.valueOf((Date) value));
  }
  else {
   cell.setCellValue((String) value);
  }
  cell.setCellStyle(cellStyle);
 }
 private void writeHeaderLine(){
       xssfSheet=workbook.createSheet("User");

		Row row = xssfSheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCell(row,0,"User Information",style);
     xssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
		font.setFontHeightInPoints((short)(10));

		row=xssfSheet.createRow(1);
		font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "User Id", style);
        createCell(row, 1, "Username", style);
        createCell(row, 2, "Email", style);
        createCell(row, 3, "Password", style);
        createCell(row, 4, "Social Media", style);
        createCell(row,5,"CreatedDate",style);
 }

 private void writeDataLines(){
    int rowCount=userList.size();

    CellStyle style=workbook.createCellStyle();
    XSSFFont font=workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);
    for (User user:userList){
     Row row=xssfSheet.createRow(rowCount++);
     int columnCount=0;

     createCell(row,columnCount++,user.getId(),style);
     createCell(row,columnCount++,user.getUsername(),style);
     createCell(row,columnCount++,user.getEmail(),style);
     createCell(row,columnCount++,user.getPassword(),style);
     createCell(row,columnCount++,user.getSocialMedia(),style);
    createCell(row,columnCount++,user.getCreatedDate(),style);
    }
 }
 public void export(HttpServletResponse response) throws IOException {
   writeHeaderLine();
   writeDataLines();

  ServletOutputStream outputStream=response.getOutputStream();
  workbook.write(outputStream);
  workbook.close();
  outputStream.close();
 }
}
