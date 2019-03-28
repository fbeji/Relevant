package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse.Document;
import edu.cnm.deepdive.relevant.service.SearchDBService.InsertSearchTask;
import edu.cnm.deepdive.relevant.service.SearchWebService.SearchTask;
import edu.cnm.deepdive.relevant.view.SearchResponseAdapter;

/**
 * Instances of this class represents searched articles by keyword typed in by the user
 * from the New York Times with titles (headline), snippets of the articles  and the corresponding Url
 *
 * @author Faycel B. Beji &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */


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

    /**
     * This method represents the onCLick view of articles searched by the use, a recycle view
     * is implemented. Information displayed is then saved on the history fragemnt.
     */

    @Override
    public void onClick(View v) {
//get the text out edit text
        new SearchTask().setSuccessListener(searchResponse -> {
            Document[] documents = searchResponse.getResponse().getDocs();
            searchResponseAdapter = new SearchResponseAdapter(KeywordFragment.this,
                    Arrays.asList(documents));

            for (Document document : documents) {
                Search search = new Search();
                search.setTitle(document.getHeadline().getMain());
                search.setUrl(document.getWebUrl());
                search.setDate(document.getPublicationDate());
                new InsertSearchTask().execute(search);

            }
            recyclerView.setAdapter(searchResponseAdapter);
        }).execute(keysearchView.getText().toString());

    }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    return super.onOptionsItemSelected(item);
  }


}






