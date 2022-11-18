/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nhanvien;

/**
 *
 * @author huhuh
 */
public class NhanviendaoImpl implements Nhanviendao {
    @Override
    public List<Nhanvien> getList() {
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from NHANVIEN";
            List<Nhanvien> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Nhanvien Nhanvien=new Nhanvien();
                
                Nhanvien.setMaNV(rs.getString("MaNV"));
                Nhanvien.setTenNV(rs.getString("TenNV"));
                Nhanvien.setTuoi(rs.getInt("Tuoi"));
                Nhanvien.setLuong(rs.getInt("Luong"));
                Nhanvien.setNgaySinh(rs.getDate("NgaySinh"));
                Nhanvien.setTK(rs.getString("Tk"));
                Nhanvien.setMK(rs.getString("MK"));
                Nhanvien.setSDT(rs.getString("SDT"));
                Nhanvien.setMail(rs.getString("Mail"));
                Nhanvien.setGioiTinh(rs.getInt("GioiTinh"));
                
                list.add(Nhanvien);
                Nhanvien a=list.get(0);
                System.out.println(a.getTenNV());
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Nhanviendao Nhanviendao=new NhanviendaoImpl();
        System.out.println(Nhanviendao.getList());
        
    }
}
    