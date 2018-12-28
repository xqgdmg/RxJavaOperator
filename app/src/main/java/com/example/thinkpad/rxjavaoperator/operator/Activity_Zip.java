package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的事件数量会与源 Observable 中最少事件的数量一样。
 */
public class Activity_Zip extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .zip(
                        Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)// Observable1
                                .map(new Function<Long, String>() {
                                    @Override
                                    public String apply(Long aLong) throws Exception {
                                        String s1 = "A" + aLong;
                                        Log.e("chris", "A发送的事件== " + s1);
                                        return s1;
                                    }
                                }),
                        Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS)// Observable2
                                .map(new Function<Long, String>() {
                                    @Override
                                    public String apply(Long aLong) throws Exception {
                                        String s2 = "B" + aLong;
                                        Log.e("chris", "B发送的事件==" + s2);
                                        return s2;
                                    }
                                }),
                        new BiFunction<String, String, String>() {//  BiFunction<? super T1, ? super T2, ? extends R> zipper
                            @Override
                            public String apply(String s1, String s2) throws Exception {
                                String result = s1 + s2;
                                return result;
                            }
                        }
                )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe ");
                    }

                    // 可以发现最终接收到的事件数量是5，那么为什么第二个 Observable 没有发送第6个事件呢？
                    // 因为在这之前第一个 Observable 已经发送了 onComplete 事件，所以第二个 Observable 不会再发送事件。
                    @Override
                    public void onNext(String s) {
                        Log.e("chris", "onNext==" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete ");
                    }
                });


    }

}
