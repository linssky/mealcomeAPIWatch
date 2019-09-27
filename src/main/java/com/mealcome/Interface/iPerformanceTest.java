package com.mealcome.Interface;

import com.mealcome.model.userInfo;

import java.util.List;

/**
 * Created by wuchaolin on 2019/5/14.
 * 此接口实现多并发的测试并返回测试结果
 */
public interface iPerformanceTest {
    //根据线程数开线程池，将封装好的测试接口逻辑（可以是单接口，可以是组合接口）传入
//    List<resultsInfo> ThreadsTest(iAPITest oneAPITest);

    List<userInfo> ThreadsTest(List<userInfo> userInfos);

}