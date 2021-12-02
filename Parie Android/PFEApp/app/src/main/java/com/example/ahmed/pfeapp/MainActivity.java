package com.example.ahmed.pfeapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener{



    private ResideMenu resideMenu;
    private ResideMenuItem ItemHome;
    private ResideMenuItem ItemAide;
    private ResideMenuItem ItemMap;
    private ResideMenuItem ItemPropos;
    private ResideMenuItem ItemProfile;
    private ResideMenuItem Itemquit;

    private Context nContext;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nContext = this;

        SetUpMenu();
        if(savedInstanceState == null){
            changeFragment(new frag_home());
        }

    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("voulez vous fermer l'Application");
        builder.setCancelable(true);
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }


    private void SetUpMenu() {

//l'activité courant - le traitement sera insatller ici
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.ooredoo_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        //we will know( les parametre de menu)
        resideMenu.setScaleValue(0.6f);

        // add menu (ajout menu items)
        ItemHome = new ResideMenuItem(this, R.drawable.home, "Accueil ");
        ItemMap = new ResideMenuItem(this, R.drawable.mapp, "Map");
        ItemAide = new ResideMenuItem(this, R.drawable.keep, "Aide");
        ItemPropos = new ResideMenuItem(this, R.drawable.dropbox, "A Propos");
        ItemProfile =new  ResideMenuItem(this,R.drawable.businessman,"Mon compte");
        Itemquit =new  ResideMenuItem(this,R.drawable.power,"Exit");

        ItemHome.setOnClickListener(this);
        ItemMap.setOnClickListener(this);
        ItemAide.setOnClickListener(this);
        ItemPropos.setOnClickListener(this);
        ItemProfile.setOnClickListener(this);
        Itemquit.setOnClickListener(this);

        resideMenu.addMenuItem(ItemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(ItemProfile, ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(ItemMap, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(ItemAide, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(ItemPropos, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(Itemquit, ResideMenu.DIRECTION_RIGHT);


        // a lot of others thing i will write them later
        // wait;

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });

    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(nContext, "Menu est overte", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(nContext, "Menu est fermé", Toast.LENGTH_SHORT).show();
        }
    };

    @Override

    public void onClick(View v) {
        if (v == ItemHome) {
            changeFragment(new frag_home());
        }
        else if (v==ItemAide){
            changeFragment(new frag_aide());
        }

        else if (v==ItemMap){
            changeFragment(new frag_map ());
        }

        else if (v==ItemPropos){
            changeFragment(new frag_apropos());
        }
        else if (v==ItemProfile){
            changeFragment(new profile());
        }
        else if (v==Itemquit){
            finish();

        }
        resideMenu.closeMenu();

    }

    private void changeFragment(Fragment tragetfragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment,tragetfragment,"fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}

