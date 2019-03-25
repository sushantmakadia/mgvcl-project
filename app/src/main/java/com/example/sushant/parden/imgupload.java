package com.example.sushant.parden;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class imgupload extends AppCompatActivity {

    Button mibtn,bibtn,uibtn,idbtn,upbtn;
    ImageView miid,biid,uiid,idid;

    Bitmap bitmap_m,bitmap_b,bitmap_u,bitmap_p;
    String table,data_id;
    private int bid=0,uid=0,pid=0;

    String ImageTag = "image_tag" ;

    String ImageName = "image_data" ;

    ProgressDialog progressDialog ;

    ByteArrayOutputStream byteArrayOutputStream ;

    byte[] byteArray ;

    HttpURLConnection httpURLConnection ;

    OutputStream outputStream;

    BufferedWriter bufferedWriter ;

    int RC ;

    BufferedReader bufferedReader ;

    StringBuilder stringBuilder;

    boolean check = true;

    private int mimg = 1, bimg = 2, uimg = 3, pimg = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgupload);
        Intent  i=getIntent();
        table=i.getStringExtra("table");
//        table = getIntent().getExtras().getString("table");
//        table="rural";
//        data_id="test123";
        data_id= i.getStringExtra("id");
//        Log.v("idgg",data_id);
        progressDialog = new ProgressDialog(imgupload.this);
        mibtn = findViewById(R.id.mibtn);
        miid = findViewById(R.id.miid);
        ///////////////////////////////
        bibtn = findViewById(R.id.bibtn);
        biid = findViewById(R.id.biid);
        /////////////////////////////////
        uibtn=findViewById(R.id.uibtn);
        uiid=findViewById(R.id.uiid);
        ////////////////////////////////
        idbtn=findViewById(R.id.idbtn);
        idid=findViewById(R.id.idid);
        ///////////////////////////////
        upbtn=findViewById(R.id.upbtn);
        upbtn.setEnabled(false);
        mibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, mimg);
            }
        });

        bibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, bimg);
            }
        });
        uibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, uimg);
            }
        });
        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, pimg);
            }
        });
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                progressDialog.show();
                uploadImage(""+table,"meter",data_id,bitmap_m);
                if(bid==1){
                    uploadImage(""+table,"bill",data_id,bitmap_b);
                }
                if(uid==1){
                    uploadImage(""+table,"user",data_id,bitmap_u);
                }
                if(pid==1){
                    uploadImage(""+table,"proof",data_id,bitmap_p);
                }
//                Toast.makeText(imgupload.this,"done",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(imgupload.this,MainActivity.class);
                startActivity(i);
            }
        });

        if (ContextCompat.checkSelfPermission(imgupload.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                        5);
            }
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        } else if (requestCode == mimg) {
            bitmap_m = (Bitmap) data.getExtras().get("data");
            miid.setImageBitmap(bitmap_m);
            upbtn.setEnabled(true);


        }else if (requestCode == bimg) {
            bitmap_b = (Bitmap) data.getExtras().get("data");
            biid.setImageBitmap(bitmap_b);
            bid=1;

        }
        else if (requestCode == uimg) {
            Log.v("img","3user");
            bitmap_u = (Bitmap) data.getExtras().get("data");
            uiid.setImageBitmap(bitmap_u);
            uid=1;
        }
        else if (requestCode == pimg) {
            Log.v("img","proof");
            bitmap_p = (Bitmap) data.getExtras().get("data");
            idid.setImageBitmap(bitmap_p);
            pid=1;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera
            }
            else {
                Toast.makeText(imgupload.this, "Unable to use Camera..Please Allow us to use Camera", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void uploadImage(String table, String cat, final String imgname, final Bitmap img)
    {
        progressDialog.setMessage(" image uploading....");
        progressDialog.setTitle("Image Upload");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(imgupload.this);

        String url = "http://tami.in.md-91.webhostbox.net/mgvcl/img_upload.php?folder="+table+"&cat="+cat;
        StringRequest sr = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("image",response);
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("image_tag",imgname);
                params.put("image_data",imagetoString(img));
                return params;
            }
        };
        queue.add(sr);
    }
    private String imagetoString(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes,Base64.DEFAULT);
    }
}
