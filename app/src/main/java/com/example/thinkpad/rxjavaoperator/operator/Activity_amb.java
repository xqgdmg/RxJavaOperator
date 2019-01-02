package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: amb() 要传入一个 Observable 集合，但是只会发送最先发送事件的 Observable 中的事件，其余 Observable 将会被丢弃。
 */
public class Activity_amb extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList< Observable < Long >> list = new ArrayList < > ();

        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));

        Observable.amb(list)
                .subscribe(new Consumer < Long > () {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "========================aLong " + aLong);
                    }
                });



    }

}
