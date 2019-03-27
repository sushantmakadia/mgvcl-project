package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class urb2 extends AppCompatActivity {
    private Button b1,b2;
    public RadioGroup rg1,rg2;
    public RadioButton rb1,rb2;
    public CheckBox ch[];
    public static String s5,s6,s7,c[];
    int y,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urb2);
        s5=new String();
        s6=new String();
        s7=new String();
        rg1=findViewById(R.id.urg5);
        rg2=findViewById(R.id.urg6);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s5=rb1.getText().toString();
            }
        }) ;
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=(RadioButton) radioGroup.findViewById(i);
                s6=rb2.getText().toString();
            }
        });
        ch=new CheckBox[]{findViewById(R.id.a7m1),
                findViewById(R.id.a7m2),
                findViewById(R.id.a7m3),
                findViewById(R.id.a7m4),
                findViewById(R.id.a7m5)};
        c=new String[6];
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(y=0;y<ch.length;y++) {
                    if (ch[y].isChecked()) {
                        c[y] = ch[y].getText().toString();
                    }
                    if(c[y]!=null)
                        s7 += c[y]+" ; ";
                }
                if(s5.isEmpty()){
                    flag=1;
                }
                else if(s6.isEmpty()){
                    flag=1;
                }
                else if(s7.isEmpty()){
                    flag=1;
                }
                else{
                    flag=0;
                }
                if(flag==0) {
                    Intent i = new Intent(getApplicationContext(), urb3.class);
                    startActivity(i);
                    Log.d("arry",s7);
                }
                else{
                    Toast.makeText(urb2.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //b2=(Button)findViewById(R.id.b2);
       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),urb1.class);
                startActivity(i);
            }
        });*/
    }
}
