package com.example.louis.weinschmecker_v2.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Betti on 19.12.17.
 */

public class DateTypeConverter {
    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}