package com.example.louis.weinschmecker_v2.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.louis.weinschmecker_v2.database.entity.WineEntity;

import java.util.List;

/**
 * Created by Dirk on 13.12.2017.
 */


@Dao
public interface WineDao {

    @Query("SELECT * FROM wineEntity")
    List<WineEntity> getAll();

    @Query("SELECT * FROM wineEntity where scanID LIKE  :scanID")
    WineEntity findByID(int scanID);

    @Query("SELECT * FROM wineEntity WHERE preis BETWEEN :minPreis and :maxPreis")


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<WineEntity> wineEntities);

    @Update
    void update(WineEntity wineEntity);

    @Delete
    void delete(WineEntity wineEntity);


}
