package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 将数据以一定的逻辑聚合起来。
 */
public class Activity_Scan extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1, 2, 3, 4, 5)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer1, Integer integer2) throws Exception {
                        Log.e("chris","apply integer1==" + integer1);// 这个是accept 返回的值
                        Log.e("chris","apply integer2==" + integer2);
//                        return null;
                        return integer1 + integer2;// 这个就是所谓逻辑，最终的总和是15，其实是累加
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("chris","accept==" + integer);// 这个是最先执行的
                    }
                });

    }

}
