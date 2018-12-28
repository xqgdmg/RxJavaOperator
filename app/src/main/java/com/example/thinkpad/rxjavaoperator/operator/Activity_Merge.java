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
import io.reactivex.functions.Function;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 这个方法与 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行（无序）发送事件。
 *                 mergeArray() 与 merge() 的作用是一样的，只是它可以发送4个以上的被观察者，这里就不再赘述了。
 */
public class Activity_Merge extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .merge(
                        Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                return "A" + aLong;
                            }
                        }),
                        Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                return "B" + aLong;
                            }
                        }))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("chris", "onNext==" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
