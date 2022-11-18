/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huhuh
 */
public class Quanly {
    public void updatesach(Sach sach) {
        try{
                        String sqlChange="UPDATE SACH SET TenSach=?, SoLuong=?, TacGia=?, Gia=?, LoaiSach=? WHERE MaNV='"+sach.getMaSach()+"'";
                        Connection conn=DBConnect.getConnection();
                        PreparedStatement pst=conn.prepareCall(sqlChange);
                        pst.setString(1, sach.getTenSach());                        
                        pst.setInt(2, sach.getSL());
                        pst.setInt(4, sach.getGia());
                        pst.setString(4, sach.getLoaiSach());
                        pst.setString(3, sach.getTacGia());
                        
                        pst.executeUpdate();


                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
    }
 
}
