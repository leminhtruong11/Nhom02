/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package unity;

import dao.DBConnect;
import dao.DBConnect;
import java.awt.event.MouseEvent;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.HOADONNHAP;
import model.Nhanvien;
import model.Sach;
import unity.AdminMain;

/**
 *
 * @author Minh Nguyet
 */
public class QLhoadon extends javax.swing.JFrame {
        private List<HOADONNHAP> search=new ArrayList<>();
        private List<HOADONNHAP> table1=new ArrayList<>();
        private List<HOADONNHAP> table2=new ArrayList<>();
        private List<HOADONNHAP> search2=new ArrayList<>();
    
        public void clearTable(JTable jTable1)
        {
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }

            
        }
        
        public void loadlist() {
            
            try {
            Connection cons=DBConnect.getConnection();
            String sql="select DISTINCT MHDN,MaNV,NgayNhap,ThoiGianNhap  from HOADONNHAP";
            table1=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                HOADONNHAP sach=new HOADONNHAP();
                
                sach.setMHDN(rs.getString("MHDN"));
                sach.setMaNV(rs.getString("MaNV"));
                sach.setNgayNhap(rs.getDate("NgayNhap"));
                sach.setThoiGian(rs.getTime("ThoiGianNhap"));
                
                
                
                table1.add(sach);
                
            }
            ps.close();
            rs.close();
            cons.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select DISTINCT MHDX,MaNV,NgayXuat,ThoiGianXuat  from HOADONXUAT";
            table2=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                HOADONNHAP sach=new HOADONNHAP();
                
                sach.setMHDN(rs.getString("MHDX"));
                sach.setMaNV(rs.getString("MaNV"));
                sach.setNgayNhap(rs.getDate("NgayXuat"));
                sach.setThoiGian(rs.getTime("ThoiGianXuat"));
                
                
                
                table2.add(sach);
                
            }
            ps.close();
            rs.close();
            cons.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    
     public void tableload(List<HOADONNHAP> table1, JTable jTable1) {
        clearTable(jTable1);
        
        
        for(int i=0;i<table1.size();i++) {
            Object obj[]=new Object[4];
            obj[0]=table1.get(i).getMHDN();
            obj[1]=table1.get(i).getMaNV();
            obj[2]=table1.get(i).getNgayNhap();
            obj[3]=table1.get(i).getThoiGian();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
            model.addRow(obj);
        }
      
    }
     
     public void theomhd(List<HOADONNHAP> table1, JTable jTable1, JTextField txtFind) {
        clearTable(jTable1);
        
        search=new ArrayList<>();
        for (int i = 0; i < table1.size(); i++) {
            if (table1.get(i).getMHDN().toLowerCase().equals(txtFind.getText().toLowerCase())) {
                search.add(table1.get(i));
            }
        }
        tableload(search,jTable1);
     }
     
      public void theomanv(List<HOADONNHAP> table1, JTable jTable1, JTextField txtFind) {
        clearTable(jTable1);
        
        search=new ArrayList<>();
        for (int i = 0; i < table1.size(); i++) {
            if (table1.get(i).getMaNV().equals(txtFind.getText().toLowerCase())) {
                search.add(table1.get(i));
            }
        }
        tableload(search,jTable1);
     }
      
      public void theongay(List<HOADONNHAP> table1, JTable jTable1, JTextField txtFind) {
        clearTable(jTable1);
        
        search=new ArrayList<>();
        for (int i = 0; i < table1.size(); i++) {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);

            String day = df.format(table1.get(i).getNgayNhap());
            if (day.substring(8, 10).contains(txtFind.getText().toLowerCase())) {
                search.add(table1.get(i));
            }
        }
        tableload(search,jTable1);
     }
      
      public void theothang(List<HOADONNHAP> table1, JTable jTable1, JTextField txtFind) {
        clearTable(jTable1);
        
        search=new ArrayList<>();
        for (int i = 0; i < table1.size(); i++) {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);

            String day = df.format(table1.get(i).getNgayNhap());
            if (day.substring(5, 7).contains(txtFind.getText().toLowerCase())) {
                search.add(table1.get(i));
            }
        }
        tableload(search,jTable1);
     }
      
      public void theonam(List<HOADONNHAP> table1, JTable jTable1, JTextField txtFind) {
        clearTable(jTable1);
        
        search=new ArrayList<>();
        for (int i = 0; i < table1.size(); i++) {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);

            String day = df.format(table1.get(i).getNgayNhap());
            if (day.substring(0, 4).equals(txtFind.getText().toLowerCase())) {
                search.add(table1.get(i));
            }
        }
        tableload(search,jTable1);
     }
    
    /** Creates new form Find */
    public QLhoadon(String abc) {
        initComponents();
        loadlist();
        tableload(table1,jTable1);
        tableload(table2,jTable2);
        begin.setText(abc);
        begin.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbFind = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        luachontim = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFind2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnhethong = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        begin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        lbFind.setText("Tìm kiếm");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Find.png"))); // NOI18N
        jButton8.setText("Tìm kiếm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon("C:\\Users\\huhuh\\Desktop\\KHOSACH\\src\\main\\java\\Image\\Refresh-icon.png")); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        luachontim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã nhân viên", "Ngày", "Tháng", "Năm" }));

        jLabel2.setText("Tìm theo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn nhập", "Nhân viên thực hiện", "Ngày xuất hóa đơn", "Thời gian"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn xuất", "Nhân viên thực hiện", "Ngày xuất hóa đơn", "Thời gian"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Xem hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tìm kiếm");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Find.png"))); // NOI18N
        jButton2.setText("Tìm kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Refresh-icon.png"))); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luachontim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbFind)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFind2)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(538, 538, 538))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(luachontim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFind, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFind2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        btnhethong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        btnhethong.setText("Hệ thống");
        btnhethong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhethongActionPerformed(evt);
            }
        });

        begin.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnhethong)
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                        .addComponent(begin)))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnhethong, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(begin))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
         txtFind.setText("");
         loadlist();
         tableload(table1,jTable1);
         
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnhethongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhethongActionPerformed
        // TODO add your handling code here:
        AdminMain a=new AdminMain(this .begin.getText());
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_btnhethongActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        clearTable(jTable1);
        if((String)luachontim.getSelectedItem()=="Mã hóa đơn") theomhd(table1,jTable1,txtFind);
        else if((String)luachontim.getSelectedItem()=="Mã nhân viên") theomanv(table1,jTable1,txtFind);
        else if((String)luachontim.getSelectedItem()=="Ngày") theongay(table1,jTable1,txtFind);
        else if((String)luachontim.getSelectedItem()=="Tháng") theothang(table1,jTable1,txtFind);
        else theonam(table1,jTable1,txtFind);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clearTable(jTable2);
        if((String)luachontim.getSelectedItem()=="Mã hóa đơn") theomhd(table2,jTable2,txtFind2);
        else if((String)luachontim.getSelectedItem()=="Mã nhân viên") theomanv(table2,jTable2,txtFind2);
        else if((String)luachontim.getSelectedItem()=="Ngày") theongay(table2,jTable2,txtFind2);
        else if((String)luachontim.getSelectedItem()=="Tháng") theothang(table2,jTable2,txtFind2);
        else theonam(table2,jTable2,txtFind2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtFind2.setText(""); 
        loadlist();
         tableload(table2,jTable2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            int Click=jTable1.getSelectedRow();
            int Click2=jTable2.getSelectedRow();
            int rowCount1 = jTable1.getRowCount();
            int rowCount2 = jTable2.getRowCount();
            List<Sach> sach=new ArrayList<>();
            TableModel model=null;
            Sach a=new Sach();
            Nhanvien b=new Nhanvien();
            String day = null,time = null;
            if(0<=Click && Click<rowCount1){
                model=jTable1.getModel();
                sach=new ArrayList<>();
                try {
                Connection cons=DBConnect.getConnection();
                String sql="select MaSach, MaNV,NgayNhap,ThoiGianNhap,SLNhap from HOADONNHAP where MHDN=?";
                PreparedStatement ps=cons.prepareCall(sql);
                ps.setString(1, model.getValueAt(Click,0).toString());
                ResultSet rs=ps.executeQuery();
                while(rs.next()) {
                    a=new Sach();
                    b=new Nhanvien();
                    b.setInfor(rs.getString("MaNV"));
                    b.setInforAdmin(rs.getString("MaNV"));
                    a.setInfor(rs.getString("MaSach"));
                    a.setSL(rs.getInt("SLNhap"));
                    sach.add(a);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    day = formatter.format(rs.getDate("NgayNhap"));
                    SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
                    time=formatter1.format(rs.getTime("ThoiGianNhap"));
                }
                ps.close();
                rs.close();
                cons.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            InhoadonNhapsach hd= new InhoadonNhapsach(sach,b,day,time,model.getValueAt(Click,0).toString());
            hd.setVisible(true);
            } else if(0<=Click2 && Click2<rowCount2) {
                model=jTable2.getModel();
                sach=new ArrayList<>();
                try {
                Connection cons=DBConnect.getConnection();
                String sql="select MaSach, MaNV,NgayXuat,ThoiGianXuat,SLXuat from HOADONXUAT where MHDX=?";
                PreparedStatement ps=cons.prepareCall(sql);
                ps.setString(1, model.getValueAt(Click2,0).toString());
                ResultSet rs=ps.executeQuery();
                while(rs.next()) {
                    a=new Sach();
                    b=new Nhanvien();
                    b.setInfor(rs.getString("MaNV"));
                    a.setInfor(rs.getString("MaSach"));
                    a.setSL(rs.getInt("SLXuat"));
                    sach.add(a);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    day = formatter.format(rs.getDate("NgayXuat"));
                    SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm:ss");
                    time=formatter1.format(rs.getTime("ThoiGianXuat"));
                }
                ps.close();
                rs.close();
                cons.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            InhoadonNhapsach hd= new InhoadonNhapsach(sach,b,day,time,model.getValueAt(Click2,0).toString());
            hd.setVisible(true);
            } else return;
                
            
            
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QLhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String abc=null;
                new QLhoadon(abc).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel begin;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnhethong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbFind;
    private javax.swing.JComboBox<String> luachontim;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFind2;
    // End of variables declaration//GEN-END:variables

}
