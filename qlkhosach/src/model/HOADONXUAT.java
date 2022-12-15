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
public class HOADONXUAT {
    private String MHDX;
    private int SLXuat;
    private String MaSach;
    private String MaNV;
    private Date NgayTao;
    private String MHDXnew;
    private Time ThoiGian;
    private int i;
    public String getMHDXnew() {
        MHDXnew="mhdn";
        
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
        if(1<=i && i<=9) MHDXnew=MHDXnew+0+0+0+0+0+0+i;
        if(10<=i && i<=99) MHDXnew=MHDXnew+0+0+0+0+0+i;
        if(100<=i && i<=999) MHDXnew=MHDXnew+0+0+0+0+i;
        if(1000<=i && i<=9999) MHDXnew=MHDXnew+0+0+0+i;
        if(10000<=i && i<=99999) MHDXnew=MHDXnew+0+0+i;
        if(100000<=i && i<=999999) MHDXnew=MHDXnew+0+i;
        if(1000000<=i && i<=9999999) MHDXnew=MHDXnew+i;
        return MHDXnew;
    }
    public String getMHDX() {
        return MHDX;
    }

    public void setMHDX(String MHDN) {
        this.MHDX = MHDN;
    }

    public int getSLXuat() {
        return SLXuat;
    }

    public void setSLXuat(int SLXuat) {
        this.SLXuat = SLXuat;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    
}
