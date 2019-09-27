package com.mealcome.model;

/**
 * Created by wuchaolin on 2019/5/14.
 */
public class userInfo {
    private String mUsername;
    private String mPassword="1";//测试服的密码是固定的1
    public final int maxcolom=4;
    private String mTenantid;
    private String mSessionId;
    private String mSessionId_overtime;
    private boolean isSaveSessionId;//是否保存新的sessionID
    private String takePosttime;//临时添加
    private String error;//临时添加
    private String takeGetResponseTime;//临时添加

    public void setError(String error){this.error=error;}
    public String getError(){return this.error;}
    public void setTakePosttime(String takePosttime){this.takePosttime=takePosttime;}
    public String getTakePosttime(){return this.takePosttime;}
    public void setTakeGetResponseTime(String takeGetResponseTime){this.takeGetResponseTime=takeGetResponseTime;}
    public String getTakeGetResponseTime(){return this.takeGetResponseTime;}

    public void setisSaveSessionId(boolean isSaveSessionId){this.isSaveSessionId=isSaveSessionId;}
    public boolean getisSaveSessionId(){return this.isSaveSessionId;}
    public void setmPassword(String password){/** this.mPassword=password; 暂且略去，后续测试服密码机制改动再去掉此注释*/}
    public String getmPassword(){return this.mPassword;}
    public void setmUsername(String username){this.mUsername=username;}
    public String getmUsername(){return this.mUsername;}
    public void setmTenantid(String tenantid){this.mTenantid=tenantid;}
    public String getmTenantid(){return this.mTenantid;}
    public void setmSessionId(String sessionId){this.mSessionId=sessionId;}
    public String getmSessionId(){return this.mSessionId;}
    public void setmSessionId_overtime(String sessionId_overtime){this.mSessionId_overtime=sessionId_overtime;}
    public String getmSessionId_overtime(){return this.mSessionId_overtime;}

    public String toString(){
        return "userInfo{" +
                "userName='"+this.mUsername+"\'," +
                "tenantid='"+this.mTenantid+"\'," +
                "sessionID='"+this.mSessionId+"\'," +
                "sessionID_overtime='"+this.mSessionId_overtime+"\'," +
                "isSaveSessionId='" +this.isSaveSessionId+"\'," +
                "takePostTime='"+this.takePosttime+"\'," +
                "takeGetResponseTime='" +this.takeGetResponseTime+"\',"+
                "error='"+this.error+"\'"+
                "}";
    }

}
