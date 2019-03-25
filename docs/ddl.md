```sql
CREATE TABLE IF NOT EXISTS `User` (
`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 `Search_id` INTEGER NOT NULL, 
 `name` TEXT, `lastName` TEXT,
 `email` TEXT
 );

CREATE TABLE IF NOT EXISTS `Search` (
`category_id` INTEGER NOT NULL, 
`search_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
`date` INTEGER, 
`user_id` INTEGER NOT NULL, 
`url` TEXT, `title` TEXT
);
```