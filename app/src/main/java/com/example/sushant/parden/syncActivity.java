package com.example.sushant.parden;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sushant.parden.sqlite.*;
import com.example.sushant.parden.*;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class syncActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    TextView txt_sync;
    Button btn_sync;
    page12 post;
    private ProgressBar p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sync);
        mydb = new DatabaseHelper(this);
        txt_sync=findViewById(R.id.txt_sync);
        p1=findViewById(R.id.p1);
        btn_sync=findViewById(R.id.btn_sync);
        p1.setVisibility(View.GONE);
        btn_sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()){
                    Toast.makeText(syncActivity.this,"network is avilable",Toast.LENGTH_SHORT).show();
                    upload();
                    viewAll();
                    p1.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(syncActivity.this,"network is not avilable",Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewAll();
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void viewAll(){
        Cursor res = mydb.getAllData();
        Log.d("data",""+res);
        int i=res.getCount();
        if (i == 0) {
            txt_sync.setText("All data are upload");
        }
        else {
            txt_sync.setText(""+i+" data need to sync");
        }
    }
    String cat,jsondata;
    public void upload() {
//        p1.setVisibility(View.VISIBLE);
        Cursor data = mydb.getAllData();
        while(data.moveToNext()){
            mydb.setData(data.getString(0));
            cat=data.getString(1);
            jsondata = data.getString(2);
            postdata(cat,jsondata);
        }
    }
    public void postdata(final String fname, final String fdata) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://tami.in.md-91.webhostbox.net/mgvcl/submit.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
                viewAll();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
                String res=error.toString();
                if(res.startsWith("done")) {
                }
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("fname",fname);
                params.put("fdata",fdata);
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }



}
