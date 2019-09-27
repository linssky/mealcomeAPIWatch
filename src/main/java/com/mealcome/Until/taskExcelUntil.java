//package com.mealcome.Until;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * Created by wuchaolin on 2019/5/21.
// */
//public class taskExcelUntil {
//    private static String excelFile;
//    private static String sheetName;
//    private static List<String> headRow;
//    private static FileOutputStream outXlsFile;
//    private static FileInputStream xlsFile;
//    private static Workbook workbook = null;
//    private static Sheet taskSheet;
//
//    public taskExcelUntil(String excelFile,String sheetName){
//        this.excelFile=excelFile;
//        this.sheetName=sheetName;
//    }
//
//
//
//    //初始化，查询，获取
//    private void inputExcel() throws IOException {
//        this.xlsFile = new FileInputStream(this.excelFile);
//        this.workbook = this.excelFile.contains("xlsx")? new XSSFWorkbook(xlsFile):new HSSFWorkbook(xlsFile);//读取03或07的版本,xlsx是07的Excel版本，xls是03的版本，此处需要注意
//    }
//
//    //写入，更新
//    private void outputExcel() throws IOException {
//        this.outXlsFile = new FileOutputStream(new File(this.excelFile));
//    }
//
//    //关闭input
//    private void closeWorkbook() throws IOException {
//        this.workbook.close();
//        this.xlsFile.close();
//    }
//
//    //关闭output
//    private void closeOutput() throws IOException {
//        this.outXlsFile.close();
//    }
//
//    //写入更新
//    private void updateExcel() throws IOException {
//        outputExcel();
//        this.workbook.write(outXlsFile);
//        this.outXlsFile.flush();
//        this.outXlsFile.close();
//    }
//
//    private void getSheet(){
//        this.taskSheet=this.workbook.getSheet(this.sheetName);
//    }
//
//    //获取表格首行的内容并存到List
//    private void getHeadRow() throws IOException {
//        inputExcel();
//        if (this.workbook==null){return ;}
//        getSheet();
//        Row headRow=this.taskSheet.getRow(0);
//        for (Cell cell:headRow){
//            cell.setCellType(CellType.STRING);
//            this.headRow.add(cell.getStringCellValue().trim());
//        }
//        closeWorkbook();
//    }
//
//    public List<HashMap> getTaskList(){
//
//
//        return null;
//    }
//
//}
