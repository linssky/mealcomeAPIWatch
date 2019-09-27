package com.mealcome.Implement;

import com.mealcome.Until.dbUntil;
import com.mealcome.model.APITestResultInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuchaolin on 2019/8/8.
 */
public class SanityTestCase {
    public boolean allTest(int testID){
        TestCase testCase=new TestCase();
        List<APITestResultInfo> apiTestResultInfos=new ArrayList<APITestResultInfo>();
        boolean isGo=testCase.test_OrderGoods(testID);
        if (isGo){
        }else {
            System.out.println("发起订货失败了！");
        }


        apiTestResultInfos=testCase.getListResult();
        dbUntil dbUntil=new dbUntil();
        dbUntil.insertTableAPIResult(apiTestResultInfos);
        return true;
    }
}
