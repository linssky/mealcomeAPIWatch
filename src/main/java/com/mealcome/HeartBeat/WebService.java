package com.mealcome.HeartBeat;

import com.mealcome.Implement.Request;
import com.mealcome.model.resultsInfo;
import com.mealcome.Interface.iRequest;

import static java.lang.System.out;

/**
 * Created by wuchaolin on 2019/8/3.
 */
public class WebService {
    public void APIMoniter() {
        out.println("开始接口监控……………………");

        int i=1;//记录测试轮数
        String response="";
        try {
            iRequest request=new Request(resultsInfo.header);
//            long time= request.sendPost("http://test.mealcome.cn/meallinkapi/seller/manage/customer/list","{\"currentPage\":1,\"pageSize\":20}");
//            iRequest WXAPI=new Request(resultsInfo.WXHeader);
//            System.out.println("返回的接口值是："+time+"ms");
//            request.sendPost("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=5d3c0d81-a687-44f1-9584-f4e4ba7a7e2b","{\n" +
//                    "    \"msgtype\": \"text\",\n" +
//                    "    \"text\": {\n" +
//                    "        \"content\": \""+"接口meallinkapi/seller/manage/customer/list运行正常，接口响应时间为："+time+"ms"+"\",\n" +
//                    "        \"mentioned_mobile_list\":[\"18676967636\"]\n" +
//                    "    }\n" +
//                    "}");
        }catch (Exception e){
            System.out.println("接口请求异常！");
        }
        i++;

        out.println("-----response数据为："+response);
    }
}
