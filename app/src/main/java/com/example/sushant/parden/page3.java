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

public class page3 extends AppCompatActivity {
    Button b1,b2;
    int temp3=-2,temp1=-2,temp2=-2;
    int x=0;
    RadioGroup r1,r2,r3;
    LinearLayout l1;
    public  static String sq5,sq6,sq7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        b1=(Button)findViewById(R.id.rB6);
       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(temp3==-2){x=1;}
                else if(temp1==-2){x=1;}
                else if(temp2==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    next();
                }
                else {
                    Toast.makeText(page3.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //b2=(Button)findViewById(R.id.rB5);
        r1=findViewById(R.id.r5rg);
        r2=findViewById(R.id.r6rg);
        r3=findViewById(R.id.r7rg);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
      /*  b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq5=rb1.getText().toString();
                temp3=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb2=findViewById(checkedId);
                sq6=rb2.getText().toString();
                temp1=1;
            }
        });
        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb3=findViewById(checkedId);
                sq7=rb3.getText().toString();
                temp2=1;
            }
        });
    }
    private void next() {
        Intent intent=new Intent(this, page4.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this, page2.class);
        startActivities(new Intent[]{intent});
    }

}
