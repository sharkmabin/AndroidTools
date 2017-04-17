package com.ma.androidtools;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.ma.androidtools.utils.ActivityUtils;
import com.ma.androidtools.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this) ;
        Utils.init(this);
    }

    @OnClick(R.id.btnPull)
    public void gotoPull(){
        ActivityUtils.launchActivity("com.ma.androidtools","com.ma.androidtools.sample.PullActivity");
    }
}
