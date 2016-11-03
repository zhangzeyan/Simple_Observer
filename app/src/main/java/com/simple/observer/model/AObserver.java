package com.simple.observer.model;

/**
 * 观察者A
 * Created by zhangzeyan on 16/10/28.
 */

public class AObserver implements Observer {

    public AObserver() {
        Subject.getInstance().attach(this);
    }

    @Override
    public void observer() {

    }
}
