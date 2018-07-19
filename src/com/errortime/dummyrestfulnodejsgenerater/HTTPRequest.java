/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static com.errortime.dummyrestfulnodejsgenerater.CloneApiConfig.getCloneApiConfigInstance;
import com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate.CloneTaskInfo;
import com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate.RequestInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Admin
 */
public class HTTPRequest {
    
    private static String urlEndpoint = "";
    public static int apiConnectTimeout = 10;
    public static int apiWriteTimeout = 10;
    public static int apiReadTimeout = 30;
    static OkHttpClient client;
    
    private static OkHttpClient getOKHttpClient(){
        if(client!=null){
            return client;
        }
         client = new OkHttpClient.Builder()
        .connectTimeout(apiConnectTimeout, TimeUnit.SECONDS)
        .writeTimeout(apiWriteTimeout, TimeUnit.SECONDS)
        .readTimeout(apiReadTimeout, TimeUnit.SECONDS)
        .build();
        return client;
    }

    
    private static String getParameterPath(String[] parameter){
        if(parameter.length>0){
            StringJoiner path = new StringJoiner("/");
            for (String value : parameter) {
                if(value != null){
                    path.add(value);
                }
            }
            return path.toString();
        }
        else{
            return null;
        }
    }
    
//    public String post(String apiPath, String json) throws IOException{
//        OkHttpClient client = getOKHttpClient(config);
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(JSON, json);
//        String url = urlEndpoint+"/"+apiPath;
//        Request request = new Request.Builder()
//        .url(url)
//        .post(body)
//        .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();   
//        }
//    }
//    
//    public String put(String apiPath, String json) throws IOException{
//        OkHttpClient client = getOKHttpClient(config);
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(JSON, json);
//        String url = config.getUrl()+"/"+apiPath;
//        Request request = new Request.Builder()
//        .url(url)
//        .put(body)
//        .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();   
//        }
//    }
    
    public static String get(String apiPath) throws IOException{
        OkHttpClient client = getOKHttpClient();
        String url;
        url = urlEndpoint+"/"+apiPath;
        Request request = new Request.Builder()
        .url(url)
        .get()
        .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();   
        }
    }
    
    public static void sentHttpRequest() {
        getCloneApiConfigInstance().readApiInfo();
        CloneTaskInfo cloneTaskInfo = getCloneApiConfigInstance().getCloneTaskOutput();
        ArrayList<RequestInfo> initDatas= cloneTaskInfo.getInitData();
        for(RequestInfo initData : initDatas){
            try {
                System.out.println(get(initData.getUri()));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
   
    
//    public String get(String apiPath,String[] parameter) throws IOException{
//        OkHttpClient client = getOKHttpClient(config);
//        String parameterPath = getParameterPath(parameter);
//        String url;
//        if(parameterPath == null){
//            url = config.getUrl()+"/"+apiPath;
//        }
//        else{
//            url = config.getUrl()+"/"+apiPath+"/"+parameterPath;
//        }
//        Request request = new Request.Builder()
//        .url(url)
//        .get()
//        .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();   
//        }
//    }
//    
//    public String delete(String apiPath, String json) throws IOException{
//        OkHttpClient client = getOKHttpClient(config);
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(JSON, json);
//        String url = config.getUrl()+"/"+apiPath;
//        Request request = new Request.Builder()
//        .url(url)
//        .delete(body)
//        .build();
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();   
//        }
//    }

    public static String getUrlEndpoint() {
        return urlEndpoint;
    }

    public static void setUrlEndpoint(String urlEndpoint) {
        HTTPRequest.urlEndpoint = urlEndpoint;
    }
}

