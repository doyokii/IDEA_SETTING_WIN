package com.mrz.excelUtil;

import com.mrz.entity.DouBanRentData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;
/**
 * @author : Zhuang Jialong
 * @description : excel写入类
 * @date : 2020/5/26 1:54
 * @Copyright: Copyright(c)2019 RedaFlight.com All Rights Reserved
 */
public class ExcelWriter {


    /**
     *
     * @param rowName
     * @param rowValue
     * @throws Exception
     */
    public static void excelWriter(List<String> rowName,List<DouBanRentData> rowValue,HSSFSheet sheet,HSSFWorkbook wb) throws Exception{
        //在sheet中创建一行
        HSSFRow row = sheet.createRow(0);
        //创建表头
        for(int i=0;i<rowName.size();i++){
            row.createCell(i).setCellValue(rowName.get(i)); }
        for(int i = 1;i<rowValue.size();i++){
            HSSFRow valueRow = sheet.createRow(i);
            valueRow.createCell(0).setCellValue(rowValue.get(i).getSheet());
            valueRow.createCell(1).setCellValue(rowValue.get(i).getNumber());
            valueRow.createCell(2).setCellValue(rowValue.get(i).getTitle());
            valueRow.createCell(3).setCellValue(rowValue.get(i).getUrl());
            valueRow.createCell(4).setCellValue(rowValue.get(i).getLastRespTime());
        }

        //最后写回磁盘
        FileOutputStream out = new FileOutputStream("C:\\Users\\wrunv\\OneDrive\\TEMPORARY_FOLDER\\douBanRent.xls");
        wb.write(out);
        out.close();

    }
    public static void excelWriter(List<DouBanRentData> rowValue,String rowNum,HSSFSheet sheet,HSSFWorkbook wb) throws Exception{

        for(int i = 1;i<rowValue.size();i++){
            HSSFRow row = sheet.createRow(((Integer.valueOf(rowNum)-1)*25)+1+i);
            for(int j = 0;j<rowValue.size();j++){

                row.createCell(0).setCellValue(rowValue.get(i).getSheet());
                row.createCell(1).setCellValue(rowValue.get(i).getNumber());
                row.createCell(2).setCellValue(rowValue.get(i).getTitle());
                row.createCell(3).setCellValue(rowValue.get(i).getUrl());
                row.createCell(4).setCellValue(rowValue.get(i).getLastRespTime());

            }
        }
            //最后写回磁盘
            FileOutputStream out = new FileOutputStream("C:\\Users\\wrunv\\OneDrive\\TEMPORARY_FOLDER\\douBanRent.xls");
            wb.write(out);
            out.close();
        }
    }

