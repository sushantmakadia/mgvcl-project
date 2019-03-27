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
import android.widget.Toast;

public class urb1 extends AppCompatActivity {
    private Button b1,b2;
    public EditText e1;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s1,s2,s3,s4;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb1);
        s1=new String();
        s2=new String();
        s3=new String();
        s4=new String();
        e1=findViewById(R.id.a1);
        rg1=findViewById(R.id.urg2);
        rg2=findViewById(R.id.urg3);
        rg3=findViewById(R.id.urg4);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s2=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s3=rb2.getText().toString();
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s4=rb3.getText().toString();
            }
        }) ;
      b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();

                if(s1.isEmpty()){
                    e1.setError("This field can't be empty");
                    flag=1;
                }
                if(s2.isEmpty()){
                    flag=1;
                }
                else if(s3.isEmpty()){
                    flag=1;
                }
                else if(s4.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if(flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb2.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb1.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //b2=(Button)findViewById(R.id.b2);
       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),menu.class);
                startActivity(i);
            }
        });*/
    }
}
