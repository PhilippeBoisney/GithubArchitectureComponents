package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import com.boisneyphilippe.githubarchitecturecomponents.api.Webservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public class NetModule {

    private static String BASE_URL = "https://api.github.com/";

    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    Webservice provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(Webservice.class);
    }
}
