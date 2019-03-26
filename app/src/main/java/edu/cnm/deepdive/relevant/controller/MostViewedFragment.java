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
import edu.cnm.deepdive.relevant.service.SearchWebService.MostViewedTask;
import edu.cnm.deepdive.relevant.view.MostPopularAdapter;
import java.util.ArrayList;
import java.util.Arrays;


public class MostViewedFragment extends Fragment implements OnClickListener {

  private MostPopularAdapter mostPopularAdapter;
  private RecyclerView recyclerView;
  private ArrayList<MostPopular> arrayList;
  private EditText mostViewedView;



  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_most_viewed, container, false);
    mostViewedView = view.findViewById(R.id.mostviewedview);
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
    }).execute(mostViewedView.getText().toString());
    return view;
  }
  @Override
  public void onClick(View v) {

  }
}

//  @Override
//  public void onCreate(@Nullable Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setHasOptionsMenu(true);
//    setRetainInstance(true);
//    new SearchWebService.SearchTask()
//        .setSuccessListener((result) -> {
//          Log.d("Success", result.toString());
//
//        })
//        .setFailureListener((result) -> {
//          Log.d("Failure", result.toString());
//        })
//        .execute("pinocchio");
//  }



//  @Override
//  public View onCreateView(
//      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//    //View view = inflater.inflate(R.layout.fragment_image, container, false);
//    setupWebView(view);
//    if (savedInstanceState != null) {
//      search = (Search) savedInstanceState.getSerializable(SEARCH_KEY);
//    }
//    if (search != null) {
//      setSearch(search);
//
//    return view;
//  }
//
//
//
//
//

//  SendMessage SM;
//
//  public static final String BODY_TEXT_KEY = "body_text";
//  @Override
//  public View onCreateView(LayoutInflater inflater, ViewGroup container,
//      Bundle savedInstanceState) {
//
//    View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
//
//    Bundle args = getArguments();
//
//    if (args!= null) {
//
//      String body = args.getString(BODY_TEXT_KEY);
//      if(body != null){
//
//        TextView bodyText = view.findViewById(R.id.body_text);
//        bodyText.setText(body);
//      }
//
//    }
//
//
//    return view;
//  }
//
//  public void displayReceivedData(String message) {
//  }
//
//  interface SendMessage {
//    void sendData(String message);
//  }
//
//
//  @Override
//  public void onAttach(Context context) {
//    super.onAttach(context);
//
//    try {
//      SM = (SendMessage) getActivity();
//    } catch (ClassCastException e) {
//      throw new ClassCastException("Error in retrieving data. Please try again");
//    }
//  }
//}
