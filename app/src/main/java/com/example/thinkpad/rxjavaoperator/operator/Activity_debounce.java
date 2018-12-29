package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者。
 * throttleWithTimeout() 与此方法的作用一样，这里就不再赘述了。
 */
public class Activity_debounce extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                Thread.sleep(900);
                e.onNext(2);
            }
        })
                .debounce(1, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "===================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {// 可以看到事件1并没有发送出去，现在将间隔时间改为1000，1和2都打印了
                        Log.d(TAG, "===================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "===================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "===================onComplete ");
                    }
                });


    }

}
