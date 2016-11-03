package com.simple.observer.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;

import com.simple.observer.R;

/**
 * 自定RadioButton,实现观察者接口
 * Created by zhangzeyan on 16/11/3.
 */

public class DefineRadioButton extends RadioButton implements ViewObserver {

    private Context context;

    public DefineRadioButton(Context context) {
        this(context,null);
    }

    public DefineRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        ViewSubject.getInstance().attach(this);//注册成为观察者对象
    }


    @Override
    public void changeTextColor(int color) {
        setTextColor(context.getResources().getColor(color));
    }

    @Override
    public void changeBackground(int color) {
        setBackgroundColor(context.getResources().getColor(color));
    }

    @Override
    public void changeTextSize(int size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    }

    @Override
    public void changeNightModel(int model) {
        if (model == 0){
            setTextColor(context.getResources().getColor(R.color.black));
        }else{
            setTextColor(context.getResources().getColor(R.color.white));
        }
    }
}
