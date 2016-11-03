package com.simple.observer.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.simple.observer.R;

/**
 * 观察者模式应用
 */
public class MainActivity extends AppCompatActivity {


    private TextView txtColorTv;
    private Button txtBgBt;
    private RadioGroup txtSizeRg;
    private CheckBox nightModelCb;
    private Button removeObServerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtColorTv = (TextView) findViewById(R.id.txtColorTv);
        txtBgBt = (Button) findViewById(R.id.txtBgBt);
        txtSizeRg = (RadioGroup) findViewById(R.id.txtSizeRg);
        nightModelCb = (CheckBox) findViewById(R.id.nightModelCb);
        removeObServerTv = (Button) findViewById(R.id.removeObServerTv);

        txtColorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSubject.getInstance().notifyChangeTxtColor(R.color.red);
            }
        });

        txtBgBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSubject.getInstance().notifyChangeBackground(R.color.green);
            }
        });


        txtSizeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.txtSizeBigRb){
                    ViewSubject.getInstance().notifyChangeTxtSize(18);
                }else{
                    ViewSubject.getInstance().notifyChangeTxtSize(14);
                }
            }
        });

        nightModelCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ViewSubject.getInstance().notifyChangeNightModel(isChecked ?1:0);
            }
        });

        removeObServerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSubject.getInstance().detach((ViewObserver) removeObServerTv);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewSubject.getInstance().detachAll();  //退出activity时，移除所有观察者对象
    }
}
