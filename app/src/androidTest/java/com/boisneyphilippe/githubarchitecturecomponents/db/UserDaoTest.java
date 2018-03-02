package com.boisneyphilippe.githubarchitecturecomponents.db;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.boisneyphilippe.githubarchitecturecomponents.database.entity.User;
import com.boisneyphilippe.githubarchitecturecomponents.db.DbTest;
import com.boisneyphilippe.githubarchitecturecomponents.utils.LiveDataTestUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserDaoTest extends DbTest {

    @Test
    public void insertAndLoad() throws InterruptedException {
        final User user = new User("66577", "JakeWharton", "https://avatars0.githubusercontent.com/u/66577?v=4", "Jake Wharton", "Google, Inc.", "http://jakewharton.com", new Date());
        db.userDao().save(user);

        final User loaded = LiveDataTestUtil.getValue(db.userDao().load(user.getLogin()));
        assertThat(loaded.getLogin(), is("JakeWharton"));
    }
}
