package edu.cnm.deepdive.relevant.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.User;

@Dao
public interface UserDao {

  /**
   * Selects the single {@link UserDao} instance (or <code>null</code>) with the specified ID.
   *
   * @param userId key ID of {@link UserDao} instance.
   * @return {@link UserDao} instance if found in database; <code>null</code> otherwise.
   */

  @Query("SELECT * FROM User WHERE user_id = :userId")
  User findFirstByUserId(long userId);

  /**
   * Inserts zero or more {@link UserDao} instances into the local database. Any primary or unique key
   * constraint violations will result in the existing records being retained.
   *
   * @param Users collection of {@link UserDao} instance(s) to be inserted.
   *
   */
  @Insert
  List<Long> insert(User... Users);

  @Insert
  List<Long> insert(List<User> users);

  /**
   *@param searches collection of {@link UserDao} instance(s) to be inserted.
   * @return searches.
   */
  @Update
  int update(Search... searches);


}