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

public class mgvcl6 extends AppCompatActivity {

    private TextView at27,at28,at29;


    private RadioGroup arg17,arg18,arg19;
    private RadioButton ard17,ard18,ard19;
int x=0,temp1=-2,temp2=-2,temp3=-2;
    private Button ab17,ac17;

    public static String rs17,rs18,rs19;

    RelativeLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl6);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at27=findViewById(R.id.i18);
        at28=findViewById(R.id.i19);
        at29=findViewById(R.id.i20);

        arg17=findViewById(R.id.arg21);
        arg18=findViewById(R.id.arg22);
        arg19=findViewById(R.id.arg23);




        ac17=findViewById(R.id.ac6);

        arg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard17=findViewById(checkedId);
                rs17=ard17.getText().toString();
                temp3=1;
            }
        });


        arg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard18=findViewById(checkedId);
                rs18=ard18.getText().toString();
                temp2=1;
            }
        });


        arg19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard19=findViewById(checkedId);
                rs19=ard19.getText().toString();
                temp1=1;
            }
        });








        ac17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else {x=0;}
                if(x==0) {

                    Intent intent = new Intent(mgvcl6.this, mgvcl7.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl6.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

       /* ab17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(mgvcl6.this,rs17+rs18+rs19,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(mgvcl6.this,mgvcl5.class);
                startActivity(intent);
            }
        });*/


    }
}
