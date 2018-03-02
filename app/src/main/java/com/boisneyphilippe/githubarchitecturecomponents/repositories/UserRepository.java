package com.boisneyphilippe.githubarchitecturecomponents.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;

import com.boisneyphilippe.githubarchitecturecomponents.App;
import com.boisneyphilippe.githubarchitecturecomponents.api.Webservice;
import com.boisneyphilippe.githubarchitecturecomponents.database.entity.User;
import com.boisneyphilippe.githubarchitecturecomponents.database.dao.UserDao;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
public class UserRepository {

    private static int FRESH_TIMEOUT_IN_MINUTES = 3;

    private final Webservice webservice;
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepository(Webservice webservice, UserDao userDao, Executor executor) {
        this.webservice = webservice;
        this.userDao = userDao;
        this.executor = executor;
    }

    // ---

    public LiveData<User> getUser(String userLogin) {
        refreshUser(userLogin);
        // return a LiveData directly from the database.
        return userDao.load(userLogin);
    }

    // ---

    private void refreshUser(final String userLogin) {
        executor.execute(() -> {
            // check if user was fetched recently
            boolean userExists = (userDao.hasUser(userLogin, getMaxRefreshTime(new Date())) != null);
            // if user have to be updated
            if (!userExists) {
                webservice.getUser(userLogin).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            User user = response.body();
                            user.setLastRefresh(new Date());
                            userDao.save(user);
                        });
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) { }
                });
            }
        });
    }

    // ---

    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}
