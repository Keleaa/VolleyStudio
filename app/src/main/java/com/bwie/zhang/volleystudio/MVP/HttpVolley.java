package com.bwie.zhang.volleystudio.MVP;

import java.util.Map;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class HttpVolley {
    //get请求
    public void VolleyHttpGet(String url, final VolleyCallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error);
            }
        });
        stringRequest.setTag("testPost");
        MyApp.queue().add(stringRequest);
    }

    public void VolleyPost(String url, final Map<String, String> map, final VolleyCallBack callBack) {
        new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error);
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }

    //定义接口
    interface VolleyCallBack {
        void onSuccess(String data);

        void onFail(VolleyError error);
    }
}
