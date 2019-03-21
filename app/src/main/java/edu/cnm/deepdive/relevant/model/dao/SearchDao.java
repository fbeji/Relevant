package edu.cnm.deepdive.relevant.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.relevant.model.entity.Search;
import java.util.Date;
import java.util.List;

@Dao

public interface SearchDao {



  @Query("SELECT * FROM Search WHERE user_id = :userId ORDER BY date DESC")
  List<Search> findAllByUserIdOrderByDate(long userId);

  @Query("SELECT * FROM Search WHERE search_id = :searchId")
  Search findFirstBySearchId(long searchId);


  @Insert
  List<Long> insert(Search... searches);


  @Delete
  int delete(Search... searches);

  @Query("SELECT * FROM Search ORDER BY date DESC")
  List<Search> findAll();

  @Query("SELECT * FROM Search WHERE date = :date")
  Search findFirstByDate(Date date);

//  @Query("SELECT User FROM Search")
//  public List<User> loadUser();




}
