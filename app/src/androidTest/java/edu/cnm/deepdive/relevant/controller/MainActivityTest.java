package edu.cnm.deepdive.relevant.controller;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import edu.cnm.deepdive.relevant.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Test
  public void navigateToHistory() {
    onView(withId(R.id.drawer_layout))
        .perform(DrawerActions.open());

    //history fragment test
    onView(withId(R.id.nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.fragment_history));
    //Make sure fragment is loaded
    onView(withId(R.id.history_view))
        .check(matches(isDisplayed()));
  }
}