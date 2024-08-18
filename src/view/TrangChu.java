/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import admin.QuanLyPhim;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.BoPhim;
import model.BoPhimManager;
import model.User;
import panels.ItemPhim;
import services.LocalData;
import services.MySql;
import services.MyCustomDialog;

/**
 *
 * @author tranv
 */
public class TrangChu extends javax.swing.JFrame {
    
    BoPhimManager boPhimManager;

    /**
     * Creates new form MainJFrame
     */
    public TrangChu() {
        initComponents();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);

        //add JDBC
        addJDBC();

        //lấy danh sách phim
        layDanhSachPhim();

        //kiểm tra đăng nhập
        if (kiemTraDangNhap()) {
            addMenuYeuThich();
            addMenuDangXuat();
        } else {
            addMenuDangNhap();
        }
        
    }
    
    public void addMenuDangXuat() {
        JMenuItem menuItem = new JMenuItem("Đăng xuất");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xacnhan = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất không?");
                if (xacnhan == JOptionPane.OK_OPTION) {
                    User.XoaUser();
                    UserMenu.removeAll();
                    addMenuDangNhap();
                }
            }
        });
        UserMenu.add(menuItem);
    }
    
    public void addMenuDangNhap() {
        JMenuItem menuItem = new JMenuItem("Đăng nhập");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                User.XoaUser();
                DangNhap manHinhDangNhap = new DangNhap();
                manHinhDangNhap.setVisible(true); // cho hiển thị lên
                manHinhDangNhap.setLocationRelativeTo(null); // cho nằm giữa màn hình
                setVisible(false);
                manHinhDangNhap.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if (DangNhap.isLogin) {
                            UserMenu.removeAll();
                            addMenuYeuThich();
                            addMenuDangXuat();
                        }
                        
                        setVisible(true);
                    }
                    
                });
                
            }
        });
        UserMenu.add(menuItem);
    }
    
    public void addMenuYeuThich() {
        JMenuItem menuItem = new JMenuItem("Yêu thích");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mo man hinh yeu thich
                setVisible(false);
                YeuThich manHinhYeuTich = new YeuThich();
                manHinhYeuTich.setVisible(true);
                manHinhYeuTich.setLocationRelativeTo(null);
                manHinhYeuTich.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        setVisible(true);
                    }
                    
                });
                
            }
        });
        UserMenu.add(menuItem);
    }
    
    public void layDanhSachPhim() {
        
        try {
            
            String tuKhoa = tfTimKiem.getText();
            String theLoai = cbTheLoai.getSelectedItem().toString();
            String quocGia = cbQuocGia.getSelectedItem().toString();
            
            if (theLoai.equals("Tất cả")) {
                theLoai = "";
            }
            if (quocGia.equals("Tất cả")) {
                quocGia = "";
            }
            
            String sqlTimKiem = "SELECT * FROM BoPhim WHERE TenPhim like '%" + tuKhoa + "%' and TheLoai like '%" + theLoai + "%' and QuocGia like '%" + quocGia + "%'";
            
            ResultSet kqTimKiem = MySql.queryData(sqlTimKiem);
            ArrayList<BoPhim> dsBoPhim = new ArrayList<>();
            while (kqTimKiem != null && kqTimKiem.next()) {
                BoPhim bp = BoPhim.chuyenDoi_ResultSet(kqTimKiem);
                dsBoPhim.add(bp);
            }

            //add danh sách vào tapPhimManager
            boPhimManager = new BoPhimManager(dsBoPhim);

            //hiển thị danh sách lên giao diện
            hienThiDanhSachPhim();
            
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void hienThiDanhSachPhim() {
        
        ArrayList<BoPhim> dsBoPhim = boPhimManager.getDsBoPhim();//lấy ds từ tapPhimManager
        pnListPhim.removeAll();//xóa các tập phim hiện có trên giao diện

        //set số dòng, cột cho gridlayout
        int dong = (dsBoPhim.size() + 1) / 2;
        GridLayout gridLayout = new GridLayout(dong, 2);
        pnListPhim.setLayout(gridLayout);
        
        for (BoPhim boPhim : dsBoPhim) {
            JPanel pnTapPhim = new ItemPhim(boPhim);//khởi tạo panel tập phim
            pnListPhim.add(pnTapPhim);//thêm panel tập phim vào giao diện
        }
        //reset giao diện
        pnListPhim.revalidate();
        pnListPhim.repaint();
        
    }
    
    public void addJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnListPhim = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbTheLoai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbQuocGia = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        UserMenu = new javax.swing.JMenu();
        QuanLyMenu = new javax.swing.JMenu();
        QuanLyPhimItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        tfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemActionPerformed(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(255, 0, 255));
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        pnListPhim.setLayout(new java.awt.GridLayout(2, 2));
        jScrollPane1.setViewportView(pnListPhim);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Thê loại:");

        cbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Ngôn tình", "Kinh dị", "Hành động", "Xuyên không" }));
        cbTheLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTheLoaiItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Quốc gia:");

        cbQuocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hàn Quốc", "Việt Nam", "Trung Quốc" }));
        cbQuocGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbQuocGiaItemStateChanged(evt);
            }
        });

        jMenuBar1.setBorderPainted(false);

        UserMenu.setText("User");
        jMenuBar1.add(UserMenu);

        QuanLyMenu.setText("Admin");

        QuanLyPhimItem.setText("Quản lý phim");
        QuanLyPhimItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLyPhimItemActionPerformed(evt);
            }
        });
        QuanLyMenu.add(QuanLyPhimItem);

        jMenuBar1.add(QuanLyMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuanLyPhimItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLyPhimItemActionPerformed
        // TODO add your handling code here:

        // kiểm tra đang nhập
        boolean kqKiemTraDangNhap = kiemTraDangNhap();
        
        if (kqKiemTraDangNhap == false) {
            DangNhap manHinhDangNhap = new DangNhap();
            manHinhDangNhap.setVisible(true); // cho hiển thị lên
            manHinhDangNhap.setLocationRelativeTo(null); // cho nằm giữa màn hình
            manHinhDangNhap.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    
                    if (DangNhap.isLogin) {
                        //check role
                        String role = LocalData.getData("role");
                        if (role != null && role.equals("admin")) {
                            moManHinhQuanLyPhim();
                            return;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Phải đăng nhập bằng tài khoản admin");
                        }
                        
                    }
                    TrangChu manHinhTranChu = new TrangChu();
                    manHinhTranChu.setLocationRelativeTo(null);
                    manHinhTranChu.setVisible(true);
                }
            });
        } else {
            //check role
            String role = LocalData.getData("role");
            if (role != null && role.equals("admin")) {
                moManHinhQuanLyPhim();
            } else {
                JOptionPane.showMessageDialog(null, "Phải đăng nhập bằng tài khoản admin");
                return;
            }
        }

        // đóng màn hình hiện tại
        dispose();
    }//GEN-LAST:event_QuanLyPhimItemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        layDanhSachPhim();
    }//GEN-LAST:event_btnTimActionPerformed

    private void tfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemActionPerformed
        // TODO add your handling code here:
        layDanhSachPhim();
    }//GEN-LAST:event_tfTimKiemActionPerformed

    private void cbTheLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTheLoaiItemStateChanged
        // TODO add your handling code here:
        layDanhSachPhim();
    }//GEN-LAST:event_cbTheLoaiItemStateChanged

    private void cbQuocGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbQuocGiaItemStateChanged
        // TODO add your handling code here:
        layDanhSachPhim();
    }//GEN-LAST:event_cbQuocGiaItemStateChanged
    
    public void moManHinhQuanLyPhim() {
        // mở màn hình quản lý phim
        QuanLyPhim manHinhQuanLyPhim = new QuanLyPhim();
        manHinhQuanLyPhim.setVisible(true);
        manHinhQuanLyPhim.setLocationRelativeTo(null);
    }
    
    public void moManHinhDangNhap() {
        // mở màn hình đăng nhập
        DangNhap manHinhDangNhap = new DangNhap();
        manHinhDangNhap.setVisible(true); // cho hiển thị lên
        manHinhDangNhap.setLocationRelativeTo(null); // cho nằm giữa màn hình
        manHinhDangNhap.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                if (DangNhap.isLogin) {
                    moManHinhQuanLyPhim();
                } else {
                    TrangChu manHinhTranChu = new TrangChu();
                    manHinhTranChu.setLocationRelativeTo(null);
                    manHinhTranChu.setVisible(true);
                }
            }
            
        });
        
    }
    
    public boolean kiemTraDangNhap() {
        //get user từ local
        String IdUser = LocalData.getData("IdUser");
        if (IdUser != null) {
            return true;
        }
        
        return false;
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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu QuanLyMenu;
    private javax.swing.JMenuItem QuanLyPhimItem;
    private javax.swing.JMenu UserMenu;
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cbQuocGia;
    private javax.swing.JComboBox<String> cbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnListPhim;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
