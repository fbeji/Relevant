package edu.cnm.deepdive.relevant.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.relevant.model.entity.SearchEntry;
import java.util.List;

@Dao
public interface SearchEntryDao {



  @Query("SELECT * FROM SearchEntry WHERE search_entry_id = :searchEntryId")
  SearchEntry findFirstBySearchentryId(long searchEntryId);

  @Query("SELECT * FROM SearchEntry WHERE search_id = :searchId ORDER BY sequence ASC")
  List<SearchEntry> findAllBySearchId(long searchId);

  @Insert
  List<Long> insert(SearchEntry... SearchEntries);


  @Delete
  int delete(SearchEntry... searchEntries);






}
