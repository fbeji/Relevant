package edu.cnm.deepdive.relevant.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import edu.cnm.deepdive.relevant.SearchApplication;
import edu.cnm.deepdive.relevant.model.SearchDB.Converters;
import edu.cnm.deepdive.relevant.model.dao.CategoryDao;
import edu.cnm.deepdive.relevant.model.dao.SearchDao;
import edu.cnm.deepdive.relevant.model.dao.SearchEntryDao;
import edu.cnm.deepdive.relevant.model.dao.UserDao;
import edu.cnm.deepdive.relevant.model.entity.Category;
import edu.cnm.deepdive.relevant.model.entity.Search;
import edu.cnm.deepdive.relevant.model.entity.SearchEntry;
import edu.cnm.deepdive.relevant.model.entity.User;
import java.util.Date;


@Database(
    entities = {User.class, Search.class, Category.class, SearchEntry.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class SearchDB extends RoomDatabase {

  private static final String DB_NAME = "serach_db";



  public synchronized static SearchDB getInstance() {
    return InstanceHolder.INSTANCE;
  }


  public abstract UserDao getUserDao();

  public abstract SearchDao getSearchDao();

  public abstract SearchEntryDao getSearchEntryDao();

  public abstract CategoryDao getCategoryDao();


  private static class InstanceHolder {

    private static final SearchDB INSTANCE = Room.databaseBuilder(
        SearchApplication.getInstance().getApplicationContext(), SearchDB.class, DB_NAME)
        .build();

  }

  public static class Converters {

    @TypeConverter
    public static Date dateFromLong(Long time) {
      return (time != null) ? new Date(time) : null;
    }

    @TypeConverter
    public static Long longFromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }

  }

}
