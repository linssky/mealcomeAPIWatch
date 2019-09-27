package com.mealcome.HeartBeat;

import javax.servlet.ServletContext;
import java.util.TimerTask;

/**
 * Created by wuchaolin on 2019/8/3.
 */
public class timer extends TimerTask {
    private static final int C_SCHEDULE_HOUR = 0;
    private static boolean isRunning = false;
    private ServletContext context = null;

    public timer(ServletContext context){
        this.context=context;
    }

    @Override
    public void run() {
        isRunning = true;
        context.log("开始执行指定任务");
        try {
            new WebService().APIMoniter();// 这里就是调用自己的方法了
        }catch (Exception e){
            System.out.println("定时器执行异常！");
        }
        isRunning = false;
        context.log("指定任务执行结束");
    }
}
