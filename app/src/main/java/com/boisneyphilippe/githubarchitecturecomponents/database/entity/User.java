package com.boisneyphilippe.githubarchitecturecomponents.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Philippe on 02/03/2018.
 */

@Entity
public class User {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("blog")
    @Expose
    private String blog;

    private Date lastRefresh;

    // --- CONSTRUCTORS ---

    public User() { }

    public User(@NonNull String id, String login, String avatar_url, String name, String company, String blog, Date lastRefresh) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.lastRefresh = lastRefresh;
    }

    // --- GETTER ---

    public String getId() { return id; }
    public String getAvatar_url() { return avatar_url; }
    public Date getLastRefresh() { return lastRefresh; }
    public String getLogin() { return login; }
    public String getName() { return name; }
    public String getCompany() { return company; }
    public String getBlog() { return blog; }

    // --- SETTER ---

    public void setId(String id) { this.id = id; }
    public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }
    public void setLastRefresh(Date lastRefresh) { this.lastRefresh = lastRefresh; }
    public void setLogin(String login) { this.login = login; }
    public void setName(String name) { this.name = name; }
    public void setCompany(String company) { this.company = company; }
    public void setBlog(String blog) { this.blog = blog; }
}
