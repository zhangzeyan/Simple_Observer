package com.simple.observer.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.simple.observer.R;

/**
 * 自定LinearLayout,实现观察者接口
 * Created by zhangzeyan on 16/11/3.
 */

public class DefineLinearLayout extends LinearLayout implements ViewObserver {

    private Context context;

    public DefineLinearLayout(Context context) {
        this(context,null);
    }

    public DefineLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        ViewSubject.getInstance().attach(this);//注册成为观察者对象
    }


    @Override
    public void changeTextColor(int color) {
    }

    @Override
    public void changeBackground(int color) {
    }

    @Override
    public void changeTextSize(int size) {
    }

    @Override
    public void changeNightModel(int model) {
        if (model == 0){
            setBackgroundColor(context.getResources().getColor(R.color.white));
        }else{
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }
    }
}
