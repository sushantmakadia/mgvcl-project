package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class urb4 extends AppCompatActivity {
    private Button b1,b2;
    public TextView t1,t2;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s11,s12,s13;
    int flag=0,fl=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb4);
        s11=new String();
        s12=new String();
        s13=new String();
        rg1=findViewById(R.id.urg11);
        rg2=findViewById(R.id.urg12);
        rg3=findViewById(R.id.urg13);
        t1=findViewById(R.id.uq12);
        t1.setAlpha((float)0.2);
        rg2.setAlpha((float)0.2);
        rg2.setEnabled(false);
        for(int x=0;x<rg2.getChildCount();x++){
            rg2.getChildAt(x).setEnabled(true);
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s11=rb1.getText().toString();
                if(i==R.id.a11rb1){
                    t1.setAlpha(1);
                    rg2.setAlpha(1);
                    rg2.setEnabled(true);
                    fl=1;
                    for(int x=0;x<rg2.getChildCount();x++) {
                        rg2.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    fl=0;
                    t1.setAlpha((float)0.2);
                    rg2.setAlpha((float)0.2);
                    rg2.setEnabled(false);
                    for(int x=0;x<rg2.getChildCount();x++){
                        rg2.getChildAt(x).setEnabled(false);
                        rb2=(RadioButton) rg2.getChildAt(x);
                        rb2.setChecked(false);
                    }
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s12=rb2.getText().toString();
                fl=0;
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s13=rb3.getText().toString();
            }
        }) ;
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s11.isEmpty()){
                    flag=1;
                }
                else if(fl==1){
                    flag=1;
                }
                else if(s13.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if(flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb5.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb4.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), urb3.class);
                startActivity(i);
            }
        });
    }
}
