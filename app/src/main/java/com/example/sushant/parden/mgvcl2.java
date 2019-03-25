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

public class mgvcl2 extends AppCompatActivity {

    private TextView at1,at2,at3;
    RelativeLayout l1;
int temp1=-2,temp2=-2,temp3=-2,temp4=-2,x=0;
    private RadioGroup arg1,rg2,rg3,rg4;
    private RadioButton ard11,rb2,rb3,rb4;

    private Button ab12,ac12;

    public static String rs01,rs02,rs03,rs03_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl2);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at1=findViewById(R.id.i6);
        at2=findViewById(R.id.i7a);
        at3=findViewById(R.id.i7b);

        arg1=findViewById(R.id.arg4);
        rg2=findViewById(R.id.arg5);
        rg3=findViewById(R.id.arg6);
        rg4=findViewById(R.id.arg7);
        ab12=findViewById(R.id.ab3);
        ac12=findViewById(R.id.ac2);

        arg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard11=findViewById(checkedId);
                rs01=ard11.getText().toString();
                temp1=1;
            }
        });
        rg3.setEnabled(false);
        rg3.setAlpha((float) 0.2);
        rg4.setEnabled(false);
        rg4.setAlpha((float) 0.2);
        for(int x=0;x<rg3.getChildCount();x++){
            rg3.getChildAt(x).setEnabled(false);
        }
        for(int x=0;x<rg4.getChildCount();x++){
            rg4.getChildAt(x).setEnabled(false);
        }
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb2=findViewById(checkedId);
                rs02=rb2.getText().toString();
                temp2=1;
                if(checkedId==R.id.arb13){
                    rg3.setEnabled(true);
                    rg3.setAlpha((float) 1);
                    for(int x=0;x<rg3.getChildCount();x++){
                        rg3.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    rs03="/";
                    temp3=1;
                    temp4=1;
                    rs03_1="/";
                    rg3.setEnabled(false);
                    rg3.setAlpha((float) 0.2);
                    rg4.setEnabled(false);
                    rg4.setAlpha((float) 0.2);
                    for(int x=0;x<rg4.getChildCount();x++){
                        rg4.getChildAt(x).setEnabled(false);
                        rb4=(RadioButton) rg4.getChildAt(x);
                        rb4.setChecked(false);
                    }
                    for(int x=0;x<rg3.getChildCount();x++){
                        rg3.getChildAt(x).setEnabled(false);
                        rb3=(RadioButton) rg3.getChildAt(x);
                        rb3.setChecked(false);
                    }
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb3=findViewById(checkedId);
                rs03=rb3.getText().toString();
                if(!rs03.isEmpty()) {
                    temp3 = 1;
                }
                if(checkedId==R.id.arb15){
                    rg4.setEnabled(true);
                    rg4.setAlpha((float) 1);
                    for(int x=0;x<rg4.getChildCount();x++){
                        rg4.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    rs03_1="/";
                    temp4=1;
                    rg4.setEnabled(false);
                    rg4.setAlpha((float) 0.2);
                    for(int x=0;x<rg4.getChildCount();x++){
                        rg4.getChildAt(x).setEnabled(false);
                        rb4=(RadioButton) rg4.getChildAt(x);
                        rb4.setChecked(false);
                    }
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb4 = findViewById(checkedId);
                rs03_1 = rb4.getText().toString();
                if (!rs03_1.isEmpty())
                    temp4 = 1;
                }
        });
        ac12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;
                    Toast.makeText(mgvcl2.this, "rg1", Toast.LENGTH_SHORT).show();
                }
                else  if(temp2==-2){x=1;
                    Toast.makeText(mgvcl2.this, "rg2", Toast.LENGTH_SHORT).show();}
                else  if(temp3==-2){x=1;
                    Toast.makeText(mgvcl2.this, "rg3", Toast.LENGTH_SHORT).show();}
                else if(temp4==-2){x=1;
                    Toast.makeText(mgvcl2.this, "rg4", Toast.LENGTH_SHORT).show();}
                else {x=0;}
                if(x==0) {
                    Intent intent = new Intent(mgvcl2.this, mgvcl3.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl2.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ab12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mgvcl2.this, mgvcl1.class);
                startActivity(intent);


                // for test
               // Toast.makeText(mgvcl2.this,rs1+rs2+rs3,Toast.LENGTH_LONG).show();
            }
        });
    }
}
