package com.mealcome.model;

/**
 * Created by wuchaolin on 2019/5/14.
 */
public class resultsInfo {
    private String mUserName;//账号
    private String mSessionID;//sessionID
    private String mHost;
    private String mLocal;
    private long mTakeTime;
    public static final int outtime=90;//超时时间，单位秒
    public static final String header="Content-Type:application/json，sessionId:c776673aec2048dea6a1fa7ec66c413e";
    public static final String WXHeader="Content-Type: application/json";

    public long getmTakeTime(){return this.mTakeTime;}
    public void setmTakeTime(long takeTime){this.mTakeTime=takeTime;}
}
