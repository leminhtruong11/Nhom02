/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DBConnect;
import dao.taotk;
import java.io.UnsupportedEncodingException;
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
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    private String MaNVnew;
    private String SDT;
    private String Mail;
    private String DiaChi;
    private int TinhTrang;
    private int i;
    public String getMaNVnew() {
        MaNVnew="nv";
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="SELECT COUNT(*) as SL FROM NHANVIEN ";
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
        if(1<=i && i<=9) MaNVnew=MaNVnew+0+0+0+0+0+0+0+i;
        if(10<=i && i<=99) MaNVnew=MaNVnew+0+0+0+0+0+0+i;
        if(100<=i && i<=999) MaNVnew=MaNVnew+0+0+0+0+0+i;
        if(1000<=i && i<=9999) MaNVnew=MaNVnew+0+0+0+0+i;
        if(10000<=i && i<=99999) MaNVnew=MaNVnew+0+0+0+i;
        if(100000<=i && i<=999999) MaNVnew=MaNVnew+0+0+i;
        if(1000000<=i && i<=9999999) MaNVnew=MaNVnew+0+i;
        if(10000000<=i && i<=99999999) MaNVnew=MaNVnew+i;
        return MaNVnew;
    }

    
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
        TK=taotk.removeAccent(TenNV);
        return TK;
    }

    public void setTK(String TK) {
        this.TK = TK;
    }

    public String getMK() {
        return "1";
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
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=1;","sa", "1");
            String sql = "INSERT INTO SACH (MaSach, TacGia, TenSach, LoaiSach, SoLuong, Gia) values (?, ?, ?, ?, ?,?)";
            statement = conn.prepareCall(sql);

            statement.setString(2, sach.getTacGia());
            statement.setString(3, sach.getTenSach());
            statement.setString(4, sach.getLoaiSach());
            statement.setInt(5, sach.getSL());
            statement.setInt(6, sach.getGia());
            

            statement.setString(1, sach.getMaSachnew());
            
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
            
            
            i-=sach.getSL();
            
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
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=1;","sa", "1");
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
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=1;","sa", "1");
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
    
    public void nhanmaxacthuc() throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "nhom2QLSach@gmail.com";
        // Mat khai email cua ban
        final String password = "phrigntyxesfslvq";
        // dia chi email nguoi nhan
        final String toEmail = Mail;

        final String subject = "Mã xác thực reset mật khẩu";
        int a=0;
        Random generator = new Random();
        for(int i=1;i<=6;i++) {
            int value = generator.nextInt(9) + 1;
            a=a*10+value;
        }
        final String body = String.valueOf(a);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);


        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
        
        PreparedStatement statement = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-F9HOTBO;databaseName=KHOSACH;portNumber=1433;encrypt=true;trustServerCertificate=true;user=sa;password=1;","sa", "1");
            String sql="UPDATE VERIFY SET MaXacThuc=? WHERE MaNV='"+MaNV+"'";
            statement = conn.prepareCall(sql);
            statement.setString(1, body);
 

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
