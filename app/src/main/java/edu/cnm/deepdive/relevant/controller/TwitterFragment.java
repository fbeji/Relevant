package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import edu.cnm.deepdive.relevant.R;


public class TwitterFragment extends Fragment implements OnClickListener {





  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_twitterfragment, container, false);
  }

  @Override
  public void onClick(View v) {

  }
}