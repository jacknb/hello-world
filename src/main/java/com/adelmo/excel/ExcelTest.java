package com.adelmo.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by znb on 17-8-13.
 */
public class ExcelTest {

    public static void exportExcel(String filePath) {

        File file = new File(filePath);

        try {
//            if (file.exists()){
//                file.delete();
//            }
//            file.createNewFile();

            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(xssfWorkbook, 100);

            Sheet first = sxssfWorkbook.getSheetAt(0);
            for (int i = 0; i <= 100000; i++) {
                Row row = first.createRow(i);
                for (int j = 0; j <= 10; j++) {
                    Cell cell = row.createCell(j);
                    String address = new CellReference(cell).formatAsString();
                    cell.setCellValue(address);

//                    if (i == 0) {
//                        // 首行
//                        row.createCell(j).setCellValue("column" + j);
//                    } else {
//                        // 数据
//                        if (j == 0) {
//                            CellUtil.createCell(row, j, String.valueOf(i));
//                        } else {
//                            CellUtil.createCell(row, j, String.valueOf(Math.random()));
//                        }
//                    }
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            sxssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();

            sxssfWorkbook.dispose();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        String filePath = "/home/znb/test.xlsx";
        Long beginTime = System.currentTimeMillis();

        exportExcel(filePath);

        Long endTime = System.currentTimeMillis();

        System.out.println("Time : " + (endTime - beginTime));
    }

}
