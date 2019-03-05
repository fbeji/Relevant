package edu.cnm.deepdive.relevant.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.ColumnInfo.Collate;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Entity;

@Entity

public class Category {

  @ColumnInfo(name = "category_id")
  @PrimaryKey(autoGenerate = true)
  private long categoryId;
@ColumnInfo(index = true)
private String name ;

public long getCategoryidId() {
    return categoryId;
  }

  public void setCategoryId(long categoryid) {
    this. categoryId = categoryid;
  }
}
