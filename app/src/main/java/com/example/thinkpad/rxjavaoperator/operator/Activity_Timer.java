package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 当到指定时间后就会发送一个 0L 的值给观察者。
 * 发送0用什么作用的吗？
 */
public class Activity_Timer extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .timer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("chris", "onNext==" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete");
                    }
                });

    }

}
