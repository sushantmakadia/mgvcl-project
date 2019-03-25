
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
import android.widget.Toast;

public class com_1 extends AppCompatActivity {
    private Button b1;
     Button b2;
    RelativeLayout l1;
    EditText e1;
    RadioGroup rg1,rg2,rg3;
    int x=0;
    int temp1=-2,temp2=-2,temp3=-2;
    RadioButton rb1,rb2,rb3;
    public static String s1=new String(),s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.edt1);

        rg1=findViewById(R.id.rg3);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=findViewById(i);
                s2=rb1.getText().toString();
                temp1=1;
            }
        });
        rg2=findViewById(R.id.rg1);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=findViewById(i);
                s3=rb2.getText().toString();
                temp2=1;
            }
        });
        rg3=findViewById(R.id.rg4);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=findViewById(i);
                s4=rb3.getText().toString();
                temp3=1;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre();
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                if(temp1==-2)
                {x=1;}
                else if(temp2==-2){
                    x=1;

                }
                else if(temp3==-2){
                    x=1;

                }
                else  if(s1.isEmpty()){
                    e1.setError("field cannot be empty");
                }
                else{
                    x=0;
                }
                if(x==0) {
                    next();
                }
                else{
                    Toast.makeText(com_1.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void next() {
        Intent intent = new Intent(com_1.this, com_2.class);
        startActivities(new Intent[]{intent});
    }
    private void pre()
    {
        Intent intent = new Intent(this, com.class);
        startActivities(new Intent[]{intent});
    }
}
