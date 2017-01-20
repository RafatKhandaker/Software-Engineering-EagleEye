package com.ekc.c4q.callbackretrofit.network;

import com.ekc.c4q.callbackretrofit.model.Contributor;
import com.ekc.c4q.callbackretrofit.model.Repository;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

  @GET("/repos/{owner}/{repo}/contributors")
  Call<List<Contributor>> getContributors(@Path("owner") String owner, @Path("repo") String repo);

  @GET("/users/{user}/repos")
  Call<List<Repository>> getRepositories(@Path("user") String user);
}
