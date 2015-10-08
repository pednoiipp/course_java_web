package com.baankrutah.app;

import com.baankrutah.db.DBConnectionManager;
import com.baankrutah.db.DBException;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection1 = null;
        Connection connection2 = null;
        try {
            String dbUrl = "127.0.0.1:3306";
            String dbUser = "root";
            String dbPass = "root";

            connection1 = getConnectionWithOutUserPass(dbUrl);
            connection2 = getConnectionWithUserPass(dbUrl, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection1 != null) {
                try {
                    connection1.close();
                } catch (Exception ignored) {
                }
            }
            if (connection2 != null) {
                try {
                    connection2.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    /**
     * example : get connection without username and password
     *
     * @param url : db server url
     * @return database connection
     * @throws DBException
     */
    private static Connection getConnectionWithOutUserPass(String url) throws DBException {
        return DBConnectionManager.getConnection(url);
    }

    /**
     * example : get connection with username and password
     *
     * @param url  : db server url
     * @param user : db username
     * @param pass : db password
     * @return database connection
     * @throws DBException
     */
    private static Connection getConnectionWithUserPass(String url, String user, String pass) throws DBException {
        return DBConnectionManager.getConnection(url, user, pass);
    }

}
