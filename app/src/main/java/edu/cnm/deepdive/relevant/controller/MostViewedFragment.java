package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.MostPopular;
import edu.cnm.deepdive.relevant.model.entity.MostPopular.Result;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.service.SearchDBService.InsertSearchTask;
import edu.cnm.deepdive.relevant.service.SearchWebService.MostViewedTask;
import edu.cnm.deepdive.relevant.view.MostPopularAdapter;

/**
 * Instances of this class represents most viewed articles from the New York Times with
 * titles (headline), snippets of the articles  and the corresponding Url.
 * a recycler view is implemented
 *
 * @author Faycel B. Beji &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */
public class MostViewedFragment extends Fragment implements OnClickListener {

  private MostPopularAdapter mostPopularAdapter;
  private RecyclerView recyclerView;
  private ArrayList<MostPopular> arrayList;
  //private EditText mostViewedView;



  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_most_viewed, container, false);
    //mostViewedView = view.findViewById(R.id.mostviewedview);
    recyclerView = view.findViewById(R.id.keyword_view);
    new MostViewedTask().setSuccessListener(mostPopular -> {
      Result[] results = mostPopular.getResults();
      for (Result result : results) {
        Search search = new Search();
        search.setTitle(result.getTitle());
        search.setUrl(result.getWebUrl());
        search.setDate(result.getPublicationDate());
        new InsertSearchTask().execute(search);

      }

      mostPopularAdapter = new MostPopularAdapter(MostViewedFragment.this,
          Arrays.asList(results));
      recyclerView.setAdapter(mostPopularAdapter);
    }).execute();
    return view;
  }
  @Override
  public void onClick(View v) {

  }
}


