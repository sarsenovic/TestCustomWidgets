package com.example.sarsenovic.testcustomwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//    private final String TAG = "MainActivityTAG";
//    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = findViewById(R.id.button);
//
//        final String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Requests requests = new Requests(MainActivity.this);
//
//                Map<String, Object> bodyParams = new HashMap<>();
//
////                bodyParams.put("userName", "clint.guier@sbsteam.net");
////                bodyParams.put("password", "pass");
//
//                bodyParams.put("deviceId", deviceId);
//                bodyParams.put("token", "5|97040b8d-60eb-4299-945c-520300264f085b72c99a-e725-4127-8be2-282cc0027b7bf274a061-a25c-479a-ae53-bede4b1a6757dfb92dfa-e54c-4f7b-91df-644fe6a2dcd4");
//
////        bodyParams.put("token", "5|107436f8-7d55-4488-9dd6-bd9e392724012048d29e-a5bd-4b74-a446-fa4bc9858237a5ddfaaf-004f-457e-a2a7-d9e380ffe352b05f8e03-a99d-4f7a-9912-dc3b5709465b");
//
//                Map<String, String> headerMapParams = new HashMap<>();
//
//                headerMapParams.put("deviceId", deviceId);
//                headerMapParams.put("token", "5|97040b8d-60eb-4299-945c-520300264f085b72c99a-e725-4127-8be2-282cc0027b7bf274a061-a25c-479a-ae53-bede4b1a6757dfb92dfa-e54c-4f7b-91df-644fe6a2dcd4");
//
//                requests.makePostRequest(MainActivity.this, "http://10.4.2.81:8082/json/login", bodyParams, "jsonObject", true, MainActivity.this, true,
//                        "application/json", headerMapParams);
//            }
//        });

    }

//    @Override
//    public void onRequestLoadSuccessful(Object jsonObject) {
//        Log.d(TAG, "success");
//    }
//
//    @Override
//    public void onRequestLoadFailed(Object objectError) {
//        Log.d(TAG, "failed");
//    }
}
