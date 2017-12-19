package com.example.louis.weinschmecker_v2;

/**
 * Created by Betti on 17.12.17.
 */

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    static void populateAsync(@NonNull final WineDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static void populateSync(@NonNull final WineDatabase db) { populateWithTestData(db);}

    private static WineEntity addWine(final WineDatabase db, WineEntity wineEntity){
        db.wineDao().insertAll(wineEntity);
        return wineEntity;
    }

    private static void populateWithTestData(WineDatabase db) {
        WineEntity wineEntity = new WineEntity();
        wineEntity.setScanID(42141204);
        wineEntity.setweinName("jjjj");
        wineEntity.setJahrgang("jjjj");
        wineEntity.setLand("jjjj");
        wineEntity.setPreis(10);
        wineEntity.setGeschmack("jjjj");
        wineEntity.setLaden("jjjj");
        wineEntity.setBewertungsZahl(3);
        wineEntity.setBild("jjjj");
        wineEntity.setContent("jjjj");
        wineEntity.setGemerkt(false);
        addWine(db, wineEntity);

        List<WineEntity> wineEntityList = db.wineDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + wineEntityList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WineDatabase mDb;

        PopulateDbAsync(WineDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }

}
