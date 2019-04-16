package com.bwie.zhang.volleystudio.MVP;

import android.util.Log;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class Model implements Contract.IModel {
    @Override
    public void getRequester(String url, final ModelCallBack callBack) {
        AsyncHttpClient.getInstance().GetAsync(url, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void Error(int errorcode, String message) {
                Log.i("bbb", "Error: "+"789"+message);
            }

            @Override
            public void Surroe(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
