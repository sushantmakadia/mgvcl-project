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

public class urb5 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2,rg3,rg4;
    public RadioButton rb1,rb2,rb3,rb4;
    public static String s14,s14_1,s15,s16;
    int flag=0,fl=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb5);
        s14=new String();
        s14_1=new String();
        s15=new String();
        s16=new String();
        rg1=findViewById(R.id.urg14);
        rg2=findViewById(R.id.urg15);
        rg3=findViewById(R.id.urg16);
        rg4=findViewById(R.id.urg14_1);
        rg4.setEnabled(false);
        rg4.setAlpha((float) 0.2);
        for(int x=0;x<rg4.getChildCount();x++){
            rg4.getChildAt(x).setEnabled(false);
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s14=rb1.getText().toString();
                if(i==R.id.a14rb1) {
                    rg4.setAlpha(1);
                    rg4.setEnabled(true);
                    fl=1;
                    for (int x = 0; x < rg4.getChildCount(); x++) {
                        rg4.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    fl=0;
                    rg4.setEnabled(false);
                    rg4.setAlpha((float) 0.2);
                    for(int x=0;x<rg4.getChildCount();x++){
                        rg4.getChildAt(x).setEnabled(false);
                        rb4=(RadioButton) rg4.getChildAt(x);
                        rb4.setChecked(false);

                    }
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s15=rb2.getText().toString();
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s16=rb3.getText().toString();
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb4=(RadioButton) radioGroup.findViewById(i);
                s14_1=rb4.getText().toString();
                if(s14_1.isEmpty()) {
                    fl = 1;
                }
                else{
                    fl=0;
                }
            }
        }) ;

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s14.isEmpty()){
                    flag=1;
                }
                else if(fl==1){
                    flag=1;
                }
                else if(s15.isEmpty()){
                    flag=1;
                }
                else if(s16.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if(flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb6.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb5.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
      /*  b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb4.class);
                startActivity(i);
            }
        });*/
    }
}
