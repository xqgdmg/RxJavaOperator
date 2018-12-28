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
 * @description: combineLatest() 的作用与 zip() 类似，但是 combineLatest() 发送事件的序列是与发送的时间线有关的，
 * 当 combineLatest() 中所有的 Observable 都发送了事件，只要其中有一个 Observable 发送事件，
 * 这个事件就会和其他 Observable 最近发送的事件结合起来发送
 */
public class Activity_CombineLatest_CombineLatestDelayError extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .combineLatest(
                        Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS)// Observable1
                                .map(new Function<Long, String>() {
                                    @Override
                                    public String apply(Long aLong) throws Exception {
                                        String s1 = "A" + aLong;
                                        Log.e("chris", "A发送的事件==" + s1);
                                        return s1;
                                    }
                                }),
                        Observable.intervalRange(1, 5, 2, 2, TimeUnit.SECONDS)// Observable2，这个两秒才发一次
                                .map(new Function<Long, String>() {
                                    @Override
                                    public String apply(Long aLong) throws Exception {
                                        String s2 = "B" + aLong;
                                        Log.e("chris", "B发送的事件==" + s2);
                                        return s2;
                                    }
                                }),
                        new BiFunction<String, String, String>() {// BiFunction
                            @Override
                            public String apply(String s, String s2) throws Exception {
                                String res = s + s2;
                                return res;
                            }
                        }
                )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe");
                    }

                    // 分析上述结果可以知道，当发送 A1 事件之后，因为 B 并没有发送任何事件，所以根本不会发生结合。
                    // 当 B 发送了 B1 事件之后，就会与 A 最近发送的事件 A2 结合成 A2B1，这样只有后面一有被观察者发送事件，这个事件就会与其他被观察者最近发送的事件结合起来了。
                    // 因为 combineLatestDelayError() 就是多了延迟发送 onError() 功能，这里就不再赘述了。
                    @Override
                    public void onNext(String s) {
                        Log.e("chris", "最终接收到的事件==" + s);
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
