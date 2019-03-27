package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class urb7 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2;
    public EditText e1;
    public CheckBox ch[];
    public RadioButton rb1,rb2;
    public static String s20,s21,s22,s23,c[];
    int y,flag=0,f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb7);
        s20=s21=s22=s23=new String();
        rg1=findViewById(R.id.urg20);
        rg2=findViewById(R.id.urg21);
        e1=findViewById(R.id.a22);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s20=rb1.getText().toString();
            }
        });
        e1.setEnabled(false);
        e1.setAlpha((float)0.2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s21=rb2.getText().toString();
                if(i==R.id.a21rb2){
                    e1.setAlpha(1);
                    e1.setEnabled(true);
                    s22=null;
                }
                else{
                    s22="/";
                    e1.setEnabled(false);
                    e1.setAlpha((float)0.2);
                }
            }
        });
        ch=new CheckBox[]{findViewById(R.id.a23rb1),
                findViewById(R.id.a23rb2),
                findViewById(R.id.a23rb3),
                findViewById(R.id.a23rb4)};
        c=new String[6];
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s22=="/"){
                    s22="/";
                }
                else{
                    s22=e1.getText().toString();
                }
                for(y=0;y<ch.length;y++) {
                    if (ch[y].isChecked()) {
                        c[y] = ch[y].getText().toString();
                        f = 0;
                    }
                    if (f == 0) {
                        if (c[y] != null)
                            s23 += c[y] + " ; ";
                    }
                    else{
                        s23="/";
                    }
                }
                if(s20.isEmpty()){
                    flag=1;
                }
                else if(s21.isEmpty()){
                    flag=1;
                }
                else if(s22.isEmpty()){
                    flag=1;
                }
                else if(s23.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }

                if(flag==0){
                    Intent i = new Intent(getApplicationContext(),urb8.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(urb7.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
      /*  b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb6.class);
                startActivity(i);
            }
        });*/
    }
}
