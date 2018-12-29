package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: elementAt() 可以指定取出事件序列中事件，但是输入的 index 超出事件序列的总数的话就不会出现任何结果。
 * 这种情况下，你想发出异常信息的话就用 elementAtOrError() 。
 */
public class Activity_elementAt_elementAtOrError extends Activity {

    private String TAG = "chris";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just(1, 2, 3, 4)
                .elementAt(0)// 将 elementAt() 的值改为5，这时是没有打印结果，也不会报错，因为没有满足条件的元素。
//                .elementAtOrError(5)// 替换 elementAt() 为 elementAtOrError(),这时候会抛出 NoSuchElementException 异常。
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "====================accept " + integer);
                    }
                });


    }

}
