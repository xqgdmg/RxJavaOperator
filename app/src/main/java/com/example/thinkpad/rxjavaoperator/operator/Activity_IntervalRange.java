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

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 可以指定发送事件的开始值和数量，其他与 interval() 的功能一样。到达数量之后会自动onComplete。
 */
public class Activity_IntervalRange extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .intervalRange(1,5,4,1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris","onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("chris","onNext==" + aLong);
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
