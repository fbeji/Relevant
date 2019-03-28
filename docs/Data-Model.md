## Data model

### Entity-Relationship Diagram

[ERD](My_App_ERD.pdf)


### Schema Data Definition Language (DDL)

```SQL

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



CREATE TABLE IF NOT EXISTS `category` (
`category_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 `name` TEXT)
 
 CREATE TABLE IF NOT EXISTS `SearchEntry` (
 `search_entry_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
 `search_id` INTEGER NOT NULL, `sequence` INTEGER NOT NULL,
 `category_id` INTEGER NOT NULL, 
 `url` INTEGER NOT NULL, 
 FOREIGN KEY(`search_id`) REFERENCES `Search`(`search_id`) ON UPDATE NO ACTION ON DELETE CASCADE);

```
