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
import edu.cnm.deepdive.relevant.service.SearchWebService.MostEmailedTask;
import edu.cnm.deepdive.relevant.view.MostPopularAdapter;


/**
 * Instances of this class represent most Emailed articles on the New York Times
 * with titles (headline), snippets of the articles  and the corresponding url
 *
 * @author Faycel B. Beji &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class EmailedFragment extends Fragment implements OnClickListener {

    private MostPopularAdapter mostPopularAdapter;
    private RecyclerView recyclerView;
    private ArrayList<MostPopular> arrayList;
    //private EditText emailView;

    /**
     * This method represents the Oncreate view of the emailed articles, a recycle view
     * is implemented. Information displayed is then saved on the history fragemnt.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emailedfragment, container, false);
        //emailView = view.findViewById(R.id.emailview);
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
        }).execute();
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}