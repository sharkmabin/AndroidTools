package com.ma.androidtools.sample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ma.androidtools.R;
import com.ma.androidtools.ui.pull.interfaces.RefreshEventListener;
import com.ma.androidtools.ui.pull.layout.PullRecyclerLayout;
import com.ma.androidtools.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PullActivity extends AppCompatActivity{

    @BindView(R.id.layPullRcy)
    public PullRecyclerLayout layout ;

    private View header;
    private View footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);

        ButterKnife.bind(this) ;
        Utils.init(this);

        initData();
    }

    public void initData(){
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + 1 + "");
        }
        header= LayoutInflater.from(this).inflate(R.layout.layout_header,null);
        footer= LayoutInflater.from(this).inflate(R.layout.layout_footer,null);
        layout.addHeaderView(header,100);
        layout.setItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL)) ;
        layout.addFooterView(footer,100);
        PullAdapter adapter = new PullAdapter(PullActivity.this, list);
        layout.setMyRecyclerView(new LinearLayoutManager(this), adapter);
        layout.addRefreshListener(new RefreshEventListener() {
            @Override
            public void OnRefreshing() {
                Log.i("angel", "refreshing: 正在刷新");
            }

            @Override
            public void OnLoading() {
                Log.i("angel", "loading: 正在加载");
            }
        });
    }


}
