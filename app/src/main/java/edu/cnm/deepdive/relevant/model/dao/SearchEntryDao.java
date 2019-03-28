package edu.cnm.deepdive.relevant.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.SearchEntry;

@Dao
public interface SearchEntryDao {

    /**
     * Selects the single {@link SearchEntry} instance (or <code>null</code>) with the specified ID.
     *
     * @param searchEntryId key ID of {@link SearchEntry} instance.
     * @return {@link SearchEntry} instance if found in database; <code>null</code> otherwise.
     */

  @Query("SELECT * FROM SearchEntry WHERE search_entry_id = :searchEntryId")
  SearchEntry findFirstBySearchentryId(long searchEntryId);

    /**
     * Selects the single {@link SearchEntry} instance (or <code>null</code>) with the specified ID.
     *
     * @param  searchId key ID of {@link SearchEntry} instance.
     * @return {@link SearchEntry} instance if found in database; <code>null</code> otherwise.
     */
    @Query("SELECT * FROM SearchEntry WHERE search_id = :searchId ORDER BY sequence ASC")
    List<SearchEntry> findAllBySearchId(long searchId);

    /**
     * Inserts zero or more {@link SearchEntry} instances into the local database. Any primary or unique key
     * constraint violations will result in the existing records being retained.
     *
     * @param SearchEntries collection of {@link Search} instance(s) to be inserted.
     * @return inserted record ID(s).
     */
    @Insert
    List<Long> insert(SearchEntry... SearchEntries);

    /**
     * Deletes zero or more {@link SearchEntry} instances from local database.
     *
     * @param  searchEntries of {@link SearchEntry} to be deleted from database.
     */
    @Delete
  int delete(SearchEntry... searchEntries);






}
