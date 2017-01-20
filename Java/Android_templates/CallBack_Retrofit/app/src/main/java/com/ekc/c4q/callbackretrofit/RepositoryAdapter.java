package com.ekc.c4q.callbackretrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ekc.c4q.callbackretrofit.model.Repository;
import java.util.ArrayList;
import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
  List<Repository> repositories;

  public RepositoryAdapter() {
    repositories = new ArrayList<>();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(android.R.layout.simple_list_item_2, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(repositories.get(position));
  }

  @Override
  public int getItemCount() {
    return repositories.size();
  }

  public void setRepositories(List<Repository> repositories) {
    this.repositories.clear();
    this.repositories.addAll(repositories);
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameView;
    private final TextView descView;

    public ViewHolder(View itemView) {
      super(itemView);

      nameView = (TextView) itemView.findViewById(android.R.id.text1);
      descView = (TextView) itemView.findViewById(android.R.id.text2);
    }

    void bind(Repository repository) {
      nameView.setText(repository.name);
      descView.setText(repository.description);
    }
  }
}
