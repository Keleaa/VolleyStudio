package com.bwie.zhang.volleystudio.MVP;

import android.app.Application;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class MyApp extends Application {
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue queue(){
        return requestQueue;
    }
}
