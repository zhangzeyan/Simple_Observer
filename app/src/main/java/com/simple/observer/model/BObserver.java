package com.simple.observer.model;

/**
 * 观察者B
 * Created by zhangzeyan on 16/10/28.
 */

public class BObserver implements Observer {

    public BObserver() {
        Subject.getInstance().attach(this);
    }

    @Override
    public void observer() {

    }
}
