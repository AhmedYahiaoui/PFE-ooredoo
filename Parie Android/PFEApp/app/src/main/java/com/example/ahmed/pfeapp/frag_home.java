package com.example.ahmed.pfeapp;

/**
 * Created by Ahmed on 22/02/2017.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;


public class frag_home extends Fragment {
    WebView web1;
    ImageView im1;
    ImageView im2;

    public frag_home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=  inflater.inflate(R.layout.home, container, false);

        web1=(WebView)rootView.findViewById(R.id.web1);
        web1.loadUrl("file:///android_asset/cloud.html");

        im1 = (ImageView)rootView.findViewById(R.id.im1);
        im1.setClickable(false);

        im1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://assistance.ooredoo.tn/"));
                startActivity(intent);
            }

        });


        im2 = (ImageView)rootView.findViewById(R.id.im2);
        im2.setClickable(false);

        im2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.ooredoo.tn/institutionnel/evenements"));
                startActivity(intent);
            }

        });


        return rootView;

        }

    }


