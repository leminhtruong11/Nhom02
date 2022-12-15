/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unity;

import dao.DBConnect;
import java.awt.event.KeyEvent;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Nhanvien;


/**
 *
 * @author huhuh
 */
public class QLnhanvien extends javax.swing.JFrame {
    private List<Nhanvien> search=new ArrayList<>();
    private List<Nhanvien> table=new ArrayList<>();

    /**
     * Creates new form QLnhanvien
     */
    public QLnhanvien(String abc) {
        initComponents();
        begin.setText(abc);
        begin.setVisible(false);
        loadlist();
        tableload(table);
        manv.enable(false);
    }
    
    public void clearTable()
{
    DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
    dm.getDataVector().removeAllElements();
    revalidate();
    manv.setText("");
        ten.setText("");
        tuoi.setText("");
        diachi.setText("");
        sdt.setText("");
        mail.setText("");
        luong.setText("");
        ghichu.setText("");
        ngaysinh.setText("");
}
    
    public void loadlist() {
        clearTable();
        table=new ArrayList<>();
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
                Nhanvien.setTinhTrang(rs.getInt("TinhTrang"));
                Nhanvien.setGhiChu(rs.getString("GhiChu"));
                Nhanvien.setDiaChi(rs.getString("DiaChi"));
                
                table.add(Nhanvien);
                
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    search=table;
        
    }
    
    public void tableload(List<Nhanvien> table) {
        clearTable();
        
        for(int i=0;i<table.size();i++) {
            if(table.get(i).getTinhTrang()!=0) {
                Object obj[]=new Object[11];
                obj[0]=table.get(i).getMaNV();
                obj[1]=table.get(i).getTenNV();
                obj[2]=table.get(i).getTuoi();
                obj[3]=table.get(i).getDiaChi();
                obj[4]=table.get(i).getSDT();
                obj[5]=table.get(i).getMail();
                if(table.get(i).getGioiTinh()==1)
                    obj[6]="Nam";
                else obj[6]="Nữ";
                obj[7]=table.get(i).getLuong();
                if(table.get(i).getTinhTrang()==1)
                    obj[8]="Còn làm";
                else
                    obj[8]="Đình chỉ";
                obj[9]=table.get(i).getNgaySinh();
                obj[10]=table.get(i).getGhiChu();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
        }
        
    }
    

    
     public void theomnv() {
        clearTable();
        search=new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getMaNV().toLowerCase().equals(this.txtFind.getText().toLowerCase())) {
                search.add(table.get(i));
            }
        }
        tableload(search);
     }
     
      public void theotennv() {
        clearTable();
        search=new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
        if (table.get(i).getTenNV().toLowerCase().contains(this.txtFind.getText().toLowerCase())) {
            search.add(table.get(i));
        }
        }
        tableload(search);
     }
        
      public void theodiachi() {
        clearTable();
        search=new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
        if (table.get(i).getDiaChi().toLowerCase().contains(this.txtFind.getText().toLowerCase())) {
            search.add(table.get(i));
        }
        }
        tableload(search);
     }
      

       
        public void theosdt() {
        clearTable();
        search=new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
        if (table.get(i).getSDT().toLowerCase().contains(this.txtFind.getText().toLowerCase())) {
            search.add(table.get(i));
        }
        }
        tableload(search);
     }
        
    public void theomail() {
        clearTable();
        search=new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
        if (table.get(i).getMail().toLowerCase().contains(this.txtFind.getText().toLowerCase())) {
            search.add(table.get(i));
        }
        }
        tableload(search);
     }
          
    public void theogioitinh() {
        clearTable();
        search=new ArrayList<>();
        int tmp=3;
        if(boxgioitinh.getSelectedItem()=="Nam") tmp=1;
        else if(boxgioitinh.getSelectedItem()=="Nữ") tmp=0;
        for (int i = 0; i < table.size(); i++) {
        if (table.get(i).getGioiTinh()==tmp) {
            search.add(table.get(i));
        }
        }
        if(tmp==3) search=table;
        tableload(search);
        
     }
            
        public void theotinhtrang() {
            clearTable();
            search=new ArrayList<>();
            int tmp = 3;
            if(boxtinhtrang.getSelectedItem()=="Còn làm") tmp=1;
            else if(boxtinhtrang.getSelectedItem()=="Đình chỉ") tmp=2;
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i).getTinhTrang()==tmp) {
                    search.add(table.get(i));
                }
            }
            if(tmp==3) search=table;
            tableload(search);
           
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        begin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ten = new javax.swing.JTextField();
        manv = new javax.swing.JTextField();
        luong = new javax.swing.JTextField();
        tuoi = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        diachi = new javax.swing.JTextField();
        sdt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gioitinh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ghichu = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tinhtrang = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ngaysinh = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        luachontim = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        boxgioitinh = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        boxtinhtrang = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CẬP NHẬT NHÂN VIÊN");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        jButton1.setText("Trang chính");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        begin.setText("jLabel13");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(begin)
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(begin)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));

        tuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuoiActionPerformed(evt);
            }
        });

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã NV");

        jLabel3.setText("Tên nhân viên");

        jLabel4.setText("Tuổi");

        jLabel5.setText("Lương");

        jLabel6.setText("Số điện thoại");

        jLabel7.setText("Địa chỉ");

        jLabel8.setText("Mail");

        gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel10.setText("Giới tính");

        ghichu.setColumns(20);
        ghichu.setRows(5);
        jScrollPane1.setViewportView(ghichu);

        jLabel11.setText("Ghi chú");

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tình trạng");

        tinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn làm", "Đuổi việc", "Đình chỉ" }));

        jLabel12.setText("Ngày sinh");

        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Find.png"))); // NOI18N
        jLabel13.setText("Tìm kiếm");

        jLabel14.setText("Theo");

        luachontim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Tên nhân viên", "Địa chỉ", "Số điện thoại", "Mail" }));

        jLabel15.setText("Giới tính");

        boxgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Nam", "Nữ" }));
        boxgioitinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxgioitinhMouseClicked(evt);
            }
        });
        boxgioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxgioitinhActionPerformed(evt);
            }
        });
        boxgioitinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxgioitinhKeyPressed(evt);
            }
        });

        jLabel16.setText("Tình trạng");

        boxtinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Còn làm", "Đình chỉ" }));
        boxtinhtrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxtinhtrangMouseClicked(evt);
            }
        });
        boxtinhtrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxtinhtrangActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên nhân viên", "Tuổi", "Địa chỉ", "SĐT", "Email", "Giới tính", "Lương", "Tình trạng", "Ngày sinh", "Ghi chú"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        status.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 51, 51));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Tình trạng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(status)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status)
        );

        jButton5.setText("Tìm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel9)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jButton2)
                                .addGap(81, 81, 81)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(452, 452, 452))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(luachontim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxtinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(manv)
                                                        .addComponent(ten, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                                    .addGap(55, 55, 55)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel12)))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10)))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(luong, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                        .addComponent(ngaysinh))
                                                    .addGap(47, 47, 47)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel8)))
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(46, 46, 46)
                                                    .addComponent(jLabel4)
                                                    .addGap(30, 30, 30)
                                                    .addComponent(tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(31, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(luachontim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(boxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(boxtinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuoiActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminMain a=new AdminMain(this.begin.getText());
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
   
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

                               try{      
                            String sqlChange="UPDATE NHANVIEN SET TenNV=?, Tuoi=?, Luong=?, GhiChu=?, SDT=?, Mail=?, GioiTinh=?, TinhTrang=?, DiaChi=?, NgaySinh=? WHERE MaNV='"+this.manv.getText()+"'";
                        Connection conn=DBConnect.getConnection();
                        PreparedStatement pst=conn.prepareCall(sqlChange);
                        pst.setString(1, ten.getText());                        
                        pst.setInt(2, Integer.parseInt(tuoi.getText()));
                        pst.setInt(3, Integer.parseInt(luong.getText()));
                        pst.setString(4, ghichu.getText());
                        pst.setString(5, sdt.getText());
                        pst.setString(6, mail.getText());
                        if((String)gioitinh.getSelectedItem()=="Nam") pst.setInt(7, 1);
                        else pst.setInt(7, 0);
                        
                        if((String)tinhtrang.getSelectedItem()=="Còn làm") pst.setInt(8, 1);
                        else if((String)tinhtrang.getSelectedItem()=="Đuổi việc") pst.setInt(8, 0);
                        else pst.setInt(8, 2);
                        
                        pst.setString(9, diachi.getText());
                        
                       pst.setDate(10, java.sql.Date.valueOf(ngaysinh.getText()));
                        pst.executeUpdate();

                        status.setText("Đổi thông tin thành công!");
                        CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                            status.setText("Trạng thái");
                         });
                        clearTable();
                        loadlist();
                        tableload(table);



                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                        
                        
                        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadlist();
        tableload(table);
        manv.setText("");
        ten.setText("");
        tuoi.setText("");
        diachi.setText("");
        sdt.setText("");
        mail.setText("");
        luong.setText("");
        ghichu.setText("");
        ngaysinh.setText("");
        gioitinh.setSelectedItem("Nam");
        tinhtrang.setSelectedItem("Còn làm");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        Nhanvien a=new Nhanvien();
        a.setMaNV(a.getMaNVnew());
        a.setTenNV(ten.getText());
        a.setTuoi(Integer.parseInt(tuoi.getText()));
        a.setDiaChi(diachi.getText());
        a.setSDT(sdt.getText());
        a.setMail(mail.getText());
        String tmp=(String)gioitinh.getSelectedItem();
        if(tmp=="Nam") a.setGioiTinh(1);
            else a.setGioiTinh(0);
        a.setLuong(Integer.parseInt(luong.getText()));
       
        a.setGhiChu(ghichu.getText());
        
        String tmp1=(String)tinhtrang.getSelectedItem();
        if(tmp1=="Còn làm") a.setTinhTrang(1);
        else if(tmp1=="Đuổi việc") a.setTinhTrang(0);
        else a.setTinhTrang(2);
        
         String date = ngaysinh.getText();
        a.setNgaySinh(java.sql.Date.valueOf(date));
        
        Nhanvien b=new Nhanvien();
        b.themnhanvien(a);
        
        status.setText("Thêm nhân viên mới thành công");
        CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
           status.setText("Trạng thái");
        });
        loadlist();
        tableload(table);
        a=new Nhanvien();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int Click=jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        if(model.getValueAt(Click,6).toString().equals("1"))  {
            gioitinh.setSelectedItem("Nam");
        } else {
            gioitinh.setSelectedItem("Nữ");
        }
        if(model.getValueAt(Click,8).toString().equals("1"))  {
            tinhtrang.setSelectedItem("Còn làm");
        } else if(model.getValueAt(Click,8).toString().equals("0")) {
            tinhtrang.setSelectedItem("Nghỉ làm");
        } else
        tinhtrang.setSelectedItem("Đình chỉ");

        manv.setText(model.getValueAt(Click,0).toString());
        ten.setText(model.getValueAt(Click,1).toString());
        tuoi.setText(model.getValueAt(Click,2).toString());
        diachi.setText(model.getValueAt(Click,3).toString());
        sdt.setText(model.getValueAt(Click,4).toString());
        mail.setText(model.getValueAt(Click,5).toString());
        luong.setText(model.getValueAt(Click,7).toString());
        ghichu.setText(model.getValueAt(Click,10).toString());
        ngaysinh.setText(model.getValueAt(Click,9).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            clearTable();
            if((String)luachontim.getSelectedItem()=="Mã NV") theomnv();
            else if((String)luachontim.getSelectedItem()=="Tên nhân viên") theotennv();
            else if((String)luachontim.getSelectedItem()=="Địa chỉ") theodiachi();
            else if((String)luachontim.getSelectedItem()=="Số điện thoại") theosdt();
            else if((String)luachontim.getSelectedItem()=="Mail") theomail();

        }
    }//GEN-LAST:event_txtFindKeyPressed

    private void boxtinhtrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxtinhtrangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_boxtinhtrangMouseClicked

    private void boxgioitinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxgioitinhKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_boxgioitinhKeyPressed

    private void boxgioitinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxgioitinhMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_boxgioitinhMouseClicked

    private void boxgioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxgioitinhActionPerformed
        // TODO add your handling code here:
        theogioitinh();
    }//GEN-LAST:event_boxgioitinhActionPerformed

    private void boxtinhtrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxtinhtrangActionPerformed
        // TODO add your handling code here:
        theotinhtrang();     
    }//GEN-LAST:event_boxtinhtrangActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
            clearTable();
            if((String)luachontim.getSelectedItem()=="Mã NV") theomnv();
            else if((String)luachontim.getSelectedItem()=="Tên nhân viên") theotennv();
            else if((String)luachontim.getSelectedItem()=="Địa chỉ") theodiachi();
            else if((String)luachontim.getSelectedItem()=="Số điện thoại") theosdt();
            else if((String)luachontim.getSelectedItem()=="Mail") theomail();

        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLnhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String a = null;
                new QLnhanvien(a).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel begin;
    private javax.swing.JComboBox<String> boxgioitinh;
    private javax.swing.JComboBox<String> boxtinhtrang;
    private javax.swing.JTextField diachi;
    private javax.swing.JTextArea ghichu;
    private javax.swing.JComboBox<String> gioitinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> luachontim;
    private javax.swing.JTextField luong;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField manv;
    private javax.swing.JTextField ngaysinh;
    private javax.swing.JTextField sdt;
    private javax.swing.JLabel status;
    private javax.swing.JTextField ten;
    private javax.swing.JComboBox<String> tinhtrang;
    private javax.swing.JTextField tuoi;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
