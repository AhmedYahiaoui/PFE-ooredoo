package com.example.ahmed.pfeapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Ahmed on 10/04/2017.
 */

public class for_frag_aide extends AppCompatActivity {

    FloatingActionButton fab_plus, fab_nav, fab_fb, fab_twitte, fab_insta, fab_call;
    Animation fabopen, fabclose, fabclockwise, fabanticlockwise;
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_layout);

        //les buttons que on a besion de l'afficher

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_fb = (FloatingActionButton) findViewById(R.id.fab_fb);
        fab_twitte = (FloatingActionButton) findViewById(R.id.fab_twitte);
        fab_insta = (FloatingActionButton) findViewById(R.id.fab_insta);
        fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        fab_nav = (FloatingActionButton) findViewById(R.id.fab_nav);
        //les animations du bouttons

        fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fabclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation_clock);
        fabanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation_anticlock);
        fab_plus.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (isopen) {
                    fab_fb.startAnimation(fabclose);
                    fab_twitte.startAnimation(fabclose);
                    fab_insta.startAnimation(fabclose);
                    fab_nav.startAnimation(fabclose);
                    fab_call.startAnimation(fabclose);
                    fab_plus.startAnimation(fabanticlockwise);

                    fab_fb.setClickable(false);
                    fab_twitte.setClickable(false);
                    fab_insta.setClickable(false);
                    fab_call.setClickable(false);
                    fab_nav.setClickable(false);
                    isopen = false;
                } else {

                    fab_fb.startAnimation(fabopen);
                    fab_twitte.startAnimation(fabopen);
                    fab_insta.startAnimation(fabopen);
                    fab_nav.startAnimation(fabopen);
                    fab_call.startAnimation(fabopen);
                    fab_plus.startAnimation(fabclockwise);

                    fab_fb.setClickable(true);
                    fab_twitte.setClickable(true);
                    fab_insta.setClickable(true);
                    fab_nav.setClickable(true);
                    fab_call.setClickable(true);
                    isopen = true;

                }
            }
        });

        fab_fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent facebookIntent = getOpenfacebookIntent(for_frag_aide.this);
                startActivity(facebookIntent);
            }
        });


        fab_twitte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent twitterIntent = getOpentwitterIntent(for_frag_aide.this);
                startActivity(twitterIntent);
            }
        });


        fab_insta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent instaIntent = getOpeninstaIntent(for_frag_aide.this);
                startActivity(instaIntent);
            }
        });


        fab_nav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent navIntent = getOpennavIntent(for_frag_aide.this);
                startActivity(navIntent);
            }
        });


        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:123"));
                if (ActivityCompat.checkSelfPermission(getApplication(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

    public static Intent getOpenfacebookIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);//faire un check si fb est installer ou nn
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ooredootn/?fref=ts"));//essai de faire un intent avec fb
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/Ahmed.yahiaoui"));//ouvrir l url
        }
    }

    public static Intent getOpentwitterIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.twitter.android", 0);//faire un check si fb est installer ou nn
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ooredootn"));//essai de faire un intent avec fb
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ooredootn"));//ouvrir l url
        }
    }

    public static Intent getOpeninstaIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.instagram.android", 0);//faire un check si fb est installer ou nn
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ooredootn"));//essai de faire un intent avec fb
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ooredootn"));//ouvrir l url
        }
    }

    public static Intent getOpennavIntent(Context context) {
        try {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("http://ooredoo.tn"));//essai de faire un intent avec fb
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("http://ooredoo.tn"));//ouvrir l url
        }
    }


    public Intent getOpencallOIntent(Context context) {

        Intent getOpencallIntent = new Intent(Intent.ACTION_CALL);
        getOpencallIntent.setData(Uri.parse("tel:123"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        }
        startActivity(getOpencallIntent);
        return getOpencallIntent;

    }
}