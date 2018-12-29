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
import com.example.thinkpad.rxjavaoperator.operator.Activity_Delay;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoAfterNext;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnComplete;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnDispose;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnEach;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnError;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnLifecycle;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnNext;
import com.example.thinkpad.rxjavaoperator.operator.Activity_DoOnSubscribe;
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
import com.example.thinkpad.rxjavaoperator.operator.Activity_doFinally;
import com.example.thinkpad.rxjavaoperator.operator.Activity_doOnTerminate_doAfterTerminate;
import com.example.thinkpad.rxjavaoperator.operator.Activity_observeOn;
import com.example.thinkpad.rxjavaoperator.operator.Activity_onErrorResumeNext;
import com.example.thinkpad.rxjavaoperator.operator.Activity_onErrorReturn;
import com.example.thinkpad.rxjavaoperator.operator.Activity_onExceptionResumeNext;
import com.example.thinkpad.rxjavaoperator.operator.Activity_repeat;
import com.example.thinkpad.rxjavaoperator.operator.Activity_repeatWhen;
import com.example.thinkpad.rxjavaoperator.operator.Activity_retry;
import com.example.thinkpad.rxjavaoperator.operator.Activity_retryUntil;
import com.example.thinkpad.rxjavaoperator.operator.Activity_retryWhen;
import com.example.thinkpad.rxjavaoperator.operator.Activity_subscribeOn;

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
    private TextView tvDelay;
    private TextView tvDoOnEach;
    private TextView tvDoOnNext;
    private TextView tvDoAfterNext;
    private TextView tvDoOnComplete;
    private TextView tvDoOnError;
    private TextView tvDoOnSubscribe;
    private TextView tvDoOnDispose;
    private TextView tvDoOnLifecycle;
    private TextView tv_doOnTerminate_doAfterTerminate;
    private TextView tv_doFinally;
    private TextView tv_onErrorReturn;
    private TextView tv_onErrorResumeNext;
    private TextView tv_onExceptionResumeNext;
    private TextView tv_retry;
    private TextView tv_retryUntil;
    private TextView tv_retryWhen;
    private TextView tv_repeat;
    private TextView tv_repeatWhen;
    private TextView tv_subscribeOn;
    private TextView tv_observeOn;

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
        tvDelay.setOnClickListener(this);
        tvDoOnEach.setOnClickListener(this);
        tvDoOnNext.setOnClickListener(this);
        tvDoAfterNext.setOnClickListener(this);
        tvDoOnComplete.setOnClickListener(this);
        tvDoOnError.setOnClickListener(this);
        tvDoOnSubscribe.setOnClickListener(this);
        tvDoOnDispose.setOnClickListener(this);
        tvDoOnLifecycle.setOnClickListener(this);
        tv_doOnTerminate_doAfterTerminate.setOnClickListener(this);
        tv_doFinally.setOnClickListener(this);
        tv_onErrorReturn.setOnClickListener(this);
        tv_onErrorResumeNext.setOnClickListener(this);
        tv_onExceptionResumeNext.setOnClickListener(this);
        tv_retry.setOnClickListener(this);
        tv_retryUntil.setOnClickListener(this);
        tv_retryWhen.setOnClickListener(this);
        tv_repeat.setOnClickListener(this);
        tv_repeatWhen.setOnClickListener(this);
        tv_subscribeOn.setOnClickListener(this);
        tv_observeOn.setOnClickListener(this);
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
        tvDelay = (TextView) findViewById(R.id.tvDelay);
        tvDoOnEach = (TextView) findViewById(R.id.tvDoOnEach);
        tvDoOnNext = (TextView) findViewById(R.id.tvDoOnNext);
        tvDoAfterNext = (TextView) findViewById(R.id.tvDoAfterNext);
        tvDoOnComplete = (TextView) findViewById(R.id.tvDoOnComplete);
        tvDoOnError = (TextView) findViewById(R.id.tvDoOnError);
        tvDoOnSubscribe = (TextView) findViewById(R.id.tvDoOnSubscribe);
        tvDoOnDispose = (TextView) findViewById(R.id.tvDoOnDispose);
        tvDoOnLifecycle = (TextView) findViewById(R.id.tvDoOnLifecycle);
        tv_doOnTerminate_doAfterTerminate = (TextView) findViewById(R.id.tv_doOnTerminate_doAfterTerminate);
        tv_doFinally = (TextView) findViewById(R.id.tv_doFinally);
        tv_onErrorReturn = (TextView) findViewById(R.id.tv_onErrorReturn);
        tv_onErrorResumeNext = (TextView) findViewById(R.id.tv_onErrorResumeNext);
        tv_onExceptionResumeNext = (TextView) findViewById(R.id.tv_onExceptionResumeNext);
        tv_retry = (TextView) findViewById(R.id.tv_retry);
        tv_retryUntil = (TextView) findViewById(R.id.tv_retryUntil);
        tv_retryWhen = (TextView) findViewById(R.id.tv_retryWhen);
        tv_repeat = (TextView) findViewById(R.id.tv_repeat);
        tv_repeatWhen = (TextView) findViewById(R.id.tv_repeatWhen);
        tv_subscribeOn = (TextView) findViewById(R.id.tv_subscribeOn);
        tv_observeOn = (TextView) findViewById(R.id.tv_observeOn);
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
            case R.id.tvDelay:
                startActivity(new Intent(MainActivity.this, Activity_Delay.class));
                break;
            case R.id.tvDoOnEach:
                startActivity(new Intent(MainActivity.this, Activity_DoOnEach.class));
                break;
            case R.id.tvDoOnNext:
                startActivity(new Intent(MainActivity.this, Activity_DoOnNext.class));
                break;
            case R.id.tvDoAfterNext:
                startActivity(new Intent(MainActivity.this, Activity_DoAfterNext.class));
                break;
            case R.id.tvDoOnComplete:
                startActivity(new Intent(MainActivity.this, Activity_DoOnComplete.class));
                break;
            case R.id.tvDoOnError:
                startActivity(new Intent(MainActivity.this, Activity_DoOnError.class));
                break;
            case R.id.tvDoOnSubscribe:
                startActivity(new Intent(MainActivity.this, Activity_DoOnSubscribe.class));
                break;
            case R.id.tvDoOnDispose:
                startActivity(new Intent(MainActivity.this, Activity_DoOnDispose.class));
                break;
            case R.id.tvDoOnLifecycle:
                startActivity(new Intent(MainActivity.this, Activity_DoOnLifecycle.class));
                break;
            case R.id.tv_doOnTerminate_doAfterTerminate:
                startActivity(new Intent(MainActivity.this, Activity_doOnTerminate_doAfterTerminate.class));
                break;
            case R.id.tv_doFinally:
                startActivity(new Intent(MainActivity.this, Activity_doFinally.class));
                break;
            case R.id.tv_onErrorReturn:
                startActivity(new Intent(MainActivity.this, Activity_onErrorReturn.class));
                break;
            case R.id.tv_onErrorResumeNext:
                startActivity(new Intent(MainActivity.this, Activity_onErrorResumeNext.class));
                break;
            case R.id.tv_onExceptionResumeNext:
                startActivity(new Intent(MainActivity.this, Activity_onExceptionResumeNext.class));
                break;
            case R.id.tv_retry:
                startActivity(new Intent(MainActivity.this, Activity_retry.class));
                break;
            case R.id.tv_retryUntil:
                startActivity(new Intent(MainActivity.this, Activity_retryUntil.class));
                break;
            case R.id.tv_retryWhen:
                startActivity(new Intent(MainActivity.this, Activity_retryWhen.class));
                break;
            case R.id.tv_repeat:
                startActivity(new Intent(MainActivity.this, Activity_repeat.class));
                break;
            case R.id.tv_repeatWhen:
                startActivity(new Intent(MainActivity.this, Activity_repeatWhen.class));
                break;
            case R.id.tv_subscribeOn:
                startActivity(new Intent(MainActivity.this, Activity_subscribeOn.class));
                break;
            case R.id.tv_observeOn:
                startActivity(new Intent(MainActivity.this, Activity_observeOn.class));
                break;
        }
    }
}
