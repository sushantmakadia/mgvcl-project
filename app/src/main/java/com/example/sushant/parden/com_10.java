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

public class com_10 extends AppCompatActivity {
    private Button b1,b3;
    private Button b2;
    int i=0;
    public CheckBox ch[];
    String str[]=new String[7];
    public static String s28,s29=new String(),c[];
    RadioGroup rg1,rg2;
    TextView t1,t2,t3,t4,t5,t6,p1,p2,p3,p4,p5,p6;
    RadioButton rb1,rb2;
    RelativeLayout l1;
    int temp1=-2,x=0,y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_10);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        t1=findViewById(R.id.a35rb1);
        b3=findViewById(R.id.reset);
        t2=findViewById(R.id.a35rb2);
        t3=findViewById(R.id.a35rb3);
        t4=findViewById(R.id.a35rb4);
        t5=findViewById(R.id.a35rb5);
        t6=findViewById(R.id.a35rb6);
        p1=findViewById(R.id.box1);
        p2=findViewById(R.id.box2);
        p3=findViewById(R.id.box3);
        p4=findViewById(R.id.box4);
        p5=findViewById(R.id.box5);
        p6=findViewById(R.id.box6);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t1.getText().toString();
                p1.setText(Integer.toString(i));
                t1.setAlpha((float)0.3);
                t1.setEnabled(false);
                p1.setEnabled(false);
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t2.getText().toString();
                p2.setText(Integer.toString(i));
                t2.setAlpha((float)0.3);
                t2.setEnabled(false);
                p2.setEnabled(false);

            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t3.getText().toString();
                p3.setText(Integer.toString(i));
                t3.setAlpha((float)0.3);
                t3.setEnabled(false);
                p3.setEnabled(false);
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t4.getText().toString();
                p4.setText(Integer.toString(i));
                t4.setAlpha((float)0.3);
                t4.setEnabled(false);
                p4.setEnabled(false);

            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t5.getText().toString();
                p5.setText(Integer.toString(i));
                t5.setAlpha((float)0.3);
                t5.setEnabled(false);
                p5.setEnabled(false);
            }
        });
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                str[i]=t6.getText().toString();
                p6.setText(Integer.toString(i));
                t6.setAlpha((float)0.3);
                t6.setEnabled(false);
                p6.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                p1.setEnabled(true);
                p2.setEnabled(true);
                p3.setEnabled(true);
                p4.setEnabled(true);
                p5.setEnabled(true);
                p6.setEnabled(true);
                t1.setAlpha((float)1);
                t2.setAlpha((float)1);
                t3.setAlpha((float)1);
                t4.setAlpha((float)1);
                t5.setAlpha((float)1);
                t6.setAlpha((float)1);
                p1.setText(" ");
                p2.setText(" ");
                p3.setText(" ");
                p4.setText(" ");
                p5.setText(" ");
                p6.setText(" ");
                s29=null;
            }
        });
        rg1=findViewById(R.id.rg28);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s28=rb1.getText().toString();
                temp1=1;
            }
        });
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre();
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(y=1;y<7;y++){
                    if(str[y]!=null) {
                        s29 += str[y]+";";
                    }
                    else{
                        x=1;
                    }
                }
                if(i<6){
                    x=1;
                    s29=null;
                }
                else if(temp1==-2)
                {
                    x=1;
                }
                else{
                    x=0;
                }
                if(x==0)
                {
                    next();
                }
                else{
                    Toast.makeText(com_10.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void next() {
        Intent intent = new Intent(com_10.this,com_11.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(com_10.this,com_9.class);
        startActivities(new Intent[]{intent});
    }
}