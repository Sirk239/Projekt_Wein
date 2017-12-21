package com.example.louis.weinschmecker_v2;

/**
 * Created by Betti on 17.12.17.
 */

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    private WineDao mWineDao;

    private static WineEntity addWine(final WineDatabase db, WineEntity wineEntity) {
        db.wineDao().insert(wineEntity);
        return wineEntity;
    }

    private List<WineEntity> populateWithTestData() {
        List<WineEntity> wineEntities = new ArrayList<>();
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
        wineEntities.add(wineEntity);

        return wineEntities;
    }


    public void populateDatabase(WineDatabase wineDatabase) {

        mWineDao = wineDatabase.wineDao();
        final List<WineEntity> wineEntities = populateWithTestData();

        PopulateWineTask populateWineTask = new PopulateWineTask();
        populateWineTask.execute(wineEntities);

    }

    public void insertWineEntities(List<WineEntity> wineEntities){
       mWineDao.insertAll(wineEntities);
    }

    private class PopulateWineTask extends AsyncTask<ArrayList<WineEntity>, WineEntity, List<WineEntity>> {

        

        @Override
        protected List<WineEntity> doInBackground(ArrayList<WineEntity>[] arrayLists) {
            arrayLists[0].
            return null;
        }
    }

}
