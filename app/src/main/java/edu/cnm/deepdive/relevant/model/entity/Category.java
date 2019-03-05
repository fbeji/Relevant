package edu.cnm.deepdive.relevant.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.ColumnInfo.Collate;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Entity;

@Entity

public class Category {

  @ColumnInfo(name = "category_id")
  @PrimaryKey(autoGenerate = true)
  private long id;
@ColumnInfo(index = true)
private String name ;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
