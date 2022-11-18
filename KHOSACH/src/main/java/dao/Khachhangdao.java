/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author huhuh
 */
public class Khachhangdao {
      public static void main(String[] args) {
        PreparedStatement statement = null;
        Connection conn = null;
        java.util.Date date = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO\\KHOA;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "123");
            String sql = "INSERT INTO NHANVIEN (MaNV, TenNV, Tuoi, Luong, NgaySinh, GhiChu, TK, MK, SDT, Mail, GioiTinh) values (?, ?, ?, ?, ?,?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, "a");
            statement.setString(2, "a");
            statement.setInt(3, 3);
            statement.setInt(4, 3);
            statement.setDate(5,sqlDate);
            statement.setString(6, "a");
            statement.setString(7, "a");
            statement.setString(8, "a");
            statement.setString(9, "a");
            statement.setString(10, "a");
            statement.setInt(11, 3);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Nhanviendao.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
