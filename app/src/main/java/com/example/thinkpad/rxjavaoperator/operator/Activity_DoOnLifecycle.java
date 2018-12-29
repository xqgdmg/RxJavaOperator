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
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 可以看到当在 onNext() 方法进行取消订阅操作后，doOnDispose() 和 doOnLifecycle() 都会被回调。
 *                  如果使用 doOnLifecycle 进行取消订阅，可以发现 doOnDispose Action 和 doOnLifecycle Action 都没有被回调。
 */
public class Activity_DoOnLifecycle extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        })
                .doOnLifecycle(
                        new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                Log.d(TAG, "==================doOnLifecycle accept");
//                                disposable.dispose();// 使用 doOnLifecycle 进行取消订阅
                            }
                        }, new Action() {// doOnLifecycle() 第二个参数的回调方法的作用与 doOnDispose() 是一样的
                            @Override
                            public void run() throws Exception {
                                Log.d(TAG, "==================doOnLifecycle Action");
                            }
                        }
                )
                .doOnDispose(
                        new Action() {
                            @Override
                            public void run() throws Exception {
                                Log.d(TAG, "==================doOnDispose Action");// doOnDispose() 的回调方法
                            }
                        }
                )
                .subscribe(new Observer<Integer>() {
                    private Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==================onSubscribe ");
                        this.disposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "==================onNext " + integer);
                        disposable.dispose();// 发一个就取消了
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "==================onComplete ");
                    }

                });


    }

}
