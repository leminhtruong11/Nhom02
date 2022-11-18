/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
