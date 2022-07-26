package com.test;

import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]) throws Exception{
            String path = "D://home/admin/data/sztt/数字天堂调证.xlsx";
            FileInputStream fileInputStream  = new FileInputStream(path);
            XSSFWorkbook xwb = new XSSFWorkbook(fileInputStream);
            addRegisterInfoSztt(xwb);
    }

    private static void addRegisterInfoSztt(XSSFWorkbook xwb) {
        List<PackageRecordSzttDO> packageRecordSzttDOList = new ArrayList<PackageRecordSzttDO>();
        // 获得打包记录信息
        XSSFSheet sheet = xwb.getSheetAt(1);
        //获得总列数
        int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
        //获得总行数
        int rowNum = sheet.getPhysicalNumberOfRows();//获得总行数
        DataFormatter formatter=new DataFormatter();
        for (int i = 1; i < rowNum; i++) {
            Row  row = sheet.getRow(i);
            PackageRecordSzttDO packageRecordSzttDO = new PackageRecordSzttDO();
            packageRecordSzttDO.setAppId(getValue(row.getCell(0)));
            packageRecordSzttDO.setAppName(getValue(row.getCell(1)));
            packageRecordSzttDO.setPackageName(getValue(row.getCell(2)));
            packageRecordSzttDO.setEmail(getValue(row.getCell(3)));
            packageRecordSzttDO.setPlatform(getValue(row.getCell(4)));
            packageRecordSzttDO.setPackageStatus(getValue(row.getCell(5)));
            packageRecordSzttDO.setIp(getValue(row.getCell(6)));
            packageRecordSzttDO.setPort(getIntValue(row.getCell(7),formatter));
            packageRecordSzttDO.setPackageTime(formatter.formatCellValue(row.getCell(8)));
            packageRecordSzttDOList.add(packageRecordSzttDO);
            if (i == 10) {
                break;
            }
        }
        List<List<PackageRecordSzttDO>> partition = ListUtils.partition(packageRecordSzttDOList, 5);
        partition.stream().forEach(sublist -> {
            System.out.println(sublist);
        });
    }

    private static String getValue (Cell cell) {
        if(StringUtils.isEmpty(cell)) {
            return "";
        }
        return cell.getStringCellValue();
    }

    private static String getIntValue (Cell cell, DataFormatter formatter) {
        if(StringUtils.isEmpty(formatter.formatCellValue(cell))) {
            return "";
        } else {
            return String.valueOf(Integer.parseInt(formatter.formatCellValue(cell)));
        }
    }
}
