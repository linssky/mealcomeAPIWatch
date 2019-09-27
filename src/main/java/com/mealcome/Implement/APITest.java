//package com.mealcome.Implement;
//
//import com.mealcome.Info.APIInfo;
//import com.mealcome.Info.resultsInfo;
//import com.mealcome.Info.taskInfo;
//import com.mealcome.Info.userInfo;
//import com.mealcome.Interface.iAPITest;
//import com.mealcome.Until.urlConnectionUntil;
//import com.mealcome.common;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by wuchaolin on 2019/5/14.
// */
//public class APITest extends common implements iAPITest {
//
//    public List<resultsInfo> forAPITest(List<taskInfo> taskInfos) {
//
//
//
//
//        List<resultsInfo> resultsInfos=new ArrayList<resultsInfo>();
//        resultsInfo rI;
//        for (taskInfo taskInfo:taskInfos){
//            long startTime=System.currentTimeMillis();
////            rI=oneAPITest(taskInfo);
//            long endtTime=System.currentTimeMillis();
//            long takeTime=(endtTime-startTime);//单位是ms
////            rI.setmTakeTime(takeTime);
////            resultsInfos.add(rI);
//        }
//        return resultsInfos;
//    }
//
//    public void sendPost(String url,String postData){
//        urlConnectionUntil urlConnectionUntil=new urlConnectionUntil("post","");
//        HttpURLConnection connection=urlConnectionUntil.getConnection(url);
//        String line = null;
//        try {
//            long startTime = System.currentTimeMillis();
//            connection.connect();
//            OutputStream dataOut = new DataOutputStream(connection.getOutputStream());
//            dataOut.write(postData.getBytes());
//            dataOut.flush();
//            dataOut.close();
//            long endtTime=System.currentTimeMillis();
//            long takeTime=(endtTime-startTime);//单位是ms
//            System.out.println("接口的post时间是："+takeTime);
//
//            long startGetTime=System.currentTimeMillis();
//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
//                BufferedReader   reader = new BufferedReader(in);// 发送http请求
//                StringBuilder result = new StringBuilder();
//                // 循环读取流
//                while ((line = reader.readLine()) != null) {
//                    result.append(line).append(System.getProperty("line.separator"));//
//                }
//                in.close();
//                connection.disconnect();
//                long endGettTime=System.currentTimeMillis();
//                long takeGetTime=(endGettTime-startGetTime);//单位是ms
//                System.out.println("接口的getResponse时间是："+takeGetTime);
//                System.out.println(result.toString());
//            }else {
//                InputStreamReader in = new InputStreamReader(connection.getInputStream(), "UTF-8");
//                BufferedReader reader = new BufferedReader(in);// 发送http请求
//                StringBuilder result = new StringBuilder();
//                // 循环读取流
//                while ((line = reader.readLine()) != null) {
//                    result.append(line).append(System.getProperty("line.separator"));//
//                }
//                in.close();
//                connection.disconnect();
//                System.out.println("接口参数异常或有bug，返回结果是：" + result.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public userInfo oneAPITest(userInfo userInfo) {
//        userInfo UI=userInfo;
//        urlConnectionUntil urlConnectionUntil=new urlConnectionUntil("post","");
//        HttpURLConnection connection=urlConnectionUntil.getConnection(APIInfo.LOGIN);
//        String line = null;
//        try {
//            long startTime=System.currentTimeMillis();
//            connection.connect();
//            OutputStream dataout = new DataOutputStream(connection.getOutputStream());// 创建输入输出流,用于往连接里面输出携带的参数
//            String body="{\"code\":\""+UI.getmUsername()+"\",\"password\":\""+UI.getmPassword()+"\"}";
//            dataout.write(body.getBytes());
//            dataout.flush();
//            dataout.close();
//            long endtTime=System.currentTimeMillis();
//            long takeTime=(endtTime-startTime);//单位是ms
//            UI.setTakePosttime(String.valueOf(takeTime));
//            System.out.println("用户"+UI.getmUsername()+"的登录接口的post时间是："+takeTime);
//
//            long startGetTime=System.currentTimeMillis();
//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
//                BufferedReader   reader = new BufferedReader(in);// 发送http请求
//                StringBuilder result = new StringBuilder();
//                // 循环读取流
//                while ((line = reader.readLine()) != null) {
//                    result.append(line).append(System.getProperty("line.separator"));//
//               }
//                in.close();
//                connection.disconnect();
//                long endGettTime=System.currentTimeMillis();
//                long takeGetTime=(endGettTime-startGetTime);//单位是ms
//                UI.setTakeGetResponseTime(String.valueOf(takeGetTime));
//                System.out.println("用户"+UI.getmUsername()+"的登录接口的getResponse时间是："+takeGetTime);
//                System.out.println(result.toString());
//                if (result.toString().contains("sessionId\":\"")){
//                    String sessionidOverTime=getNowTime();
//                    boolean isSave=isSaveSeesionID(sessionidOverTime,UI.getmSessionId_overtime());
//                    System.out.println("isSave的结果是："+isSave);
//                    UI.setisSaveSessionId(isSave);
//                    String sessionid=result.toString().split("sessionId\":\"")[1].split("\"")[0];
//                    if (isSave){
//                        UI.setmSessionId(sessionid);
//                        UI.setmSessionId_overtime(sessionidOverTime);
//                    }
//
//                }else {
//                    UI.setError(result.toString().trim());
//                }
//            }else {
//                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
//                    BufferedReader   reader = new BufferedReader(in);// 发送http请求
//                    StringBuilder result = new StringBuilder();
//                    // 循环读取流
//                    while ((line = reader.readLine()) != null) {
//                        result.append(line).append(System.getProperty("line.separator"));//
//                    }
//                in.close();
//                connection.disconnect();
//                    System.out.println("接口参数异常或有bug，返回结果是："+result.toString());
//                UI.setError(result.toString().trim());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return UI;
//    }
//
//    public void APITest(){
//        urlConnectionUntil urlConnectionUntil=new urlConnectionUntil("post",");
//        HttpURLConnection connection=urlConnectionUntil.getConnection("www.");
//        String line = null;
//        try {
//            long startTime=System.currentTimeMillis();
//            connection.connect();
//            OutputStream dataout = new DataOutputStream(connection.getOutputStream());// 创建输入输出流,用于往连接里面输出携带的参数
//            String body="";
//            dataout.write(body.getBytes());
//            dataout.flush();
//            dataout.close();
//            long endtTime=System.currentTimeMillis();
//            long takeTime=(endtTime-startTime);//单位是ms
//            System.out.println("接口的post时间是："+takeTime);
//
//            long startGetTime=System.currentTimeMillis();
//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
//                BufferedReader   reader = new BufferedReader(in);// 发送http请求
//                StringBuilder result = new StringBuilder();
//                // 循环读取流
//                while ((line = reader.readLine()) != null) {
//                    result.append(line).append(System.getProperty("line.separator"));//
//                }
//                in.close();
//                connection.disconnect();
//                long endGettTime=System.currentTimeMillis();
//                long takeGetTime=(endGettTime-startGetTime);//单位是ms
//                System.out.println("接口的getResponse时间是："+takeGetTime);
//                System.out.println(result.toString());
//                line=result.toString();
//            }else {
//                InputStreamReader in=new InputStreamReader(connection.getInputStream(), "UTF-8");
//                BufferedReader   reader = new BufferedReader(in);// 发送http请求
//                StringBuilder result = new StringBuilder();
//                // 循环读取流
//                while ((line = reader.readLine()) != null) {
//                    result.append(line).append(System.getProperty("line.separator"));//
//                }
//                in.close();
//                connection.disconnect();
//                System.out.println("接口参数异常或有bug，返回结果是："+result.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
