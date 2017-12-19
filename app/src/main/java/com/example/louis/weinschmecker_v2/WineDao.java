package com.example.louis.weinschmecker_v2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Dirk on 13.12.2017.
 */

/*HALLO12*/

@Dao
public interface WineDao {

    @Query("SELECT * FROM wein")
    List<WineEntity> getAll();

    @Query("SELECT * FROM wein where scanID LIKE  :scanID")
    WineEntity findByID(int scanID);

    @Query("SELECT * FROM wein WHERE preis BETWEEN :minPreis and :maxPreis")


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(WineEntity...wineEntities);

    @Delete
    void delete(WineEntity wineEntity);


}
