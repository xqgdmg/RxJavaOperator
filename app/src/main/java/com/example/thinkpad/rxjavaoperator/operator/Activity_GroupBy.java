package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 将发送的数据进行分组，每个分组都会返回一个被观察者。
 */
public class Activity_GroupBy extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(5, 2, 3, 4, 1, 6, 8, 9, 7, 10)
                .groupBy(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer % 3;
                    }
                })
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    // 这个 onNext 的调用次数好像是不确定的，对于rxjava而言
                    // 5, 2, 3, 4, 1, 6, 8, 9, 7, 10 是顺序发送的，groupName 只是个标志，不影响顺序
                    @Override
                    public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {// 这里的参数有点意思
                        Log.e("chris","onNext");
                        integerIntegerGroupedObservable.subscribe(new Observer < Integer > () {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e("chris", "GroupedObservable onSubscribe");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e("chris", "GroupedObservable onNext，groupName: " + integerIntegerGroupedObservable.getKey() + " value: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("chris", "GroupedObservable onError");
                            }

                            @Override
                            public void onComplete() {
                                Log.e("chris", "GroupedObservable onComplete");
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
