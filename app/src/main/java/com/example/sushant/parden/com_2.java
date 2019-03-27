package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class com_2 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    int x=0,temp1=-2,temp2=-2,temp3=-2;
    public static String s5,s6,s7;
    RadioGroup rg1,rg2,rg3;
    RelativeLayout l1;
    RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_2);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        rg1=findViewById(R.id.rg1);
       rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=findViewById(i);
                temp1=1;
                s5=rb1.getText().toString();


            }
        });

        rg2=findViewById(R.id.rg6);
        rg3=findViewById(R.id.rg2);
        rg3.setAlpha((float) 0.2);
        rg3.setEnabled(false);
        for(int y=0;y<rg3.getChildCount();y++){
            rg3.getChildAt(y).setEnabled(false);
        }
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                temp2=1;
                s6=rb2.getText().toString();
                if(i==R.id.rb6){
                    rg3.setAlpha((float) 1);
                    temp3=-2;
                    rg3.setEnabled(true);
                    for(int y=0;y<rg3.getChildCount();y++){
                        rg3.getChildAt(y).setEnabled(true);
                    }
                }
                else{
                    temp3=1;
                    rg3.setAlpha((float) 0.2);
                    rg3.setEnabled(false);
                    for(int y=0;y<rg3.getChildCount();y++){
                        rg3.getChildAt(y).setEnabled(false);
                        rb3=(RadioButton) rg3.getChildAt(y);
                        rb3.setChecked(false);
                    }
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s7=rb3.getText().toString();
                temp3=1;
            }
        });
        //b1.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View view) {                 pre();             }         });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                else{x=0;}
                if(x==0){
                    Intent intent = new Intent(com_2.this, com_3.class);

                    startActivities(new Intent[]{intent});
                }
                else{
                    Toast.makeText(com_2.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void pre()
    {
        Intent intent = new Intent(this,com_1.class);
        startActivities(new Intent[]{intent});
    }
}
