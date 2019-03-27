package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sushant.parden.urb16.f;

public class urb17 extends AppCompatActivity {
private Button b1,b2;
    public EditText e1,e2;
    public RadioGroup rg1,rg2;
    public RadioButton rb1,rb2;
    public static String s49_1,s49,s50,s51;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb17);
        s49=s50=s51=new String();
        e1=findViewById(R.id.a49);
        e2=findViewById(R.id.uq49_1);
        e1.setAlpha((float)0.2);
        e1.setEnabled(false);
        e2.setAlpha((float)0.2);
        e2.setEnabled(false);
        if(f==1) {
            e1.setEnabled(true);
            e2.setEnabled(true);
            e1.setAlpha(1);
            e2.setAlpha(1);
        }
        else{
            s49_1="/";
            s49="/";
        }
        rg1=findViewById(R.id.urg50);
        rg2=findViewById(R.id.urg51);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s50=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s51=rb2.getText().toString();
            }
        }) ;
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((s49=="/")&&(s49_1=="/")) {
                    flag = 0 ;
                }
                else{
                    s49_1 = e2.getText().toString();
                    s49 = e1.getText().toString() + " ; " + s49_1;
                }
                if(s49.isEmpty()){
                    flag=1;
                }
                else if(s49_1.isEmpty()){
                    flag=1;
                }
                else if(s50.isEmpty()){
                    flag=1;
                }
                else if(s51.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb18.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb17.this, "Answer field can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
     /*   b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb16.class);
                startActivity(i);
            }
        });*/
    }

}
