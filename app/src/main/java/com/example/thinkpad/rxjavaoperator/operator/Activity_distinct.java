package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 过滤事件序列中的重复事件。
 */
public class Activity_distinct extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just(1, 2, 3, 3, 2, 1)
                .distinct()// 去除重复的值
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "==================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "==================onComplete ");
                    }
                });


    }

}
