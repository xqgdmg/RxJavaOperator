package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: Observable 每发送一件事件之前都会先回调这个方法。onSubscribe例外
 */
public class Activity_DoOnEach extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe < Integer > () {
            @Override
            public void subscribe(ObservableEmitter < Integer > e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        })
                .doOnEach(new Consumer<Notification< Integer >>() {
                    @Override
                    public void accept(Notification < Integer > integerNotification) throws Exception {
                        Log.e("chris", "==================doOnEach " + integerNotification.getValue());
                    }
                })
                .subscribe(new Observer < Integer > () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "==================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("chris", "==================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "==================onComplete ");
                    }
                });



    }

}
