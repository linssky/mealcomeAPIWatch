package com.mealcome.Until;

import com.mealcome.Implement.Request;
import com.mealcome.model.APITestResultInfo;
import com.mealcome.model.testInfo;

/**
 * Created by wuchaolin on 2019/8/8.
 * 警报消息推送
 */
public class warnUntil {
    public boolean sendWarn(APITestResultInfo apiTestResultInfo, String Handler){
        apiTestResultInfo.getResponseData().replace("\"","\\\"");
        String log="警告！接口响应异常！\n" +
                "接口:"+apiTestResultInfo.getUrl()+"\n" +
                "请求类型:"+apiTestResultInfo.getRequestYype()+"\n" +
                "测试端:"+apiTestResultInfo.getTestEnd()+"\n" +
                "测试场景:"+apiTestResultInfo.getTestContent()+"\n" +
                "响应码:"+apiTestResultInfo.getResponseCode()+"\n" +
                "响应时间:"+apiTestResultInfo.getResponseTime()+"\n" +
                "响应内容:"+ apiTestResultInfo.getResponseData().toString().trim().replace("\"","\\\"")+"\n" +//内容->转义->json，这里如果不转义的话，双引号会导致显示的内容直接结束
                "测试结果:"+apiTestResultInfo.getTestResult()+"\n";
        String postData=testInfo.WXpostData.replace("${content}",log);//将content变量替换成log
        postData=postData.replace("${@phone}",Handler);
        Request request=new Request(testInfo.WXheader);
        request.sendPost(testInfo.WXurl,postData);
        return true;
    }


    /**markdown模式的输入*/
    public String content(APITestResultInfo apiTestResultInfo){
        String log="<font color=\\\"warning\\\">接口响应异常</font>，请相关同事注意！\\n\n" +
                ">接口:<font color=\\\"comment\\\">"+apiTestResultInfo.getUrl()+"</font> \\n\n" +
                ">请求类型:<font color=\\\"comment\\\">"+apiTestResultInfo.getRequestYype()+"</font> \\n\n" +
                ">测试端:<font color=\\\"comment\\\">"+apiTestResultInfo.getTestEnd()+"</font> \\n\n" +
                ">测试场景:<font color=\\\"comment\\\">"+apiTestResultInfo.getTestContent()+"</font> \\n\n" +
                ">响应码:<font color=\\\"warning\\\">"+apiTestResultInfo.getResponseCode()+"</font> \\n\n" +
                ">响应时间:<font color=\\\"warning\\\">"+apiTestResultInfo.getResponseTime()+"</font> \\n\n" +
                ">响应内容:<font color=\\\"warning\\\">"+apiTestResultInfo.getResponseData().toString().trim()+"</font> \\n\n" +
                ">测试结果:<font color=\\\"warning\\\">"+apiTestResultInfo.getTestResult()+"</font>";

        return log;
    }
}
