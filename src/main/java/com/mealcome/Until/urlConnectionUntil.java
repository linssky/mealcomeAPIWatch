package com.mealcome.Until;

import com.mealcome.model.resultsInfo;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wuchaolin on 2019/5/16.
 */
public class urlConnectionUntil {
    private static String getOrPost;//get请求或者post请求
    private static String url;//get请求或者post请求
    private static String Header;//请求头
    private static HttpURLConnection connection = null;
    public urlConnectionUntil(String getOrPost,String Header){
        this.getOrPost=getOrPost.toUpperCase().trim();
        this.Header=Header;
    }

    public HttpURLConnection getConnection(String url){
        this.url=url;
        getConnection();
        setHeader(this.Header);
        return this.connection;
    }

    private void getConnection(){
        HttpURLConnection connection = null;
        try {
            // 打开和URL之间的连接
            URL postUrl = new URL(url);
            connection = (HttpURLConnection) postUrl.openConnection();// 根据URL生成HttpURLConnection
            // 设置通用的请求属性
            connection.setDoOutput(true);//设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,默认情况下是false
            connection.setDoInput(getOrPost.equals("POST")?true:false);//设置是否从connection读入，默认情况下是true;
            connection.setRequestMethod(getOrPost);// 设置请求方式为post,默认GET请求
            connection.setUseCaches(false);// post请求不能使用缓存设为false
            connection.setInstanceFollowRedirects(true);// 设置该HttpURLConnection实例是否自动执行重定向
            connection.setConnectTimeout(1000* resultsInfo.outtime);// 连接主机的超时时间
            connection.setReadTimeout(1000*resultsInfo.outtime);// 从主机读取数据的超时时间
//            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Charset", "utf-8");//连接复用,设置header内容
            connection.setRequestProperty("Accept-Charset", "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.connection=connection;
    }

    private  void setHeader(String header){
        String[] a = new String[1];
        if (header.trim().contains("\n")){
            a=header.split("\n");
        }else if(header.trim().contains("，")) {
            a = header.split("，");
        }else if(header.trim().contains(",")){
            a = header.split(",");
        }else {
            a[0]=header;
        }
        if (a!=null) {
            for (int i = 0; i < a.length; i++) {
                this.connection.setRequestProperty(a[i].split(": ")[0], a[i].split(": ")[1]);
            }
        }
    }

    public static void upLoad(){
//part 1
//        String part1 =  "--" + boundary + Enter
//                + "Content-Type: application/octet-stream" + Enter
//                + "Content-Disposition: form-data; filename=\""+xml.getName()+"\"; name=\"file\"" + Enter + Enter;
//        //part 2
//        String part2 = Enter
//                + "--" + boundary + Enter
//                + "Content-Type: text/plain" + Enter
//                + "Content-Disposition: form-data; name=\"dataFormat\"" + Enter + Enter
//                + "hk" + Enter
//                + "--" + boundary + "--";

    }
}
