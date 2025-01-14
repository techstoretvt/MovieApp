/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BoPhim;
import model.TapPhimManager;
import services.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import model.TapPhim;

/**
 *
 * @author tranv
 */
public class XemPhim extends javax.swing.JFrame {

    BoPhim boPhim;
    TapPhimManager tapPhimManager;
    ArrayList<JButton> listBtn;

    /**
     * Creates new form XemPhim
     */
    public XemPhim(BoPhim boPhim) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//chế độ đóng (chỉ đóng màn hình hiện tại)
        this.boPhim = boPhim;

        //lấy danh sách tập phim
        layDSTapPhim();
    }

    public void layDSTapPhim() {

        try {
            String sqlLayTapPhim = String.format("SELECT * FROM TapPhim WHERE IdBoPhim = '%s'", boPhim.getId());
            ResultSet kqTruyVan = MySql.queryData(sqlLayTapPhim);

            ArrayList<TapPhim> dsTapPhim = new ArrayList<>();
            while (kqTruyVan != null && kqTruyVan.next()) {
                TapPhim tp = TapPhim.chuyenDoi_ResultSet(kqTruyVan);
                dsTapPhim.add(tp);
            }
            //thêm ds tập phim  vào tapPhimManager
            tapPhimManager = new TapPhimManager(dsTapPhim);

            //hiển thị dánh sách tập phim
            hienThiDS();

        } catch (SQLException ex) {
            Logger.getLogger(XemPhim.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hienThiDS() {

        //khởi tạo list button
        listBtn = new ArrayList<>();

        //lấy ds tập phim
        ArrayList<TapPhim> dsTapPhim = tapPhimManager.getDsTapPhim();

        //set kích thướt panel chứa ds tập phim
//        pnListTapPhim.setPreferredSize(new Dimension(600,30 *));
        for (TapPhim tapPhim : dsTapPhim) {
            JButton btnTapPhim = new JButton(tapPhim.getTenTap());
            btnTapPhim.setBackground(new Color(104, 104, 104));
            btnTapPhim.setForeground(Color.WHITE);
            btnTapPhim.setFocusPainted(false);
            btnTapPhim.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnTapPhim.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //set màu cho btn
                    for (JButton btn : listBtn) {
                        btn.setBackground(new Color(104, 104, 104));
                    }
                    btnTapPhim.setBackground(Color.RED);
                    
                    //mở tập phim
                    moTapPhim(tapPhim.getUrlVideo());
                }
            });

            pnListTapPhim.add(btnTapPhim);
            listBtn.add(btnTapPhim);

        }

        //set mặt định là tập 1
        listBtn.get(0).setBackground(Color.RED);

    }
    
    public void moTapPhim(String urlVideo) {
        //mở tập phim
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
        pnListTapPhim = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 620));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 400));

        jLabel1.setText("Phim sẽ được chiếu ở đây");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(662, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pnListTapPhim.setMinimumSize(new java.awt.Dimension(1757, 100));
        pnListTapPhim.setPreferredSize(new java.awt.Dimension(1000, 120));
        pnListTapPhim.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        getContentPane().add(pnListTapPhim);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnListTapPhim;
    // End of variables declaration//GEN-END:variables
}
