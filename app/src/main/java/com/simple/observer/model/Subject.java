package com.simple.observer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * Created by zhangzeyan on 16/10/28.
 */

public class Subject {

    private static Subject subject;

    /**
     * 单例模式
     */
    private Subject(){}

    public static synchronized Subject getInstance(){
        if(subject==null){
            synchronized (Subject.class){
                if (subject == null){
                    subject=new Subject();
                }
            }
        }
        return subject;
    }

    /**
     * 观察者集合
     */
    private List<Observer> observers = new ArrayList<>();


    /**
     * 注册成为观察者
     * @param observer
     */
    public void attach(Observer observer ){
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * 移除某个观察者对象
     * @param observer
     */
    public void detach(Observer observer){
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
     * 通知所有观察者对象
     */
    public void notifyChange(){
        for (Observer observer : observers) {
            if (observer != null) {
                observer.observer();
            }
        }
    }

}
