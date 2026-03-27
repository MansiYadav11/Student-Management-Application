package com.Mansi.db;

import java.sql.Connection;  // ✅ THIS is the correct import!
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection createConnection() {
        Connection con = null;
        
        try {
            // No need to load driver manually for MySQL 8+
            String url = "jdbc:mysql://localhost:3306/students?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "mysql123";
            
            con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connected successfully!");
            
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
        
        return con;
    }
}