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
 * @description: 判断事件序列是否为空。
 */
public class Activity_isEmpty extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        })
                .isEmpty()
                .subscribe(new Consumer<Boolean>() {
                        @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, "========================onNext " + aBoolean);
                    }
                });


    }

}
