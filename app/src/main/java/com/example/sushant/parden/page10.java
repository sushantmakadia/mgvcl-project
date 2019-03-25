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

public class page10 extends AppCompatActivity {
Button b1,b2;
RadioGroup r1,r2,r3,r4;
int x=0;
int temp3=-2,temp1=-2,temp2=-2,temp4=-2;
LinearLayout l1;
public  static String sq24,sq25,sq26,sq27;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10);
        l1=findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB20);
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
                else {
                    Toast.makeText(page10.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b1=(Button)findViewById(R.id.rB19);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });
        r1=findViewById(R.id.r24rg1);
        r2=findViewById(R.id.r25rg);
        r3=findViewById(R.id.r26rg);
        r4=findViewById(R.id.r27rg);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq24=rb1.getText().toString();
                temp4=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb2=findViewById(checkedId);
                sq25=rb2.getText().toString();
                temp1=1;
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb3=findViewById(checkedId);
                sq26=rb3.getText().toString();
                temp3=1;

            }
        });
        r4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb4=findViewById(checkedId);
                sq27=rb4.getText().toString();
                temp2=1;
            }
        });
    }

    private void next() {
        Intent intent=new Intent(this,page11.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page9.class);
        startActivities(new Intent[]{intent});
    }
}
