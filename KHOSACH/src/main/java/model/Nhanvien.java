/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DBConnect;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author huhuh
 */
public class Nhanvien extends Quanly {
    private String MaNV;
    private String TenNV;
    private int Tuoi;
    private Date NgaySinh;
    private int GioiTinh;
    private int Luong;
    private String GhiChu;
    private String TK;
    private String MK;

    
    private String SDT;
    private String Mail;
    private String DiaChi;
    private int TinhTrang;

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

 
    

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    
    

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTK() {
        return TK;
    }

    public void setTK(String TK) {
        this.TK = TK;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }
    
    public void setInfor(String manv) {
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from NHANVIEN where MaNV=?";
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, manv);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                this.setMaNV(manv);
                this.setTenNV(rs.getString("TenNV"));
                this.setTuoi(rs.getInt("Tuoi"));
                this.setLuong(rs.getInt("Luong"));
                this.setNgaySinh(rs.getDate("NgaySinh"));
                this.setTK(rs.getString("TK"));
                this.setMK(rs.getString("MK"));
                this.setSDT(rs.getString("SDT"));
                this.setMail(rs.getString("Mail"));
                this.setGioiTinh(rs.getInt("GioiTinh"));
                this.setTinhTrang(rs.getInt("TinhTrang"));
                this.setGhiChu(rs.getString("GhiChu"));
                this.setDiaChi(rs.getString("DiaChi"));
                
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setInforAdmin(String manv) {
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from QUANLY where MaQL=?";
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, manv);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                this.setMaNV(manv);
                this.setTenNV(rs.getString("TenQL"));
                this.setTK(rs.getString("TKAdmin"));
                this.setMK(rs.getString("MKAdmin"));
                
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void nhapsachmoi(Sach sach) {
        PreparedStatement statement = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO\\KHOA;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "123");
            String sql = "INSERT INTO SACH (MaSach, TacGia, TenSach, LoaiSach, SoLuong, Gia) values (?, ?, ?, ?, ?,?)";
            statement = conn.prepareCall(sql);

            statement.setString(2, sach.getTacGia());
            statement.setString(3, sach.getTenSach());
            statement.setString(4, sach.getLoaiSach());
            statement.setInt(5, sach.getSL());
            statement.setInt(6, sach.getGia());
            String a="ms";
            Random generator = new Random();
            for(int i=1;i<=8;i++) {
                int value = generator.nextInt(9) + 1;
                a+=value;
            }

            statement.setString(1, a);
            
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void nhapsachcu(Sach sach) {
        Connection conn = null;
        try{
            String sqlChange="Select * from SACH where MaSach=? ";
            conn=DBConnect.getConnection();
            PreparedStatement pst=conn.prepareCall(sqlChange);
            pst.setString(1, sach.getMaSach());
            ResultSet rs=pst.executeQuery();
            int i = 0;
            while(rs.next()) {
                i=rs.getInt("SoLuong");
                
            }
            
            
            i+=sach.getSL();
            
            sqlChange="UPDATE SACH SET SoLuong=? WHERE MaSach=?";
            conn=DBConnect.getConnection();
            pst=conn.prepareCall(sqlChange);
            pst.setInt(1, i);
            pst.setString(2, sach.getMaSach());
            pst.executeUpdate();

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void xuatsach(Sach sach) {
        Connection conn = null;
        try{
            String sqlChange="Select * from SACH where MaSach=? ";
            conn=DBConnect.getConnection();
            PreparedStatement pst=conn.prepareCall(sqlChange);
            pst.setString(1, sach.getMaSach());
            ResultSet rs=pst.executeQuery();
            int i = 0;
            while(rs.next()) {
                i=rs.getInt("SoLuong");
                
            }
            
            
            i+=sach.getSL();
            
            sqlChange="UPDATE SACH SET SoLuong=? WHERE MaSach=?";
            conn=DBConnect.getConnection();
            pst=conn.prepareCall(sqlChange);
            pst.setInt(1, i);
            pst.setString(2, sach.getMaSach());
            pst.executeUpdate();
            
            

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void xuathoadonnhap(HOADONNHAP hdn, String mhdn) {
        PreparedStatement statement = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO\\KHOA;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "123");
            String sql = "INSERT INTO HOADONNHAP (MHDN, MaSach, SLNhap, MaNV, NgayNhap, ThoiGianNhap) values (?, ?, ?, ?, ?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, mhdn);
            statement.setString(2, hdn.getMaSach());
            statement.setInt(3, hdn.getSL());
            statement.setString(4, hdn.getMaNV());
            java.util.Date date = Calendar.getInstance().getTime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            statement.setTime(6, hdn.getThoiGian());
            statement.setDate(5, sqlDate);

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void xuathoadonxuat(HOADONNHAP hdn, String mhdx) {
        PreparedStatement statement = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO\\KHOA;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=123;","sa", "123");
            String sql = "INSERT INTO HOADONXUAT (MHDX, MaSach, SLXuat, MaNV, NgayXuat, ThoiGianXuat) values (?, ?, ?, ?, ?,?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, mhdx);
            statement.setString(2, hdn.getMaSach());
            statement.setInt(3, hdn.getSL());
            statement.setString(4, hdn.getMaNV());
            java.util.Date date = Calendar.getInstance().getTime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            statement.setTime(6, hdn.getThoiGian());
            statement.setDate(5, sqlDate);

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
