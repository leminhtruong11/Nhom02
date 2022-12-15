/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huhuh
 */
public class DBConnect {
    
    public static Connection getConnection() throws SQLException {
        
        try {
            Connection cons = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons=DriverManager.getConnection("jdbc:sqlserver://LE-MINH-TRUONG\\SQLEXPRESS;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=1;");
            return cons;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static void main(String[] args) throws SQLException {
        Connection c= getConnection();
        System.out.println(c.toString());
        c.close();
  }
}
