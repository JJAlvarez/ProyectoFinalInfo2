package com.unis.javieralvarez.connectfour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unis.javieralvarez.connectfour.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
        finish();
    }
}
