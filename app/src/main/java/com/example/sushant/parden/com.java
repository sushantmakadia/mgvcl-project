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

public class com extends AppCompatActivity {
    private Button b1,b22;
    RelativeLayout l1;
    RadioGroup rg1,rg10;
    RadioButton b2,b32;
    int x=0;
    int temp1=-2,temp2=-2;
    EditText e1,e2,e3,e4_1,e4_2,e4_3,e5,e6,e7,e8,e9;
    public static String q1,q2,q3,q4_1,q4_2,q4_3,q5,q6,q7,q8,q9,q10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.b1);
        b22=(Button)findViewById(R.id.b2);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e3=(EditText)findViewById(R.id.et3);
        e4_1=(EditText)findViewById(R.id.et4_1);
        e4_2=(EditText)findViewById(R.id.et4_2);
        e4_3=(EditText)findViewById(R.id.et4_3);
        e5=(EditText)findViewById(R.id.et5);
        e6=(EditText)findViewById(R.id.et6);
        e7=(EditText)findViewById(R.id.et7);
        e8=(EditText)findViewById(R.id.et8);


        rg1=findViewById(R.id.rg44);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                b2=(RadioButton) radioGroup.findViewById(i);
                q9=b2.getText().toString();
                temp1=1;

            }
        });

        rg10=findViewById(R.id.rg10);
        rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                b32=(RadioButton) radioGroup.findViewById(i);
                q10=b32.getText().toString();
                temp2=1;

            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q1=e1.getText().toString();
                q2=e2.getText().toString();
                q3=e3.getText().toString();
                q4_1=e4_1.getText().toString();
                q4_2=e4_2.getText().toString();
                q4_3=e4_3.getText().toString();
                q5=e5.getText().toString();
                q6=e6.getText().toString();
                q7=e7.getText().toString();
                q8=e8.getText().toString();
                if(q8.length()<11){
                    e8.setError("enter 11 digit number");
                    x=1;
                }
               else if(q4_3.length()<10){
                    e4_3.setError("enter 10 digit number");
                    x=1;
                }
                else if(q1.isEmpty()){
                    e1.setError("field cannot be empty");
                    x=1;
                }
                else if(q2.isEmpty()){
                    e2.setError("field cannot be empty");
                    x=1;
                }
                else if(q3.isEmpty()){
                    e3.setError("field cannot be empty");
                    x=1;
                }
                else if(q4_1.isEmpty()){
                    e4_1.setError("field cannot be empty");
                    x=1;
                }
                else if(q4_2.isEmpty()){
                    e4_2.setError("field cannot be empty");
                    x=1;
                }
                else if(q4_3.isEmpty()){
                    e2.setError("field cannot be empty");
                    x=1;
                }
                else if(q5.isEmpty()){
                    e5.setError("field cannot be empty");
                    x=1;
                }
                else if(q6.isEmpty()){
                    e6.setError("field cannot be empty");
                    x=1;
                }
                else if(q7.isEmpty()){
                    e7.setError("field cannot be empty");
                    x=1;
                }
                else if(q8.isEmpty()){
                    e8.setError("field cannot be empty");
                    x=1;
                }
                else if(temp1==-2){x=1;}
                else if(temp2==-2){x=1;}
                else{
                    x=0;
                }
                if(x==0) {
                    pre();
                }
                else{
                    Toast.makeText(com.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
     /*   b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.this, MainActivity.class);
                startActivities(new Intent[]{intent});

            }
        });*/

    }

    private void pre() {
        Intent intent = new Intent(this,com_1.class);
        startActivities(new Intent[]{intent});
    }
}
