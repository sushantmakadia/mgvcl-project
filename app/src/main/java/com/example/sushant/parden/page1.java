package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class page1 extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5,e6,e7;
public static String s1,s2,s3,s4,s5,s6,s7;
RelativeLayout l1;
int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        b1=(Button)findViewById(R.id.rB2);
        b2=(Button)findViewById(R.id.rB1);
        e1=(EditText)findViewById(R.id.raet);
        e2=(EditText)findViewById(R.id.rbet);
        e3=(EditText)findViewById(R.id.rcet);
        e4=(EditText)findViewById(R.id.rdet);
        e5=(EditText)findViewById(R.id.reet);
        e6=(EditText)findViewById(R.id.rfet);
        e7=(EditText)findViewById(R.id.rget);
        l1=(RelativeLayout) findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                if(s2.length()<10){
                    e2.setError("Enter 10 digit number");
                    x=1;
                }
                else if(s7.length()<11){
                    e7.setError("Enter 11 digit number");
                    x=1;
                }
               else if(s1.isEmpty()) {
                    e1.setError("this field can't be empty");
                    x=1;
                }else if(s2.isEmpty()) {
                    e2.setError("this field can't be empty");
                    x=1;
                }else if(s3.isEmpty()) {
                    e3.setError("this field can't be empty");
                    x=1;
                }else if(s4.isEmpty()) {
                    e4.setError("this field can't be empty");
                    x=1;
                }else if(s5.isEmpty()) {
                    e5.setError("this field can't be empty");
                    x=1;
                }else if(s6.isEmpty()) {
                    e6.setError("this field can't be empty");
                    x=1;
                }else if(s7.isEmpty()) {
                    e7.setError("this field can't be empty");
                    x=1;
                }
                else {x=0;}
                if(x==0) {
                    next();
                }
                else {
                    Toast.makeText(page1.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page1.this, MainActivity.class);
                startActivities(new Intent[]{intent});

            }
        });
    }

    private void next() {

            Intent intent = new Intent(this, page2.class);
            startActivities(new Intent[]{intent});

    }
}
