package com.boisneyphilippe.githubarchitecturecomponents.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.boisneyphilippe.githubarchitecturecomponents.database.converter.DateConverter;
import com.boisneyphilippe.githubarchitecturecomponents.database.dao.UserDao;
import com.boisneyphilippe.githubarchitecturecomponents.database.entity.User;

/**
 * Created by Philippe on 02/03/2018.
 */

@Database(entities = {User.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    // --- DAO ---
    public abstract UserDao userDao();
}
