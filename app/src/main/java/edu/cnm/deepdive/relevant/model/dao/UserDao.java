package edu.cnm.deepdive.relevant.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.User;
import java.util.List;

@Dao
public interface UserDao {



  @Query("SELECT * FROM User WHERE user_id = :userId")
  User findFirstByUserId(long userId);





  @Insert
  List<Long> insert(User... Users);

  @Insert
  List<Long> insert(List<User> users);
  @Update
  int update(Search... searches);


}