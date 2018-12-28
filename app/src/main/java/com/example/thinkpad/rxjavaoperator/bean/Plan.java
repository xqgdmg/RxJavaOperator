package com.example.thinkpad.rxjavaoperator.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chris on 2018/12/28 11:17
 * @description:
 */
public class Plan {
    private String time;// 时间
    private String content;// 内容
    private List<String> actionList = new ArrayList<>();// 活动清单

    public Plan(String time, String content,List<String> actionList ) {
        this.time = time;
        this.content = content;
        this.actionList = actionList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getActionList() {
        return actionList;
    }

    public void setActionList(List<String> actionList) {
        this.actionList = actionList;
    }
}
