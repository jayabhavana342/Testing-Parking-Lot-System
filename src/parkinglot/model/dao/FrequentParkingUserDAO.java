package parkinglot.model.dao;

import parkinglot.model.database.DatabaseConnection;

import java.util.*;
import java.sql.*;
import java.io.*;

import parkinglot.model.FrequentParkingUser;

public class FrequentParkingUserDAO {

    private Connection myConn;

    public FrequentParkingUserDAO() throws Exception {
        myConn = DatabaseConnection.getConnection();

    }

    public void addFrequentParkingUser(FrequentParkingUser frequentParkingUser) throws Exception {

        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO frequent_parking_users"
                    + " (first_name, last_name, email, address,phone,license_id,rewards)"
                    + " VALUES (?, ?, ?, ?,? ,? ,?)");

            // set params
            myStmt.setString(1, frequentParkingUser.getFirstName());
            myStmt.setString(2, frequentParkingUser.getLastName());
            myStmt.setString(3, frequentParkingUser.getEmail());
            myStmt.setString(4, frequentParkingUser.getAddress());
            myStmt.setInt(5, frequentParkingUser.getPhone());
            myStmt.setString(6, frequentParkingUser.getLicense_id());
            myStmt.setInt(7, frequentParkingUser.getRewards());

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(null,myStmt, null);
        }

    }

    public List<FrequentParkingUser> getAllFrequentParkingUsers() throws Exception {
        List<FrequentParkingUser> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM frequent_parking_users");

            while (myRs.next()) {
                FrequentParkingUser tempFrequentParker = convertRowToFrequentParkingUser(myRs);
                list.add(tempFrequentParker);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public List<FrequentParkingUser> searchFrequentParkingUsers(String lastName) throws Exception {
        List<FrequentParkingUser> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("SELECT * FROM frequent_parking_users WHERE last_name LIKE ?");

            myStmt.setString(1, lastName);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                FrequentParkingUser tempFrequentParker = convertRowToFrequentParkingUser(myRs);
                list.add(tempFrequentParker);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    private FrequentParkingUser convertRowToFrequentParkingUser(ResultSet myRs) throws SQLException {

        String lastName = myRs.getString("last_name");
        String firstName = myRs.getString("first_name");
        String email = myRs.getString("email");
        String address = myRs.getString("address");
        int phone = myRs.getInt("phone");
        String license_id = myRs.getString("license_id");
        int rewards = myRs.getInt("rewards");

        return new FrequentParkingUser(lastName, firstName, email, address, phone, license_id, rewards);
    }


    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

}
