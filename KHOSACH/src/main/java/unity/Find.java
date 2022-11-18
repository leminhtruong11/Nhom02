/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package unity;

import dao.DBConnect;
import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Sach;
import unity.AdminMain;

/**
 *
 * @author Minh Nguyet
 */
public class Find extends javax.swing.JFrame {

    
        public void clearTable()
{
    DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    dm.removeRow(i);
}
}
    
     public void tableload() {
        clearTable();
        
        try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH";
            List<Sach> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Sach sach=new Sach();
                
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                
                sach.setLoaiSach(rs.getString("LoaiSach"));
                sach.setGia(rs.getInt("Gia"));
                sach.setSL(rs.getInt("SoLuong"));
                
                
                list.add(sach);
                Object obj[]=new Object[6];
                obj[0]=sach.getMaSach();
                obj[1]=sach.getTenSach();
                obj[2]=sach.getTacGia();
                obj[3]=sach.getLoaiSach();
                obj[4]=sach.getGia();
                obj[5]=sach.getSL();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
     
     public void theoms() {
         clearTable();
         try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH where MaSach=?";
            List<Sach> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, this.txtFind.getText());
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Sach sach=new Sach();
                
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                
                sach.setLoaiSach(rs.getString("LoaiSach"));
                sach.setGia(rs.getInt("Gia"));
                sach.setSL(rs.getInt("SoLuong"));
                
                
                list.add(sach);
                Object obj[]=new Object[6];
                obj[0]=sach.getMaSach();
                obj[1]=sach.getTenSach();
                obj[2]=sach.getTacGia();
                obj[3]=sach.getLoaiSach();
                obj[4]=sach.getGia();
                obj[5]=sach.getSL();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     
      public void theotg() {
         clearTable();
         try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH where TacGia=?";
            List<Sach> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, this.txtFind.getText());
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Sach sach=new Sach();
                
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                
                sach.setLoaiSach(rs.getString("LoaiSach"));
                sach.setGia(rs.getInt("Gia"));
                sach.setSL(rs.getInt("SoLuong"));
                
                
                list.add(sach);
                Object obj[]=new Object[6];
                obj[0]=sach.getMaSach();
                obj[1]=sach.getTenSach();
                obj[2]=sach.getTacGia();
                obj[3]=sach.getLoaiSach();
                obj[4]=sach.getGia();
                obj[5]=sach.getSL();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
      
       public void theols() {
         clearTable();
         try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH where LoaiSach=?";
            List<Sach> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, this.txtFind.getText());
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Sach sach=new Sach();
                
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                
                sach.setLoaiSach(rs.getString("LoaiSach"));
                sach.setGia(rs.getInt("Gia"));
                sach.setSL(rs.getInt("SoLuong"));
                
                
                list.add(sach);
                Object obj[]=new Object[6];
                obj[0]=sach.getMaSach();
                obj[1]=sach.getTenSach();
                obj[2]=sach.getTacGia();
                obj[3]=sach.getLoaiSach();
                obj[4]=sach.getGia();
                obj[5]=sach.getSL();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
       
        public void theots() {
         clearTable();
         try {
            Connection cons=DBConnect.getConnection();
            String sql="select * from SACH where TenSach=?";
            List<Sach> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ps.setString(1, this.txtFind.getText());
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                Sach sach=new Sach();
                
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTacGia(rs.getString("TacGia"));
                
                sach.setLoaiSach(rs.getString("LoaiSach"));
                sach.setGia(rs.getInt("Gia"));
                sach.setSL(rs.getInt("SoLuong"));
                
                
                list.add(sach);
                Object obj[]=new Object[6];
                obj[0]=sach.getMaSach();
                obj[1]=sach.getTenSach();
                obj[2]=sach.getTacGia();
                obj[3]=sach.getLoaiSach();
                obj[4]=sach.getGia();
                obj[5]=sach.getSL();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel() ;
                model.addRow(obj);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
    
    /** Creates new form Find */
    public Find(String abc) {
        initComponents();
        tableload();
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
        btnhethong = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        begin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        lbFind.setText("Tìm kiếm");

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

        luachontim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách", "Loại sách", "Tác giả" }));

        jLabel2.setText("Tìm theo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luachontim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFind)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnhethong.setIcon(new javax.swing.ImageIcon("C:\\Users\\huhuh\\Desktop\\KHOSACH\\src\\main\\java\\Image\\Back.png")); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnhethong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(369, 369, 369)
                                .addComponent(begin)))))
                .addGap(61, 61, 61))
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
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
         txtFind.setText(""); 
         tableload();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnhethongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhethongActionPerformed
        // TODO add your handling code here:
        UserMain a=new UserMain(this .begin.getText());
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_btnhethongActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        clearTable();
        if((String)luachontim.getSelectedItem()=="Mã sách") theoms();
        else if((String)luachontim.getSelectedItem()=="Tên sách") theots();
        else if((String)luachontim.getSelectedItem()=="Tác giả") theotg();
        else  theols();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String abc=null;
                new Find(abc).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel begin;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnhethong;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbFind;
    private javax.swing.JComboBox<String> luachontim;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

}
