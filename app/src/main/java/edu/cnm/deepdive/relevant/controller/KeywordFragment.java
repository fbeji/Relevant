package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse.Document;
import edu.cnm.deepdive.relevant.service.SearchWebService.SearchTask;
import edu.cnm.deepdive.relevant.view.SearchResponseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KeywordFragment extends Fragment implements OnClickListener {


  private SearchResponseAdapter searchResponseAdapter;
  private RecyclerView recyclerView;
  private ArrayList<SearchResponse> arrayList;
  private List<Document> keywordSearch = new ArrayList<>();
  private Button keysearchButton;
  private EditText keysearchView;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_keywordfragment, container, false);
    recyclerView = view.findViewById(R.id.keyword_view);
    keysearchButton = view.findViewById(R.id.keysearchbutton);
    keysearchButton.setOnClickListener(this);
    searchResponseAdapter = new SearchResponseAdapter(this, keywordSearch);
    recyclerView.setAdapter(searchResponseAdapter);
    keysearchView = view.findViewById(R.id.keysearchview);

    return view;

  }

  @Override
  public void onClick(View v) {
//get the text out edit text
    new SearchTask().setSuccessListener(searchResponse -> {
      Document[] documents = searchResponse.getResponse().getDocs();
      searchResponseAdapter = new SearchResponseAdapter(KeywordFragment.this,
          Arrays.asList(documents));
      recyclerView.setAdapter(searchResponseAdapter);
    }).execute(keysearchView.getText().toString());

  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    return super.onOptionsItemSelected(item);
  }

  private void search(SearchView searchView) {

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        new SearchTask().setSuccessListener(searchResponse -> {
          Document[] documents = searchResponse.getResponse().getDocs();
          searchResponseAdapter = new SearchResponseAdapter(KeywordFragment.this,
              Arrays.asList(documents));
          recyclerView.setAdapter(searchResponseAdapter);
        }).execute();
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {

        //mAdapter.getFilter().filter(newText);
        return true;
      }
    });
  }
}

//    String [] values =
//        {"Time at Residence","Under 6 months","6-12 months","1-2 years","2-4 years","4-8 years","8-15 years","Over 15 years",};
//    Spinner spinner = v.findViewById(R.id.fragment_1);
//    ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(),
//        android.R.layout.simple_spinner_item, values);
//    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//    spinner.setAdapter(adapter);
//
//    return v;




