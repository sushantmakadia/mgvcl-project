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

public class urb6 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s17,s18,s19;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb6);
        s17=s18=s19=new String();
        rg1=findViewById(R.id.urg17);
        rg2=findViewById(R.id.urg18);
        rg3=findViewById(R.id.urg19);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s17=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s18=rb2.getText().toString();
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s19=rb3.getText().toString();
            }
        }) ;

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s17.isEmpty()){
                    flag=1;
                }
               else if(s18.isEmpty()){
                    flag=1;
                }
                else if(s19.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if(flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb7.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb6.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb5.class);
                startActivity(i);
            }
        });
    }
}
