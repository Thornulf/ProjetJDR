/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities;

import java.sql.Connection;

/**
 *
 * @author Thomas
 */
public class GlobaleConnection {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        GlobaleConnection.connection = connection;
    }
}
