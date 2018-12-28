package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static android.support.constraint.Constraints.TAG;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 返回被观察者发送事件的数量。
 */
public class Activity_Count extends Activity {

    String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1, 2, 3)
                .count()// just之后，subscribe之前
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "=======================aLong " + aLong);
                    }
                });


    }

}
