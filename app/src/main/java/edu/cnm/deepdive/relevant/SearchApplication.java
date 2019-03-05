package edu.cnm.deepdive.relevant;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class SearchApplication extends Application {

  private static SearchApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
  }


  public static Application getInstance() {
    return instance;
  }


}
