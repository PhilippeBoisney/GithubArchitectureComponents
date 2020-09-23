package com.boisneyphilippe.githubarchitecturecomponents.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.boisneyphilippe.githubarchitecturecomponents.database.entity.User;
import com.boisneyphilippe.githubarchitecturecomponents.repositories.UserRepository;

import javax.inject.Inject;

/**
 * Created by Philippe on 02/03/2018.
 */

public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;
    private UserRepository userRepo;

    @Inject
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // ----

    public void init(String userId) {
        if (this.user != null) {
            return;
        }
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser() {
        return this.user;
    }
}
