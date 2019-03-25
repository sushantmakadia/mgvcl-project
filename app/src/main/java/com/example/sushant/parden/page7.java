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

public class page7 extends AppCompatActivity {
Button b1,b2;
RadioGroup r1,r2,r3;
int temp3=-2,temp1=-2,temp2=-2;
int x=0;
LinearLayout l1;
public static String sq15,sq16,sq17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB14);
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
                    Toast.makeText(page7.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.rB13);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });
        r1=findViewById(R.id.r15rg);
        r2=findViewById(R.id.r16rg);
        r3=findViewById(R.id.r17rg);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq15=rb1.getText().toString();
                temp1=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb2=findViewById(checkedId);
                sq16=rb2.getText().toString();
                temp2=1;
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb3=findViewById(checkedId);
                sq17=rb3.getText().toString();
                temp3=1;
            }
        });

    }

    private void next() {
        Intent intent = new Intent(this, page8.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page6.class);
        startActivities(new Intent[]{intent});
    }
}
