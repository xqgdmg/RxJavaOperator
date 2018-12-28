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
 * @description:  empty() ： 直接发送 onComplete() 事件
 *                 never()：不发送任何事件
 *                 error()：发送 onError() 事件
 */
public class Activity_EmptyNeverError extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // empty()
        Observable
                .empty()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe1");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e("chris", "onNext1==" + o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError1");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete1");
                    }
                });

        // never()
        Observable
                .never()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe2");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e("chris", "onNext2==" + o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("chris", "onError2");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete2");
                    }
                });

        // error()
        Observable
                .error(new Throwable("myError3"))
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe3");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e("chris", "onNext3==" + o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // java.lang.Throwable: myError3
                        Log.e("chris", "onError3==" + e);// + e.getCause().toString() 这样打印会Attempt to invoke virtual method 'java.lang.String java.lang.Throwable.toString()' on a null object reference
                    }

                    @Override
                    public void onComplete() {
                        Log.e("chris", "onComplete3");
                    }
                });


    }

}
