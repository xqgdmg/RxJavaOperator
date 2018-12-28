package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.thinkpad.rxjavaoperator.bean.Person;
import com.example.thinkpad.rxjavaoperator.bean.Plan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: concatMap() 和 flatMap() 基本上是一样的，只不过 concatMap() 转发出来的事件是有序的，而 flatMap() 是无序的。
 */
public class Activity_ConcatMap extends Activity {

    List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        // flatMap 无序
        Observable.fromIterable(personList)
                .flatMap(new Function< Person, ObservableSource< Plan >>() {
                    @Override
                    public ObservableSource < Plan > apply(Person person) {
                        if ("name1".equals(person.getName())) {// name1
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
                        }
                        return Observable.fromIterable(person.getPlanList());// name2
                    }
                })
                .subscribe(new Observer < Plan > () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Plan plan) {
                        Log.e("chris", "onNext1==" + plan.getContent());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // contactMap
        Observable.fromIterable(personList)
                .concatMap(new Function< Person, ObservableSource< Plan >>() {
                    @Override
                    public ObservableSource < Plan > apply(Person person) {
                        if ("name1".equals(person.getName())) {// name1
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
                        }
                        return Observable.fromIterable(person.getPlanList());// name2
                    }
                })
                .subscribe(new Observer < Plan > () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Plan plan) {
                        Log.e("chris", "onNext2==" + plan.getContent());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /*
     * 初始化数据
     */
    private void initData() {
        List<String> actionList1 = new ArrayList<>();
        actionList1.add("action1-1");
        actionList1.add("action1-2");
        actionList1.add("action1-3");
        List<String> actionList2 = new ArrayList<>();
        actionList2.add("action2-1");
        actionList2.add("action2-2");
        actionList2.add("action2-3");
        List<Plan> planList1 = new ArrayList<>();
        List<Plan> planList2 = new ArrayList<>();

        Plan plan1 = new Plan("time1", "name1的内容content1", actionList1);
        Plan plan2 = new Plan("time2", "name2的内容content2", actionList2);
        planList1.add(plan1);
        planList2.add(plan2);

        Person person1 = new Person("name1", planList1);
        Person person2 = new Person("name2", planList2);
        personList.add(person1);
        personList.add(person2);
    }

}
