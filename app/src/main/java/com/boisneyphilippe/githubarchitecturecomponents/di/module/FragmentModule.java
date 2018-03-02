package com.boisneyphilippe.githubarchitecturecomponents.di.module;

import com.boisneyphilippe.githubarchitecturecomponents.fragments.UserProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();
}
