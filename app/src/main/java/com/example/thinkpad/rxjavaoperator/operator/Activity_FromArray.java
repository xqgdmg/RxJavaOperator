package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组。
 */
public class Activity_FromArray extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Integer array[] = {1, 2, 3, 4};

        Observable.fromArray(array)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("chris","onNext==" + integer);
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
