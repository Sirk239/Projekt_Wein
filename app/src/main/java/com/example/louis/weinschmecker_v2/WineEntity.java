package com.example.louis.weinschmecker_v2;

/**
 * Created by Dirk on 12.12.2017.
 */
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName="wein")
public class WineEntity {

    @PrimaryKey(autoGenerate=true)
    private int uid;

    @ColumnInfo(name="scanID")
    public int scanID;

    @ColumnInfo(name="weinName")
    public String weinName;

    @ColumnInfo(name="jahrgang")
    public String jahrgang;

    @ColumnInfo(name="land")
    public String land;

    @ColumnInfo(name="preis")
    public int preis;

    @ColumnInfo(name="minPreis")
    public int minPreis;

    @ColumnInfo(name="maxPreis")
    public int maxPreis;

    @ColumnInfo(name="geschmack")
    public String geschmack;

    @ColumnInfo(name="art")
    public String art;

    @ColumnInfo(name="laden")
    public String laden;

    @ColumnInfo(name="bewertungsZahl")
    public int bewertungsZahl;

    @ColumnInfo(name="bild")
    public String bild;

    @ColumnInfo(name="content")
    public String content;

    @ColumnInfo(name="gemerkt")
    public boolean gemerkt;



    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getScanID() {
        return scanID;
    }

    public void setScanID(int scanID) {
        this.scanID = scanID;
    }

    public String getWeinName() {
        return weinName;
    }

    public void setweinName(String weinName) {
        this.weinName = weinName;
    }

    public String getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(String jahrgang) {
        this.jahrgang = jahrgang;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public int getMinPreis() {
        return minPreis;
    }

    public void setMinPreis(int minPreis) {
        this.minPreis = minPreis;
    }

    public int getMaxPreis() {
        return maxPreis;
    }

    public void setMaxPreis(int maxPreis) {
        this.maxPreis = maxPreis;
    }

    public String getGeschmack() {
        return geschmack;
    }

    public void setGeschmack(String geschmack) {
        this.geschmack = geschmack;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getLaden() {
        return laden;
    }

    public void setLaden(String laden) {
        this.laden = laden;
    }

    public int getBerwertungsZahl() {
        return bewertungsZahl;
    }

    public void setBewertungsZahl(int bewertungsZahl) {
        this.bewertungsZahl = bewertungsZahl;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getGemerkt() {
        return gemerkt;
    }

    public void setGemerkt(boolean gemerkt) {
        this.gemerkt = gemerkt;
    }
}
