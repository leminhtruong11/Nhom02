/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huhuh
 */
public class Quanly {
    public void updatesach(Sach sach) {
        try{
                        String sqlChange="UPDATE SACH SET TenSach=?, SoLuong=?, TacGia=?, Gia=?, LoaiSach=? WHERE MaSach='"+sach.getMaSach()+"'";
                        Connection conn=DBConnect.getConnection();
                        PreparedStatement pst=conn.prepareCall(sqlChange);
                        pst.setString(1, sach.getTenSach());                        
                        pst.setInt(2, sach.getSL());
                        pst.setInt(4, sach.getGia());
                        pst.setString(5, sach.getLoaiSach());
                        pst.setString(3, sach.getTacGia());
                        
                        pst.executeUpdate();


                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
    }
    
    public void xoasach(Sach sach) {
        try{
                        String sqlChange="delete from SACH WHERE MaSach='"+sach.getMaSach()+"'";
                        Connection conn=DBConnect.getConnection();
                        PreparedStatement pst=conn.prepareCall(sqlChange);
                        
                        pst.executeUpdate();


                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
    }
    
    public void themnhanvien(Nhanvien nhanvien) {
        PreparedStatement statement = null;
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "1");
            String sql = "INSERT INTO NHANVIEN (MaNV, TenNV, Tuoi, DiaChi, SDT, Mail, GioiTinh, Luong, TinhTrang,  GhiChu, NgaySinh, TK, MK) values (?,?,?, ?, ?, ?, ?, ?,?,?,?,?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, nhanvien.getMaNV());
            statement.setString(2, nhanvien.getTenNV());
            statement.setInt(3, nhanvien.getTuoi());
            statement.setString(4, nhanvien.getDiaChi());
            statement.setString(5, nhanvien.getDiaChi());
            statement.setString(6, nhanvien.getMail());
            statement.setInt(7, nhanvien.getGioiTinh());
            statement.setInt(8, nhanvien.getLuong());
            statement.setInt(9, nhanvien.getTinhTrang());
            
            
            statement.setString(10, nhanvien.getGhiChu());
            //java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(nhanvien.getNgaySinh().getTime());
            statement.setDate(11, sqlDate);

            statement.setString(12, nhanvien.getTK());
            statement.setString(13, nhanvien.getMK());
            statement.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        statement = null;
        conn = null;
        
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "1");
            String sql = "INSERT INTO VERIFY (MaNV, MaXacThuc) values (?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, nhanvien.getMaNV());
            statement.setString(2, "");
           
            statement.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    }
    
    
    
 

