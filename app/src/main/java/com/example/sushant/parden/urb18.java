package com.example.sushant.parden;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.sushant.parden.menu.sc;
import static com.example.sushant.parden.menu.sm;
import static com.example.sushant.parden.urb1.s1;
import static com.example.sushant.parden.urb1.s2;
import static com.example.sushant.parden.urb1.s3;
import static com.example.sushant.parden.urb1.s4;
import static com.example.sushant.parden.urb10.s30;
import static com.example.sushant.parden.urb10.s31;
import static com.example.sushant.parden.urb11.s32;
import static com.example.sushant.parden.urb11.s33;
import static com.example.sushant.parden.urb12.s34;
import static com.example.sushant.parden.urb12.s35;
import static com.example.sushant.parden.urb13.s36;
import static com.example.sushant.parden.urb13.s37;
import static com.example.sushant.parden.urb13.s38;
import static com.example.sushant.parden.urb14.s39;
import static com.example.sushant.parden.urb14.s40;
import static com.example.sushant.parden.urb14.s41;
import static com.example.sushant.parden.urb14.s42;
import static com.example.sushant.parden.urb15.s43;
import static com.example.sushant.parden.urb15.s44;
import static com.example.sushant.parden.urb15.s45;
import static com.example.sushant.parden.urb16.s46;
import static com.example.sushant.parden.urb16.s47;
import static com.example.sushant.parden.urb16.s48;
import static com.example.sushant.parden.urb17.s49;
import static com.example.sushant.parden.urb17.s50;
import static com.example.sushant.parden.urb17.s51;
import static com.example.sushant.parden.urb2.s5;
import static com.example.sushant.parden.urb2.s6;
import static com.example.sushant.parden.urb2.s7;
import static com.example.sushant.parden.urb3.s10;
import static com.example.sushant.parden.urb3.s8;
import static com.example.sushant.parden.urb3.s8_1;
import static com.example.sushant.parden.urb3.s8_2;
import static com.example.sushant.parden.urb3.s8_3;
import static com.example.sushant.parden.urb3.s9;
import static com.example.sushant.parden.urb4.s11;
import static com.example.sushant.parden.urb4.s12;
import static com.example.sushant.parden.urb4.s13;
import static com.example.sushant.parden.urb5.s14;
import static com.example.sushant.parden.urb5.s14_1;
import static com.example.sushant.parden.urb5.s15;
import static com.example.sushant.parden.urb5.s16;
import static com.example.sushant.parden.urb6.s17;
import static com.example.sushant.parden.urb6.s18;
import static com.example.sushant.parden.urb6.s19;
import static com.example.sushant.parden.urb7.s20;
import static com.example.sushant.parden.urb7.s21;
import static com.example.sushant.parden.urb7.s22;
import static com.example.sushant.parden.urb7.s23;
import static com.example.sushant.parden.urb8.s24;
import static com.example.sushant.parden.urb8.s25;
import static com.example.sushant.parden.urb8.s26;
import static com.example.sushant.parden.urb9.s27;
import static com.example.sushant.parden.urb9.s28;
import static com.example.sushant.parden.urb9.s29;

public class urb18 extends AppCompatActivity {
private Button b2,b1;
    DatabaseHelper mydb;
    public RadioGroup rg1;
    JSONObject obj;
    public EditText e1;
    public RatingBar e2;
    public RadioButton rb1;
    public static String s52,s53,s54,s55,s56,jsondata,date;
    ProgressDialog progressDialog ;
    int flag=0;
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
        setContentView(R.layout.activity_urb18);
        progressDialog = new ProgressDialog(urb18.this);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        date = df.format(Calendar.getInstance().getTime());
        mydb =new DatabaseHelper(this);
        s52=s53=s54=new String();
        init();
        // restore the values from saved instance state
        restoreValuesFromBundle(savedInstanceState);

        startLocationButtonClick();
        rg1=findViewById(R.id.urg52);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=(RadioButton) radioGroup.findViewById(i);
                s52=rb1.getText().toString();
            }
        }) ;
        e1=findViewById(R.id.uq53_1);


        e2=findViewById(R.id.uq54_1);

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s53=e1.getText().toString();
                s54= String.valueOf(e2.getRating());

                if(s52.isEmpty()){
                    flag=1;
                }
                else if(s53.isEmpty()){
                    flag=1;
                }
                else if(s54.isEmpty()){
                    flag=1;
                }

                else{
                    flag=0;
                }
                if (flag==0) {
                    try {
                        JSONObject jsonBody = buidJsonObject();
                        postdata("urban",jsonBody.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(urb18.this, "Answer field can't be empty", Toast.LENGTH_SHORT).show();
                }    }
        });
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(urb18.this,urb17.class);

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
                                    rae.startResolutionForResult(urb18.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(urb18.this, errorMessage, Toast.LENGTH_LONG).show();
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
        boolean isInserted=mydb.insertData("urban",""+jsondata,0);
        if (isInserted=true){
            Toast.makeText(this,"data is inserted",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"data is not inserted",Toast.LENGTH_LONG).show();
        }
        Intent i=new Intent(urb18.this,MainActivity.class);
        startActivity(i);
    }
    private JSONObject buidJsonObject() throws JSONException {

        JSONObject obj=new JSONObject();
        try {
            obj.put("a", sm[0]);
            obj.put("b", sm[1]);
            obj.put("c", sm[2]);
            obj.put("d", sm[3]);
            obj.put("e", sm[4]);
            obj.put("f", sm[5]);
            obj.put("g", sm[6]);
            obj.put("h", sc);
            obj.put("h1", s1);
            obj.put("h2", s2);
            obj.put("h3", s3);
            obj.put("h4", s4);
            obj.put("h5", s5);
            obj.put("h6", s6);
            obj.put("h7", s7);
            obj.put("h8", s8);
            obj.put("h9", s9);
            obj.put("h10", s10);
            obj.put("h11", s11);
            obj.put("h12", s12.replaceAll("/",""));
            obj.put("h13", s13);
            obj.put("h14a", s14);
            obj.put("h14b", s14_1);
            obj.put("h15", s15);
            obj.put("h16", s16);
            obj.put("h17", s17);
            obj.put("h18", s18);
            obj.put("h19", s19);
            obj.put("h20", s20);
            obj.put("h21", s21);
            obj.put("h22", s22.replaceAll("/",""));
            obj.put("h23", s23);
            obj.put("h24", s24);
            obj.put("h25", s25);
            obj.put("h26", s26.replaceAll("/",""));
            obj.put("h27", s27);
            obj.put("h28", s28.replaceAll("/",""));
            obj.put("h29", s29);
            obj.put("h30", s30);
            obj.put("h31", s31);
            obj.put("h32", s32);
            obj.put("h33", s33);
            obj.put("h34", s34);
            obj.put("h35", s35);
            obj.put("h36", s36);
            obj.put("h37", s37);
            obj.put("h38", s38);
            obj.put("h39", s39);
            obj.put("h40", s40);
            obj.put("h41", s41);
            obj.put("h42", s42);
            obj.put("h43", s43);
            obj.put("h44", s44);
            obj.put("h45", s45);
            obj.put("h46", s46);
            obj.put("h47", s47);
            obj.put("h48", s48);
            obj.put("h49", s49.replaceAll("/",""));
            obj.put("h50", s50);
            obj.put("h51", s51);
            obj.put("h52", s52);
            obj.put("h53", s53);
            obj.put("h54", s54);
            obj.put("i", date);
            obj.put("j", location);
            obj.put("k","");
            jsondata=obj.toString();
            Log.v("tag", obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void postdata(final String fname, final String fdata) {
        RequestQueue queue = Volley.newRequestQueue(urb18.this);
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
                    Intent i=new Intent(urb18.this,imgupload.class);
                    i.putExtra("table","urban");
                    i.putExtra("id",part.trim());
                    Log.v("id", ""+part);
                    Toast.makeText(urb18.this,"POSTED",Toast.LENGTH_LONG).show();
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
