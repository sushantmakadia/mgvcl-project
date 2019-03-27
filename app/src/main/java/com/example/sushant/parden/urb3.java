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

public class urb3 extends AppCompatActivity {
    private Button b1,b2;
    public EditText e1,e2,e3;
    public RadioGroup rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s8_1,s8_2,s8_3,s9,s10,s8;
    int flag=0;
    int d=0,m=0,y=0,dd=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb3);
        s8_1=new String();
        s8_2=new String();
        s8_3=new String();
        s9=new String();
        s10=new String();
        s8=new String();
        e1=findViewById(R.id.a8_d);

        e2=findViewById(R.id.a8_m);

        e3=findViewById(R.id.a8_y);

        rg2=findViewById(R.id.urg9);
        rg3=findViewById(R.id.urg10);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s9=rb2.getText().toString();
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s10=rb3.getText().toString();
            }
        });
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s8_1=e1.getText().toString();
                s8_2=e2.getText().toString();
                s8_3=e3.getText().toString();
                if(s8_1.isEmpty()){
                    s8_1="0";
                }
                if(s8_2.isEmpty()){
                    s8_2="0";
                }
                if(s8_3.isEmpty()){
                    s8_3="0";
                }
                d=(Integer.parseInt(s8_1)/30);
                y=(Integer.parseInt(s8_3)*12);
                m=(Integer.parseInt(s8_2));
                dd=(Integer.parseInt(s8_1)%30);
                if(Integer.parseInt(s8_1)%30!=0){
                    s8="Months: "+String.valueOf(d+y+m)+" ; Days: "+String.valueOf(dd);
                }
                if((dd+d+m+y)==0){
                    flag=1;
                }
                else if(s9.isEmpty()) {
                    flag = 1;
                }
                else if(s10.isEmpty()) {
                    flag = 1;
                }
                else {
                    flag = 0;
                }
                if(flag==0) {
                    Toast.makeText(urb3.this, s8, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), urb4.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb3.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
      /*  b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), urb2.class);
                startActivity(i);
            }
        });*/
    }
}
