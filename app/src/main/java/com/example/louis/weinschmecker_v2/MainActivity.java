package com.example.louis.weinschmecker_v2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.louis.weinschmecker_v2.database.entity.WineEntity;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


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

        //Datenbank
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<WineEntity> wineEntities = App.get().getDB().wineDao().getAll();
                boolean force = App.get().isForceUpdate();
                if (force || wineEntities.isEmpty()) {
                    retrieveWineEntities();
                } else {
                    populateWineEntities(wineEntities);
                }
            }
        }).start();

    }

    private void retrieveWineEntities() {
        List<WineEntity> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            WineEntity wineEntity = new WineEntity();
            wineEntity.setweinName("WineEntity {String.valueOf(i)}");
            wineEntity.setBild("http://lorempixel.com/500/500/technics/" + i);
            wineEntity.setPreis(i == 0 ? 50 : i * 100);
            list.add(wineEntity);
        }

        // insert product list into database
        App.get().getDB().wineDao().insertAll(list);

        // disable flag for force update
        App.get().setForceUpdate(false);

        populateWineEntities(list);
    }

    private void populateWineEntities(final List<WineEntity> wineEntities) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(new WineAdapter(wineEntities));
            }
        });
    }

    /**@Override
    protected void onStart() {
        super.onStart();
        List <WineEntity> wineEntities = new ArrayList();

        WineEntity entity = new WineEntity();
        //entity.scanID; //muss noch integriert werden
        wineEntities.add(entity);

        WineDatabase wineDatabase = Room.databaseBuilder(getApplicationContext(), WineDatabase.class, "wineDatebase").build();
        wineDatabase.wineDao().insertAll((WineEntity) wineEntities);
    }*/



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

}















