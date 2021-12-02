package com.example.ahmed.pfeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class frag_map extends Fragment {

    ImageButton b;
    ImageButton c;
    ImageButton d;
    ImageButton e;

    public frag_map() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.for_frag_maps, container, false);


        b = (ImageButton) rootView.findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FirstFragment.class);
                startActivity(intent);
            }
        });


        c = (ImageButton) rootView.findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Ma_boutique.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

