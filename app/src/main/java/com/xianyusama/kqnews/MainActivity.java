package com.xianyusama.kqnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.socks.library.KLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils
                .post()
                .url("http://v.juhe.cn/toutiao/index")
                .addParams("type", "top")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        String s = response.toString();
                        KLog.d(s);
                    }
                });
    }
}
