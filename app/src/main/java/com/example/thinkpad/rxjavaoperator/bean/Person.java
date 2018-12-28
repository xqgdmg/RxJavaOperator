package com.example.thinkpad.rxjavaoperator.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chris on 2018/12/28 11:17
 * @description:
 */
public class Person {

    private String name;// 名字
    private List<Plan> planList = new ArrayList<>();// 计划清单

    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }
}
