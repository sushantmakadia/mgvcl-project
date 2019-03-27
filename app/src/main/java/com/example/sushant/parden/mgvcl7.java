package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mgvcl7 extends AppCompatActivity {

    private TextView at30,at31,at32;

    RelativeLayout l1;
    private RadioGroup arg20,arg21,arg22;
    private RadioButton ard20,ard21,ard22;
int x=0,temp1=-2,temp2=-2,temp3=-2;
    private Button ab18,ac18;

   public static String rs20,rs210,rs22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl7);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at30=findViewById(R.id.i21);
        at31=findViewById(R.id.i22);
        at32=findViewById(R.id.i23);

        arg20=findViewById(R.id.arg24);
        arg21=findViewById(R.id.arg25);
        arg22=findViewById(R.id.arg26);


        ac18=findViewById(R.id.ac7);

        arg20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard20=findViewById(checkedId);
                rs20=ard20.getText().toString();
                temp1=1;
            }
        });

        arg21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard21=findViewById(checkedId);
                rs210=ard21.getText().toString();
                temp2=1;
            }
        });

        arg22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard22=findViewById(checkedId);
                rs22=ard22.getText().toString();
                temp3=1;
            }
        });


        ac18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else {x=0;}
                if(x==0) {

                    Intent intent = new Intent(mgvcl7.this, mgvcl8.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl7.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });


       /* ab18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mgvcl7.this,mgvcl6.class);
                startActivity(intent);

                //for test
               // Toast.makeText(mgvcl7.this,rs20+rs21+rs22,Toast.LENGTH_LONG).show();
            }
        });*/



    }
}
