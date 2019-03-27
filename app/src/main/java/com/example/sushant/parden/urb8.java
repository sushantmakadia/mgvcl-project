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

public class urb8 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2,rg3;
    public RadioButton rb1,rb2,rb3;
    public static String s24,s25,s26;
    int flag=0,fl=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb8);
        s24=s25=s26=new String();
        rg1=findViewById(R.id.urg24);
        rg2=findViewById(R.id.urg25);
        rg3=findViewById(R.id.urg26);
        rg3.setAlpha((float)0.2);
        rg3.setEnabled(false);
        for(int i=0;i<rg3.getChildCount();i++){
            rg3.getChildAt(i).setEnabled(false);
        }
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s24=rb1.getText().toString();
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s25=rb2.getText().toString();
                if(i!=R.id.a25rb1){
                    rg3.setAlpha(1);
                    rg3.setEnabled(true);
                    fl=1;
                    for(int x=0;x<rg3.getChildCount();x++){
                        rg3.getChildAt(x).setEnabled(true);
                    }
                }
                else{
                    fl=0;
                    rg3.setAlpha((float)0.2);
                    rg3.setEnabled(false);
                    for(int j=0;j<rg3.getChildCount();j++){
                        rg3.getChildAt(j).setEnabled(false);
                        rb3=(RadioButton) rg3.getChildAt(j);
                        rb3.setChecked(false);

                    }
                }
            }
        }) ;
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb3=(RadioButton) radioGroup.findViewById(i);
                s26=rb3.getText().toString();
                fl=0;
            }
        }) ;
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s24.isEmpty()){
                    flag=1;
                }
                else if(s25.isEmpty()){
                    flag=1;
                }
                else if(fl==1){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if (flag==0){
                Intent i = new Intent(getApplicationContext(),urb9.class);
                startActivity(i);
                }
                else{
                    Toast.makeText(urb8.this, "Answers field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    /*    b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb7.class);
                startActivity(i);
            }
        });*/
    }
}
