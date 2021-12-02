package com.example.ahmed.pfeapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;


public class frag_aide extends Fragment {
    Button button1;
    WebView web1;
    WebView web2;
    WebView web3;
    WebView web4;
        public frag_aide() {
            // Required empty public constructor
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.aide, container, false);

        button1 =(Button)rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(),for_frag_aide.class);
                startActivity(myIntent);
            }
        });

        web1=(WebView)rootView.findViewById(R.id.web1);
        web1.loadUrl("file:///android_asset/tes.html");

        web2=(WebView)rootView.findViewById(R.id.web2);
        web2.loadUrl("file:///android_asset/propros.html");

        web3=(WebView)rootView.findViewById(R.id.web3);
        web3.loadUrl("file:///android_asset/eligiblee.html");

        web4=(WebView)rootView.findViewById(R.id.web4);
        web4.loadUrl("file:///android_asset/boutique.html");


        return rootView;
    }
}