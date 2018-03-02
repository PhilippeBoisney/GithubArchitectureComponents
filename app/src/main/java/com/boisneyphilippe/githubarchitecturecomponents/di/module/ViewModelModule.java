package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.boisneyphilippe.githubarchitecturecomponents.di.key.ViewModelKey;
import com.boisneyphilippe.githubarchitecturecomponents.view_models.FactoryViewModel;
import com.boisneyphilippe.githubarchitecturecomponents.view_models.UserProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel.class)
    abstract ViewModel bindUserProfileViewModel(UserProfileViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
