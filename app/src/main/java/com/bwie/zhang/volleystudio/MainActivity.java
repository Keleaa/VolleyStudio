package com.bwie.zhang.volleystudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bwie.zhang.volleystudio.Adapter.UrlAdapter;
import com.bwie.zhang.volleystudio.Bean.UrlBean;
import com.bwie.zhang.volleystudio.MVP.Contract;
import com.bwie.zhang.volleystudio.MVP.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private Presenter presenter;
    String Url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    private RecyclerView recy;
    private Gson gson;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        presenter.attch(this);
        presenter.login(Url);
        recy = findViewById(R.id.recy);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recy.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void getLogin(String data) {
        Log.i("a", "getLogin: "+data);
        gson = new Gson();
        UrlBean urlBean = gson.fromJson(data, UrlBean.class);
        List<UrlBean.ResultsBean> results = urlBean.getResults();
        Toast.makeText(MainActivity.this,"123"+results.get(0).getType(),Toast.LENGTH_SHORT).show();
        UrlAdapter adapter = new UrlAdapter(MainActivity.this,results);
        recy.setAdapter(adapter);
    }
}
