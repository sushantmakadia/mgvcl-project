package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page9 extends AppCompatActivity {
Button b1,b2;
RadioGroup r1,r2,r3,r4;
LinearLayout l1;
int x=0;
int temp3=-2,temp1=-2,temp2=-2,temp4=-2;
RadioButton rb1,rb2,rb3,rb4;
public static String sq20,sq21,sq22,sq23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9);
        l1=findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB18);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp3==-2) {

                    x=1;
                }
                else if(temp1==-2){x=1;}
                else if(temp2==-2){x=1;}
                else if(temp4==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    next();
                }
                else Toast.makeText(page9.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
            }
        });
        //b2=(Button)findViewById(R.id.rB17);
        /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        r1=findViewById(R.id.r20rg);
        r2=findViewById(R.id.r21rg);
        r3=findViewById(R.id.r22rg1);
        r4=findViewById(R.id.r23rg);
        r2.setAlpha((float) 0.2);
        r2.setEnabled(false);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb1=findViewById(checkedId);
                sq20=rb1.getText().toString();
                temp3=1;
                if(checkedId==R.id.r20rb1){
                    r2.setAlpha((float) 1);
                    r2.setEnabled(true);
                    temp2=-2;
                    for(int y=0;y<r2.getChildCount();y++){
                        r2.getChildAt(y).setEnabled(true);
                    }
                }
                else{
                    temp2=1;
                    r2.setAlpha((float) 0.2);
                    r2.setEnabled(false);
                    for(int y=0;y<r2.getChildCount();y++){
                        r2.getChildAt(y).setEnabled(false);
                        rb2=(RadioButton) r2.getChildAt(y);
                        rb2.setChecked(false);
                    }
                }

            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb2=findViewById(checkedId);
                sq21=rb2.getText().toString();
                temp2=1;
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb3=findViewById(checkedId);
                sq22=rb3.getText().toString();
                temp1=1;
            }
        });
        r4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb4=findViewById(checkedId);
                sq23=rb4.getText().toString();
                temp4=1;
            }
        });

    }

    private void next() {
        Intent intent=new Intent(this,page10.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page8.class);
        startActivities(new Intent[]{intent});
    }
}
