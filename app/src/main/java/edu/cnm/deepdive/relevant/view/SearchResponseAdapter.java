package edu.cnm.deepdive.relevant.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.controller.KeywordFragment;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse.Document;
import java.util.List;

/**
 * Supplies {@link View} instances&mdash;each presenting an {@link SearchResponseAdapter} instance,
 * to a {@link RecyclerView}.
 */

public class SearchResponseAdapter extends RecyclerView.Adapter<SearchResponseAdapter.Holder> {

  private Context context;
  private KeywordFragment keywordFragment;
  private List<Document> items;


  public SearchResponseAdapter(KeywordFragment keywordFragment, List<Document> items) {
    context = keywordFragment.getContext();
    this.keywordFragment = keywordFragment;
    this.items = items;

  }

  @NonNull
  @Override
  public SearchResponseAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(context)
        .inflate(R.layout.search_item, viewGroup, false);
    Holder holder = new Holder(view);
    return holder;
//TODO inflate layout for one single item
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

    private Document document;
    private View view;
    private TextView headline;
    private TextView snippet;
    private TextView webUrl;

    /**
     * using references to views
     */

    private Holder(@NonNull View itemView) {
      super(itemView);
      view = itemView;
      view.setOnClickListener(keywordFragment);
      // view.setOnCreateContextMenuListener(this);

      headline = view.findViewById(R.id.headline);
      snippet = view.findViewById(R.id.snippet);
      webUrl = view.findViewById(R.id.weburl);
    }

    /**
     * using view methods to set the contents of view to the ocntents from document
     * @param document
     */
    private void bind(Document document) {
      this.document = document;

      headline.setText(document.getHeadline().getMain());
      snippet.setText(document.getSnippet());
      webUrl.setText(document.getWebUrl());
    }


  }
}
