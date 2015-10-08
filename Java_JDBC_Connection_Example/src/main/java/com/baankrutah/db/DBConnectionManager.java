package com.baankrutah.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    /**
     * this method is connect to db server without username and password
     *
     * @param host is db server url ex: 127.0.0.1:3306
     * @return database connection
     * @throws DBException (ClassNotFound & SQLException)
     */
    public static Connection getConnection(String host) throws DBException {
        Connection con = null;
        StringBuilder url = new StringBuilder("jdbc:db2://");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url.append(host);
            con = DriverManager.getConnection(url.toString());
        } catch (ClassNotFoundException e) {
            throw new DBException("ClassNotFoundException: driver not found! (com.mysql.jdbc.Driver)", e);
        } catch (SQLException e) {
            throw new DBException("SQLException: " + e.getMessage(), e);
        }
        return con;
    }

    /**
     * this method is connect to db server with username and password
     *
     * @param host     is db server url ex: 127.0.0.1:3306
     * @param username is username of db server
     * @param password is password of db server
     * @return database connection
     * @throws DBException (ClassNotFound & SQLException)
     */
    public static Connection getConnection(String host, String username, String password) throws DBException {
        Connection con = null;
        StringBuilder url = new StringBuilder("jdbc:db2://");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url.append(host);
            con = DriverManager.getConnection(url.toString(), username, password);
        } catch (ClassNotFoundException e) {
            throw new DBException("ClassNotFoundException: driver not found! (com.mysql.jdbc.Driver)", e);
        } catch (SQLException e) {
            throw new DBException("SQLException: " + e.getMessage(), e);
        }
        return con;
    }

}
