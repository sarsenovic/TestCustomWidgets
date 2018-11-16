package com.example.testcustomwidgetslibrary;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Requests {
    public static final String CONTENT_TYPE = "application/json";
    private Context context;
    private LoadingDialog loadingDialog;
    private OkHttpClient okHttpClient;
    private PostRequestListener postRequestListenerCallback;
    private ANRequest.PostRequestBuilder postRequestBuilder;

    public Requests(Context context) {
        this.context = context;
    }

    public void makePostRequest(final Context context, String urlString, Map<String, Object> bodyParams, String typeOfExpectedResponse, boolean sendAsJSON,
                                final PostRequestListener postCallback, final boolean showLoadingDialog, String contentTypeString, Map<String, String> headerParamsMap, final String requestIndicator) {
        if (urlString != null) {

            this.postRequestListenerCallback = postCallback;

            if (showLoadingDialog)
                showLoadingDialog(context);

            postRequestBuilder = AndroidNetworking.post(urlString)
                    .setOkHttpClient(getOkHttpClient());

            if (contentTypeString != null && !contentTypeString.equals(""))
                postRequestBuilder.setContentType(contentTypeString);

            if (headerParamsMap != null && headerParamsMap.size() > 0) {
                for (Map.Entry<String, String> entry : headerParamsMap.entrySet()) {
                    postRequestBuilder.addHeaders(entry.getKey(), entry.getValue());
                }
            }

            Map<String, Object> mainMap = new HashMap<>();

            if (bodyParams != null)
                mainMap.putAll(bodyParams);

            if (sendAsJSON) {
                JSONObject jsonObject = new JSONObject(mainMap);

                try {
                    for (Map.Entry<String, Object> entry : mainMap.entrySet()) {
                        jsonObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                postRequestBuilder.addStringBody(String.valueOf(jsonObject));
            } else if (!mainMap.isEmpty()) {
                for (Map.Entry<String, Object> entry : mainMap.entrySet()) {
                    postRequestBuilder.addBodyParameter(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }

            if (typeOfExpectedResponse != null && !typeOfExpectedResponse.equals("")) {
                switch (typeOfExpectedResponse) {

                    case "jsonObject":

                        postRequestBuilder.build().getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response != null) {
                                    postCallback.onRequestLoadSuccessful(response, requestIndicator);
                                }
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }

                            @Override
                            public void onError(ANError anError) {
                                postCallback.onRequestLoadFailed(anError, requestIndicator);
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }
                        });
                        break;

                    case "jsonArray":

                        postRequestBuilder.build().getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                if (response != null) {
                                    postCallback.onRequestLoadSuccessful(response, requestIndicator);
                                }
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }

                            @Override
                            public void onError(ANError anError) {
                                postCallback.onRequestLoadFailed(anError, requestIndicator);
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }
                        });
                        break;

                    case "String":

                        postRequestBuilder.build().getAsString(new StringRequestListener() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null) {
                                    postCallback.onRequestLoadSuccessful(response, requestIndicator);
                                }
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }

                            @Override
                            public void onError(ANError anError) {
                                postCallback.onRequestLoadFailed(anError, requestIndicator);
                                if (showLoadingDialog)
                                    hideLoadingDialog();

                                postRequestListenerCallback = null;
                                postRequestBuilder = null;
                            }
                        });
                        break;

                    default:
                        ToastMessage.toaster(context, "Invalid type");
                        break;
                }
            }
        }
    }

    private void showLoadingDialog(Context context) {
        hideLoadingDialog();
        loadingDialog = new LoadingDialog(context, "Loading, please wait...", false);
    }

    private void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.hide();
            loadingDialog = null;
        }
    }

    public OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
        }

        return okHttpClient;
    }

}
