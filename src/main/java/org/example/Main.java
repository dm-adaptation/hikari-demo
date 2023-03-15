package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT 1 FROM DUAL";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:dm://localhost:5236");
        config.setDriverClassName("dm.jdbc.driver.DmDriver");
        config.setUsername("SYSDBA");
        config.setPassword("SYSDBA");

        HikariDataSource hikariDataSource = new HikariDataSource(config);

        Connection connection = hikariDataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        resultSet.close();
        statement.close();
        connection.close();
        hikariDataSource.close();
    }
}