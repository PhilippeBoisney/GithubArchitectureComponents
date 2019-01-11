package com.boisneyphilippe.githubarchitecturecomponents.di.component;

import com.boisneyphilippe.githubarchitecturecomponents.App;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.ActivityModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.AppModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.DataModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.FragmentModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class, FragmentModule.class, AppModule.class, DataModule.class, ViewModelModule.class})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
