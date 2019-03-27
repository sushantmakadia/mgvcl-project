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
import android.widget.Toast;

public class com_16 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    public static String s44,s45_1,s45_2;
    RadioGroup rg1;
    RadioButton rb1;
    int temp1=-2,x=0;
    EditText e1,e2;
    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_16);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1=findViewById(R.id.rg44);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s44=rb1.getText().toString();
                temp1=1;
            }
        });
        e1=findViewById(R.id.edt45_1);
        e2=findViewById(R.id.edt45_2);

        b1=(Button)findViewById(R.id.b1);
        //b1.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View view) {                 pre();             }         });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s45_2=e1.getText().toString();
                s45_1=e2.getText().toString();
                if(s45_1.isEmpty()){
                    e1.setError("field cannot be empty");
                    x=1;
                }
                else if(s45_2.isEmpty()){
                    e2.setError("field cannot be empty");
                    x=1;
                }
                else if(temp1==-2)
                {
                    x=1;
                }
                else{x=0;}
                if(x==0)
                {
                    next();
                }
                else{
                    Toast.makeText(com_16.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_17.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_15.class);
        startActivities(new Intent[]{intent});
    }
}