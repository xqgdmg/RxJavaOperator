package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 直接发送一个 List 集合数据给观察者
 */
public class Activity_FromIterable extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建集合
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Observable
                .fromIterable(list)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("chris", "onNext==" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete");
                    }
                });

    }

}
