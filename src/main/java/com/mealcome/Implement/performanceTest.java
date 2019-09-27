//package com.mealcome.Implement;
//
//import com.mealcome.Info.userInfo;
//import com.mealcome.Interface.iAPITest;
//import com.mealcome.Interface.iPerformanceTest;
//import com.mealcome.common;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.*;
//
///**
// * Created by wuchaolin on 2019/5/16.
// */
//public class performanceTest extends common implements iPerformanceTest {
//    public List<userInfo> ThreadsTest(List<userInfo> userInfos) {
////        int size=userInfos.size();
//        int size=50;
//        ExecutorService pool= Executors.newFixedThreadPool(size+1);
//        List<userInfo> UI=new ArrayList<userInfo>(); //结果集
//        CompletionService<userInfo> completionService = new ExecutorCompletionService<userInfo>(pool); //1.定义CompletionService
////        List<Future<userInfo>> lf=new ArrayList<Future<userInfo>>();//方法1
//        for (int i=0;i<size;i++){
//            Callable mCallable = new CallableImpl(userInfos.get(i));
//            completionService.submit(mCallable);
////            Future<userInfo> future=completionService.submit(mCallable);//方法1
////            lf.add(future);
//        }
//
////        //方法1：future是提交时返回的，遍历queue则按照任务提交顺序，获取结果
////        for(Future<userInfo> future:lf){
////            try {
////                userInfo result=future.get();//线程在这里阻塞等待该任务执行完毕
////                UI.add(result);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            } catch (ExecutionException e) {
////                e.printStackTrace();
////            }
////        }
//
//        //方法2.使用内部阻塞队列的take()
//        for (int i=0;i<size;i++){
//            try {
//                userInfo result=completionService.take().get();//采用completionService.take()，内部维护阻塞队列，任务先完成的先获取到
//                UI.add(result);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }finally {
//                pool.shutdown();//关闭线程池
//            }
//        }
//        return UI;
//    }
//
//    static class CallableImpl implements Callable {
//        private userInfo UI;
//        CallableImpl(userInfo userInfo) {
//            this.UI = userInfo;
//        }
//        public Object call() throws Exception {
//            iAPITest iAPITest=new APITest();
//            userInfo newUI=iAPITest.oneAPITest(UI);
//            return newUI;
//        }
//    }
//}
