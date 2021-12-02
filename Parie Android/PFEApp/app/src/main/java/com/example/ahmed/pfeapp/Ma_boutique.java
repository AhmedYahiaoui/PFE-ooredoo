package com.example.ahmed.pfeapp;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ma_boutique extends FragmentActivity implements OnMapReadyCallback {
    private static final LatLng Tunisie = new LatLng(33.8376761,10.6337907);
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_boutique);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

public void mapclick(View v)
    {switch (v.getId())
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
    {switch (v.getId()) {
        case R.id.gps:

            LatLng B1 = new LatLng(36.0806509, 9.3725707);LatLng B15 = new LatLng(34.747008, 10.766178);LatLng B8 = new LatLng(36.903293, 10.302768);
            LatLng B2= new LatLng(36.0807509, 9.3725707); LatLng B14 = new LatLng(34.416898, 8.791018);LatLng B9 = new LatLng(36.098072, 9.460565);
            LatLng B3 = new LatLng(36.7959627, 10.1176238);LatLng B13 = new LatLng(34.942919, 8.565511);LatLng B7 = new LatLng(36.865674, 10.169013);
            LatLng B4 = new LatLng(36.811751, 10.076040); LatLng B12 = new LatLng(35.235372, 9.119588);LatLng B10 = new LatLng(35.678448, 10.092533);
            LatLng B5 = new LatLng(36.805618, 10.176281);LatLng B11 = new LatLng(35.174670, 8.806639);LatLng B6 = new LatLng(36.809848, 10.129514);
            LatLng B0 = new LatLng(36.848331, 10.268308);


            //declarer l'icone pour la boutique
            int height = 37;
            int width = 37;
            BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.shop);
            Bitmap b=bitmapdraw.getBitmap();
            Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

            //declarer l'icone du siege du ooredoo

            int h = 40;
            int w = 40;
            BitmapDrawable bitmapa=(BitmapDrawable)getResources().getDrawable(R.drawable.siege);
            Bitmap bi=bitmapa.getBitmap();
            Bitmap small = Bitmap.createScaledBitmap(bi, w, h, false);


            Marker b0 = mMap.addMarker(new MarkerOptions().position(B0).icon(BitmapDescriptorFactory.fromBitmap(small)));
                  mMap.moveCamera(CameraUpdateFactory.newLatLng(B0));
                  mMap.animateCamera(CameraUpdateFactory.newLatLng(B0));
            Marker b1 = mMap.addMarker(new MarkerOptions().position(B1).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
                //   mMap.moveCamera(CameraUpdateFactory.newLatLng(B1));
                 //  mMap.animateCamera(CameraUpdateFactory.newLatLng(B1));
            Marker b2 = mMap.addMarker(new MarkerOptions().position(B2).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b3 = mMap.addMarker(new MarkerOptions().position(B3).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b4 = mMap.addMarker(new MarkerOptions().position(B4).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b5 = mMap.addMarker(new MarkerOptions().position(B5).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b6 = mMap.addMarker(new MarkerOptions().position(B6).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b7 = mMap.addMarker(new MarkerOptions().position(B7).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b8 = mMap.addMarker(new MarkerOptions().position(B8).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b9 = mMap.addMarker(new MarkerOptions().position(B9).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b10 = mMap.addMarker(new MarkerOptions().position(B10).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b11 = mMap.addMarker(new MarkerOptions().position(B11).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b12 = mMap.addMarker(new MarkerOptions().position(B12).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b13 = mMap.addMarker(new MarkerOptions().position(B13).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b14 = mMap.addMarker(new MarkerOptions().position(B14).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
            Marker b15 = mMap.addMarker(new MarkerOptions().position(B15).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            mMap.setMyLocationEnabled(true);
            break;
    }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tunisie, 6));
        mMap.getUiSettings().setZoomControlsEnabled(false);
    }
}
