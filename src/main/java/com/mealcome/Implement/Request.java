package com.mealcome.Implement;

import com.mealcome.Interface.iRequest;
import com.mealcome.Until.urlConnectionUntil;
import com.mealcome.common;
import com.mealcome.model.APITestResultInfo;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * Created by wuchaolin on 2019/8/3.
 */
public class Request extends common implements iRequest {
    private static String Header;

    public Request(String Header){
        this.Header=Header;
    }
    public APITestResultInfo sendPost(String URL, String postData) {
        if (postData.contains("${date}")) {
            postData = postData.replace("${date}", getNowDay());//把日期变量替换成今天
        }else if (postData.contains("${time}")){
            postData = postData.replace("${date}", getNowSeconds());//把时间变量替换成现在
        }
        APITestResultInfo apiTestResultInfo = new APITestResultInfo();
        apiTestResultInfo.setRequestData(postData);//设置请求数据
        apiTestResultInfo.setUrl(URL);
        apiTestResultInfo.setRequestYype("POST");
        apiTestResultInfo.setTestStartTime(getNowSeconds());//保存当前时间
        urlConnectionUntil urlConnectionUntil=new urlConnectionUntil("post",Header);
        HttpURLConnection connection=urlConnectionUntil.getConnection(URL);
        String line = null;
        StringBuilder result = new StringBuilder();
        long takeGetTime = 0;
        try {
            long startTime = System.currentTimeMillis();
            connection.connect();
            OutputStream dataOut = new DataOutputStream(connection.getOutputStream());
            dataOut.write(postData.getBytes());
            dataOut.flush();
            dataOut.close();
            long endtTime=System.currentTimeMillis();
            long takeTime=(endtTime-startTime);//单位是ms
            apiTestResultInfo.setRequestTime(takeTime);
            System.out.println("接口的post时间是："+takeTime);

            long startGetTime=System.currentTimeMillis();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(in);// 发送http请求
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));//
                }

                apiTestResultInfo.setResponseCode(connection.getResponseCode());
                in.close();
                connection.disconnect();
                long endGettTime=System.currentTimeMillis();
                takeGetTime=(endGettTime-startGetTime);//单位是ms
                System.out.println("接口的getResponse时间是："+takeGetTime);
                System.out.println(result.toString());
            }else {
                InputStreamReader in = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(in);// 发送http请求

                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));//
                }
                apiTestResultInfo.setResponseCode(connection.getResponseCode());
                in.close();
                connection.disconnect();
                System.out.println("接口参数异常或有bug，返回结果是："+connection.getResponseCode()+"\n" + result.toString());
                long endGettTime=System.currentTimeMillis();
                takeGetTime=(endGettTime-startGetTime);
                System.out.println("接口的getResponse时间是："+takeGetTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        apiTestResultInfo.setResponseTime(takeGetTime);
        apiTestResultInfo.setResponseData(result.toString());
        return apiTestResultInfo;

    }

    public APITestResultInfo sendGet(String url) {
        return null;
    }

}
