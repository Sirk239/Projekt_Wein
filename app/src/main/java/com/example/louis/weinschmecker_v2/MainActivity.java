package com.example.louis.weinschmecker_v2;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {


    private ZXingScannerView zXingScannerView;

    private static final String TAG = MainActivity.class.getName();


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



        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        SucheFrag sucheFrag = new SucheFrag();

        transaction.add(R.id.content, sucheFrag);
        transaction.commit();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Slide-Effekt weg
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();

        WineDatabase wineDatabase = Room.databaseBuilder(getApplicationContext(), WineDatabase.class, "wineDatebase").build();
        databaseInitializer.populateDatabase(wineDatabase);
    }

    public void onSelectFragment (View view) {

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
        //Datenbank
        protected void onDestroy(){
            WineDatabase.destroyInstance();
            super.onDestroy();
        }

}















