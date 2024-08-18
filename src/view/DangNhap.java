/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import admin.QuanLyPhim;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;
import services.LocalData;
import services.MySql;

/**
 *
 * @author tranv
 */
public class DangNhap extends javax.swing.JFrame {

    public static boolean isLogin = false;

    /**
     * Creates new form LoginJFrame
     */
    public DangNhap() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//chế độ đóng (chỉ đóng màn hình hiện tại)
        isLogin = false;
//        suKienDongManHinh();
    }

    public void suKienDongManHinh() {
        // sự kiện khi đóng màn hình đăng nhập
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // mở màn hình trang chủ
                TrangChu manHinhTranChu = new TrangChu();
                manHinhTranChu.setLocationRelativeTo(null);
                manHinhTranChu.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        tfMatKhau = new javax.swing.JPasswordField();
        lblChuaCoTK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tài khoản");

        tfTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaiKhoanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mật khẩu");

        btnDangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        tfMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMatKhauActionPerformed(evt);
            }
        });

        lblChuaCoTK.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblChuaCoTK.setForeground(new java.awt.Color(0, 102, 255));
        lblChuaCoTK.setText("Chưa có tài khoản?");
        lblChuaCoTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblChuaCoTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChuaCoTKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTaiKhoan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDangNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblChuaCoTK)
                                .addGap(0, 122, Short.MAX_VALUE))
                            .addComponent(tfMatKhau))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap)
                    .addComponent(lblChuaCoTK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        xuLyDangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void tfTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaiKhoanActionPerformed
        // TODO add your handling code here:
        xuLyDangNhap();
    }//GEN-LAST:event_tfTaiKhoanActionPerformed

    private void tfMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMatKhauActionPerformed
        // TODO add your handling code here:
        xuLyDangNhap();
    }//GEN-LAST:event_tfMatKhauActionPerformed

    private void lblChuaCoTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuaCoTKMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        DangKy manHinhDangKy = new DangKy();
        manHinhDangKy.setVisible(true);
        manHinhDangKy.setLocationRelativeTo(null);
        manHinhDangKy.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(true);
            }

        });
    }//GEN-LAST:event_lblChuaCoTKMouseClicked

    public void xuLyDangNhap() {

        // lấy dữ liệu nhập vào từ input
        String TaiKhoanNhapVao = tfTaiKhoan.getText();
        String MatKhauNhapVao = String.valueOf(tfMatKhau.getPassword());
        System.out.println("MatKhauNhapVao: "+MatKhauNhapVao);

        User user = new User();
        user.UserLogin(TaiKhoanNhapVao, MatKhauNhapVao);

        if (user.getId().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác");
        } else {
            //lưu thông tin đăng nhập
            User.LuuUser(user);

            isLogin = true;
            
            //đóng màn hình hiện tại
            dispose();
        }

    }

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblChuaCoTK;
    private javax.swing.JPasswordField tfMatKhau;
    private javax.swing.JTextField tfTaiKhoan;
    // End of variables declaration//GEN-END:variables
}