package edu.cnm.deepdive.relevant.service;

import android.support.annotation.Nullable;
import edu.cnm.deepdive.relevant.model.SearchDB;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public final class SearchDBService {

  private SearchDBService() {
  }


  public static class InsertSearchTask
      extends BaseFluentAsyncTask<Search, Void, List<Long>, List<Long>> {

    @Override
    protected List<Long> perform(Search... searchs) {
      List<Long> searchIds = SearchDB.getInstance().getSearchDao().insert(searchs);
      List<User> users = new LinkedList<>();
      for (long id : searchIds) {

        User user = new User();
        user.setSearchId(id);
        users.add(user);
      }
      SearchDB.getInstance().getUserDao().insert(users);
      return searchIds;
    }

  }


  public static class SelectSearchTask extends BaseFluentAsyncTask<Date, Void, User, Search> {

    @Override
    protected User perform(Date... dates) {
      Search search = SearchDB.getInstance().getSearchDao().findFirstByDate(dates[0]);
      if (search == null) {
        throw new TaskException();
      }
      User user = new User();
      user.setSearchId(search.getId());
      SearchDB.getInstance().getUserDao().insert(user);
      return user;
    }

  }


  public static class SelectAllSearchTask
      extends BaseFluentAsyncTask<Void, Void, List<Search>, List<Search>> {

    @Override
    protected List<Search> perform(Void... voids) {
      return SearchDB.getInstance().getSearchDao().findAll();
    }

  }

  public static class DeleteSearchTask extends BaseFluentAsyncTask<Search, Void, Void, Void> {

    @Nullable
    @Override
    protected Void perform(Search... searches) throws TaskException {
      SearchDB.getInstance().getSearchDao().delete(searches);
      return null;
    }

  }

  public static class InsertAccessTask
      extends BaseFluentAsyncTask<User, Void, List<Long>, List<Long>> {

    @Nullable
    @Override
    protected List<Long> perform(User... users) throws TaskException {
      return SearchDB.getInstance().getUserDao().insert(users);
    }

  }

}


