package edu.cnm.deepdive.relevant.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.cnm.deepdive.relevant.BuildConfig;
import edu.cnm.deepdive.relevant.R;
import edu.cnm.deepdive.relevant.SearchApplication;
import edu.cnm.deepdive.relevant.model.entity.MostPopular;
import edu.cnm.deepdive.relevant.model.entity.SearchResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface SearchWebService {


  @GET("svc/search/v2/articlesearch.json")
  Call<SearchResponse> search(@Query("api-key") String apiKey, @Query("q") String search);

  @GET("svc/mostpopular/v2/viewed/{period}.json")
  Call<MostPopular> mostViewed(@Path("period") int period, @Query("api-key") String apiKey);

  @GET("svc/mostpopular/v2/emailed/{period}.json")
  Call<MostPopular> mostEmailed(@Path("period") int period, @Query("api-key") String apiKey);

  @GET("svc/mostpopular/v2/shared/{period}/{type}.json")
  Call<MostPopular> mostShared(@Path("period") int period,
      @Path("type") String type, @Query("api-key") String apiKey);

  class InstanceHolder {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final SearchWebService INSTANCE;
    private static final String API_KEY;

    static {
      SearchApplication application = (SearchApplication) SearchApplication.getInstance();
      GsonBuilder gsonBuilder = new GsonBuilder();
      gsonBuilder.excludeFieldsWithoutExposeAnnotation();
      gsonBuilder.setDateFormat(DATE_FORMAT);
      Gson gson = gsonBuilder.create();
      Retrofit retrofit = new Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(SearchWebService.class);
      API_KEY = BuildConfig.API_KEY;
    }

  }

  /**
   * Encapsulates the request lifecycle for the NASA APOD web service as a {@link
   * BaseFluentAsyncTask} subclass.
   */
  class SearchTask extends BaseFluentAsyncTask<String, Void, SearchResponse, SearchResponse> {

    @Override
    protected SearchResponse perform(String... strings) throws TaskException {

      String searchString = strings[0];

      try {
        Response<SearchResponse> response = InstanceHolder.INSTANCE.search(
            InstanceHolder.API_KEY, searchString).execute();
        if (!response.isSuccessful()) {
          throw new TaskException();
        }
        return response.body();
      } catch (Exception e) {
        throw new TaskException(e);
      }
    }

  }

  class MostViewedTask extends BaseFluentAsyncTask<String, Void, MostPopular, MostPopular> {

    @Override
    protected MostPopular perform(String... strings) throws TaskException {

      {
        int period = 1;


          try {
          Response<MostPopular> response = InstanceHolder.INSTANCE.mostViewed(period,
              InstanceHolder.API_KEY).execute();
          if (!response.isSuccessful()) {
            throw new TaskException();
          }
          return response.body();
        } catch (Exception e) {
          throw new TaskException(e);
        }
      }
    }

  }


    class MostSharedTask extends BaseFluentAsyncTask<String, Void, MostPopular, MostPopular> {

    @Override
    protected MostPopular perform(String... strings) throws TaskException {

      {
        int period = 1;

        String type = strings[0];

        try {
          Response<MostPopular> response = InstanceHolder.INSTANCE.mostShared(period, type,
              InstanceHolder.API_KEY).execute();
          if (!response.isSuccessful()) {
            throw new TaskException();
          }
          return response.body();
        } catch (Exception e) {
          throw new TaskException(e);
        }
      }
    }

  }

  class MostEmailedTask extends BaseFluentAsyncTask<String, Void, MostPopular, MostPopular> {

    @Override
    protected MostPopular perform(String... strings) throws TaskException {

      {
        int period = 1;


          try {
          Response<MostPopular> response = InstanceHolder.INSTANCE.mostEmailed(period,
              InstanceHolder.API_KEY).execute();
          if (!response.isSuccessful()) {
            throw new TaskException();
          }
          return response.body();
        } catch (Exception e) {
          throw new TaskException(e);
        }
      }
    }

  }


}

