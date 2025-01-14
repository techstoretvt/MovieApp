/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import java.awt.FlowLayout;
import panels.ItemTapPhimAdmin;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.BoPhim;
import model.TapPhim;
import model.TapPhimManager;
import services.MySql;

public class QuanLyTapPhim extends javax.swing.JFrame {

    BoPhim boPhim;
    TapPhimManager tapPhimManager = null;
    ArrayList<JPanel> listPN = new ArrayList<>();

    /**
     * Creates new form QuanLyTapPhim
     */
    public QuanLyTapPhim(BoPhim boPhim) {
        initComponents();
        this.boPhim = boPhim;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//chế độ đóng (chỉ đóng màn hình hiện tại)

        //lấy danh sách tập phim
        layDSTapPhim();
    }

    public void layDSTapPhim() {
        if (tapPhimManager != null) {
            resetFrame();
        }

        try {

            String IdBoPhim = boPhim.getId();
            String sqlLayTapPhim = String.format("SELECT * FROM TapPhim WHERE IdBoPhim = '%s' ORDER BY stt ASC", IdBoPhim);

            //thực thi câu lệnh sql
            ResultSet kqTruyVan = MySql.queryData(sqlLayTapPhim);
            ArrayList<TapPhim> dsTapPhim = new ArrayList<>();
            while (kqTruyVan != null && kqTruyVan.next()) {
                TapPhim tapPhim = TapPhim.chuyenDoi_ResultSet(kqTruyVan);
                dsTapPhim.add(tapPhim);
            }

            //gán ds vào tapPhimManager
            tapPhimManager = new TapPhimManager(dsTapPhim);

            //hiện ds lên giao diện
            hienTapPhim();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTapPhim.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hienTapPhim() {
        ArrayList<TapPhim> dsTapPhim = tapPhimManager.getDsTapPhim();
        if (dsTapPhim == null) {
            return; //dừng xử lý
        }
        for (TapPhim tapPhim : dsTapPhim) {
            JPanel pn = new ItemTapPhimAdmin(tapPhim, boPhim); //tạo panel tập phim
            add(pn); //thêm  vào giao diện
            listPN.add(pn); // thêm panel vào arraylist
        }
        revalidate();
        repaint();

    }

    public void resetFrame() {
        //xóa các tập phim đang hiển thị trên giao diện
        for (JPanel i : listPN) {
            remove(i);
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

        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 699));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnThem.setBackground(new java.awt.Color(153, 255, 153));
        btnThem.setText("Thêm tập");
        btnThem.setFocusPainted(false);
        btnThem.setPreferredSize(new java.awt.Dimension(90, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        //mở màn hình thêm tập phim
        ThemTapPhim manHinhThemTapPhim = new ThemTapPhim(boPhim);
        manHinhThemTapPhim.setVisible(true);
        manHinhThemTapPhim.setLocationRelativeTo(null);//nằm giữa màn hình

        // thêm sự kiện khi đóng màn hình thêm bộ phim
        manHinhThemTapPhim.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // hiện màn hình hiện tại
                setVisible(true);
                layDSTapPhim();
            }
        });

        // ẩn màn hình hiện tại
        setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    // End of variables declaration//GEN-END:variables
}
