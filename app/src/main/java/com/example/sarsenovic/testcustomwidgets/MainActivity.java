package com.example.sarsenovic.testcustomwidgets;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.testcustomwidgetslibrary.RequestListener;
import com.example.testcustomwidgetslibrary.Requests;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements RequestListener {
    private final String TAG = "MainActivityTag";
    int i = 0;
    int z = 0;
    Requests req;
    Map<String, Object> bodyParams;
    Map<String, String> headerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        req = new Requests(this, true);

        bodyParams = new HashMap<>();
        bodyParams.put("pib", String.valueOf("104052135"));
//        bodyParams.put("pib", "100020806");
//        bodyParams.put("date", String.valueOf(""));
//        bodyParams.put("date", "2019-01-24");

        headerMap = new HashMap<>();
        headerMap.put("userId", "198");
        headerMap.put("token", "198|04114761-2899-4179-a215-82229ebb335d");
        headerMap.put("deviceId", "3bb0dadb1e1db094");


        req.createPostRequest("http://10.4.2.45:8080/listaPrijava", bodyParams, "jsonObject", true, MainActivity.this, true
                , "Message 1", 0, 1, false, false, false, "application/json", headerMap, "tag1");
        req.createPostRequest("http://10.4.2.45:8080/listaPrijava", bodyParams, "jsonObject", true, MainActivity.this, true
                , "Message 2", 0, 0, false, false, false, "application/json", headerMap, "tag2");
        req.createPostRequest("http://10.4.2.45:8080/listaPrijava", bodyParams, "jsonObject", true, MainActivity.this, true
                , "Message 3", 0, 1, false, false, false, "application/json", headerMap, "tag3");
        req.createPostRequest("http://10.4.2.45:8080/listaPrijava", bodyParams, "jsonObject", true, MainActivity.this, true
                , "Message 4", 0, 0, false, false, false, "application/json", headerMap, "tag4");
    }

    private void runn() {
        req.createPostRequest("http://10.4.2.45:8080/listaPrijava", bodyParams, "jsonObject", true, MainActivity.this, true
                , "Message " + (i + 1), 0, 0, false, false, false, "application/json", headerMap, "tag" + (i + 1));
    }

    @Override
    public void onRequestLoadSuccessful(Object o, String s) {
        if (s.equals("tag1")) {
            Log.e(TAG, "onRequestLoadSuccessful: ");
        } else if (s.equals("tag2")) {
            Log.e(TAG, "onRequestLoadSuccessful: ");
        } else if (s.equals("tag3")) {
            Log.e(TAG, "onRequestLoadSuccessful: ");
        } else if (s.equals("tag4")) {
            Log.e(TAG, "onRequestLoadSuccessful: ");
        }
    }

    @Override
    public void onRequestLoadFailed(Object o, String s) {
        if (s.equals("tag1")) {
            Log.e(TAG, "onRequestLoadFailed: ");
        } else if (s.equals("tag2")) {
            Log.e(TAG, "onRequestLoadFailed: ");
        } else if (s.equals("tag3")) {
            Log.e(TAG, "onRequestLoadFailed: ");
        } else if (s.equals("tag4")) {
            Log.e(TAG, "onRequestLoadFailed: ");
        }
    }
}
