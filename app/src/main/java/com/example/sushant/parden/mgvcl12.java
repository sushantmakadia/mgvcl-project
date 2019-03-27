


package com.example.sushant.parden;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushant.parden.sqlite.DatabaseHelper;

public class mgvcl12 extends AppCompatActivity {
    DatabaseHelper mydb;


    private TextView tv7,tv8,tv9;
    private EditText ed7,ed8,ed9;
    private Button ba2,ca2;
    public static String s71,s81,s91;
    RelativeLayout l1;
    int x=0;

    private EditText ed1,ed2,ed3,ed4,ed5,ed6;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private Button ba1,ca1;
    public static String s1,s2,s3,s4,s5,s6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl12);
        mydb =new DatabaseHelper(this);


        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        tv1=findViewById(R.id.a);
        tv2=findViewById(R.id.b);
        tv3=findViewById(R.id.c);
        tv4=findViewById(R.id.d);
        tv5=findViewById(R.id.e);
        tv6=findViewById(R.id.f);

        tv7=findViewById(R.id.g);
        tv8=findViewById(R.id.h);
        tv9=findViewById(R.id.i);

        ed1=findViewById(R.id.aata3);
        ed2=findViewById(R.id.aata4);
        ed3=findViewById(R.id.aata5);
        ed4=findViewById(R.id.aata6);
        ed5=findViewById(R.id.aata7);
        ed6=findViewById(R.id.aata8);

        ed7=findViewById(R.id.aata9);
        ed8=findViewById(R.id.aata10);
        ed9=findViewById(R.id.aata11);

//        ba1=findViewById(R.id.ab1a);
////        ca1=findViewById(R.id.ac1a);
//
//
////        ca1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                Intent intent12=new Intent(mgvcl12.this,mgvcl13.class);
////                startActivity(intent12);
////            }
////        });
////
////        ba1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent=new Intent(mgvcl12.this,mgvcl11.class);
////                startActivity(intent);
////            }
////        });



        tv7=findViewById(R.id.g);
        tv8=findViewById(R.id.h);
        tv9=findViewById(R.id.i);

        ed7=findViewById(R.id.aata9);
        ed8=findViewById(R.id.aata10);
        ed9=findViewById(R.id.aata11);
        ed9.setSelection(0);

        ca2=findViewById(R.id.aac11);



//        AlertDialog.Builder dialog=new AlertDialog.Builder(mgvcl13.this);
//        dialog.create();
//        dialog.setMessage("done");
//        dialog.show();



        ca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s71=ed7.getText().toString();
                s81=ed8.getText().toString().trim();
                s91=ed9.getText().toString().trim();
                s1=ed1.getText().toString();
                s91=ed9.getText().toString();
                s81=ed8.getText().toString();
                s6=ed6.getText().toString().trim();
                s5=ed5.getText().toString().trim();
                s4=ed4.getText().toString().trim();
                s3=ed3.getText().toString().trim();
                s71=ed7.getText().toString();
                s2=ed2.getText().toString().trim();
                if(s81.length()<11){
                    ed8.setError("enter 11 digit number");
                    x=1;
                }
                else if (s2.length()<10){
                    ed2.setError("Enter 10 digit number");
                    x=1;
                }
                else if(s1.isEmpty()) {
                    ed1.setError("this field can't be empty");
                    x=1;
                }
               else if(TextUtils.isEmpty(s2)) {
                    ed2.setError("this field can't be empty");
                    x=1;
                }
                else if(s3.isEmpty()) {
                    ed3.setError("this field can't be empty");
                    x=1;
                }
                else if(s4.isEmpty()) {
                    ed4.setError("this field can't be empty");
                    x=1;
                }
                else if(s5.isEmpty()) {
                    ed5.setError("this field can't be empty");
                    x=1;
                }
                else if(s6.isEmpty()) {
                    ed6.setError("this field can't be empty");
                    x=1;
                }
                else if(s71.isEmpty()) {
                    ed7.setError("this field can't be empty");
                    x=1;
                }
                else if(TextUtils.isEmpty(s81)) {
                    ed8.setError("this field can't be empty");
                    x=1;
                }
                else if(s91.isEmpty()) {
                    ed9.setError("this field can't be empty");
                    x=1;
                }
                else {x=0;}
                if(x==0) {
                    next();
                }
                else{
                    Toast.makeText(mgvcl12.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }


            }
        });

      /*  ba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               back();
            }
        });*/

    }

    private void back() {
        Intent intent=new Intent(mgvcl12.this,MainActivity.class);
        startActivities(new Intent[]{intent});
    }

    private void next() {
        Intent intent13=new Intent(getApplicationContext() , mgvcl1.class);
        startActivity(intent13);
    }


}
