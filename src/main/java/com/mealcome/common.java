package com.mealcome;

import com.mealcome.Implement.Request;
import com.mealcome.model.APITestResultInfo;
import com.mealcome.model.testInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuchaolin on 2019/5/15.
 */
public class common {
    /**以yyyyMMdd的格式返回一个string，
     * 主要用于创建文件夹*/
    public String getNowTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//时间展示方式
        String time=df.format(day);//获取当前时间
        return time;
    }

    public String getNowDay(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//时间展示方式
        String time=df.format(day);//获取当前时间
        return time;
    }

    public String getNowSeconds(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间展示方式
        String time=df.format(day);//获取当前时间
        return time;
    }


    //对比上次获取sessionid的时间，如果在7天以内，则不保存
    public boolean isSaveSeesionID(String nowTime,String getExcelTime){
        boolean isSave=true;
        if (getExcelTime!=null||getExcelTime!=""){
            try {
                int nowtime = Integer.parseInt(nowTime);
                int getexceltime = Integer.parseInt(getExcelTime);
                isSave = (nowtime - getexceltime) < 6 ? false : true;
            }catch (Exception e){
                System.out.println("Excel获取的日期格式有问题！");
            }
        }
        return isSave;
    }

    public static String Split(String Text, String Front, String After){
        String text= Text.split(Front)[1].split(After)[0];
        System.out.println("分解出来的session是："+text);
        return text;
    }

    /**获取采购管家sessionid*/
    public static String getSessionIDFromPurchaseAPP() {
        Request request = new Request("Content-Type: application/json;charset=UTF-8");
        APITestResultInfo apiTestResultInfo;
        apiTestResultInfo = request.sendPost(testInfo.PurchaseAPPurl, testInfo.PurchaseAPPPostData);
        if (apiTestResultInfo.getResponseCode() == 200) {
            System.out.println();
            String sessionID = Split(apiTestResultInfo.getResponseData(), "sessionId\":\"", "\",");
            return sessionID;
        } else {
            return null;
        }
    }

    /**获取采购管家sessionid*/
    public static String getSessionIDFromBossAPP(){
        Request request=new Request("Content-Type: application/json;charset=UTF-8");
        APITestResultInfo apiTestResultInfo;
        apiTestResultInfo=request.sendPost(testInfo.PurchaseAPPurl,testInfo.PurchaseAPPPostData);
        if (apiTestResultInfo.getResponseCode()==200){
            System.out.println();
            String sessionID=Split(apiTestResultInfo.getResponseData(),"sessionId\":\"","\",");
            return sessionID;
        }else {
            return null;
        }
    }

    /**获取sessionid*/
    public static String getSessionID(String url,String postData){
        Request request=new Request("Content-Type: application/json;charset=UTF-8");
        APITestResultInfo apiTestResultInfo;
        apiTestResultInfo=request.sendPost(url,postData);
        if (apiTestResultInfo.getResponseCode()==200&&apiTestResultInfo.getResponseData().contains("{\"code\":\"0\"")){
            System.out.println();
            String sessionID=Split(apiTestResultInfo.getResponseData(),"sessionId\":\"","\",");
            return sessionID;
        }else {
            return null;
        }
    }


}
