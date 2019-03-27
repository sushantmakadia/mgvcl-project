package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class com_7 extends AppCompatActivity {
    private Button b1;
    public static String s20,s21,s22,s23=new String(),c[];
    private Button b2;
    RadioGroup rg1,rg2,rg3;
    RadioButton rb1,rb2,rb3;
    CheckBox ch[];
    TextView tv1;

    int temp1=-2,temp2=-2,x=0,y;
    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_7);
        l1 = findViewById(R.id.l1);
        AnimationDrawable animationDrawable = (AnimationDrawable) l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1 = findViewById(R.id.rg21);
        tv1 = findViewById(R.id.c23);
        rg3 = findViewById(R.id.rg23);
        ch = new CheckBox[]{findViewById(R.id.a23rb1),
                findViewById(R.id.a23rb2),
                findViewById(R.id.a23rb3),
                findViewById(R.id.a23rb4)};
        c = new String[6];
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    rb1 = (RadioButton) radioGroup.findViewById(i);
                    s21 = rb1.getText().toString();
                    temp1 = 1;
                }
            });
            rg2 = findViewById(R.id.rg22);
            rg3.setAlpha((float) 0.2);
            rg3.setEnabled(false);
            for(int y=0;y<rg3.getChildCount();y++){
                rg3.getChildAt(y).setEnabled(false);
            }
            tv1.setAlpha((float) 0.2);
            rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    rb2 = (RadioButton) radioGroup.findViewById(i);
                    if (i != R.id.rb22_1){
                        rg3.setAlpha((float) 1);
                        rg3.setEnabled(true);
                        temp1=-2;
                        for(int y=0;y<rg3.getChildCount();y++){
                            rg3.getChildAt(y).setEnabled(true);
                        }
                        tv1.setAlpha((float) 1);
                    }
                    else{
                        s23="/";
                        rg3.setAlpha((float) 0.2);
                        rg3.setEnabled(false);
                        for(int y=0;y<rg3.getChildCount();y++){
                            rg3.getChildAt(y).setEnabled(false);
                            rb3=(RadioButton) rg3.getChildAt(y);
                            rb3.setChecked(false);
                        }
                    }
                    s22 = rb2.getText().toString();
                    temp2 = 1;
                }
            });
            rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    rb3 = (RadioButton) radioGroup.findViewById(i);
                    temp1 = 1;
                    s23 = rb3.getText().toString();
                }
            });
            b1 = (Button) findViewById(R.id.b1);
            /*b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pre();
                }
            });*/
            b2 = (Button) findViewById(R.id.b2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (temp1 == -2) {
                        x = 1;
                    }
                    else if(temp2==-2){
                        x=1;
                    }
                    else
                     {
                        x = 0;
                    }
                    if (x == 0) {
                        next();
                    }
                    else{
                        Toast.makeText(com_7.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    private void next() {
        for(y=0;y<ch.length;y++) {
            if (ch[y].isChecked()) {
                c[y] = ch[y].getText().toString();
            }
            if(c[y]!=null)
                s20 += c[y]+" ; ";
        }
        Intent intent = new Intent(this,com_8.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_6.class);
        startActivities(new Intent[]{intent});
    }
}

