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
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 与 scan() 操作符的作用一样也是将发送数据以一定逻辑聚合起来，
 * 这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，
 * 而 reduce() 会将所有数据聚合在一起才会发送事件给观察者。
 */
public class Activity_Reduce extends Activity {
    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(0, 1, 2, 3)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        int res = integer + integer2;
                        Log.e(TAG, "====================integer " + integer);
                        Log.e(TAG, "====================integer2 " + integer2);
                        Log.e(TAG, "====================res " + res);
                        return res;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        // 只收到一条消息
                        Log.e(TAG, "==================accept " + integer);
                    }
                });


    }

}
