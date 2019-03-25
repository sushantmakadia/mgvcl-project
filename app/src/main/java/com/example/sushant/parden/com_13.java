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
import android.widget.Toast;

public class com_13 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    public static String s37,s38;
    RadioGroup rg1,rg2;
    int temp1=-2,temp2=-2,x=0;
    RadioButton rb1,rb2;
    RelativeLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_13);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1=findViewById(R.id.rg37);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s37=rb1.getText().toString();
                temp1=1;
            }
        });
        rg2=findViewById(R.id.rg38);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s38=rb2.getText().toString();
                temp2=1;
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
                else{x=0;}
                if(x==0){
                    next();
                }
                else{
                    Toast.makeText(com_13.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_14.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_12.class);
        startActivities(new Intent[]{intent});
    }
}