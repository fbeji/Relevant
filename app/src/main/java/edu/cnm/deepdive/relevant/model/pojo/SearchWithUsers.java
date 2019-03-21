package edu.cnm.deepdive.relevant.model.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.User;
import java.util.List;

public class SearchWithUsers {

  @Embedded
  private Search search;

  @Relation(parentColumn = "search_id", entityColumn = "search_id")
  private List<Search> users;

  public Search getSearch() {
    return search;
  }

  public void setSearch(Search search) {
    this.search = search;
  }

  public List<Search> getUsers() {
    return users;
  }

  public void setAccesses(List<User> accesses) {
    this.users = users;
  }
}


