package com.boisneyphilippe.githubarchitecturecomponents.database.converter;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * Created by Philippe on 02/03/2018.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
