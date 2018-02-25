# Create parkinglot database if it doesn't exists
CREATE DATABASE IF NOT EXISTS parkinglot;

# use parkinglot database
USE parkinglot;

# drop tables if they exist
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS frequent_parking_users;
DROP TABLE IF EXISTS parking_history;