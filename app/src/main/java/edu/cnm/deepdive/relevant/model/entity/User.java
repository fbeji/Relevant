package edu.cnm.deepdive.relevant.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import java.util.Calendar;



public class User {

  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  private long userId;





  public long getUserId() {
    return userId;
  }

  public void setUserId(String userid) {
    this.userId = userId;
  }






}