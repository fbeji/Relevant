/*
 *  Copyright 2019 Faycel B. Beji & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package edu.cnm.deepdive.relevant.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.controller.HistoryFragment;
import edu.cnm.deepdive.relevant.model.entity.Search;
import java.text.DateFormat;
import java.util.List;

/**
 * Supplies {@link View} instances&mdash;each presenting an {@link Search} instance, to a {@link
 * RecyclerView}.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Holder> {

  Context context;
  private HistoryFragment historyFragment;
  private List<Search> items;
  private DateFormat format;

  /**
   * Initializes {@link HistoryAdapter} instance with the specified {@link HistoryFragment} host and
   * {@link List}&lt;{@link Search}&gt; data source.
   *
   * @param historyFragment host fragment.
   * @param items source of {@link Search} instances.
   */

  public HistoryAdapter(HistoryFragment historyFragment, List<Search> items) {
    context = historyFragment.getContext();
    this.historyFragment = historyFragment;
    this.items = items;
    format = android.text.format.DateFormat.getDateFormat(context);
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(context).inflate(R.layout.history_item, viewGroup, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int i) {
    holder.bind(items.get(i));
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  /**
   * Maintains a connection between a {@link View} and an {@link Search} instance. The {@link
   * HistoryAdapter} manages the creation and re-use of {@link Holder} instances as rows are
   * scrolled into and out of view.
   * <p>Each view item is clickable (the {@link View.OnClickListener} attached to each is the host
   * {@link HistoryFragment}), supporting display of an APOD selected from the list view.</p>
   */

  public class Holder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

    private Search search;
    private View view;
    private TextView dateView;
    private TextView titleView;

    private Holder(@NonNull View itemView) {
      super(itemView);
      view = itemView;
      view.setOnClickListener(historyFragment);
      view.setOnCreateContextMenuListener(this);
      dateView = itemView.findViewById(R.id.date_view);
      titleView = itemView.findViewById(R.id.title_view);
    }

    private void bind(Search search) {
      this.search = search;
      view.setTag(search);
      dateView.setText(format.format(search.getDate()));
      titleView.setText(search.getTitle());


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

      historyFragment.createContextMenu(menu, getAdapterPosition(), search);


    }
  }

}
