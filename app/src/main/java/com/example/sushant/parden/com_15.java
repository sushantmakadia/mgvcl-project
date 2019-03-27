package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static com.example.sushant.parden.com_14.f;

public class com_15 extends AppCompatActivity {
    private Button b1;
    private Button b2;
    EditText e1,e2;
    public static String s42_1,s42_2,s43;
    RadioGroup rg1;
    int temp1=-2,x=0;
    RelativeLayout l1;
    RadioButton rb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_15);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rg1=findViewById(R.id.rg43);
        e1=findViewById(R.id.edt42_1);
        e2=findViewById(R.id.edt42_2);
        e1.setAlpha((float) 0.2);
        e2.setAlpha((float) 0.2);
        e1.setEnabled(false);
        e2.setEnabled(false);
        s42_1=new String();
        s42_2=new String();
        if(f==1){
            e1.setAlpha((float) 1);
            e2.setAlpha((float) 1);
            e1.setEnabled(true);
            e2.setEnabled(true);
        }
        else{
            s42_1="/";
            s42_2="/";
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s43=rb1.getText().toString();
                temp1=1;
            }
        });

        b1=(Button)findViewById(R.id.b1);
        //b1.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View view) {                 pre();             }         });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((s42_1=="/")&&(s42_2=="/")) {
                    x = 0 ;
                }
                else{
                    s42_2 = e2.getText().toString();
                    s42_1 = e1.getText().toString() + " ; " + s42_2;
                }
                if(s42_1.isEmpty()){
                    e1.setError("field cannot be empty");
                    x=1;
                }
                else if(s42_2.isEmpty()){
                    e2.setError("field cannot be empty");
                    x=1;
                }
                else if(temp1==-2)
                {
                    x=1;
                }
                else{x=0;}
                if(x==0)
                {
                    next();
                }
                else{
                    Toast.makeText(com_15.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(this,com_16.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this,com_14.class);
        startActivities(new Intent[]{intent});
    }
}