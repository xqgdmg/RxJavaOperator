package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 指定观察者的线程，每指定一次就会生效一次。
 */
public class Activity_observeOn extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just(1, 2, 3)
                .observeOn(Schedulers.newThread())// 切换一次
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        Log.d(TAG, "======================flatMap Thread name " + Thread.currentThread().getName());
                        return Observable.just("chan" + integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())// 再切换一次
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "======================onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "======================onNext Thread name " + Thread.currentThread().getName());
                        Log.d(TAG, "======================onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "======================onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "======================onComplete");
                    }
                });


    }

}
