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

public class mgvcl5 extends AppCompatActivity {

RelativeLayout l1;
    private TextView at23,at24,at35;

    private RadioGroup arg14,arg15,arg16;
    private RadioButton ard14,ard15,ard16;
int x=0,temp1=-2,temp2=-2,temp3=-2;
    private Button ab16,ac16;

    public static String rs14,rs15,rs16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl5);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        at23=findViewById(R.id.i16);
        at24=findViewById(R.id.i17);
        at35=findViewById(R.id.i171);

        arg14=findViewById(R.id.arg18);
        arg15=findViewById(R.id.arg19);
        arg16=findViewById(R.id.arg20);

        ab16=findViewById(R.id.ab5);
        ac16=findViewById(R.id.ac5);




        arg14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard14=findViewById(checkedId);
                rs14=ard14.getText().toString();
                temp1=1;
            }
        });

        arg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard15=findViewById(checkedId);
                rs15=ard15.getText().toString();
                temp2=1;
            }
        });

        arg16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard16=findViewById(checkedId);
                rs16=ard16.getText().toString();
                temp3=1;
            }
        });

        ac16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else {x=0;}
                if(x==0) {

                    Intent intent5 = new Intent(mgvcl5.this, mgvcl6.class);
                    startActivity(intent5);
                }
                else{
                    Toast.makeText(mgvcl5.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ab16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(mgvcl5.this,rs14+rs15+rs16,Toast.LENGTH_LONG).show();

                Intent intent=new Intent(mgvcl5.this,mgvcl4.class);
                startActivity(intent);
            }
        });



    }
}
