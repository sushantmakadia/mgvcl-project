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

public class com_12 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    public static String s33,s34,s35,s36;
    RadioGroup rg1,rg2,rg3,rg4;
    RadioButton rb1,rb2,rb3,rb4;
    int temp1=-2,temp2=-2,temp3=-2,temp4=-2,x=0;
    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_12);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1=findViewById(R.id.rg33);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s33=rb1.getText().toString();
                temp1=1;
            }
        });
        rg2=findViewById(R.id.rg34);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s34=rb2.getText().toString();
                temp2=1;
            }
        });
        rg3=findViewById(R.id.rg35);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s35=rb3.getText().toString();
                temp3=1;
            }
        });
        rg4=findViewById(R.id.rg36);
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb4=(RadioButton) radioGroup.findViewById(i);
                s36=rb4.getText().toString();
                temp4=1;
            }
        });
        b1=(Button)findViewById(R.id.b1);
        //b1.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View view) {                 pre();             }         });
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
                    Toast.makeText(com_12.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_13.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_11.class);
        startActivities(new Intent[]{intent});
    }
}