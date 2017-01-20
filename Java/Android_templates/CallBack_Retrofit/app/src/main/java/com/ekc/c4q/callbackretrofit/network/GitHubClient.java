package com.ekc.c4q.callbackretrofit.network;

import com.ekc.c4q.callbackretrofit.model.Contributor;
import com.ekc.c4q.callbackretrofit.model.Repository;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {
  public static final String API_URL = "https://api.github.com";

  private static GitHubClient instance;

  private final GitHubApi api;

  public static GitHubClient getInstance() {
    if (instance == null) {
      instance = new GitHubClient();
    }

    return instance;
  }

  private GitHubClient() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    api = retrofit.create(GitHubApi.class);
  }

  public Call<List<Contributor>> getContributors(String owner, String repository) {
    return api.getContributors(owner, repository);
  }

  public Call<List<Repository>> getRepositories(String user) {
    return api.getRepositories(user);
  }
}
