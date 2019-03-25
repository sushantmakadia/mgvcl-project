package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mgvcl10 extends AppCompatActivity {

    private TextView at38,at39;

    RelativeLayout l1;
    private RadioGroup arg28;
    private RadioButton ard28;

    private Button ab21,ac22;

    private EditText ed1;
int x=0,temp1=-2;
    public static String rs28,rs29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl10);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        at38=findViewById(R.id.i29);
        at39=findViewById(R.id.i30);

        arg28=findViewById(R.id.arg32);

        ed1=findViewById(R.id.ata1);

        ab21=findViewById(R.id.ab10);
        ac22=findViewById(R.id.ac10);

        arg28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard28=findViewById(checkedId);
                rs28=ard28.getText().toString();
                temp1=1;
            }
        });



        ac22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rs29 = ed1.getText().toString();
                if (rs29.isEmpty()) {
                    ed1.setError("field can't be empty");
                    x = 1;
                } else if (temp1 == -2) {
                    x = 1;

                } else {
                    x = 0;
                }
                if (x == 0) {

                    //Toast.makeText(mgvcl10.this,rs29,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mgvcl10.this, mgvcl11.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl10.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ab21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(mgvcl10.this,rs29,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(mgvcl10.this,mgvcl9.class);
                startActivity(intent);
            }
        });

    }
}
