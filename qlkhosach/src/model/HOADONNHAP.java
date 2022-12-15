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
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author huhuh
 */
public class HOADONNHAP {
    private String MHDN;
    private int SL;
    private String MaSach;
    private String MaNV;
    private Date NgayNhap;
    private Time ThoiGian;
    private String MHDNnew;
    private int i;
    public String getMHDNnew() {
        MHDNnew="mhdn";
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="SELECT COUNT(*) as SL FROM HOADONNHAP ";
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
        if(1<=i && i<=9) MHDNnew=MHDNnew+0+0+0+0+0+0+i;
        if(10<=i && i<=99) MHDNnew=MHDNnew+0+0+0+0+0+i;
        if(100<=i && i<=999) MHDNnew=MHDNnew+0+0+0+0+i;
        if(1000<=i && i<=9999) MHDNnew=MHDNnew+0+0+0+i;
        if(10000<=i && i<=99999) MHDNnew=MHDNnew+0+0+i;
        if(100000<=i && i<=999999) MHDNnew=MHDNnew+0+i;
        if(1000000<=i && i<=9999999) MHDNnew=MHDNnew+i;
        return MHDNnew;
    }
    
    
    public String getMHDXnew() {
        MHDNnew="mhdx";
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="SELECT COUNT(*) as SL FROM HOADONNHAP ";
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
        if(1<=i && i<=9) MHDNnew=MHDNnew+0+0+0+0+0+0+i;
        if(10<=i && i<=99) MHDNnew=MHDNnew+0+0+0+0+0+i;
        if(100<=i && i<=999) MHDNnew=MHDNnew+0+0+0+0+i;
        if(1000<=i && i<=9999) MHDNnew=MHDNnew+0+0+0+i;
        if(10000<=i && i<=99999) MHDNnew=MHDNnew+0+0+i;
        if(100000<=i && i<=999999) MHDNnew=MHDNnew+0+i;
        if(1000000<=i && i<=9999999) MHDNnew=MHDNnew+i;
        return MHDNnew;
    }
    
    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    
    
    public Time getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Time ThoiGian) {
        this.ThoiGian = ThoiGian;
    }
    
    

    public String getMHDN() {
        return MHDN;
    }

    public void setMHDN(String MHDN) {
        this.MHDN = MHDN;
    }

   

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    

    
    
}
