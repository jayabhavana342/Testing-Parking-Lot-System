# Create parkinglot database if it doesn't exists
CREATE DATABASE IF NOT EXISTS parkinglot;

# use parkinglot database
USE parkinglot;

# drop tables if they exist
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS frequent_parking_users;
DROP TABLE IF EXISTS parking_history;

# Table user's
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `is_admin` tinyint DEFAULT 0,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

# Insert into table users
INSERT INTO `users` (`id`, `last_name`, `first_name`, `email`, `password`, `is_admin`)
VALUES (1, 'Alpha', 'Joe', 'joe.alpha@foo.com', 'admin', 0);
