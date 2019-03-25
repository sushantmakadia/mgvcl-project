package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class urb16 extends AppCompatActivity {
private Button b1,b2;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s46,s47,s48;
    int flag=0;
    public static int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb16);
        s46=s47=s48=new String();
        rg1=findViewById(R.id.urg46);
        rg2=findViewById(R.id.urg47);
        rg3=findViewById(R.id.urg48);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s46=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s47=rb2.getText().toString();
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s48=rb3.getText().toString();
                if(i==R.id.a48rb1){
                    f=1;
                }
                else{
                    f=0;
                }
            }
        }) ;
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s46.isEmpty()){
                    flag=1;
                }
                else if(s47.isEmpty()){
                    flag=1;
                }
                else if(s48.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb17.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb16.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb15.class);
                startActivity(i);
            }
        });
    }
}
