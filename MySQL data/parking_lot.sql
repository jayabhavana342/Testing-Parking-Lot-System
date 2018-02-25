# Create parkinglot database if it doesn't exists
CREATE DATABASE IF NOT EXISTS parkinglot;

# use parkinglot database
USE parkinglot;

# drop tables if they exist
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS frequent_parking_users;
DROP TABLE IF EXISTS parking_history;

# User's Table
CREATE TABLE `users` (
  `id`         INT(11) NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)      DEFAULT NULL,
  `first_name` VARCHAR(64)      DEFAULT NULL,
  `email`      VARCHAR(64)      DEFAULT NULL,
  `password`   VARCHAR(256)     DEFAULT NULL,
  `is_admin`   TINYINT          DEFAULT 0,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

# Insert into table users
INSERT INTO `users` (`id`, `last_name`, `first_name`, `email`, `password`, `is_admin`)
VALUES (1, 'Alpha', 'Joe', 'joe.alpha@foo.com', 'admin', 0);

# Frequent Parking User's table
CREATE TABLE `frequent_parking_users` (
  `id`         INT(11) NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)      DEFAULT NULL,
  `first_name` VARCHAR(64)      DEFAULT NULL,
  `email`      VARCHAR(64)      DEFAULT NULL,
  `address`    VARCHAR(100)     DEFAULT NULL,
  `phone`      INT(10)          DEFAULT NULL,
  `license_id` VARCHAR(10)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;
