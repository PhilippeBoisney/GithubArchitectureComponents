package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

}
