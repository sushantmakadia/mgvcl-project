package com.example.sushant.parden;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class menu extends AppCompatActivity {
public EditText[] editTextArray ;
public CheckBox ch[];
public Button b1,b4;
LinearLayout l1;
public static String sm[],sc,c[];
public int x,y,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        editTextArray = new EditText[] {
                findViewById(R.id.me1),
                findViewById(R.id.me2),
                findViewById(R.id.me3),
                findViewById(R.id.me4),
                findViewById(R.id.me5),
                findViewById(R.id.me6),
                findViewById(R.id.me7)
        };
        ch=new CheckBox[]{findViewById(R.id.mc1),
                findViewById(R.id.mc2),
                findViewById(R.id.mc3),
                findViewById(R.id.mc4),
                findViewById(R.id.mc5),
                findViewById(R.id.mc6),
                findViewById(R.id.mc7),
                findViewById(R.id.mc8),
                findViewById(R.id.mc9),
                findViewById(R.id.mc10),
                findViewById(R.id.mc11),
                findViewById(R.id.mc12)};
        sm=new String[8];
        sc=new String();
        c=new String[13];
        b1=(Button)findViewById(R.id.b2);
       // b4=(Button)findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(y=0;y<ch.length;y++) {
                    if (ch[y].isChecked()) {
                        c[y] = ch[y].getText().toString();
                    }
                    if(c[y]!=null)
                        sc += c[y]+" ; ";
                }
                for(x=0;x<editTextArray.length;x++) {
                    sm[x]=editTextArray[x].getText().toString();
                    if (sm[x].isEmpty()) {
                        editTextArray[x].setError("This field can't be empty");
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                }
                if(sm[5].length()<11){
                    editTextArray[5].setError("Enter 11 digit number");
                    flag=1;
                }
                if(sm[1].length()<10){
                    flag=1;
                    editTextArray[1].setError("Enter 10 digit number");
                }
                if (flag == 0) {
                    Intent i = new Intent(getApplicationContext(),urb1.class);
                    startActivity(i);
                }
            }
        });
       /* b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(menu.this,urb1.class);
                startActivities(new Intent[]{intent});
            }
        });*/

}
}
