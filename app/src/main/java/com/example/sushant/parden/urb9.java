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

public class urb9 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s27,s28,s29;
    int flag=0,fl=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb9);
        s27=s28=s29=new String();
        rg1=findViewById(R.id.urg27);
        rg2=findViewById(R.id.urg28);
        rg3=findViewById(R.id.urg29);
        rg2.setAlpha((float)0.2);
        rg2.setEnabled(false);
        for(int k=0;k<rg2.getChildCount();k++){
            rg2.getChildAt(k).setEnabled(false);
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s27=rb1.getText().toString();
                if(i!=R.id.a27rb1){
                    rg2.setAlpha(1);
                    rg2.setEnabled(true);
                    fl=1;
                    for(int x=0;x<rg2.getChildCount();x++){
                        rg2.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    fl=0;
                    rg2.setAlpha((float)0.2);
                    rg2.setEnabled(false);
                    for(int j=0;j<rg2.getChildCount();j++){
                        rg2.getChildAt(j).setEnabled(false);
                        rb2=(RadioButton) rg2.getChildAt(j);
                        rb2.setChecked(false);

                    }
                }
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s28=rb2.getText().toString();
                fl=0;
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s29=rb3.getText().toString();
            }
        }) ;
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s27.isEmpty()){
                    flag=1;
                }
                else if(fl==1){
                    flag=1;
                }
                else if(s29.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb10.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb9.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb8.class);
                startActivity(i);
            }
        });
    }
}
