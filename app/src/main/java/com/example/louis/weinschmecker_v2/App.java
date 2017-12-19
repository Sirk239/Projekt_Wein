package com.example.louis.weinschmecker_v2;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;

import com.example.louis.weinschmecker_v2.database.WineDatabase;

/**
 * Created by Betti on 19.12.17.
 */

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "MyDatabase";
    private static final String PREFERENCES = "Projekt_Wein.preferences";
    private static final String KEY_FORCE_UPDATE = "force_update";

    private WineDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // create database
        database = Room.databaseBuilder(getApplicationContext(), WineDatabase.class, DATABASE_NAME)
                .addMigrations(WineDatabase.MIGRATION_1_2)
                .build();

        INSTANCE = this;
    }

    public WineDatabase getDB() {
        return database;
    }

    public boolean isForceUpdate() {
        return getSP().getBoolean(KEY_FORCE_UPDATE, true);
    }

    public void setForceUpdate(boolean force) {
        SharedPreferences.Editor edit = getSP().edit();
        edit.putBoolean(KEY_FORCE_UPDATE, force);
        edit.apply();
    }

    private SharedPreferences getSP() {
        return getSharedPreferences(PREFERENCES, MODE_PRIVATE);
    }
}
