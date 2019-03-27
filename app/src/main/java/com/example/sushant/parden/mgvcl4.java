package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mgvcl4 extends AppCompatActivity {

    private TextView at13,at14,at15;
RelativeLayout l1;
    private RadioGroup arg13,arg23,arg33;
    private RadioButton ard13,ard23,ard33;
    int x=0,temp1=-2,temp2=-2,temp3=-2;
    private Button ab14,ac15;

    public static String rs12,rs23,rs33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl4);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        at13=findViewById(R.id.i13);
        at14=findViewById(R.id.i14);
        at15=findViewById(R.id.i15);

        arg13=findViewById(R.id.arg15);
        arg23=findViewById(R.id.arg16);
        arg33=findViewById(R.id.arg17);

        ac15=findViewById(R.id.ac4);

        arg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard13=findViewById(checkedId);
                rs12=ard13.getText().toString();
                temp1=1;

            }
        });

        arg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard23=findViewById(checkedId);
                rs23=ard23.getText().toString();
                temp2=1;

            }
        });

        arg33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard33=findViewById(checkedId);
                rs33=ard33.getText().toString();
                temp3=1;

            }
        });

        ac15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else {x=0;}
                if(x==0) {

                    Intent intent = new Intent(mgvcl4.this, mgvcl5.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(mgvcl4.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }


            }
        });

      /*  ab14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4=new Intent(mgvcl4.this,mgvcl3.class);
                startActivity(intent4);

            }
        });*/




    }
}
