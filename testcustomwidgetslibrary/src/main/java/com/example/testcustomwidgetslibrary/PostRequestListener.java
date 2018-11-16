package com.example.testcustomwidgetslibrary;

import org.json.JSONObject;

public interface PostRequestListener {
    void onRequestLoadSuccessful(Object jsonObject, String requestIndicator);
    void onRequestLoadFailed(Object objectError, String requestIndicator);
}
