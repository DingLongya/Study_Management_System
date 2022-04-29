package com.e.library_management_system;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpDate extends AsyncTask<String, Void, String> {

    private HttpClient mHttpClient;
    private HttpGet mHttpGet;//请求方式
    private String url;
    private HttpResponse mHttpResponse;
    private HttpEntity mHttpEntity;
    private InputStream in;
    private HttpGetDataListener listener;

    public HttpDate(String url, HttpGetDataListener listener) {
        this.url = url;
        this.listener = listener;
    }

    public HttpDate(HttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            mHttpClient = new DefaultHttpClient();//实例化客户端
            mHttpGet = new HttpGet(url);//进行请求
            mHttpResponse = mHttpClient.execute(mHttpGet);
            mHttpEntity = mHttpResponse.getEntity();
            in = mHttpEntity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            return  sb.toString();
        }catch(Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        listener.getDataUrl(s);
        super.onPostExecute(s);
    }
}
