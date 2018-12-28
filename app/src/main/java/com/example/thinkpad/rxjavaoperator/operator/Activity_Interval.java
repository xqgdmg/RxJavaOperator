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
 * @description: 每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字。就一直在发射。
 */
public class Activity_Interval extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .interval(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("chris","onNext==" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris","onComplete");
                    }
                });

    }

}
