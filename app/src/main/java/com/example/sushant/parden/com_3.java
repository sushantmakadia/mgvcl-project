package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class com_3 extends AppCompatActivity {

    private Button b1;
    private Button b2;
    RadioGroup rg1,rg2,rg3,rg4;

    RadioButton rb1,rb2,rb3,rb4;
    RelativeLayout l1;
    int temp1=-2,temp2=-2,temp3=-2,x=0,temp4=-2;
    //TextView tv1;
    public static String s8,s9,s9_1,s10;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_3);
        l1= findViewById(R.id.l1);
//        tv1.findViewById(R.id.c9);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1=findViewById(R.id.rg8);
        rg2=findViewById(R.id.rg91);
        rg3=findViewById(R.id.rg10);
        rg4=findViewById(R.id.rg9);
        rg4.setAlpha((float) 0.2);

        rg4.setEnabled(false);
        for(int y=0;y<rg4.getChildCount();y++){
            rg4.getChildAt(y).setEnabled(false);
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                temp1=1;
                s8=rb1.getText().toString();
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                temp2=1;
                s9=rb2.getText().toString();
                if(i==R.id.rb91_1)
                {
                    rg4.setAlpha((float) 1);
                    rg4.setEnabled(true);
                    temp4 = -2;
                    for(int y=0;y<rg4.getChildCount();y++){
                        rg4.getChildAt(y).setEnabled(true);
                    }
                }
                else{
                    temp4=1;
                    rg4.setAlpha((float) 0.2);
                    rg4.setEnabled(false);
                    for(int y=0;y<rg4.getChildCount();y++){
                        rg4.getChildAt(y).setEnabled(false);
                        rb4=(RadioButton) rg4.getChildAt(y);
                        rb4.setChecked(false);
                    }
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s10=rb3.getText().toString();
                temp3=1;
            }
        });
        rg4=findViewById(R.id.rg9);
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb4=group.findViewById(checkedId);
                s9_1=rb4.getText().toString();
                temp4=1;
            }
        });
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre();
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(temp1==-2)
                {
                    x=1;
                }
                else if(temp2==-2)
                {
                    x=1;
                }
                else if(temp3==-2)
                {
                    x=1;
                }
                else if(temp4==-2){
                    x=1;
                }
                else{x=0;}
                if(x==0){
                    next();
                }
                else{
                    Toast.makeText(com_3.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_4.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_2.class);
        startActivities(new Intent[]{intent});
    }
}