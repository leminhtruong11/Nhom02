/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author huhuh
 */
public class ConnectSQLServerExample {
    
    public static void main(String[] args) {
    try {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String connectionUrl = "jdbc:sqlserver://DESKTOP-F9HOTBO\\KHOA" +
        "databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;";
        Connection con = DriverManager.getConnection(connectionUrl);
    } catch (SQLException e) {
        System.out.println("SQL Exception: "+ e.toString());
    } catch (ClassNotFoundException cE) {
        System.out.println("Class Not Found Exception: "+ cE.toString());
    }
  }
}
