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

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组。
 */
public class Activity_Window extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1, 2, 3, 4, 5)
                .window(2)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        Log.e("chris","onNext");
                        // 再次订阅
                        integerObservable.subscribe(new Observer < Integer > () {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e("chris", "integerObservable onSubscribe ");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e("chris", "integerObservable onNext " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("chris", "integerObservable onError ");
                            }

                            @Override
                            public void onComplete() {
                                Log.e("chris", "integerObservable onComplete ");
                            }
                        });
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
