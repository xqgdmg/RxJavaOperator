package com.example.thinkpad.rxjavaoperator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.thinkpad.rxjavaoperator.operator.Activity_Create;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromArray;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromCallable;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Just;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCreate;
    private TextView tvJust;
    private TextView tvFromArray;
    private TextView tvFromCallable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        tvCreate.setOnClickListener(this);
        tvJust.setOnClickListener(this);
        tvFromArray.setOnClickListener(this);
        tvFromCallable.setOnClickListener(this);

    }

    private void initView() {
        tvCreate = (TextView) findViewById(R.id.tvCreate);
        tvJust = (TextView) findViewById(R.id.tvJust);
        tvFromArray = (TextView) findViewById(R.id.tvFromArray);
        tvFromCallable = (TextView) findViewById(R.id.tvFromCallable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCreate:
                startActivity(new Intent(MainActivity.this, Activity_Create.class));
                break;
            case R.id.tvJust:
                startActivity(new Intent(MainActivity.this, Activity_Just.class));
                break;
            case R.id.tvFromArray:
                startActivity(new Intent(MainActivity.this, Activity_FromArray.class));
                break;
            case R.id.tvFromCallable:
                startActivity(new Intent(MainActivity.this, Activity_FromCallable.class));
                break;
        }
    }
}
