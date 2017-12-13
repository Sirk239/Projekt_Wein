package com.example.louis.weinschmecker_v2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Dirk on 13.12.2017.
 */

@Dao
public interface WineDao {

    @Query("SELECT * FROM wine")
    List<WineEntity> getAll();

    @Insert
    void insertAll(List<WineEntity> wineEntities);



}
