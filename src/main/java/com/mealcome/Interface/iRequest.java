package com.mealcome.Interface;

import com.mealcome.model.APITestResultInfo;

/**
 * Created by wuchaolin on 2019/8/3.
 * 实现post/get请求
 */
public interface iRequest {
    APITestResultInfo sendPost(String URL, String postData);
    APITestResultInfo sendGet(String url);
}
