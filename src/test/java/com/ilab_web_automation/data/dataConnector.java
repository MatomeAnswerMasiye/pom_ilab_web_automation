package com.ilab_web_automation.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//A class that contains the logic to connect to database
public class dataConnector {

    //Logic for connecting to database and querying data
    public ResultSet ConnectAndQuerySQL(String sDBURL, String sUserName, String sPassword, String sQuery) {

        //Stores data queried from database
        ResultSet rs = null;

        //Connects and queries data from the database
        try {

            String dbURL = sDBURL;
            String user = sUserName;
            String pass = sPassword;
            java.sql.Connection conn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Returns the data queried from the database
        return rs;
    }

}