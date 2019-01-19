package com.example.administrator.thirdyuekaotest.data.utils;

import com.example.administrator.thirdyuekaotest.ui.adapter.LogInterceptor;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OKHttpUtil  {
    private static OKHttpUtil okHttpUtil;
    private final OkHttpClient client;

    //日志拦截器
    private OKHttpUtil() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();
    }
    //单例
    public static OKHttpUtil getInstance() {
        if (null == okHttpUtil) {
            synchronized (OKHttpUtil.class) {
                if (null == okHttpUtil) {
                    okHttpUtil = new OKHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    //get
    public void get(String urlString, Callback callback) {
        Request request = new Request.Builder()
                .url(urlString).build();
        client.newCall(request).enqueue(callback);
    }
}
