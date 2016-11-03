package com.simple.observer.sample;

/**
 * 控件观察者接口
 * Created by zhangzeyan on 16/11/3.
 */

public interface ViewObserver {

    void changeTextColor(int color);
    void changeBackground(int color);
    void changeTextSize(int size);
    void changeNightModel(int model);

}
