package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mgvcl1 extends AppCompatActivity {
    private TextView at1,at2,at3,at4,at5;
    EditText edit;
    int x=0;
    RelativeLayout l1;
int temp1=-2,temp2=-2,temp3=-3,temp4=-2;
    private RadioGroup arg1,arg2,arg3,arg4;
   private RadioButton ard1,ard2,ard3,ard4;

    private Button ab1,ac1;

    public static String rs1,rs2,rs3,rs4,rs05;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl1);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at1=findViewById(R.id.i1);
        at2=findViewById(R.id.i2);
        at3=findViewById(R.id.i3);
        at5=findViewById(R.id.i4);
        edit=findViewById(R.id.aedit1);
        arg1=findViewById(R.id.arg1);
        arg2=findViewById(R.id.arg2);
        arg3=findViewById(R.id.aarg2);
        arg4=findViewById(R.id.arg3);

        ac1=findViewById(R.id.ac1);


        arg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard1=findViewById(checkedId);
                rs1=ard1.getText().toString();
                temp1=1;
            }
        });
        arg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard2=findViewById(checkedId);
                rs2=ard2.getText().toString();
                temp2=1;
            }
        });

        arg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard3=findViewById(checkedId);
                rs3=ard3.getText().toString();
                temp3=1;
            }
        });

        arg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard4=findViewById(checkedId);
                rs4=ard4.getText().toString();
                temp4=1;
            }
        });
        ac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rs05=edit.getText().toString();
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else  if(temp4==-2){x=1;}
                else {x=0;}
                if(x==0) {
                    Intent intent = new Intent(getApplicationContext(), mgvcl2.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl1.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

     /*   ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mgvcl1.this, mgvcl12.class);
                startActivity(intent);
               // Toast.makeText(MainActivity.this,"radio text is:- " + rs1+rs2+rs3+rs4,Toast.LENGTH_LONG).show();
            }
        });*/
    }
}
