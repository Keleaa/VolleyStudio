package com.bwie.zhang.volleystudio.MVP;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class AsyncHttpClient {
    public static final AsyncHttpClient ourInstance = new AsyncHttpClient();

    public static final AsyncHttpClient getInstance() {
        return ourInstance;
    }

    public void GetAsync(final String url, final AsyncCallBack callBack) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                return GetDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    callBack.Surroe(s);
                } else {
                    callBack.Error(503, "未找到数据");
                }
            }
        }.execute(url);
    }

    private String GetDataHttp(String server_url) {
        try {
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == connection.HTTP_OK) {
                InputStream stream = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(stream));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface AsyncCallBack {
        void Error(int errorcode, String message);

        void Surroe(String result);
    }
}
