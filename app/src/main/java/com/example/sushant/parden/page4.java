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

public class page4 extends AppCompatActivity {
    Button b1, b2;
    int temp1 =-2,temp2=-2;
    int x=0;
    public static String sq8,sq9;
    RadioGroup r1,r2;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1 = (Button) findViewById(R.id.rB8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp1==-2){x=1;}
                else if(temp2==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    next();
                }
                else {
                    Toast.makeText(page4.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //b2 = (Button) findViewById(R.id.rB7);
       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        r1=findViewById(R.id.r8rg);
        r2=findViewById(R.id.r9rg);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq8=rb1.getText().toString();
                temp1=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb2=findViewById(checkedId);
                sq9=rb2.getText().toString();
                temp2=1;

            }
        });
    }

    private void next() {
        Intent intent = new Intent(this, page5.class);
        startActivities(new Intent[]{intent});
    }

    private void prev() {
        Intent intent = new Intent(this, page3.class);
        startActivities(new Intent[]{intent});
    }
}
