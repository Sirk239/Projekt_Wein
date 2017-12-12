package com.example.louis.weinschmecker_v2;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.google.zxing.Result;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission_group.CAMERA;
import static java.util.logging.Level.parse;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private ZXingScannerView zXingScannerView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.navigation_suche:
                    SucheFrag sucheFrag = new SucheFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, sucheFrag,
                            sucheFrag.getTag()).commit();
                    return true;

                case R.id.navigation_scan:
                    ScanFrag barcode_frag = new ScanFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, barcode_frag, barcode_frag.getTag()).commit();
                    return true;

                case R.id.navigation_weinstyle:
                    WeinstyleFrag weinstyleFrag = new WeinstyleFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, weinstyleFrag, weinstyleFrag.getTag()).commit();
                    return true;

                case R.id.navigation_weinregal:
                    WeinregalFrag weinregalFrag = new WeinregalFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, weinregalFrag, weinregalFrag.getTag()).commit();

                    return true;

            }


            return false;
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Datenbank
        myDb = new DatabaseHelper(this);

      /*  FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        FragmentEinstellungen fragmentEinstellungen = new FragmentEinstellungen();

        transaction.add(R.id.content, fragmentEinstellungen);
        transaction.commit();

        /*Logo in Action Bar integrieren
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.logo_white_margin);*/



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    }






    public void onSelectFragment (View view){

        Fragment newFragment;

        if (view == findViewById(R.id.btnSettings)) {
            newFragment = new FragmentEinstellungen();


        } else {
            newFragment = new FragmentEinstellungen();

        }


        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}















