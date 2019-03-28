package edu.cnm.deepdive.relevant.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import edu.cnm.deepdive.relevant.R;


/**
 * Instances of this class represents the main activity. fragments are inflated upon click from
 * the user from a menu selection.
 *
 * @author Faycel B. Beji &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  private ProgressBar loading;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, " ", Snackbar.LENGTH_LONG)
                .setAction(" ", null).show();
      }
    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.fragment_1) {
      // Handle the camera action
    } else if (id == R.id.fragment_2) {

    } else if (id == R.id.fragment_3) {

    }  else if (id == R.id.fragment_4) {

    }else if (id == R.id.fragment_5) {

    }else if (id == R.id.fragment_6) {

    } else if (id == R.id.fragment_history) {

    }

//    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//    drawer.closeDrawer(GravityCompat.START);
    return true;
  }


  /**
   * This method represents the navigation view. Navigates through the fragment and load the
   * appropriate fragment bases on user selection.
   */

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {

    Bundle args = new Bundle();

    switch(item.getItemId()){
      case R.id.fragment_1:
        setTitle("Keyword");
        loadFragment(new KeywordFragment(), R.id.fragment_container, "fragment1", null);

        break;
      case R.id.fragment_2:
        setTitle("Most Viewed");
        loadFragment(new MostViewedFragment(), R.id.fragment_container, "fragment2", null);
        break;
      case R.id.fragment_4:
        setTitle("Email");

        loadFragment(new EmailedFragment(), R.id.fragment_container, "fragment3", null);
        break;

      case R.id.fragment_5:
        setTitle("Facebook");

        loadFragment(new FacebookFragment(), R.id.fragment_container, "fragment4", null);
        break;

      case R.id.fragment_6:
        setTitle("Twitter");

        loadFragment(new TwitterFragment(), R.id.fragment_container, "fragment5", null);
        break;

      case R.id.fragment_history:

        setTitle("History");

        loadFragment(new HistoryFragment(), R.id.fragment_container, "historyfragment", null);
        break;
    }


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void loadFragment(Fragment fragment, int container,String tag, Bundle args){


    FragmentManager manger = getSupportFragmentManager();
    if (args !=null) {
      fragment.setArguments(args);
    }
    manger.beginTransaction().replace(container,fragment,tag).commit();

  }


  public ProgressBar getLoading() {
    return loading;
  }

}



