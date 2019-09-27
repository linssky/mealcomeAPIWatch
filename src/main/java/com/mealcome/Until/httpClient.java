//package com.mealcome.Until;
//
//import net.sf.json.JSONObject;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by wuchaolin on 2019/6/9.
// */
//public class httpClient {
//    private boolean isPost;
//    httpClient(String getOrPost){
//        this.isPost=getOrPost.trim().equals("post");
//    }
//
//    public JSONObject sendRequest(String url,String body,String header,String encoding){
//        List<NameValuePair> headers=new ArrayList<NameValuePair>();
//        JSONObject response;
//
//        if (header!=null&&!header.equals("")) {
//            String[] h = header.split(";");
//            for (String head : h) {
//                NameValuePair he = new BasicNameValuePair(head.split(":")[0], head.split(":")[1]);
//                headers.add(he);
//            }
//        }else {
//            headers=null;
//        }
//        if (this.isPost){
//           response= post(url,body,headers,encoding);
//        }else {
//            List<NameValuePair> params=new ArrayList<NameValuePair>();
//            String splits=body.contains(";")?";":",";
//            String splits1=body.contains("=")?"=":":";
//
//            if (body!=null&&!body.equals("")) {
//                String[] p = body.split(splits);
//                for (String param : p) {
//                    NameValuePair pa = new BasicNameValuePair(param.split(splits1)[0], param.split(splits1)[1]);
//                    params.add(pa);
//                }
//            }else {
//                params=null;
//            }
//            response=get(url,params,headers,encoding);
//        }
//        return response;
//    }
//
//
//    private JSONObject post(String url, String body, List<NameValuePair> headers, String encoding){
//
//        JSONObject response = null;
//        try{
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpPost httpPost = new HttpPost(url);
//
//            JSONObject json = new JSONObject();
//            StringEntity entity = new StringEntity(body.trim(),encoding);
//            httpPost.setEntity(entity);
//
//            if(headers != null){
//                for(int i=0;i<headers.size();i++){
//                    httpPost.addHeader(headers.get(i).getName(),headers.get(i).getValue());
//                }
//            }
//
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//
//            long startGetTime=System.currentTimeMillis();
//            if(httpResponse.getStatusLine().getStatusCode() == 200){
//                String result = EntityUtils.toString(httpResponse.getEntity());
//                long endGettTime=System.currentTimeMillis();
//                long takeGetTime=(endGettTime-startGetTime);//单位是ms
//                System.out.println("接口的getResponse时间是："+takeGetTime);
//                System.out.println(result);
//                response = JSONObject.fromObject(result);
//            }
//
//            httpPost.abort();
//            httpClient.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//        return response;
//
//    }
//
//    private JSONObject get(String url, List<NameValuePair> params, List<NameValuePair> headers, String encoding){
//
//        JSONObject response = null;
//        try{
//            String uri = url+"?"+ EntityUtils.toString(new UrlEncodedFormEntity(params,encoding));//拼接域名和地址和?后参数
//
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpGet httpGet = new HttpGet(uri);
//
//            if(headers != null){
//                for(int i=0;i<headers.size();i++){
//                    httpGet.addHeader(headers.get(i).getName(),headers.get(i).getValue());
//                }
//            }
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            long startGetTime=System.currentTimeMillis();
//            if(httpResponse.getStatusLine().getStatusCode() == 200){
//                String result = EntityUtils.toString(httpResponse.getEntity());
//                long endGettTime=System.currentTimeMillis();
//                long takeGetTime=(endGettTime-startGetTime);//单位是ms
//                System.out.println("接口的getResponse时间是："+takeGetTime);
//                System.out.println(result);
//                response = JSONObject.fromObject(result);
//            }
//            httpGet.abort();
//            httpClient.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return response;
//    }
//}
