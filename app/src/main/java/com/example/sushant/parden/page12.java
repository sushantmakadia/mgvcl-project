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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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
import static com.example.sushant.parden.page1.s1;
import static com.example.sushant.parden.page1.s2;
import static com.example.sushant.parden.page1.s3;
import static com.example.sushant.parden.page1.s4;
import static com.example.sushant.parden.page1.s5;
import static com.example.sushant.parden.page1.s6;
import static com.example.sushant.parden.page1.s7;
import static com.example.sushant.parden.page10.sq24;
import static com.example.sushant.parden.page10.sq25;
import static com.example.sushant.parden.page10.sq26;
import static com.example.sushant.parden.page10.sq27;
import static com.example.sushant.parden.page11.sq28;
import static com.example.sushant.parden.page11.sq30;
import static com.example.sushant.parden.page11.sq31;
import static com.example.sushant.parden.page2.sq1;
import static com.example.sushant.parden.page2.sq2;
import static com.example.sushant.parden.page2.sq3;
import static com.example.sushant.parden.page2.sq4;
import static com.example.sushant.parden.page3.sq5;
import static com.example.sushant.parden.page3.sq6;
import static com.example.sushant.parden.page3.sq7;
import static com.example.sushant.parden.page4.sq8;
import static com.example.sushant.parden.page4.sq9;
import static com.example.sushant.parden.page5.sq10;
import static com.example.sushant.parden.page5.sq11;
import static com.example.sushant.parden.page5.sq12;
import static com.example.sushant.parden.page6.sq13;
import static com.example.sushant.parden.page6.sq131;
import static com.example.sushant.parden.page6.sq14;
import static com.example.sushant.parden.page7.sq15;
import static com.example.sushant.parden.page7.sq16;
import static com.example.sushant.parden.page7.sq17;
import static com.example.sushant.parden.page8.sq18;
import static com.example.sushant.parden.page8.sq19;
import static com.example.sushant.parden.page9.sq20;
import static com.example.sushant.parden.page9.sq21;
import static com.example.sushant.parden.page9.sq22;
import static com.example.sushant.parden.page9.sq23;

public class page12 extends AppCompatActivity {
    DatabaseHelper mydb;
    Button b1,b2;
    RadioGroup r1;
    EditText e1,e3,e4;
    RatingBar e2;
    LinearLayout l1;
    int temp3=-2;
    int x=0;
    ProgressDialog progressDialog ;
    public static String sq32,sq33,sq34,jsondata,date;
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
        setContentView(R.layout.activity_page12);
        progressDialog = new ProgressDialog(page12.this);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        date = df.format(Calendar.getInstance().getTime());
        l1=findViewById(R.id.l1);
        AnimationDrawable animationDrawable=(AnimationDrawable)l1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        init();
        // restore the values from saved instance state
        restoreValuesFromBundle(savedInstanceState);

        startLocationButtonClick();
        mydb =new DatabaseHelper(this);
        r1=findViewById(R.id.r32rg);
        e1=findViewById(R.id.r33et);
        e2=findViewById(R.id.r34et);
        b1=findViewById(R.id.rB23);
        b2=findViewById(R.id.rB24);

        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1=findViewById(checkedId);
                sq32=rb1.getText().toString();
                temp3=1;
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sq34= String.valueOf(e2.getRating());
                sq33=e1.getText().toString();

                if(temp3==-2) {
                    x=1;
                }
                else if(sq33.isEmpty()){
                    e1.setError("\"this field can't be empty");
                    x=1;}
                else if(sq34.isEmpty()){
                    x=1;}

                else {x=0;}
                if(x==0) {
                    try {
                        JSONObject jsonBody = buidJsonObject();
                        postdata("rural",jsonBody.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    submit();
                }
                else {
                    Toast.makeText(page12.this, "Answer Fields can't be empty.", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(page12.this, "data stored", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(page12.this,page11.class);
                startActivities(new Intent[]{intent});
            }
        });

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
                                    rae.startResolutionForResult(page12.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(page12.this, errorMessage, Toast.LENGTH_LONG).show();
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
        boolean isInserted=mydb.insertData("rural",""+jsondata,0);
        if (isInserted=true){
            Toast.makeText(page12.this,"data is inserted in sqlite",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(page12.this,"data is not inserted in sqlite",Toast.LENGTH_LONG).show();
        }
        Intent i=new Intent(page12.this,MainActivity.class);
        startActivity(i);
    }

    private JSONObject buidJsonObject() throws JSONException {

        JSONObject d1=new JSONObject();
        try {
            d1.put("a",s1);
            d1.put("b",s2);
            d1.put("c",s3);
            d1.put("d",s4);
            d1.put("e",s5);
            d1.put("f",s6);
            d1.put("g",s7);
            d1.put("g1",sq1);
            d1.put("g2",sq2);
            d1.put("g3",sq3);
            d1.put("g4",sq4);
            d1.put("g5",sq5);
            d1.put("g6",sq6);
            d1.put("g7",sq7);
            d1.put("g8",sq8);
            d1.put("g9",sq9);
            d1.put("g10",sq10);
            d1.put("g11",sq11);
            d1.put("g12",sq12);
            d1.put("g13a",sq13);
            d1.put("g13b",sq131);
            d1.put("g14",sq14);
            d1.put("g15",sq15);
            d1.put("g16",sq16);
            d1.put("g17",sq17);
            d1.put("g18",sq18);
            d1.put("g19",sq19);
            d1.put("g20",sq20);
            d1.put("g21",sq21);
            d1.put("g22",sq22);
            d1.put("g23",sq23);
            d1.put("g24",sq24);
            d1.put("g25",sq25);
            d1.put("g26",sq26);
            d1.put("g27",sq27);
            d1.put("g28",sq28);
            d1.put("g29",sq30);
            d1.put("g30",sq31);
            d1.put("g31",sq32);
            d1.put("g32",sq33);
            d1.put("g33",sq34);
            d1.put("h",date);
            d1.put("i",location);

            d1.put("j","");
            jsondata=d1.toString();
            Log.v("tag", d1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return d1;
    }
    public void postdata(final String fname, final String fdata) {
        progressDialog.setMessage(" data uploading....");
        progressDialog.setTitle("data Upload");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(page12.this);
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
                    Intent i=new Intent(page12.this,imgupload.class);
                    i.putExtra("table","rural");
                    i.putExtra("id",part.trim());
                    Log.v("id", ""+part);
                    Toast.makeText(page12.this,"POSTED",Toast.LENGTH_LONG).show();
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
