package com.ekc.c4q.callbackretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Contributor {
  public final String login;

  @SerializedName("avatar_url")


  public final String avatarUrl;

  public final String url;

  public final int contributions;


  public Contributor(String login, String avatarUrl, String url, int contributions) {

    this.login = login;

    this.avatarUrl = avatarUrl;

    this.url = url;

    this.contributions = contributions;

  }
}
