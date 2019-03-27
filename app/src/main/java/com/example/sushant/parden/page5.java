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
import android.widget.TextView;
import android.widget.Toast;

public class page5 extends AppCompatActivity {
Button b1,b2;
RadioGroup r1,r2,r3;
LinearLayout l1;
RadioButton rb3,rb2,rb1;
int temp3=-2,temp1=-2,temp=-2;
int x=0;
public static String sq10,sq11,sq12;

TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(temp3==-2) {

                    x=1;
                }
                else if(temp1==-2){x=1;}
                else if(temp==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    next();
                }
                else {
                    Toast.makeText(page5.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //b2=(Button)findViewById(R.id.rB9);
        /*b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        r1=findViewById(R.id.r10rg);
        r2=findViewById(R.id.r11rg);
        r3=findViewById(R.id.r12rg);
        t1=findViewById(R.id.r12tv);
        t1.setAlpha((float) 0.2);
        r3.setAlpha((float) 0.2);
        r3.setEnabled(false);
        for(int y=0;y<r3.getChildCount();y++){
            r3.getChildAt(y).setEnabled(false);
        }
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1=findViewById(checkedId);
                sq10=rb1.getText().toString();
                temp3=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb2=findViewById(checkedId);
                sq11=rb2.getText().toString();
                temp1=1;
                if(checkedId==R.id.r11rb1)
                {
                    temp=-2;
                    t1.setAlpha((float) 1);
                    r3.setAlpha((float) 1);
                    r3.setEnabled(true);
                    for(int y=0;y<r3.getChildCount();y++){
                        r3.getChildAt(y).setEnabled(true);
                    }
                }
                else
                {
                    temp=1;
                    t1.setAlpha((float) 0.2);
                    r3.setAlpha((float) 0.2);
                    r3.setEnabled(false);
                    for(int y=0;y<r3.getChildCount();y++){
                        r3.getChildAt(y).setEnabled(false);
                        rb3=(RadioButton) r3.getChildAt(y);
                        rb3.setChecked(false);
                    }
                }
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb3=findViewById(checkedId);
                sq12=rb3.getText().toString();
                temp=1;

            }
        });


    }

    private void next() {
        Intent intent=new Intent(this,page6.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page4.class);
        startActivities(new Intent[]{intent});
    }
}
