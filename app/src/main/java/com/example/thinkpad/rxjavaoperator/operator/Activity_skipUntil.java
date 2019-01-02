package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 当 skipUntil() 中的 Observable 发送事件了，原来的 Observable 才会发送事件给观察者。
 * 但是 skipUntil() 里的 Observable 并不会发送事件给观察者。
 */
public class Activity_skipUntil extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)// 这个1,2,3是在前3秒发送的
                .skipUntil(Observable.intervalRange(6, 5, 3, 1, TimeUnit.SECONDS))// 这个延时了3秒
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "========================onSubscribe ");
                    }

                    @Override
                    public void onNext(Long along) {
                        Log.d(TAG, "========================onNext " + along);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "========================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "========================onComplete ");
                    }
                });


    }

}
