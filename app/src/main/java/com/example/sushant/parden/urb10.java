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

public class urb10 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2;
    public RadioButton rb1,rb2;
    public static String s30,s31;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb10);
        s30=s31=new String();
        rg1=findViewById(R.id.urg30);
        rg2=findViewById(R.id.urg31);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s30=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s31=rb2.getText().toString();
            }
        }) ;
        b1=(Button)findViewById(R.id.b11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s30.isEmpty()){
                    flag=1;
                }
                else if(s31.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb11.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb10.this, "Answer field can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb9.class);
                startActivity(i);
            }
        });
    }
}
