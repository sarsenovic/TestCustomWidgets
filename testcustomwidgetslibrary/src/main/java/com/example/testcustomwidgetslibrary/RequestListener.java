package com.example.testcustomwidgetslibrary;

import org.json.JSONObject;

public interface RequestListener {
    void onRequestLoadSuccessful(Object jsonObject, String requestIndicator);
    void onRequestLoadFailed(Object objectError, String requestIndicator);
}
