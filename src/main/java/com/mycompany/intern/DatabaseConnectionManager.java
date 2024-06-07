/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.intern;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author maytinh
 */
public class DatabaseConnectionManager {

    private final String url;

    public DatabaseConnectionManager(
            String databaseName,
            String username,
            String password
    ) {
        this.url = "jdbc:sqlserver://localhost:1433;database=" + databaseName
                + ";user=" + username
                + ";password=" + password
                + ";encrypt=true;" + "trustServerCertificate=true;" + "loginTimeout=30;";
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(this.url);
    }

}
