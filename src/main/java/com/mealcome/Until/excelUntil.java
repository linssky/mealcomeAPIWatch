//package com.mealcome.Until;
//
//import com.mealcome.Info.userInfo;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by wuchaolin on 2019/5/14.
// */
//public class excelUntil {
//    private static String excelFile;
//    private static String sheetName;
//
//    public excelUntil(String excelFile,String sheetName ){
//        this.excelFile=excelFile;
//        this.sheetName=sheetName;
//    }
//
//    private FileInputStream xlsFile;
//    private Workbook inputExcel(){
//        Workbook workbook = null;
//        try {
//            this.xlsFile = new FileInputStream(this.excelFile);
//             workbook = this.excelFile.contains("xlsx")? new XSSFWorkbook(xlsFile):new HSSFWorkbook(xlsFile);//读取03或07的版本,xlsx是07的Excel版本，xls是03的版本，此处需要注意
//        }catch (Exception e){}
//        return workbook;
//    }
//
//    private FileOutputStream outXlsFile;
//    private FileOutputStream  outputExcel(){
//        try {
//            this.outXlsFile = new FileOutputStream(new File(this.excelFile));
//              }catch (Exception e){}
//        return this.outXlsFile;
//    }
//
//
//    //修改表格信息
//    private List<userInfo> USERINFO;
//    public void updateUserInfo(List<userInfo> userInfos){
//        this.USERINFO=userInfos;
//        try {
//            getOrUpdateUserInfo(false);
//        }catch (Exception e){
//        }
//    }
//
//    //获取表格信息
//    public List<userInfo> getUserInfo(){
//        List<userInfo> userInfos=new ArrayList<userInfo>();
//        try{
//            userInfos=getOrUpdateUserInfo(true);
//        }catch (Exception e){}
//        return userInfos;
//    }
//
//    //传入true表示获取表格信息，传入false表示修改表格信息
//    public List<userInfo> getOrUpdateUserInfo(boolean GetOrUpdate) throws IOException, InvalidFormatException {
//        Workbook workbook = inputExcel();
//        if (workbook==null){return null;}
//        Sheet userSheet =workbook.getSheet(this.sheetName);//Excel中user的sheet
//        int userRowTotal=userSheet.getLastRowNum()+1;//最后一行行标，获取的结果比实际行数小1，所以总数要+1
//        int colormTotal=userSheet.getRow(0).getPhysicalNumberOfCells();//第一行的总列数，获取列数，比最后一列列标大1，所以获取的结果是实际列数
//        System.out.println("user的总行数是："+userRowTotal+"\ncolormTotal的总列数是："+colormTotal);
//        colormTotal=colormTotal>7?7:colormTotal;//获取的最大列数是6列,超过则为6
//        List<userInfo> userInfos = new ArrayList<userInfo>();
//        for(int i=1;i<userRowTotal;i++){
//            userInfo rowUserInfo=new userInfo();
//            Row row=userSheet.getRow(i);
//            int mark = -1;//找到第一列username对应的List角标
//            if(!GetOrUpdate){
//                Cell cell=row.getCell(0);
//                cell.setCellType(CellType.STRING);
//                String checkInfo=cell.getStringCellValue().trim();
//                mark=findListMark(checkInfo);
//            }
//            for (int j=0;j<colormTotal;j++){
//                Cell cell=row.getCell(j);
//                String info;
//                if (cell!=null) {
//                    cell.setCellType(CellType.STRING);
//                    info=cell.getStringCellValue().trim();
//                }else {
//                    info=null;
//                }
//                switch (j){
//                    case 0:
//                        if (GetOrUpdate) {
//                            rowUserInfo.setmUsername(info);
//                        }else {
//                        }
//                        break;
//                    case 1:
//                        if (GetOrUpdate) {
//                            rowUserInfo.setmTenantid(info);
//                        }
//                        break;
//                    case 2:
//                        if (GetOrUpdate) {
//                            rowUserInfo.setmSessionId(info);
//                        }else {
//                            if (mark!=-1 && this.USERINFO.get(mark).getisSaveSessionId()) {
//                                cell=row.createCell(j,CellType.STRING);//设置写入cell的格式
//                                cell.setCellValue(this.USERINFO.get(mark).getmSessionId());//获取写入内容并写入
//                            }
//                        }
//                        break;
//                    case 3:
//                        if (GetOrUpdate) {
//                            rowUserInfo.setmSessionId_overtime(info);
//                        }else {
//                            if (mark!=-1 && this.USERINFO.get(mark).getisSaveSessionId()) {
//                                cell=row.createCell(j,CellType.STRING);
//                                cell.setCellValue(this.USERINFO.get(mark).getmSessionId_overtime());//获取
//                            }
//                        }
//                        break;
//                    case 4:
//                        if (GetOrUpdate){
//                            rowUserInfo.setTakePosttime(info);
//                        }else {
//                            if (mark!=-1) {
//                                cell = row.createCell(j, CellType.STRING);
//                                cell.setCellValue(this.USERINFO.get(mark).getTakePosttime());//获取
//                            }
//                        }
//                        break;
//
//                    case 5:
//                        if (GetOrUpdate){
//                            rowUserInfo.setTakeGetResponseTime(info);
//                        }else {
//                            if (mark != -1) {
//                                cell = row.createCell(j, CellType.STRING);
//                                cell.setCellValue(this.USERINFO.get(mark).getTakeGetResponseTime());//获取
//                            }
//                        }
//                        break;
//
//                    case 6:
//                        if (GetOrUpdate){
//                            rowUserInfo.setError(info);
//                        }else {
//                            if (mark != -1) {
//                                cell = row.createCell(j, CellType.STRING);
//                                cell.setCellValue(this.USERINFO.get(mark).getError());//获取
//                            }
//                        }
//                        break;
//                    default:
//                        System.out.println("逻辑出错或者表格中有多余的列！");
//                        break;
//                }
//            }
//            if (GetOrUpdate) {
//                System.out.println("rowUserInfo的数据是："+rowUserInfo+"\n此时i的值是："+i);
//                userInfos.add(rowUserInfo);
//            }
//        }
//        if (!GetOrUpdate) {
//            FileOutputStream out = outputExcel();
//            workbook.write(out);// 将最新的 Excel 文件写入到文件输出流中，更新文件信息
//            out.flush();// 执行 flush 操作， 将缓存区内的信息更新到文件上
//            out.close();// 操作完成后，及时关闭这个输出流对象
//        }else {
//            this.xlsFile.close();
//        }
//        workbook.close();
//        return userInfos;
//    }
//
//
//    //通过列信息找到数组对应角标
//    public int findListMark(String cellInfo){
//        int line = -1;
//        List<userInfo> userInfos=this.USERINFO;
//        for(int i=0;i<userInfos.size();i++){
//            if(userInfos.get(i).toString().contains(cellInfo)){
//             line=i;
//            }
//        }
//        return line;
//    }
//}
