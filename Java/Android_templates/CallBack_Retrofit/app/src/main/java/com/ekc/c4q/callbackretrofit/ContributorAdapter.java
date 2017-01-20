package com.ekc.c4q.callbackretrofit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ekc.c4q.callbackretrofit.model.Contributor;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorAdapter.ViewHolder> {

  private List<Contributor> contributors;

  public ContributorAdapter() {
    contributors = new ArrayList<>();
  }

  void setContributors(List<Contributor> contributors) {
    this.contributors.clear();
    this.contributors.addAll(contributors);
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contributor, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public int getItemCount() {
    return contributors.size();
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(contributors.get(position));
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ImageView photoView;
    private final TextView loginView;
    private final TextView contributionCountView;

    public ViewHolder(View itemView) {
      super(itemView);

      photoView = (ImageView) itemView.findViewById(R.id.photo);
      loginView = (TextView) itemView.findViewById(R.id.login);
      contributionCountView = (TextView) itemView.findViewById(R.id.contribution_count);
    }

    void bind(Contributor contributor) {
      itemView.setOnClickListener(this);

      final Context context = itemView.getContext();
      Picasso.with(context)
          .load(contributor.avatarUrl)
          .placeholder(R.drawable.ic_action_github_logo)
          .resizeDimen(R.dimen.list_detail_image_size, R.dimen.list_detail_image_size)
          .centerInside()
          .into(photoView);

      loginView.setText(contributor.login);

      Resources resources = context.getResources();
      int c = contributor.contributions;
      String contributionSummaryText = resources.getQuantityString(R.plurals.num_contributions, c, c);
      contributionCountView.setText(contributionSummaryText);
    }

    @Override
    public void onClick(View v) {
      Contributor item = contributors.get(getAdapterPosition());

      final Context context = itemView.getContext();
      Intent intent = new Intent(context, ProfileActivity.class);
      intent.putExtra(ProfileActivity.EXTRA_USER_LOGIN, item.login);
      intent.putExtra(ProfileActivity.EXTRA_USER_AVATAR_URL, item.avatarUrl);
      context.startActivity(intent);
    }
  }
}
