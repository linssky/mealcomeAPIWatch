package com.mealcome.Control;

import com.mealcome.Implement.SanityTestCase;

/**
 * Created by wuchaolin on 2019/5/15.
 */
public class main {
    public static void main(String[] args){
//public void test(){
        SanityTestCase sanityTestCase=new SanityTestCase();
        sanityTestCase.allTest(1);

//        TestCase.test_OrderGoods(1);
//        iRequest request=new Request(resultsInfo.header);
//        long time= request.sendPost("http://test.mealcome.cn/meallinkapi/seller/manage/customer/list","{\"currentPage\":1,\"pageSize\":20}");
//        iRequest WXAPI=new Request(resultsInfo.WXHeader);
//        request.sendPost("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=5d3c0d81-a687-44f1-9584-f4e4ba7a7e2b","{\n" +
//                "    \"msgtype\": \"text\",\n" +
//                "    \"text\": {\n" +
//                "        \"content\": \""+"接口meallinkapi/seller/manage/customer/list运行正常，接口响应时间为："+time+"ms"+"\",\n" +
//                "        \"mentioned_mobile_list\":[\"18676967636\"]\n" +
//                "    }\n" +
//                "}");

//        if (true){
//            return;
//        }
//        long startTime=System.currentTimeMillis();
//        List<userInfo> userI=new ArrayList<userInfo>();
//        excelUntil excelUntil=new excelUntil(excelInfo.USER_NAME_FORM, excelInfo.SHEET_NAME);
//        iPerformanceTest PT=new performanceTest();
//        List<userInfo> userInfos= excelUntil.getUserInfo();
//        userI=PT.ThreadsTest(userInfos);
//        excelUntil.updateUserInfo(userI);
//        System.out.println(userI.toString());
//
//
//        long endtTime=System.currentTimeMillis();
//        long takeTime=(endtTime-startTime);//单位是ms
//        System.out.println("本次测试总耗时："+takeTime*1.00/1000+"秒");

    }
}
