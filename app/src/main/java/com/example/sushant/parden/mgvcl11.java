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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

import static com.example.sushant.parden.MainActivity.IMEI_Number_Holder;
import static com.example.sushant.parden.area_agri.CIRCLE_A;
import static com.example.sushant.parden.area_agri.DIV_A;
import static com.example.sushant.parden.area_agri.SUB_A;
import static com.example.sushant.parden.area_urban.CIRCLE_U;
import static com.example.sushant.parden.area_urban.DIV_U;
import static com.example.sushant.parden.area_urban.SUB_U;
import static com.example.sushant.parden.mgvcl1.rs05;
import static com.example.sushant.parden.mgvcl1.rs1;
import static com.example.sushant.parden.mgvcl1.rs2;
import static com.example.sushant.parden.mgvcl1.rs3;
import static com.example.sushant.parden.mgvcl1.rs4;
import static com.example.sushant.parden.mgvcl10.rs28;
import static com.example.sushant.parden.mgvcl10.rs29;
import static com.example.sushant.parden.mgvcl12.s1;
import static com.example.sushant.parden.mgvcl12.s2;
import static com.example.sushant.parden.mgvcl12.s3;
import static com.example.sushant.parden.mgvcl12.s4;
import static com.example.sushant.parden.mgvcl12.s5;
import static com.example.sushant.parden.mgvcl12.s6;
import static com.example.sushant.parden.mgvcl12.s71;
import static com.example.sushant.parden.mgvcl12.s81;
import static com.example.sushant.parden.mgvcl12.s91;
import static com.example.sushant.parden.mgvcl2.rs01;
import static com.example.sushant.parden.mgvcl2.rs02;
import static com.example.sushant.parden.mgvcl2.rs03;
import static com.example.sushant.parden.mgvcl2.rs03_1;
import static com.example.sushant.parden.mgvcl3.rs11;
import static com.example.sushant.parden.mgvcl3.rs21;
import static com.example.sushant.parden.mgvcl3.rs31;
import static com.example.sushant.parden.mgvcl3.rs41;
import static com.example.sushant.parden.mgvcl3.rs51;
import static com.example.sushant.parden.mgvcl4.rs12;
import static com.example.sushant.parden.mgvcl4.rs23;
import static com.example.sushant.parden.mgvcl4.rs33;
import static com.example.sushant.parden.mgvcl5.rs14;
import static com.example.sushant.parden.mgvcl5.rs15;
import static com.example.sushant.parden.mgvcl5.rs16;
import static com.example.sushant.parden.mgvcl6.rs17;
import static com.example.sushant.parden.mgvcl6.rs18;
import static com.example.sushant.parden.mgvcl6.rs19;
import static com.example.sushant.parden.mgvcl7.rs20;
import static com.example.sushant.parden.mgvcl7.rs210;
import static com.example.sushant.parden.mgvcl7.rs22;
import static com.example.sushant.parden.mgvcl8.rs230;
import static com.example.sushant.parden.mgvcl8.rs240;
import static com.example.sushant.parden.mgvcl8.rs25;
import static com.example.sushant.parden.mgvcl9.rs26;
import static com.example.sushant.parden.mgvcl9.rs27;

public class mgvcl11 extends AppCompatActivity {
    DatabaseHelper mydb;

    private TextView at40,at41,at42;
    private EditText ed3,ed4;
    private Button ab23,ac23;
    RelativeLayout l1;
    RatingBar ed2;
    int x=0;
    public static String rs30,date;
    public String jsondata;
    ProgressDialog progressDialog ;
    private static final String TAG = page12.class.getSimpleName();
    private String mLastUpdateTime;
    public String location;

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
        setContentView(R.layout.activity_mgvcl11);
        progressDialog = new ProgressDialog(mgvcl11.this);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        date = df.format(Calendar.getInstance().getTime());
        l1= findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        init();
        restoreValuesFromBundle(savedInstanceState);

        startLocationButtonClick();
        at40=findViewById(R.id.i31);

        ed2=findViewById(R.id.ata2);

       // ab23=findViewById(R.id.ab11);
        ac23=findViewById(R.id.ac11);
        mydb =new DatabaseHelper(this);

        ac23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rs30= String.valueOf(ed2.getNumStars());

                if (rs29.isEmpty()) {
                    x = 1;
                }
                else {x=0;}
                if(x==0) {
                    try {
                        JSONObject jsonBody = buidJsonObject();
                        postdata("agriculture",jsonBody.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(mgvcl11.this, "data submitted ", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(mgvcl11.this, "Answer field can't be empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });


       /* ab23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mgvcl11.this,mgvcl10.class);
                startActivity(intent);
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
                                    rae.startResolutionForResult(mgvcl11.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(mgvcl11.this, errorMessage, Toast.LENGTH_LONG).show();
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
    private void AddData() {
        boolean isInserted=mydb.insertData("agriculture",""+jsondata,0);
        if (isInserted=true){
            Toast.makeText(mgvcl11.this,"data is inserted",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(mgvcl11.this,"data is not inserted",Toast.LENGTH_LONG).show();
        }
        Intent i=new Intent(mgvcl11.this,MainActivity.class);
        startActivity(i);
    }
    private JSONObject buidJsonObject() throws JSONException {

        final JSONObject obj=new JSONObject();
        try {
            obj.put("a", s1);
            obj.put("b", s2);
            obj.put("c", s3);
            obj.put("d", s4);
            obj.put("e", s5);
            obj.put("f", s6);
            obj.put("g", s71);
            obj.put("h", s81);
            obj.put("i", s91);
            obj.put("i1", rs1);
            obj.put("i2", rs2);
            obj.put("i3", rs05);
            obj.put("i4", rs3);
            obj.put("i5",rs4);
            obj.put("i6", rs01);
            obj.put("i7a", rs02);
            obj.put("i7b", rs03);
            obj.put("i7c", rs03_1);
            obj.put("i8", rs11);
            obj.put("i9", rs21);
            obj.put("i10", rs31);
            obj.put("i11", rs41);
            obj.put("i12", rs51);
            obj.put("i13", rs12);
            obj.put("i14", rs23);
            obj.put("i15", rs33);
            obj.put("i16", rs14);
            obj.put("i17", rs15);
            obj.put("i18", rs16);
            obj.put("i19", rs17);
            obj.put("i20", rs18);
            obj.put("i21", rs19);
            obj.put("i22", rs20);
            obj.put("i23", rs210);
            obj.put("i24", rs22);
            obj.put("i25", rs230);
            obj.put("i26", rs240);
            obj.put("i27", rs25);
            obj.put("i28", rs26);
            obj.put("i29", rs27);
            obj.put("i30", rs28);
            obj.put("i31", rs29);
            obj.put("i32", rs30);
            obj.put("j",date);
            obj.put("k",location);
            obj.put("l","");
            obj.put("imei",IMEI_Number_Holder);
            obj.put("circle",CIRCLE_A);
            obj.put("div",DIV_A);
            obj.put("subdiv",SUB_A);
            Log.v("tag",obj.toString());
            jsondata=obj.toString();
            Log.d("tag", obj.toString());
            Log.d("jsondata", jsondata);
        } catch (JSONException e) {
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
        RequestQueue queue = Volley.newRequestQueue(mgvcl11.this);
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
                    Intent i=new Intent(mgvcl11.this,imgupload.class);
                    i.putExtra("table","agriculture");
                    i.putExtra("id",part.trim());
                    Log.v("id", ""+part);
                    Toast.makeText(mgvcl11.this,"POSTED",Toast.LENGTH_LONG).show();
                    startActivity(i);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
                String res=error.toString();
                if(!res.startsWith("done")){
                    AddData();
                    progressDialog.dismiss();
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
