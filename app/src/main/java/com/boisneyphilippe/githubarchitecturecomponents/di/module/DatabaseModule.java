package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.boisneyphilippe.githubarchitecturecomponents.database.MyDatabase;
import com.boisneyphilippe.githubarchitecturecomponents.database.dao.UserDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Philippe on 02/03/2018.
 */
@Module
public class DatabaseModule {

    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MyDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(MyDatabase database) {
        return database.userDao();
    }
}
