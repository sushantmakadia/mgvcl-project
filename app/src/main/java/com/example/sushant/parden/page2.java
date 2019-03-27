package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page2 extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2;
    RadioGroup r1, r2;
    LinearLayout l2;
    int temp1=-2,temp2=-2;

    int x=0;
    public static String sq1, sq2, sq3, sq4;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        b1 = (Button) findViewById(R.id.rB4);
        l2=findViewById(R.id.l2);
        AnimationDrawable animationDrawable=(AnimationDrawable)l2.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
       /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev();
            }
        });*/
        e1 = (EditText) findViewById(R.id.r1et);
        e2 = (EditText) findViewById(R.id.r3et);
        r1 = findViewById(R.id.r2rg);
        r2 = findViewById(R.id.r4rg);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                          @Override
                                          public void onCheckedChanged(RadioGroup group, int checkedId) {
                                               rb1 = findViewById(checkedId);
                                               temp1=0;
                                              sq2 = rb1.getText().toString();


                                          }

                                      }
        );
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 rb2=findViewById(checkedId);
                 temp2=0;
                sq4=rb2.getText().toString();

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                sq1=e1.getText().toString();
                                sq3=e2.getText().toString();



                                if(sq1.isEmpty()) {
                                    e1.setError("this field can't be empty");
                                    x = 1;

                                }
                                else if(sq4.isEmpty()) {
                                    e2.setError("this field can't be empty");
                                    x=1;
                                }
                                else if(temp1==-2){x=1;}
                                else if(temp2==-2){x=1;}
                                else {x=0;}
                                if(x==0) {
                                    next();
                                }
                                else {
                                    Toast.makeText(page2.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
    }




    private void next() {
        Intent intent=new Intent(this, page3.class);
        startActivities(new Intent[]{intent});
    }
    private void prev() {
        Intent intent=new Intent(this, page1.class);
        startActivities(new Intent[]{intent});
    }
}
