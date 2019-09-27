package com.mealcome.Implement;

import com.mealcome.Until.warnUntil;
import com.mealcome.common;
import com.mealcome.model.APIInfo;
import com.mealcome.model.APITestResultInfo;
import com.mealcome.model.testInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wuchaolin on 2019/8/8.
 */
public class TestCase extends common {

    private static List<APITestResultInfo> listResult=new ArrayList<APITestResultInfo>(); //保存测试结果的集合

    /**保存测试结果的集合，测完一趟后，再提取测试结果集合，然后保存到数据库*/
    public List<APITestResultInfo> getListResult(){
        return this.listResult;
    }



    /**发起订货*/
    public static boolean test_OrderGoods(int testCode){
        warnUntil warnUntil=new warnUntil();
        int i=0;
        if (getSessionID(testInfo.PurchaseAPPurl,testInfo.PurchaseAPPPostData)==null){
            return false;
        }
        String header=testInfo.headers.replace("${sessionId}",getSessionID(testInfo.PurchaseAPPurl,testInfo.PurchaseAPPPostData));
        boolean isRetry=true;
        out:while (isRetry) {
            APITestResultInfo apiTestResultInfo;
            Request request = new Request(header);
            apiTestResultInfo = request.sendPost(testInfo.url, testInfo.postData);
            apiTestResultInfo.setTestCode(testCode);
            apiTestResultInfo.setTestContent("下单收货-订货");
            apiTestResultInfo.setTestEnd("采购管家");
            listResult.add(apiTestResultInfo);
            isRetry=(apiTestResultInfo.getResponseCode()!=200 || (!apiTestResultInfo.getResponseData().contains("code\":\"0\"")));
            if(i>2){
                for (APITestResultInfo apiTestResultInfos:listResult){
                    warnUntil.sendWarn(apiTestResultInfos,"18676967636");
                }
                return false;
            }
            i++;
        }
        for (APITestResultInfo apiTestResultInfo:listResult){
            System.out.println("订货流程的结果是："+apiTestResultInfo.toString());
        }
        return true;
    }

    /**供应商查看收货消息*/
    public static boolean test_SupplierInfo(int testCode){
        return false;
    }


}
