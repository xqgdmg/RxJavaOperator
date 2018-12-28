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
import io.reactivex.functions.Function;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: map 可以将被观察者发送的数据类型转变成其他的类型
 */
public class Activity_Map extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1, 2, 3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I'm " + integer;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("chris","onNext==" + s);
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
