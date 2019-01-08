package com.boisneyphilippe.githubarchitecturecomponents;

import com.boisneyphilippe.githubarchitecturecomponents.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


/**
 * Created by Philippe on 02/03/2018.
 */

public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
