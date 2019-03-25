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

public class urb14 extends AppCompatActivity {
private Button b1,b2;
    public RadioGroup rg1,rg2,rg3,rg4;
    public RadioButton rb1,rb2,rb3,rb4;
    public static String s39,s40,s41,s42;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb14);
        s39=s40=s41=s42=new String();
        rg1=findViewById(R.id.urg39);
        rg2=findViewById(R.id.urg40);
        rg3=findViewById(R.id.urg41);
        rg4=findViewById(R.id.urg42);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s39=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s40=rb2.getText().toString();
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s41=rb3.getText().toString();
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb4=(RadioButton) radioGroup.findViewById(i);
                s42=rb4.getText().toString();
            }
        }) ;
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s39.isEmpty()){
                    flag=1;
                }
                else if(s40.isEmpty()){
                    flag=1;
                }
                else if(s41.isEmpty()){
                    flag=1;
                }
                else if(s42.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb15.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb14.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb13.class);
                startActivity(i);
            }
        });
    }
}
