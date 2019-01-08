package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import android.app.Application;

import com.boisneyphilippe.githubarchitecturecomponents.App;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class AppModule {
    @Binds
    @Singleton
    abstract Application application(App app);
}
