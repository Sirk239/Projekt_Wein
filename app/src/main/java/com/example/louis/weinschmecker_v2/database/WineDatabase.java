package com.example.louis.weinschmecker_v2.database;

/**
 * Created by Dirk on 12.12.2017.
 */
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;

import com.example.louis.weinschmecker_v2.App;
import com.example.louis.weinschmecker_v2.database.entity.WineEntity;


@Database(entities = {WineEntity.class}, version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class WineDatabase extends RoomDatabase {

    //private static WineDatabase INSTANCE;

    public abstract WineDao wineDao();

    public static final Migration MIGRATION_1_2 = new Migration(1,2){
        @Override
        public void migrate(SupportSQLiteDatabase database){
            database.execSQL("ALTER TABLE wineEntity "
            + "ADD COLUMN preis INTEGER");

            App.get().setForceUpdate(true);
        }
    };

}
