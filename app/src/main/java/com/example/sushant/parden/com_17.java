package com.example.sushant.parden;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sushant.parden.sqlite.DatabaseHelper;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sushant.parden.sqlite.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.sushant.parden.MainActivity.IMEI_Number_Holder;
import static com.example.sushant.parden.area_comm.CIRCLE_C;
import static com.example.sushant.parden.area_comm.DIV_C;
import static com.example.sushant.parden.area_comm.SUB_C;
import static com.example.sushant.parden.area_urban.CIRCLE_U;
import static com.example.sushant.parden.area_urban.DIV_U;
import static com.example.sushant.parden.area_urban.SUB_U;
import static com.example.sushant.parden.com.q1;
import static com.example.sushant.parden.com.q10;
import static com.example.sushant.parden.com.q2;
import static com.example.sushant.parden.com.q3;
import static com.example.sushant.parden.com.q4_1;
import static com.example.sushant.parden.com.q4_2;
import static com.example.sushant.parden.com.q4_3;
import static com.example.sushant.parden.com.q5;
import static com.example.sushant.parden.com.q6;
import static com.example.sushant.parden.com.q7;
import static com.example.sushant.parden.com.q8;
import static com.example.sushant.parden.com.q9;
import static com.example.sushant.parden.com_1.s1;
import static com.example.sushant.parden.com_1.s2;
import static com.example.sushant.parden.com_1.s3;
import static com.example.sushant.parden.com_1.s4;
import static com.example.sushant.parden.com_10.s28;
import static com.example.sushant.parden.com_10.s29;
import static com.example.sushant.parden.com_11.s30;
import static com.example.sushant.parden.com_11.s31;
import static com.example.sushant.parden.com_11.s32;
import static com.example.sushant.parden.com_12.s33;
import static com.example.sushant.parden.com_12.s34;
import static com.example.sushant.parden.com_12.s35;
import static com.example.sushant.parden.com_12.s36;
import static com.example.sushant.parden.com_13.s37;
import static com.example.sushant.parden.com_13.s38;
import static com.example.sushant.parden.com_14.s39;
import static com.example.sushant.parden.com_14.s40;
import static com.example.sushant.parden.com_14.s41;
import static com.example.sushant.parden.com_15.s42_1;
import static com.example.sushant.parden.com_15.s42_2;
import static com.example.sushant.parden.com_15.s43;
import static com.example.sushant.parden.com_16.s44;
import static com.example.sushant.parden.com_16.s45_1;
import static com.example.sushant.parden.com_16.s45_2;
import static com.example.sushant.parden.com_2.s5;
import static com.example.sushant.parden.com_2.s6;
import static com.example.sushant.parden.com_2.s7;
import static com.example.sushant.parden.com_3.s10;
import static com.example.sushant.parden.com_3.s8;
import static com.example.sushant.parden.com_3.s9;
import static com.example.sushant.parden.com_4.s11;
import static com.example.sushant.parden.com_4.s12;
import static com.example.sushant.parden.com_5.s13;
import static com.example.sushant.parden.com_5.s14;
import static com.example.sushant.parden.com_5.s15;
import static com.example.sushant.parden.com_6.s16;
import static com.example.sushant.parden.com_6.s17;
import static com.example.sushant.parden.com_6.s18;
import static com.example.sushant.parden.com_6.s19;
import static com.example.sushant.parden.com_7.s20;
import static com.example.sushant.parden.com_7.s21;
import static com.example.sushant.parden.com_7.s22;
import static com.example.sushant.parden.com_7.s23;
import static com.example.sushant.parden.com_8.s24;
import static com.example.sushant.parden.com_8.s25;
import static com.example.sushant.parden.com_9.s26;
import static com.example.sushant.parden.com_9.s27;

public class com_17 extends AppCompatActivity {

    private Button b1;
    private Button b2;
    DatabaseHelper mydb;
    public static String s46,s47,s48,jsondata;
    int temp1=-2,x=0;
    RadioGroup rg1;
    RadioButton rb1;
    EditText e1;
    RatingBar e2;
    RelativeLayout l1;
    ProgressDialog progressDialog ;
    public static String sq32,sq33,sq34,date;
    private static final String TAG = page12.class.getSimpleName();
    private String mLastUpdateTime;
    public String location;

    // location updates interval - 10sec
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    // fastest updates interval - 5 sec
    // location updates will be received if another app is requesting the locations
    // than your app can handle
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;

    private static final int REQUEST_CHECK_SETTINGS = 100;
    private FusedLocationProviderClient mFusedLocationClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;
    private Boolean mRequestingLocationUpdates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_17);
        progressDialog = new ProgressDialog(com_17.this);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        date = df.format(Calendar.getInstance().getTime());
        l1=findViewById(R.id.l1);
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        e1=findViewById(R.id.edt47);
        e2=findViewById(R.id.rt48);
        init();
        // restore the values from saved instance state
        restoreValuesFromBundle(savedInstanceState);

        startLocationButtonClick();

        mydb =new DatabaseHelper(this);
        rg1=findViewById(R.id.rg46);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s46=rb1.getText().toString();
                temp1=1;
            }
        });

        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s47=e1.getText().toString();
                s48= String.valueOf(e2.getRating());
                if(s42_1.isEmpty()){
                    e1.setError("field cannot be empty");
                    x=1;
                }


                else if(s42_2.isEmpty()){

                    x=1;
                }
                else if(temp1==-2)
                {
                    x=1;
                }
                else{x=0;}
                if(x==0) {
                    try {
                        JSONObject jsonBody = buidJsonObject();
                        postdata("commercial", jsonBody.toString());
                        Toast.makeText(com_17.this, "data inserted successful", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(com_17.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
       /* b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre();
            }
        });*/
    }
    private void init() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mSettingsClient = LocationServices.getSettingsClient(this);

        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                // location is received
                mCurrentLocation = locationResult.getLastLocation();
                mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());

                updateLocationUI();
            }
        };

        mRequestingLocationUpdates = false;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        mLocationSettingsRequest = builder.build();
    }

    /**
     * Restoring values from saved instance state
     */
    private void restoreValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("is_requesting_updates")) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean("is_requesting_updates");
            }

            if (savedInstanceState.containsKey("last_known_location")) {
                mCurrentLocation = savedInstanceState.getParcelable("last_known_location");
            }

            if (savedInstanceState.containsKey("last_updated_on")) {
                mLastUpdateTime = savedInstanceState.getString("last_updated_on");
            }
        }

        updateLocationUI();
    }

    private void updateLocationUI() {
        if (mCurrentLocation != null) {
            location = "Lat: " + mCurrentLocation.getLatitude() + ", " +"Lng: " + mCurrentLocation.getLongitude();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("is_requesting_updates", mRequestingLocationUpdates);
        outState.putParcelable("last_known_location", mCurrentLocation);
        outState.putString("last_updated_on", mLastUpdateTime);

    }


    /**
     * Starting location updates
     * Check whether location settings are satisfied and then
     * location updates will be requested
     */
    private void startLocationUpdates() {
        mSettingsClient
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        Log.i(TAG, "All location settings are satisfied.");

                        Toast.makeText(getApplicationContext(), "Started location updates!", Toast.LENGTH_SHORT).show();

                        //noinspection MissingPermission
                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                                mLocationCallback, Looper.myLooper());

                        updateLocationUI();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " +
                                        "location settings ");
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(com_17.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(com_17.this, errorMessage, Toast.LENGTH_LONG).show();
                        }

                        updateLocationUI();
                    }
                });
    }

    //    @OnClick(R.id.btn_start_location_updates)
    public void startLocationButtonClick() {
        // Requesting ACCESS_FINE_LOCATION using Dexter library
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        mRequestingLocationUpdates = true;
                        startLocationUpdates();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            // open device settings when the permission is
                            // denied permanently
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.e(TAG, "User agreed to make required location settings changes.");
                        // Nothing to do. startLocationupdates() gets called in onResume again.
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.e(TAG, "User chose not to make required location settings changes.");
                        mRequestingLocationUpdates = false;
                        break;
                }
                break;
        }
    }

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private JSONObject buidJsonObject() throws JSONException {
        JSONObject obj = new JSONObject();
        try{
            obj.put("a",q1);
            obj.put("b",q2);
            obj.put("c",q3);
            obj.put("d",q4_1);
            obj.put("e",q4_2);
            obj.put("f",q4_3);
            obj.put("g",q5);
            obj.put("h",q6);
            obj.put("i",q7);
            obj.put("j",q8);
            obj.put("k",q9);
            obj.put("l",q10);
            obj.put("l1",s1);
            obj.put("l2",s2);
            obj.put("l3",s3);
            obj.put("l4",s4);
            obj.put("l5",s5);
            obj.put("l6",s6);
            obj.put("l7",s7);
            obj.put("l8",s8);
            obj.put("l9a",s9);
            obj.put("l9b", com_3.s9_1);
            obj.put("l10",s10);
            obj.put("l11",s11);
            obj.put("l12",s12);
            obj.put("l13",s13);
            obj.put("l14",s14);
            obj.put("l15",s15);
            obj.put("l16",s16);
            obj.put("l17",s17);
            obj.put("l18",s18);
            obj.put("l19",s19);
            obj.put("l20",s20);
            obj.put("l21",s21);
            obj.put("l22",s22);
            obj.put("l23",s23);
            obj.put("l24",s24);
            obj.put("l25",s25);
            obj.put("l26",s26);
            obj.put("l27",s27);
            obj.put("l28",s28);
            obj.put("l29",s29);
            obj.put("l30",s30);
            obj.put("l31",s31);
            obj.put("l32",s32);
            obj.put("l33",s33);
            obj.put("l34",s34);
            obj.put("l35",s35);
            obj.put("l36",s36);
            obj.put("l37",s37);
            obj.put("l38",s38);
            obj.put("l39",s39);
            obj.put("l40",s40);
            obj.put("l41",s41);
            obj.put("l42",s42_1);
            obj.put("l43",s43);
            obj.put("l44",s44);
            obj.put("l45",s45_1+s45_2);
            obj.put("l46",s46);
            obj.put("l47",s47);
            obj.put("l48",s48);
            obj.put("m",date);
            obj.put("n",location);
            obj.put("o","");
            obj.put("imei",IMEI_Number_Holder);
            obj.put("circle",CIRCLE_C);
            obj.put("div",DIV_C);
            obj.put("subdiv",SUB_C);
            jsondata=obj.toString();
            Log.v("tag",obj.toString());
        } catch(JSONException e){
            e.printStackTrace();
        }
        return obj;
    }
    public void postdata(final String fname, final String fdata) {
        progressDialog.setMessage(" data uploading....");
        progressDialog.setTitle("data Upload");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(com_17.this);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://tami.in.md-91.webhostbox.net/mgvcl/submit.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.v("resp",response);
                if(!response.startsWith("done")){
                    AddData();
                }else {
                    String[] parts = response.split(",");
                    String part = parts[1];
                    Intent i=new Intent(com_17.this,imgupload.class);
                    i.putExtra("table","commercial");
                    i.putExtra("id",part.trim());
                    Log.v("id", ""+part);
                    Toast.makeText(com_17.this,"POSTED",Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
                String res=error.toString();
                if(res.startsWith("done")){
                }
                else {
                    AddData();
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
    private void AddData() {
        boolean isInserted=mydb.insertData("commercial",""+jsondata,0);
        if (isInserted=true){
            Toast.makeText(this,"data is inserted",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"data is not inserted",Toast.LENGTH_LONG).show();
        }
        Intent i=new Intent(com_17.this,MainActivity.class);
        startActivity(i);
    }

    private void pre() {
        Intent intent = new Intent(this, com_16.class);
        startActivities(new Intent[]{intent});
    }
}
