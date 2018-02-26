CREATE DATABASE IF NOT EXISTS parkinglot;

USE parkinglot;

DROP TABLE IF EXISTS admin_users;
DROP TABLE IF EXISTS update_parking_rates;
DROP TABLE IF EXISTS frequent_parker_vehicle_details_parking_history;
DROP TABLE IF EXISTS non_frequent_parker_vehicle_details_parking_history;
DROP TABLE IF EXISTS frequent_parker_vehicle_details;
DROP TABLE IF EXISTS vehicle_details;
DROP TABLE IF EXISTS frequent_parking_users;
DROP TABLE IF EXISTS parking_history;
DROP TABLE IF EXISTS parking_spaces;


CREATE TABLE `admin_users` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)           DEFAULT NULL,
  `first_name` VARCHAR(64)           DEFAULT NULL,
  `email`      VARCHAR(64)  NOT NULL,
  `password`   VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `admin_users` (`last_name`, `first_name`, `email`, `password`)
VALUES ('Alpha', 'Joe', 'joe.alpha@foo.com', 'admin');

CREATE TABLE `vehicle_details` (
  `id`           INT(11)     NOT NULL AUTO_INCREMENT,
  `vehicle_num`  VARCHAR(11) NOT NULL,
  `vehicle_type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;


CREATE TABLE `parking_history` (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `in_date_time`  TIMESTAMP,
  `out_date_time` TIMESTAMP,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

CREATE TABLE `parking_spaces` (
  `id`            INT(11)     NOT NULL AUTO_INCREMENT,
  `space_name`    VARCHAR(11) NOT NULL,
  `path_to_space` VARCHAR(11) NULL, # shortest path to the parking space
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('1', 'A', '');
INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('2', 'B', '');
INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('3', 'C', '');
INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('4', 'D', '');
INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('5', 'E', '');
INSERT INTO `parking_spaces` (id, space_name, path_to_space) VALUES ('6', 'F', '');

CREATE TABLE `update_parking_rates` (
  `id`   INT(11)   NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL,
  `rate` INT(11)   NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;


CREATE TABLE `frequent_parking_users` (
  `id`         INT(11)        NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)    NOT NULL,
  `first_name` VARCHAR(64)    NOT NULL,
  `email`      VARCHAR(64)    NOT NULL,
  `address`    VARCHAR(100)   NOT NULL,
  `phone`      INT(10) UNIQUE NOT NULL,
  `license_id` VARCHAR(10)    NOT NULL,
  `rewards`    INT(10)                 DEFAULT 0,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (1, 'karupanan', 'Shivaranjani', 'shivaranjani.karupanan@foo.com', 'txstate rrc', '515515515', 'A123A123');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (2, 'Kommuru', 'Bhavana', 'bhavana.kommuru@foo.com', 'txstate rrc', '616616616', 'A000A000');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (3, 'Agarwal', 'Mehak', 'mehak.agarwal@foo.com', 'txstate rrc', '717717717', 'A111A111');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (4, 'Rana', 'Aishwarya', 'aishwarya.rana@foo.com', 'txstate rrc', '818818818', 'A222A222');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (5, 'Ndame', 'Micheal', 'mike.adam@foo.com', 'txstate rrc', '919919919', 'A333A33');


CREATE TABLE `frequent_parker_vehicle_details` (
  `id`                    INT(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id`            INT(11) NOT NULL,
  `frequent_parker_phone` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (frequent_parker_phone) REFERENCES frequent_parking_users (phone),
  FOREIGN KEY (vehicle_id) REFERENCES vehicle_details (id)

)
  AUTO_INCREMENT = 1;

CREATE TABLE `frequent_parker_vehicle_details_parking_history` (
  `id`                                 INT(11) NOT NULL AUTO_INCREMENT,
  `frequent_parker_vehicle_details_id` INT(11) NOT NULL,
  `parking_history_id`                 INT(11) NOT NULL,
  `rate`                               INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (frequent_parker_vehicle_details_id) REFERENCES frequent_parker_vehicle_details (id),
  FOREIGN KEY (parking_history_id) REFERENCES parking_history (id)

)
  AUTO_INCREMENT = 1;


CREATE TABLE `non_frequent_parker_vehicle_details_parking_history` (
  `id`                 INT(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id`         INT(11) NOT NULL,
  `parking_history_id` INT(11) NOT NULL,
  `rate`               INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (vehicle_id) REFERENCES vehicle_details (id),
  FOREIGN KEY (parking_history_id) REFERENCES parking_history (id)

)
  AUTO_INCREMENT = 1;

