package com.example.louis.weinschmecker_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by louis on 29.11.2017.
 */
//Quelle: https://www.youtube.com/watch?v=cp2rL3sAFmI



public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME ="Wein.db";
    public static final String TABLE_NAME ="wein_table";
    //Spalten der Tabelle
    public static final String Col_1 ="ID";
    public static final String COL_2 ="NAME";
    public static final String COL_3 ="JAHRGANG";
    public static final String COL_4 ="LAND";
    public static final String COL_5 ="PREIS";
    public static final String COL_6 ="RICHTUNG";
    public static final String COL_7 ="ART";
    public static final String COL_8 ="LADEN";
    public static final String COL_9 ="SERVIERVORSCHLAG";
    public static final String COL_10 ="BEWERTUNGTEXT";
    public static final String COL_11 ="BEWERTUNGZAHL";
    public static final String COL_12 ="BILD";
    public static final String COL_13 ="CONTENT";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,JAHRGANG TEXT,LAND TEXT,PREIS INTEGER,RICHTUNG TEXT,ART TEXT,LADEN TEXT,SERVIERVORSCHLAG TEXT,BEWERTUNGTEXT TEXT,BEWERTUNGZAHL INTEGER,CONTENT TEXT,BILD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
