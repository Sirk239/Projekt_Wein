package com.example.louis.weinschmecker_v2;

/**
 * Created by Dirk on 12.12.2017.
 */
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WineEntity.class}, version = 1)
public abstract class WineDatabase extends RoomDatabase {

    public abstract WineDao wineDao();

}
