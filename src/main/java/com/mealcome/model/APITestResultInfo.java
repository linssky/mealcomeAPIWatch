package com.mealcome.model;

/**
 * Created by wuchaolin on 2019/8/8.
 */
public class APITestResultInfo {
    private int testCode=0;//测试轮数，一直递增
    private String testContent="0";//测试内容or测试流程，分：下单收货-采购商下单，下单收货-供应商收到通知，下单收货-电子秤收到通知，下单收货-采购商收到通知
    private String testEnd="0";//测试端
    private String testStartTime="0";//测试开始时间，格式：2019-8-8 11:46:42
    private String url="0";//测试接口url
    private String requestYype="0";//请求类型
    private String requestData="0";//请求数据
    private long requestTime=0;//响应时间，单位ms
    private long responseTime=0;//响应时间，单位ms
    private int responseCode=0;//响应码
    private String responseData="0";//响应数据
    private String testResult="0";//测试结果
    private String note="0";//备注


    public int getTestCode(){return this.testCode;}
    public void setTestCode(int Testcode){this.testCode=Testcode;}

    public String getTestContent(){return this.testContent;}
    public void setTestContent(String TestContent){this.testContent=TestContent;}

    public String getTestEnd(){return this.testEnd;}
    public void setTestEnd(String TestEnd){this.testEnd=TestEnd;}

    public String getTestStartTime(){return this.testStartTime;}
    public void setTestStartTime(String TestStartTime){this.testStartTime=TestStartTime;}

    public String getUrl(){return this.url;}
    public void setUrl(String Url){this.url=Url;}

    public String getRequestYype(){return this.requestYype;}
    public void setRequestYype(String RequestType){this.requestYype=RequestType;}

    public String getRequestData(){return this.requestData;}
    public void setRequestData(String RequestData){this.requestData=RequestData;}

    public long getRequestTime(){return this.requestTime;}
    public void setRequestTime(long RequestTime){this.requestTime=RequestTime;}

    public long getResponseTime(){return this.responseTime;}
    public void setResponseTime(long ResponseTime){this.responseTime=ResponseTime;}

    public int getResponseCode(){return this.responseCode;}
    public void setResponseCode(int ResponseCode){this.responseCode=ResponseCode;}

    public String getResponseData(){return this.responseData;}
    public void setResponseData(String ResponseData){this.responseData=ResponseData;}

    public String getTestResult(){return this.testResult;}
    public void setTestResult(String RestResult){this.testResult=RestResult;}

    public String getNote(){return this.note;}
    public void setNote(String Note){this.note=Note;}

    @Override
    public String toString() {
        return "APITestResultInfo{" +
                "testCode='" + testCode + '\'' +
                ", testContent='" + testContent + '\'' +
                ", testEnd='" + testEnd + '\'' +
                ", testStartTime='" + testStartTime + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", url='" + url + '\'' +
                ", requestYype='" + requestYype + '\'' +
                ", requestData='" + requestData + '\'' +
                ", responseTime='" + responseTime + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseData='" + responseData + '\'' +
                ", testResult='" + testResult + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
