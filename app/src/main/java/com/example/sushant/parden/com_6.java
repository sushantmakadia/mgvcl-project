package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class com_6 extends AppCompatActivity {
    private Button b1;
    TextView tv1;
    private Button b2;
    public static String s16,s17,s18,s19;
    RadioGroup rg1,rg2;
    RadioButton rb1,rb2;
    EditText e1,e2;
    int temp1=-2,temp2=-2,x=0;
    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_6);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        tv1=findViewById(R.id.c19);
        e1=findViewById(R.id.et17);
        e2=findViewById(R.id.e19);
        tv1.setAlpha((float) 0.2);
        e2.setEnabled(false);
        e2.setAlpha((float) 0.2);
        rg1=findViewById(R.id.rg16);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                if(i==R.id.rb16_1)
                {
                    e1.setAlpha(1);
                    e1.setEnabled(true);
                }
                else
                {
                    s17="/";
                    e1.setAlpha((float) 0.2);
                    e1.setEnabled(false);
                }
                s16=rb1.getText().toString();
                temp1=1;
            }
        });
        rg2=findViewById(R.id.rg18);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                if(i==R.id.rb13_2)
                {
                    tv1.setAlpha(1);
                    e2.setEnabled(true);
                    e2.setAlpha(1);
                }
                else
                {
                    s19="/";
                    tv1.setAlpha((float) 0.2);
                    e2.setEnabled(false);
                    e2.setAlpha((float) 0.2);
                }
                s18=rb2.getText().toString();
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
                if(s17!="/"){
                    s17=e1.getText().toString();
                }
                if(s17!="/"){
                    s19=e2.getText().toString();
                }
                if(s17.isEmpty())
                {
                    e1.setError("field cannot be empty");
                    x=1;
                }
                else if(temp1==-2)
                {
                    x=1;
                }
                else if(temp2==-2)
                {
                    x=1;
                }
                else{
                    x=0;
                }
                if(x==0){
                    next();
                }
                else{
                    Toast.makeText(com_6.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_7.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_5.class);
        startActivities(new Intent[]{intent});
    }
}
