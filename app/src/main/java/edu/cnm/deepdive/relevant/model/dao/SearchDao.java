package edu.cnm.deepdive.relevant.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import edu.cnm.deepdive.relevant.model.entity.Search;

@Dao

public interface SearchDao {


    /**
     * Selects the single {@link Search} instance (or <code>null</code>) with the specified ID.
     *
     * @param userId key ID of {@link Search} instance.
     * @return {@link Search} instance if found in database; <code>null</code> otherwise.
     */

    @Query("SELECT * FROM Search WHERE user_id = :userId ORDER BY date DESC")
    List<Search> findAllByUserIdOrderByDate(long userId);

    /**
     * Selects the single {@link Search} instance (or <code>null</code>) with the specified ID.
     *
     * @param  searchId key ID of {@link Search} instance.
     * @return {@link Search} instance if found in database; <code>null</code> otherwise.
     */

    @Query("SELECT * FROM Search WHERE search_id = :searchId")
    Search findFirstBySearchId(long searchId);

    /**
     * Inserts zero or more {@link Search} instances into the local database. Any primary or unique key
     * constraint violations will result in the existing records being retained.
     *
     * @param searches collection of {@link Search} instance(s) to be inserted.
     * @return inserted record ID(s).
     */

    @Insert
    List<Long> insert(Search... searches);


    /**
     * Deletes zero or more {@link Search} instances from local database.
     *
     * @param searches instances of {@link Search} to be deleted from database.
     */
    @Delete
    int delete(Search... searches);

  @Query("SELECT * FROM Search ORDER BY date DESC")
  List<Search> findAll();

    /**
     * Selects the single {@link Search} instance (or <code>null</code>) with the specified date.
     * @param date maximum number of {@link Search} instances to return.
     *@return date <code>limit</code> {@link Search} instances.
     */

    @Query("SELECT * FROM Search WHERE date = :date")
    Search findFirstByDate(Date date);


}
