package com.boisneyphilippe.githubarchitecturecomponents.di.component;

import android.app.Application;

import com.boisneyphilippe.githubarchitecturecomponents.App;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.ActivityModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.FragmentModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.NetworkModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.RoomModule;
import com.boisneyphilippe.githubarchitecturecomponents.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
@Component(modules = {
        ActivityModule.class,
        FragmentModule.class,
        ViewModelModule.class,
        NetworkModule.class,
        RoomModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
