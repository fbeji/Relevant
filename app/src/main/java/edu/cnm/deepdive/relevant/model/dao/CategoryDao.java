/*
 *  Copyright 2019 Faycel B. Beji & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package edu.cnm.deepdive.relevant.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.cnm.deepdive.relevant.model.entity.Category;

@Dao

public interface CategoryDao {
  /**
   * Selects the single {@link Category} instance (or <code>null</code>) with the specified ID.
   *
   * @param categoryId primary key ID of {@link Category} instance.
   * @return {@link Category} instance if found in database; <code>null</code> otherwise.
   */
  @Query("SELECT * FROM Category WHERE category_id = :categoryId")
  Category findFirstByCategoryId(long categoryId);

  /**
   * Inserts zero or more {@link Category} instances into the local database. Any primary or unique key
   * constraint violations will result in the existing records being retained.
   *
   * @param Categories collection of {@link Category} instance(s) to be inserted.
   * @return inserted record ID(s).
   */
  @Insert
  List<Long> insert(Category... Categories);

  /**
   * Deletes zero or more {@link Category} instances from local database.
   *
   * @param Categories instances of {@link Category} to be deleted from database.
   */

  @Delete
  int Delete(Category... Categories);


}
