package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.MostPopular;
import edu.cnm.deepdive.relevant.model.entity.MostPopular.Result;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.service.SearchDBService.InsertSearchTask;
import edu.cnm.deepdive.relevant.service.SearchWebService.MostEmailedTask;
import edu.cnm.deepdive.relevant.view.MostPopularAdapter;
import java.util.ArrayList;
import java.util.Arrays;


public class EmailedFragment extends Fragment implements OnClickListener {

  private MostPopularAdapter mostPopularAdapter;
  private RecyclerView recyclerView;
  private ArrayList<MostPopular> arrayList;
  private EditText emailView;

  /**
   * In the EmailedFragment, most emailed articles will be displayed
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_emailedfragment, container, false);
    emailView = view.findViewById(R.id.emailview);
    recyclerView = view.findViewById(R.id.keyword_view);
    new MostEmailedTask().setSuccessListener(mostPopular -> {
      Result[] results = mostPopular.getResults();
      for (Result result : results) {
        Search search = new Search();
        search.setTitle(result.getTitle());
        search.setUrl(result.getWebUrl());
        search.setDate(result.getPublicationDate());
        new InsertSearchTask().execute(search);

      }

      mostPopularAdapter = new MostPopularAdapter(EmailedFragment.this,
          Arrays.asList(results));
      recyclerView.setAdapter(mostPopularAdapter);
    }).execute(emailView.getText().toString());
    return view;
  }


  @Override
  public void onClick(View v) {

  }
}