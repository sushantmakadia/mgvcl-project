
package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mgvcl9 extends AppCompatActivity {

    private TextView at36,at37;
int x=0,temp1=-2,temp2=-2;
 RelativeLayout l1;
    private RadioGroup arg26,arg27;
    private RadioButton ard26,ard27;

    private Button ab20,ac20;

    public static String rs26,rs27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgvcl9);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        at36=findViewById(R.id.i27);
        at37=findViewById(R.id.i28);

        arg26=findViewById(R.id.arg30);
        arg27=findViewById(R.id.arg31);


        ac20=findViewById(R.id.ac9);

        arg26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard26=findViewById(checkedId);
                rs26=ard26.getText().toString();
                temp1=1;
            }
        });

        arg27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ard27=findViewById(checkedId);
                rs27=ard27.getText().toString();
                temp2=1;
            }
        });

        ac20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp1==-2){x=1;}
                else  if(temp2==-2){x=1;}
                else {x=0;}
                if(x==0) {


                    // Toast.makeText(mgvcl9.this,rs26+rs27,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mgvcl9.this, mgvcl10.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(mgvcl9.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });

       /* ab20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mgvcl9.this,mgvcl8.class);
                startActivity(intent);
            }
        });*/






    }
}
