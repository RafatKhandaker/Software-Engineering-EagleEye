package com.ekc.c4q.callbackretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ekc.c4q.callbackretrofit.model.Repository;
import com.ekc.c4q.callbackretrofit.network.GitHubClient;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ProfileActivity extends AppCompatActivity {
  public static final String EXTRA_USER_LOGIN = "LOGIN";
  public static final String EXTRA_USER_AVATAR_URL = "AVATAR_URL";

  private ImageView photoView;
  private TextView loginView;
  private RecyclerView recyclerView;

  private Gson gson;
  private GitHubClient gitHubClient;
  private RepositoryAdapter adapter;
  private ViewGroup emptyView;
  private ContentLoadingProgressBar progressView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    gson = new Gson();
    Intent intent = getIntent();
    String login = intent.getStringExtra(EXTRA_USER_LOGIN);
    String avatarUrl = intent.getStringExtra(EXTRA_USER_AVATAR_URL);

    photoView = (ImageView) findViewById(R.id.photo);
    loginView = (TextView) findViewById(R.id.login);
    emptyView = (ViewGroup) findViewById(android.R.id.empty);
    recyclerView = (RecyclerView) findViewById(android.R.id.list);
    progressView = (ContentLoadingProgressBar) findViewById(R.id.progress_bar);

    Picasso.with(this)
        .load(avatarUrl)
        .placeholder(R.drawable.ic_action_github_logo)
        .resizeDimen(R.dimen.list_detail_image_size, R.dimen.list_detail_image_size)
        .centerInside()
        .into(photoView);

    loginView.setText(login);

    adapter = new RepositoryAdapter();
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    gitHubClient = GitHubClient.getInstance();
    Call<List<Repository>> call = gitHubClient.getRepositories(login);
    progressView.show();

    call.enqueue(new Callback<List<Repository>>() {
      @Override
      public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
        List<Repository> repositories = response.body();
        if (repositories == null || repositories.isEmpty()) {
          emptyView.setVisibility(VISIBLE);
          progressView.hide();
          recyclerView.setVisibility(GONE);
        } else {
          emptyView.setVisibility(GONE);
          progressView.hide();
          recyclerView.setVisibility(VISIBLE);
          adapter.setRepositories(repositories);
        }
      }

      @Override
      public void onFailure(Call<List<Repository>> call, Throwable t) {
        progressView.hide();
        String errorMessage =
            ProfileActivity.this.getString(R.string.error_loading_repositories, t.getMessage());
        Toast.makeText(ProfileActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      // Respond to the action bar's Up/Home button
      case android.R.id.home:
        Intent upIntent = NavUtils.getParentActivityIntent(this);
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        NavUtils.navigateUpTo(this, upIntent);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
