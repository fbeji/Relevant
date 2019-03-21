package edu.cnm.deepdive.relevant.controller;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.service.SearchDBService.DeleteSearchTask;
import edu.cnm.deepdive.relevant.service.SearchDBService.SelectAllSearchTask;
import edu.cnm.deepdive.relevant.view.HistoryAdapter;
import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment implements View.OnClickListener {

  private List<Search> history;
  private HistoryAdapter adapter;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_history, container, false);
    RecyclerView historyView = view.findViewById(R.id.history_view);
    history = new ArrayList<Search>();
    adapter = new HistoryAdapter(this, history);
    historyView.setAdapter(adapter);
    refresh();
    return view;
  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    refresh();
  }


  public void refresh() {
    if (!isHidden()) {
      new SelectAllSearchTask()
          .setSuccessListener((searches) -> {
            history.clear();
            history.addAll(searches);
            adapter.notifyDataSetChanged();
          })
          .execute();
    }
  }


  public void createContextMenu(ContextMenu menu, int position, Search search) {

    getActivity().getMenuInflater().inflate(R.menu.item_context, menu);
    menu.findItem(R.id.context_delete).setOnMenuItemClickListener((item) -> {
      new DeleteSearchTask()
          .setSuccessListener((V) -> {
            history.remove(position);
            adapter.notifyItemRemoved(position);

          })
          .execute(search);

      return true;
    });

  }

  @Override
  public void onClick(View v) {

  }
}

