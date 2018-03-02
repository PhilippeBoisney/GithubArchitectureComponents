package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import android.support.annotation.NonNull;

import com.boisneyphilippe.githubarchitecturecomponents.api.Webservice;
import com.boisneyphilippe.githubarchitecturecomponents.database.MyDatabase;
import com.boisneyphilippe.githubarchitecturecomponents.database.dao.UserDao;
import com.boisneyphilippe.githubarchitecturecomponents.repositories.UserRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public class RepositoryModule {

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(Webservice webservice, UserDao userDao, Executor executor) {
        return new UserRepository(webservice, userDao, executor);
    }
}
