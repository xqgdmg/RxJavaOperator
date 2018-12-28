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
 * @description: 在 concatArray() 和 mergeArray() 两个方法当中，如果其中有一个被观察者发送了一个 Error 事件，那么就会停止发送事件，
 * 如果你想 onError() 事件延迟到所有被观察者都发送完事件后再执行的话，就可以使用  concatArrayDelayError() 和 mergeArrayDelayError()
 */
public class Activity_ConcatArrayDelayError_MergeArrayDelayError extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 这是默认的中断写法
        Observable
                .concatArray(// 这里的参数有点奇怪
                        Observable.create(new ObservableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                                e.onNext(1);
                                e.onError(new NumberFormatException());// 自己抛异常
                            }
                        }), Observable.just(2, 3, 4))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("chris", "onNext==" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError ");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // 这个是不中断的写法
        Observable
                .concatArrayDelayError(// 不用concatArray
                        Observable.create(new ObservableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                                e.onNext(1);
                                e.onError(new NumberFormatException());// 所有消息都发射出去之后，onError才会收到消息
                            }
                        }), Observable.just(2, 3, 4))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("chris", "onNext2 " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError2");
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
