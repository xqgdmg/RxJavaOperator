package com.example.thinkpad.rxjavaoperator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.thinkpad.rxjavaoperator.operator.Activity_Buffer;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Collect;
import com.example.thinkpad.rxjavaoperator.operator.Activity_CombineLatest_CombineLatestDelayError;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Concat;
import com.example.thinkpad.rxjavaoperator.operator.Activity_ConcatArray;
import com.example.thinkpad.rxjavaoperator.operator.Activity_ConcatArrayDelayError_MergeArrayDelayError;
import com.example.thinkpad.rxjavaoperator.operator.Activity_ConcatMap;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Count;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Create;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Defer;
import com.example.thinkpad.rxjavaoperator.operator.Activity_EmptyNeverError;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FlatMap;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromArray;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromCallable;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromFuture;
import com.example.thinkpad.rxjavaoperator.operator.Activity_FromIterable;
import com.example.thinkpad.rxjavaoperator.operator.Activity_GroupBy;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Interval;
import com.example.thinkpad.rxjavaoperator.operator.Activity_IntervalRange;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Just;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Map;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Merge;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Range;
import com.example.thinkpad.rxjavaoperator.operator.Activity_RangeLong;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Reduce;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Scan;
import com.example.thinkpad.rxjavaoperator.operator.Activity_StartWith_StartWithArray;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Timer;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Window;
import com.example.thinkpad.rxjavaoperator.operator.Activity_Zip;

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
    private TextView tvConcatMap;
    private TextView tvBuffer;
    private TextView tvGroupBy;
    private TextView tvScan;
    private TextView tvWindow;
    private TextView tvConcat;
    private TextView tvConcatArray;
    private TextView tvConcatMerge;
    private TextView tvConcatArrayDelayError_MergeArrayDelayError;
    private TextView tvZip;
    private TextView tvCombineLatest_CombineLatestDelayError;
    private TextView tvReduce;
    private TextView tvCollect;
    private TextView tvStartWith_StartWithArray;
    private TextView tvCount;

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
        tvConcatMap.setOnClickListener(this);
        tvBuffer.setOnClickListener(this);
        tvGroupBy.setOnClickListener(this);
        tvScan.setOnClickListener(this);
        tvWindow.setOnClickListener(this);
        tvConcat.setOnClickListener(this);
        tvConcatArray.setOnClickListener(this);
        tvConcatMerge.setOnClickListener(this);
        tvConcatArrayDelayError_MergeArrayDelayError.setOnClickListener(this);
        tvZip.setOnClickListener(this);
        tvCombineLatest_CombineLatestDelayError.setOnClickListener(this);
        tvReduce.setOnClickListener(this);
        tvCollect.setOnClickListener(this);
        tvStartWith_StartWithArray.setOnClickListener(this);
        tvCount.setOnClickListener(this);
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
        tvConcatMap = (TextView) findViewById(R.id.tvConcatMap);
        tvBuffer = (TextView) findViewById(R.id.tvBuffer);
        tvGroupBy = (TextView) findViewById(R.id.tvGroupBy);
        tvScan = (TextView) findViewById(R.id.tvScan);
        tvWindow = (TextView) findViewById(R.id.tvWindow);
        tvConcat = (TextView) findViewById(R.id.tvConcat);
        tvConcatArray = (TextView) findViewById(R.id.tvConcatArray);
        tvConcatMerge = (TextView) findViewById(R.id.tvConcatMerge);
        tvConcatArrayDelayError_MergeArrayDelayError = (TextView) findViewById(R.id.tvConcatArrayDelayError_MergeArrayDelayError);
        tvZip = (TextView) findViewById(R.id.tvZip);
        tvCombineLatest_CombineLatestDelayError = (TextView) findViewById(R.id.tvCombineLatest_CombineLatestDelayError);
        tvReduce = (TextView) findViewById(R.id.tvReduce);
        tvCollect = (TextView) findViewById(R.id.tvCollect);
        tvStartWith_StartWithArray = (TextView) findViewById(R.id.tvStartWith_StartWithArray);
        tvCount = (TextView) findViewById(R.id.tvCount);
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
            case R.id.tvConcatMap:
                startActivity(new Intent(MainActivity.this, Activity_ConcatMap.class));
                break;
            case R.id.tvBuffer:
                startActivity(new Intent(MainActivity.this, Activity_Buffer.class));
                break;
            case R.id.tvGroupBy:
                startActivity(new Intent(MainActivity.this, Activity_GroupBy.class));
                break;
            case R.id.tvScan:
                startActivity(new Intent(MainActivity.this, Activity_Scan.class));
                break;
            case R.id.tvWindow:
                startActivity(new Intent(MainActivity.this, Activity_Window.class));
                break;
            case R.id.tvConcat:
                startActivity(new Intent(MainActivity.this, Activity_Concat.class));
                break;
            case R.id.tvConcatArray:
                startActivity(new Intent(MainActivity.this, Activity_ConcatArray.class));
                break;
            case R.id.tvConcatMerge:
                startActivity(new Intent(MainActivity.this, Activity_Merge.class));
                break;
            case R.id.tvConcatArrayDelayError_MergeArrayDelayError:
                startActivity(new Intent(MainActivity.this, Activity_ConcatArrayDelayError_MergeArrayDelayError.class));
                break;
            case R.id.tvZip:
                startActivity(new Intent(MainActivity.this, Activity_Zip.class));
                break;
            case R.id.tvCombineLatest_CombineLatestDelayError:
                startActivity(new Intent(MainActivity.this, Activity_CombineLatest_CombineLatestDelayError.class));
            case R.id.tvReduce:
                startActivity(new Intent(MainActivity.this, Activity_Reduce.class));
                break;
            case R.id.tvCollect:
                startActivity(new Intent(MainActivity.this, Activity_Collect.class));
                break;
            case R.id.tvStartWith_StartWithArray:
                startActivity(new Intent(MainActivity.this, Activity_StartWith_StartWithArray.class));
                break;
            case R.id.tvCount:
                startActivity(new Intent(MainActivity.this, Activity_Count.class));
                break;
        }
    }
}
