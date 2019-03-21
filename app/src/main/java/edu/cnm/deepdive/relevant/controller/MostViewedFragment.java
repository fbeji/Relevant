package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.service.SearchWebService;


public class MostViewedFragment extends Fragment implements OnClickListener {


  private static final String SEARCH_KEY = "search";
  private WebView webView;
  private Search search;
  private HistoryFragment historyFragment;
  private LayoutInflater inflater;
  private ViewGroup container;
  private Bundle savedInstanceState;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    this.inflater = inflater;
    this.container = container;
    this.savedInstanceState = savedInstanceState;

    return inflater.inflate(R.layout.fragment_most_viewed, container, false);
  }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    setRetainInstance(true);
    new SearchWebService.SearchTask()
        .setSuccessListener((result) -> {
          Log.d("Success", result.toString());

        })
        .setFailureListener((result) -> {
          Log.d("Failure", result.toString());
        })
        .execute("pinocchio");
  }

  @Override
  public void onClick(View v) {

  }

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

}

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
