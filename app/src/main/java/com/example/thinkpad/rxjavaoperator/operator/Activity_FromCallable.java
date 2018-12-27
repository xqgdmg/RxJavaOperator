package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 这里的 Callable 是 java.util.concurrent 中的 Callable，Callable 和 Runnable 的用法基本一致，只是它会返回一个结果值，这个结果值就是发给观察者的。
 */
public class Activity_FromCallable extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .fromCallable(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return 1;
                    }
                })
                .subscribe(new Consumer<Integer>() {// 不能重复 .subscribe?
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("chris","accept==" + integer);
                    }
                });

    }

}
