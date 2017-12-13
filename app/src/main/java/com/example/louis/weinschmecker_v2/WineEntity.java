package com.example.louis.weinschmecker_v2;

/**
 * Created by Dirk on 12.12.2017.
 */
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class WineEntity {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name="scanID")
    public int scanID;




}
