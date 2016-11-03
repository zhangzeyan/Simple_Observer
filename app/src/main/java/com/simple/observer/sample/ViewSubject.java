package com.simple.observer.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * Created by zhangzeyan on 16/10/28.
 */

public class ViewSubject {

    private static ViewSubject subject;


    public static synchronized ViewSubject getInstance(){
        if(subject==null){
            subject=new ViewSubject();
        }
        return subject;
    }

    /**
     * 观察者集合
     */
    protected List<ViewObserver> observers = new ArrayList<>();


    /**
     * 注册成为观察者
     * @param observer
     */
    public void attach(ViewObserver observer ){
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * 移除某个观察者对象
     * @param observer
     */
    public void detach(ViewObserver observer){
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * 移除所有观察者对象
     */
    public void detachAll(){
        if (observers != null) {
            observers.clear();
        }
    }

    /**
     * 通知观察者，更改字体颜色
     * @param color
     */
    public void notifyChangeTxtColor(int color) {
        for (ViewObserver observer : observers) {
            if (observer != null) {
                observer.changeTextColor(color);
            }
        }
    }

    /**
     * 通知观察者，更改背景颜色
     * @param color
     */
    public void notifyChangeBackground(int color) {
        for (ViewObserver observer : observers) {
            if (observer != null) {
                observer.changeBackground(color);
            }
        }
    }

    /**
     * 通知观察者，更改字体大小
     * @param size
     */
    public void notifyChangeTxtSize(int size) {
        for (ViewObserver observer : observers) {
            if (observer != null) {
                observer.changeTextSize(size);
            }
        }
    }

    /**
     * 通知观察者，更改夜间模式
     * @param model
     */
    public void notifyChangeNightModel(int model) {
        for (ViewObserver observer : observers) {
            if (observer != null) {
                observer.changeNightModel(model);
            }
        }
    }

}
