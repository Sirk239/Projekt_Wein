package com.example.louis.weinschmecker_v2;

/**
 * Created by Dirk on 12.12.2017.
 */
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Room;
import android.content.Context;

@Database(entities = {WineEntity.class}, version = 1)
public abstract class WineDatabase extends RoomDatabase {

    private static WineDatabase INSTANCE;

    public abstract WineDao wineDao();

    public static WineDatabase getWineDatabase(Context context){
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WineDatabase.class, "wine-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
