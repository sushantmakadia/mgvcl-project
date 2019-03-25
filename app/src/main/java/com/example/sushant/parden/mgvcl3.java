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

public class mgvcl3 extends AppCompatActivity {

    private TextView at8,at9,at10,at11,at12;
int x=0,temp1=-2,temp2=-2,temp3=-2,temp4=-2,temp5=-2;
    private RadioGroup arg11,arg21,arg31,arg41,arg51;
    private RadioButton ard12,ard22,ard32,ard42,ard52;
    RelativeLayout l1;
    private Button ab13,ac13;

   public static String rs11,rs21,rs31,rs41,rs51;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl3);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at8=findViewById(R.id.i8);
        at9=findViewById(R.id.i9);
        at10=findViewById(R.id.i10);
        at11=findViewById(R.id.i11);
        at12=findViewById(R.id.i12);

        arg11=findViewById(R.id.arg10);
        arg21=findViewById(R.id.arg11);
        arg31=findViewById(R.id.arg12);
        arg41=findViewById(R.id.arg13);
        arg51=findViewById(R.id.arg14);

        ab13=findViewById(R.id.ab3);
        ac13=findViewById(R.id.ac3);

        arg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard12=findViewById(checkedId);
                rs11=ard12.getText().toString();
                temp1=1;

            }
        });

        arg21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard22=findViewById(checkedId);
                rs21=ard22.getText().toString();
                temp2=1;

            }
        });

        arg31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard32=findViewById(checkedId);
                rs31=ard32.getText().toString();
                temp3=1;
            }
        });


        arg41.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard42=findViewById(checkedId);
                rs41=ard42.getText().toString();
                temp4=1;

            }
        });

        arg51.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard52=findViewById(checkedId);
                rs51=ard52.getText().toString();
                temp5=1;
            }
        });



        ac13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else  if(temp4==-2){x=1;}
                else  if(temp5==-2){x=1;}
                else {x=0;}
                if(x==0) {
                Intent intent3=new Intent(mgvcl3.this, mgvcl4.class);
                startActivity(intent3);
                }
                else{
                    Toast.makeText(mgvcl3.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ab13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(mgvcl3.this,mgvcl2.class);
               startActivity(intent);

                //for test
               // Toast.makeText(mgvcl3.this,rs11+rs21+rs31+rs41+rs51,Toast.LENGTH_LONG).show();
            }
        });

    }
}
