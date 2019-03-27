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

public class com_8 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    RadioGroup rg2,rg3;
    RadioButton rb2,rb3;
    TextView tv1;
    public static String s24,s25;
    int temp1=-2,temp2=-2,temp3=-2,x=0;
    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_8);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg3=findViewById(R.id.rg25);
        rg2=findViewById(R.id.rg24);
        tv1=findViewById(R.id.c25);
        rg3.setAlpha((float) 0.2);
        rg3.setEnabled(false);
        for(int y=0;y<rg3.getChildCount();y++){
            rg3.getChildAt(y).setEnabled(false);
        }
        tv1.setAlpha((float) 1);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                temp2=1;
                if (i != R.id.rb24_1){
                    rg3.setAlpha((float) 1);
                    rg3.setEnabled(true);
                    temp3=-2;
                    for(int y=0;y<rg3.getChildCount();y++){
                        rg3.getChildAt(y).setEnabled(true);
                    }
                    tv1.setAlpha((float) 1);

                }
                else{
                    s25="/";
                    rg3.setAlpha((float) 0.2);
                    rg3.setEnabled(false);
                    for(int y=0;y<rg3.getChildCount();y++){
                        rg3.getChildAt(y).setEnabled(false);
                        rb3=(RadioButton) rg3.getChildAt(y);
                        rb3.setChecked(false);
                    }
                    temp3=1;
                }
                s24=rb2.getText().toString();
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                temp3=1;
                s25=rb3.getText().toString();
            }
        });

        b1=(Button)findViewById(R.id.b1);
        //b1.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View view) {                 pre();             }         });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(temp2==-2)
                {
                    x=1;
                }
                else if(temp3==-2)
                {
                    x=1;
                }
                else{x=0;}
                if(x==0) {
                    next();
                }
                else{
                    Toast.makeText(com_8.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_9.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_7.class);
        startActivities(new Intent[]{intent});
    }
}