package com.example.ahmed.pfeapp;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import android.content.Intent;
import android.provider.Settings;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;


import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static android.graphics.Color.GRAY;
import static com.example.ahmed.pfeapp.R.id.map;
import static com.example.ahmed.pfeapp.R.id.never;

public class FirstFragment extends FragmentActivity implements OnMapReadyCallback {
    int n;
    int strokeColor = 0xffff0000; //pour indoor
    int shadeColor = 0x44ff0000; //pour indoor
    int outdoor1 =0x4000ff00;

    ImageButton loc ;

    private Circle mCircle;
    private Marker mMarker;
    private GoogleMap mMap;

    private static final LatLng Tunisie = new LatLng(33.8376761,10.6337907);

//      http://192.168.43.111/android/get_all_zones.php

    // liste JSONArray
    JSONArray liste_zones = null;
    private ProgressDialog pDialog;
    private static final String URL_LISTE_ZONES = "http://192.168.1.4/android/get_all_zones.php";
    private static final String TAG_SUCCESS = "SUCCESS";
    private static final String TAG_MESSAGE = "MESSAGE";
    private static final String TAG_LISTE = "ZONES";
    private static final String TAG_ID = "id";
    private static final String TAG_ALTITUDE = "altitude";
    private static final String TAG_LONGITUDE = "longitude";
    private static final String TAG_RADIUS1 = "radius1";
    private static final String TAG_RADIUS2 = "radius2";

    LatLng myLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);



    }


    public void mapclick(View v)
    {
        switch (v.getId())
        {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }

    public void open(View v)
    {
        switch (v.getId()) {
        case R.id.gps:
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);
            break;
        }
    }

    public void buttonClicked(View v) {

        switch (v.getId()) {
            case R.id.markers:
                // recuperer zones in Background Thread
                new ListZonesAsync().execute();
            break;
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tunisie, 6));

        if(mMap != null) {
            mMap.setOnMyLocationChangeListener
                    (new GoogleMap.OnMyLocationChangeListener() {
                        @Override

                        public void onMyLocationChange(Location location) {

                            //récupérer ma position courante
                            myLocation = new LatLng(location.getLatitude(), location.getLongitude());

                        }
                    });
        }
    }
    //async arriere plan pour récuperer zones
    class ListZonesAsync extends AsyncTask<String, String, JSONObject> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        JSONParser jsonParser = new JSONParser();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(FirstFragment.this);
            pDialog.setMessage("Récuperer ZONES ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        protected JSONObject doInBackground(String... args) {
            JSONObject json = null;
            try {
                HashMap<String, String> params = new HashMap<>();
                json = jsonParser.makeHttpRequest(URL_LISTE_ZONES, "GET", params);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return json;
        }

        protected void onPostExecute(JSONObject json) {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }

            try {
                if (json != null) {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        liste_zones = json.getJSONArray(TAG_LISTE);
                        Log.v("onPostExecute", "Success");
                        // looping through All zones
                        for (int i = 0; i < liste_zones.length(); i++) {
                            JSONObject c = liste_zones.getJSONObject(i);
                            Log.v("onPostExecute", "getJSONObject Success");
                            // Storing each json item in variable
                            int id = c.getInt(TAG_ID);
                            double altitude = c.getDouble(TAG_ALTITUDE);
                            double longitude = c.getDouble(TAG_LONGITUDE);
                            final double radius1 = c.getDouble(TAG_RADIUS1);
                            double radius2 = c.getDouble(TAG_RADIUS2);
                            Log.v("onPostExecute", "getJSONObject =  " + String.valueOf(altitude) + "  - " + String.valueOf(longitude) + "  - ");

                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(Double.valueOf(altitude), Double.valueOf(longitude)))
                                    .title(Double.valueOf(altitude).toString() + "," + Double.valueOf(longitude).toString()));

                            final CircleOptions circleOption = new CircleOptions()
                                    .center(new LatLng(Double.valueOf(altitude), Double.valueOf(longitude)));
                            circleOption.radius(radius1); // In meters
                            circleOption.strokeWidth(2);
                            circleOption.strokeColor(strokeColor);
                            circleOption.fillColor(shadeColor);
                            mMap.addCircle(circleOption);

                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(Double.valueOf(altitude), Double.valueOf(longitude)))
                                    .title(Double.valueOf(altitude).toString() + "," + Double.valueOf(longitude).toString()));

                            final CircleOptions circleOptions = new CircleOptions()
                                    .center(new LatLng(Double.valueOf(altitude), Double.valueOf(longitude)));
                            circleOptions.strokeWidth(2);
                            circleOptions.strokeColor(strokeColor);
                            circleOptions.fillColor(shadeColor);
                            circleOptions.radius(radius2); // In meters
                            mMap.addCircle(circleOptions);

                            float[] distance = new float[2];

                            Location.distanceBetween(myLocation.latitude, myLocation.longitude, circleOption.getCenter().latitude, circleOption.getCenter().longitude, distance);
                            Location.distanceBetween(myLocation.latitude, myLocation.longitude, circleOptions.getCenter().latitude, circleOptions.getCenter().longitude, distance);

                            if (distance[0] > circleOptions.getRadius() && distance[0] > circleOption.getRadius()) {



                            } else if (distance[0] < circleOptions.getRadius() && (distance[0] < circleOption.getRadius())) {
                            //    Toast.makeText(getBaseContext(), " OUTDOOR , Félicitation Zone est éligible , vous pouvez utiliser le Fixe jdid. Rendez-vous à la boutique la plus proche et l'acheté , the distance from the center of the circle is: " + distance[0] + circleOptions.getRadius(), Toast.LENGTH_LONG).show();

                                NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                Intent intent = new Intent(getApplication(), Ma_boutique.class);
                                PendingIntent pintent = PendingIntent.getActivities(getApplication(), (int) System.currentTimeMillis(), new Intent[]{intent}, 0);

                                Notification notif = new Notification.Builder(getApplication())
                                        .setSmallIcon(R.drawable.android_app)
                                        .setContentTitle("Félicitation")
                                       .setContentText("Indoor , Votre Zone est éligible , Vous pouvez utilisé le Fix E Jdid")
                                        .setContentIntent(pintent)
                                        .getNotification();
                                notificationmanager.notify(0, notif);
                                Log.v("notif tekhdem", "notif Success");

                            } else if (distance[0] < circleOptions.getRadius() && (distance[0] > circleOption.getRadius())){
                            //    Toast.makeText(getBaseContext(), " INDOOR ,  Félicitation Zone est éligible , vous pouvez utiliser le Fixe jdid. Rendez-vous à la boutique la plus proche et l'acheté , the distance from the center of the circle is: " + distance[0] + circleOptions.getRadius(), Toast.LENGTH_LONG).show();
                                NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                Intent intent = new Intent(getApplication(), Ma_boutique.class);
                                PendingIntent pintent = PendingIntent.getActivities(getApplication(), (int) System.currentTimeMillis(), new Intent[]{intent}, 0);
                                // notification

                                Notification notif = new Notification.Builder(getApplication())
                                        .setSmallIcon(R.drawable.android_app)
                                        .setContentTitle("Félicitation ")
                                        .setContentText("Outdoor,Votre Zone est éligible , Vous pouvez utilisé le Fix E Jdid , " +
                                                "Ouvrez la liste du boutique , trouvez la bouqtique la plus proche et et Achetez fix jdid Outdoor")
                                        .setContentIntent(pintent)
                                        .getNotification();
                                notificationmanager.notify(0, notif);
                            }
                        }
                    }
                } else {
                    Toast.makeText(FirstFragment.this, "Liste Zones non disponibles.", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                    e.printStackTrace();
            }
        }
    }
}
// LatLng Lac 2 -- 36.8318461,10.2111016
//Tbourba ---  36.8281174, 9.8912185
