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


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Holder> {

  Context context;
  private HistoryFragment historyFragment;
  private List<Search> items;
  private DateFormat format;


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
