package com.example.lenovo.preghelp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import static com.example.lenovo.preghelp.MainActivity.MY_PERMISSIONS_REQUEST_LOCATION;

public class alert extends Activity {
    String longitude;
    String latitude;
    String[] Phone_num = new String[3];
    private String provider = "network";
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        TextView[] Station_view = new TextView[3];
        Station_view[0] = (TextView) findViewById(R.id.Station1);
        Station_view[1] = (TextView) findViewById(R.id.Station2);
        Station_view[2] = (TextView) findViewById(R.id.Station3);



        try {

            //sleep 5 seconds
            Thread.sleep(2000);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Station_view[0].setText("Name : " + "Poonam Hospital" + "\nRating : " + "4" + "\nAddress " + "Kaushambi Road, Near SBI, Jhalwa, Allahabad");


        Station_view[1].setText("Name : " + "Ayan Hospital" + "\nRating : " + "4" + "\nAddress " + "B-46, Sola Market, Opposite Mehbooba Palace, GTB Nagar, Kareli, Allahabad");


        Station_view[2].setText("Name : " + "Narayan Swaroop Hospital" + "\nRating : " + "3.1" + "\nAddress " + "A-8/3, Opp. Mundera Mandi, Dharambir Marg, Transport Nagar, Allahabad");



      /*  Location location = null;
//        while(location == null) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        boolean isNetworkEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
        boolean isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // The minimum time between updates in milliseconds
        long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

        if (isNetworkEnabled) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,//                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            Log.d("Network", "Network");
            if (locationManager != null) {
                location = locationManager
                        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (location != null) {
                    onLocationChanged(location);
                }
            }
        }
        Log.d("Debug","CAME HERE BETWEEN");



        int radius = 500;
        int station_num = 0;
        while(true) {
            radius *= 10;
            try {
                //replace location=...,... with your actual latitude and longitude
                Log.d("Debug","Latitue here : "+latitude+"Long here : "+longitude);
                URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=25.430637,81.770691&type=hospital&radius=5000&keyword=hospital&key=AIzaSyA48MwoYxinYJYY0lnldmmObddPQ4ec9IM");
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection connection = null;
                if (urlConnection instanceof HttpURLConnection) {
                    connection = (HttpURLConnection) urlConnection;
                } else {
                    System.out.println("Please enter an HTTP URL.");
                    return;
                }

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String urlString = "";
                String current;

                while ((current = in.readLine()) != null) {
                    urlString += current;
                }
                JSONObject obj = new JSONObject(urlString);
                JSONArray results = obj.getJSONArray("results");
                if(results.length()==0){
                    if(radius==500000){
                        System.out.println("No police stations nearby");
                        break;
                    }else
                        continue;
                }
                for (int i = 0; i < results.length(); i++) {
                    JSONObject res = results.getJSONObject(i);
                    String name = res.getString("name");
                    String place_id = res.getString("place_id");
                    System.out.println(name);

                    try {
                        url = new URL("https://maps.googleapis.com/maps/api/place/details/json?placeid=" + place_id + "&key=AIzaSyA48MwoYxinYJYY0lnldmmObddPQ4ec9IM");
                        urlConnection = url.openConnection();
                        connection = null;
                        if (urlConnection instanceof HttpURLConnection) {
                            connection = (HttpURLConnection) urlConnection;
                            in = new BufferedReader(
                                    new InputStreamReader(connection.getInputStream()));
                            urlString = "";
                            while ((current = in.readLine()) != null) {
                                urlString += current;
                            }
                            JSONObject station = new JSONObject(urlString).getJSONObject("result");
                            try {

                                if (station_num == 0) {
                                    Station_view[station_num].setText("Address = " + "Jhalwa" + "\nPhone Number = " + "7838673020");
                                    Phone_num[station_num] = "7838673020";
                                    station_num++;

                                }
                                else {

                                    String number = station.getString("formatted_phone_number");
                                    String addr = station.getString("formatted_address");
                                    Station_view[station_num].setText("Address = " + addr + "\nPhone Number = " + number);
                                    Phone_num[station_num] = number;
                                    station_num++;
                                    Log.d("Debug","Address = " + addr + "\nPhone Number = " + number + "\n");
                                    if(station_num==3){break;}
                                }



                            } catch (org.json.JSONException e) {
                                System.out.println("Unable to get phone number and/or address\n");
                            }
                        } else {
                            System.out.println("Please enter an HTTP URL.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(station_num==3){break;}
                break;
                //System.out.println(urlString);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates((LocationListener)this);
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = (double) (location.getLatitude());
        double lng = (double) (location.getLongitude());
        latitude = String.valueOf(lat);
        longitude = String.valueOf(lng);
        Log.d("Debug", "onLocationChanged");
        Log.d("Debug", " ==latitude " + latitude + ", longitude" + longitude + " ==");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
                        locationManager.requestLocationUpdates(provider, 400, 1, this);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
            }
        }
    }

    /* Request updates at startup */
  /*  @Override
    protected void onResume() {
        super.onResume();
        if (checkLocationPermission()) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {

                //Request location updates:
                locationManager.requestLocationUpdates(provider, 400, 1, this);
            }
        }
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Title Location Permission")
                        .setMessage("Anjaneya needs to access your location information")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(alert.this,
                                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }*/


    }
}

