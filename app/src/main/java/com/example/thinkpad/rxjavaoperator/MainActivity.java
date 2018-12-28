package com.example.thinkpad.rxjavaoperator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.thinkpad.rxjavaoperator.operator.Activity_Create;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Defer;
import com.example.thinkpad.rxjavaoperator.operator.Activity_EmptyNeverError;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FlatMap;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromArray;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromCallable;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromFuture;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromIterable;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Interval;
import com.example.thinkpad.rxjavaoperator.operator.Activity_IntervalRange;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Just;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Map;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Range;
import com.example.thinkpad.rxjavaoperator.operator.Activity_RangeLong;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCreate;
    private TextView tvJust;
    private TextView tvFromArray;
    private TextView tvFromCallable;
    private TextView tvFromFuture;
    private TextView tvFromIterable;
    private TextView tvDefer;
    private TextView tvTimer;
    private TextView tvInterval;
    private TextView tvIntervalRange;
    private TextView tvRange;
    private TextView tvRangeLong;
    private TextView tvEmptyNeverError;
    private TextView tvMap;
    private TextView tvFlatMap;

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
        tvFromFuture.setOnClickListener(this);
        tvFromIterable.setOnClickListener(this);
        tvDefer.setOnClickListener(this);
        tvTimer.setOnClickListener(this);
        tvInterval.setOnClickListener(this);
        tvIntervalRange.setOnClickListener(this);
        tvRange.setOnClickListener(this);
        tvRangeLong.setOnClickListener(this);
        tvEmptyNeverError.setOnClickListener(this);
        tvMap.setOnClickListener(this);
        tvFlatMap.setOnClickListener(this);
    }

    private void initView() {
        tvCreate = (TextView) findViewById(R.id.tvCreate);
        tvJust = (TextView) findViewById(R.id.tvJust);
        tvFromArray = (TextView) findViewById(R.id.tvFromArray);
        tvFromCallable = (TextView) findViewById(R.id.tvFromCallable);
        tvFromFuture = (TextView) findViewById(R.id.tvFromFuture);
        tvFromIterable = (TextView) findViewById(R.id.tvFromIterable);
        tvDefer = (TextView) findViewById(R.id.tvDefer);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        tvInterval = (TextView) findViewById(R.id.tvInterval);
        tvIntervalRange = (TextView) findViewById(R.id.tvIntervalRange);
        tvRange = (TextView) findViewById(R.id.tvRange);
        tvRangeLong = (TextView) findViewById(R.id.tvRangeLong);
        tvEmptyNeverError = (TextView) findViewById(R.id.tvEmptyNeverError);
        tvMap = (TextView) findViewById(R.id.tvMap);
        tvFlatMap = (TextView) findViewById(R.id.tvFlatMap);
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
            case R.id.tvFromFuture:
                startActivity(new Intent(MainActivity.this, Activity_FromFuture.class));
                break;
            case R.id.tvFromIterable:
                startActivity(new Intent(MainActivity.this, Activity_FromIterable.class));
                break;
            case R.id.tvDefer:
                startActivity(new Intent(MainActivity.this, Activity_Defer.class));
                break;
            case R.id.tvTimer:
                startActivity(new Intent(MainActivity.this, Activity_Timer.class));
                break;
            case R.id.tvInterval:
                startActivity(new Intent(MainActivity.this, Activity_Interval.class));
                break;
            case R.id.tvIntervalRange:
                startActivity(new Intent(MainActivity.this, Activity_IntervalRange.class));
                break;
            case R.id.tvRange:
                startActivity(new Intent(MainActivity.this, Activity_Range.class));
                break;
            case R.id.tvRangeLong:
                startActivity(new Intent(MainActivity.this, Activity_RangeLong.class));
                break;
            case R.id.tvEmptyNeverError:
                startActivity(new Intent(MainActivity.this, Activity_EmptyNeverError.class));
                break;
            case R.id.tvMap:
                startActivity(new Intent(MainActivity.this, Activity_Map.class));
                break;
            case R.id.tvFlatMap:
                startActivity(new Intent(MainActivity.this, Activity_FlatMap.class));
                break;
        }
    }
}
