package com.ekc.c4q.callbackretrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ekc.c4q.callbackretrofit.model.Contributor;
import com.ekc.c4q.callbackretrofit.network.GitHubClient;
import com.google.gson.Gson;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

  private EditText ownerView;
  private EditText repositoryView;
  private RecyclerView recyclerView;

  private GitHubClient gitHubClient;
  private Gson gson;
  private ContributorAdapter adapter;
  private ViewGroup emptyView;
  private ContentLoadingProgressBar progressView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gson = new Gson();
    ownerView = (EditText) findViewById(R.id.owner);
    progressView = (ContentLoadingProgressBar) findViewById(R.id.progress_bar);
    repositoryView = (EditText) findViewById(R.id.repository);
    emptyView = (ViewGroup) findViewById(android.R.id.empty);
    recyclerView = (RecyclerView) findViewById(android.R.id.list);

    adapter = new ContributorAdapter();
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    // hold onto this for later
    gitHubClient = GitHubClient.getInstance();

    repositoryView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
          loadRepositoryContributors(null);
          InputMethodManager imm =
              (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
          imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
          return true;
        }
        return false;
      }
    });
  }

  public void loadRepositoryContributors(View view) {
    String owner = ownerView.getText().toString();
    final String repository = repositoryView.getText().toString();
    if (!owner.isEmpty() && !repository.isEmpty()) {
      Call<List<Contributor>> call = gitHubClient.getContributors(owner, repository);
      progressView.setVisibility(VISIBLE);
      call.enqueue(new Callback<List<Contributor>>() {
        @Override
        public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
          List<Contributor> contributors = response.body();
          if (contributors == null || contributors.isEmpty()) {
            emptyView.setVisibility(VISIBLE);
            recyclerView.setVisibility(GONE);
            progressView.hide();
          } else {
            emptyView.setVisibility(GONE);
            recyclerView.setVisibility(VISIBLE);
            progressView.hide();
            adapter.setContributors(contributors);
          }
        }

        @Override
        public void onFailure(Call<List<Contributor>> call, Throwable t) {
          progressView.hide();
          String errorMessage =
              MainActivity.this.getString(R.string.error_loading_contributors, t.getMessage());
          Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        }
      });
    }
  }
}
