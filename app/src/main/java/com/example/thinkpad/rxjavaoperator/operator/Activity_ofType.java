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
 * @description: 可以过滤不符合该类型事件
 */
public class Activity_ofType extends Activity {

    private String TAG = "chris";
    public Integer i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just(1, 2, 3, "a", "b")
                .ofType(Integer.class)// 指定类型
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        i += integer;
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
