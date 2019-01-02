package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 如果观察者只发送一个 onComplete() 事件，则可以利用这个方法发送一个值。
 */
public class Activity_defaultIfEmpty extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();// 只发送一个 onComplete() 事件
            }
        })
                .defaultIfEmpty(666)// 利用这个方法发送一个值
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "========================onNext " + integer);
                    }
                });


    }

}
