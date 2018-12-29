package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出。（会造成事件重复发送）
 */
public class Activity_Buffer extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1, 2, 3, 4, 5)
                .buffer(3, 1)// count 缓冲区元素的数量，skip 代表下一次事件序列的时候要跳过多少元素（按第一个时间的第一个元素skip）。
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.e("chris", "缓冲区大小==" + integers.size());
                        for (Integer i : integers) {
                            Log.e("chris", "元素==" + i);
                        }
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
