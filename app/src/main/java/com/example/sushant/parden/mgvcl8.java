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

public class mgvcl8 extends AppCompatActivity {

    private TextView at33,at34,at35;

    RelativeLayout l1;
    private RadioGroup arg23,arg24,arg25;
    private RadioButton ard23,ard24,ard25;
int x=0,temp1=-2,temp2=-2,temp3=-2;
    private Button ab19,ac19;

    public static String rs230,rs240,rs25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl8);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at33=findViewById(R.id.i24);
        at34=findViewById(R.id.i25);
        at35=findViewById(R.id.i26);

        arg23=findViewById(R.id.arg27);
        arg24=findViewById(R.id.arg28);
        arg25=findViewById(R.id.arg29);


        ac19=findViewById(R.id.ac8);

        arg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard23=findViewById(checkedId);
                rs230=ard23.getText().toString();
                temp3=1;
            }
        });

        arg24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard24=findViewById(checkedId);
                rs240=ard24.getText().toString();
                temp2=1;
            }
        });

        arg25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard25=findViewById(checkedId);
                rs25=ard25.getText().toString();
                temp1=1;
            }
        });


        ac19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else  if(temp3==-2){x=1;}
                else {x=0;}
                if(x==0) {

                    //Toast.makeText(mgvcl8.this,rs23+rs24+rs25,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mgvcl8.this, mgvcl9.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl8.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

      /*  ab19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mgvcl8.this,mgvcl7.class);
                startActivity(intent);
            }
        });*/



    }
}
