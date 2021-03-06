package edu.cnm.deepdive.relevant.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.controller.EmailedFragment;
import edu.cnm.deepdive.relevant.controller.FacebookFragment;
import edu.cnm.deepdive.relevant.controller.MostViewedFragment;
import edu.cnm.deepdive.relevant.controller.TwitterFragment;
import edu.cnm.deepdive.relevant.model.entity.MostPopular.Result;
import java.util.List;

/**
 * Supplies {@link View} instances&mdash;each presenting an {@link SearchResponseAdapter} instance,
 * to a {@link RecyclerView}.
 */
public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.Holder> {


  private Context context;
  private EmailedFragment emailedFragment;
  private FacebookFragment facebookFragment;
  private TwitterFragment twitterFragment;
  private MostViewedFragment mostViewedFragment;
  private List<Result> items;


  public MostPopularAdapter(EmailedFragment emailedFragment, List<Result> items) {
    context = emailedFragment.getContext();
    this.emailedFragment = emailedFragment;
    this.items = items;
  }


  public MostPopularAdapter(FacebookFragment facebookFragment, List<Result> items) {
    context = facebookFragment.getContext();
    this.facebookFragment = facebookFragment;
    this.items = items;
  }

  public MostPopularAdapter(TwitterFragment twitterFragment, List<Result> items) {
    context = twitterFragment.getContext();
    this.twitterFragment = twitterFragment;
    this.items = items;
  }

  public MostPopularAdapter(MostViewedFragment mostViewedFragment, List<Result> items) {
    context = mostViewedFragment.getContext();
    this.mostViewedFragment = mostViewedFragment;
    this.items = items;
  }



  @NonNull
  @Override

/**
 * inflate layout for one single item
 *
 */

  public MostPopularAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(context)
        .inflate(R.layout.search_item, viewGroup, false);
    Holder holder = new Holder(view);

    return holder;

  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int i) {
    holder.bind(items.get(i));
  }

  @Override
  public int getItemCount() {
    return items.size();
  }


  public class Holder extends RecyclerView.ViewHolder {

    private Result result;
    private View view;
    private TextView title1;
    private TextView webUrl1;
    private TextView leadparagraph;


    private Holder(@NonNull View itemView) {
      super(itemView);
      view = itemView;
      view.setOnClickListener(emailedFragment);
      view.setOnClickListener(facebookFragment);
      view.setOnClickListener(twitterFragment);
      view.setOnClickListener(mostViewedFragment);
      title1 = view.findViewById(R.id.headline);
      leadparagraph = view.findViewById(R.id.snippet);
      webUrl1 = view.findViewById(R.id.weburl);
    }

    /**
     * use view methods to set the contents of view to the contents from document
     */

    private void bind(Result result) {
      this.result = result;

      title1.setText(result.getTitle());
      leadparagraph.setText(result.getLeadParagraph());
      webUrl1.setText(result.getWebUrl());
    }

  }

}







