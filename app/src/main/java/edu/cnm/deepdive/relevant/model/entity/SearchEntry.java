package edu.cnm.deepdive.relevant.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;



@Entity(
    foreignKeys = @ForeignKey(
        entity = Search.class,
        parentColumns = "search_id", childColumns = "search_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class SearchEntry {

  @ColumnInfo(name = "search_entry_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "search_id", index = true)
  private long searchId;

  @ColumnInfo(index = true)
  private long sequence;

  @ColumnInfo(name = "category_id", index = true)
  private long categoryId;

  @ColumnInfo(name = "url", index = true)
  private long url;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSearchId() {
    return searchId;
  }

  public void setSearchId(long searchId) {
    this.searchId = searchId;
  }

  public long getSequence() {
    return sequence;
  }

  public void setSequence(long sequence) {
    this.sequence = sequence;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public long getUrl() {
    return url;
  }

  public void setUrl(long url) {
    this.url = url;
  }
}
