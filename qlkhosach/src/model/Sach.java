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
public class Sach {
    private String MaSach;
    private String TenSach;
    private String TacGia;
    private int Gia;
    private String LoaiSach;
    private int SL;
    private String MaSachnew;
    private int i;
    public String getMaSachnew() {
        MaSachnew="ms";
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="SELECT COUNT(*) as SL FROM SACH ";
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                i=rs.getInt("SL");
            }
            
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        i+=1;
        if(1<=i && i<=9) MaSachnew=MaSachnew+0+0+0+0+0+0+0+i;
        if(10<=i && i<=99) MaSachnew=MaSachnew+0+0+0+0+0+0+i;
        if(100<=i && i<=999) MaSachnew=MaSachnew+0+0+0+0+0+i;
        if(1000<=i && i<=9999) MaSachnew=MaSachnew+0+0+0+0+i;
        if(10000<=i && i<=99999) MaSachnew=MaSachnew+0+0+0+i;
        if(100000<=i && i<=999999) MaSachnew=MaSachnew+0+0+i;
        if(1000000<=i && i<=9999999) MaSachnew=MaSachnew+0+i;
        if(10000000<=i && i<=99999999) MaSachnew=MaSachnew+i;
        return MaSachnew;
    }
    
    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getLoaiSach() {
        return LoaiSach;
    }

    public void setLoaiSach(String LoaiSach) {
        this.LoaiSach = LoaiSach;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }
    
    public void setInfor(String ms) {
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH where MaSach=?";
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, ms);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                this.setMaSach(ms);
                this.setTenSach(rs.getString("TenSach"));
                this.setTacGia(rs.getString("TacGia"));
                this.setLoaiSach(rs.getString("LoaiSach"));
                this.setSL(rs.getInt("SoLuong"));
                this.setGia(rs.getInt("Gia"));
                
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
