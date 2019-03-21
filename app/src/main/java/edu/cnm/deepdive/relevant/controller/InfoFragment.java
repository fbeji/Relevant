package edu.cnm.deepdive.relevant.controller;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.Search;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link InfoFragment.OnFragmentInteractionListener} interface to handle interaction events. Use
 * the {@link InfoFragment#newInstance} factory method to create an instance of this fragment.
 */
public class InfoFragment extends DialogFragment {


  private static final String SEARCH_KEY = "search";

  public static InfoFragment newInstance(Search search) {
    InfoFragment fragment = new InfoFragment();
    Bundle args = new Bundle();

    args.putSerializable(SEARCH_KEY, search);
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    Search search = (Search) getArguments().getSerializable(SEARCH_KEY);

    View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_info, null);

    TextView url = view.findViewById(R.id.url);

    url.setText(search.getUrl());
    TextView hdUrl = view.findViewById(R.id.hd_url);

    return new Builder(getActivity())
        .setIcon(R.drawable.ic_info_filled)
        .setTitle(search.getTitle())
        .setView(view)
        .setPositiveButton(R.string.positive_label, (dialog, which) -> {
        })
        .create();
  }
}