package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 这个方法的作用就是直到被观察者被订阅后才会创建被观察者。
 */
public class Activity_Defer extends Activity{

    // i 要定义为成员变量
    Integer i = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建被观察者
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                Log.e("chris","call");
                return Observable.just(i);// 虽然执行了call，但是这个i没有发射出去的，也就是Observable没有创建。
            }
        });

        // 修改i的值
        i = 200;

        // 创建观察者
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("chris","onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("chris","onNext==" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("chris","onError");
            }

            @Override
            public void onComplete() {
                Log.e("chris","onComplete");
            }
        };

        // 订阅
        observable.subscribe(observer);

        // 修改i的值
        i = 300;

        // 再次订阅
        observable.subscribe(observer);

    }

}
