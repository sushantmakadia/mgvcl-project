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

public class page6 extends AppCompatActivity {
Button b1,b2;
public static String sq13,sq131,sq14;
RadioGroup r1,r2,r3;
RadioButton rb1,rb2,rb3;
int temp1=-2,temp2=-2,temp3=-2;
int x=0;
LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 if(temp3==-2) {

                    x=1;
                }
                else if(temp1==-2){x=1;}
                else if(temp2==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    next();
                }
                else {
                    Toast.makeText(page6.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2=(Button)findViewById(R.id.rB11);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });
        r1=findViewById(R.id.r13rg);
        r2=findViewById(R.id.r13rg1);
        r3=findViewById(R.id.r14rg);
        r2.setAlpha((float) 0.2);
        r2.setEnabled(false);
        for(int y=0;y<r2.getChildCount();y++){
            r2.getChildAt(y).setEnabled(false);
        }
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1=findViewById(checkedId);
                sq13=rb1.getText().toString();
                temp2=1;
                if(checkedId==R.id.r13rb11){
                    r2.setAlpha((float) 1);
                    r2.setEnabled(true);
                    temp1=-2;
                    for(int y=0;y<r2.getChildCount();y++){
                        r2.getChildAt(y).setEnabled(true);
                    }
                }
                else{
                    temp1=1;
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
                sq131=rb2.getText().toString();
                temp1=1;
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb3=findViewById(checkedId);
                sq14=rb3.getText().toString();
                temp3=1;
            }
        });

    }

    private void next() {
        Intent intent=new Intent(this,page7.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page5.class);
        startActivities(new Intent[]{intent});
    }
}
