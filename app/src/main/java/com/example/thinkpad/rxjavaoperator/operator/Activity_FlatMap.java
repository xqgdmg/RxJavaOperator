package com.example.thinkpad.rxjavaoperator.operator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.thinkpad.rxjavaoperator.bean.Person;
import com.example.thinkpad.rxjavaoperator.bean.Plan;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * @author: Chris on 2018/12/27 16:00
 * @description: 可以将事件序列中的元素进行整合加工，返回一个新的被观察者。比 Map 可以多一步操作，for循环操作。
 * 假设一个有一个 Person 类
 * Person 类有一个 name 和 planList 两个变量，分别代表的是人名和 plan清单。
 * 现在有一个需求就是要将 Person 集合中的每个元素中的 Plan 的 action清单 打印出来。
 */
public class Activity_FlatMap extends Activity {

    List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        // map的方式处理
        Observable
                .fromIterable(personList)
                .map(new Function<Person, List<Plan>>() {
                    @Override
                    public List<Plan> apply(Person person) throws Exception {
                        return person.getPlanList();// 这里的返回值就很有道理，一看就看懂
                    }
                })
                .subscribe(new Observer<List<Plan>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe1");
                    }

                    @Override
                    public void onNext(List<Plan> Plans) {// onNext 会被调用两次？ 为啥？？
                        Log.e("chris", "onNext1");
                        for (Plan plan : Plans) {
                            List<String> actionList = plan.getActionList();
                            for (String actionString : actionList) {
                                Log.e("chris", "actionString1==" + actionString);
                            }
                        }
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

        // flatMap的方式处理
        Observable
                .fromIterable(personList)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {// 这里泛型直接是 Plan ？
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        return Observable.fromIterable(person.getPlanList());// 这里返回的却是 planList，关键是他是 Observable
                    }
                })
                .flatMap(new Function<Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        return Observable.fromIterable(plan.getActionList());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("chris", "onSubscribe2");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("chris", "onNext2==" + s);
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

        Plan plan1 = new Plan("time1", "content1", actionList1);
        Plan plan2 = new Plan("time2", "content2", actionList2);
        planList1.add(plan1);
        planList2.add(plan2);

        Person person1 = new Person("name1", planList1);
        Person person2 = new Person("name2", planList2);
        personList.add(person1);
        personList.add(person2);
    }

}
