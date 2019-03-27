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

public class page8 extends AppCompatActivity {
Button b1,b2;
RadioGroup r1,r2;
LinearLayout l1;
int temp1=-2,temp2=-2;
int x=0;
public static String sq18,sq19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);
        l1=findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.rB16);
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
                    Toast.makeText(page8.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //b2=(Button)findViewById(R.id.rB15);
        /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        r1=findViewById(R.id.r18rg);
        r2=findViewById(R.id.r19rg);

        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq18=rb1.getText().toString();
                temp2=1;
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb2=findViewById(checkedId);
                sq19=rb2.getText().toString();
                temp1=1;
            }
        });


    }

    private void next() {
        Intent intent=new Intent(this,page9.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this,page7.class);
        startActivities(new Intent[]{intent});
    }
}
