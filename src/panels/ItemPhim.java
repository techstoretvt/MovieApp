/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panels;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import model.BoPhim;
import services.utils;
import view.ChiTietPhim;

/**
 *
 * @author tranv
 */
public class ItemPhim extends javax.swing.JPanel {

    BoPhim boPhim;

    /**
     * Creates new form ItemPhim
     */
    public ItemPhim(BoPhim boPhim) {
        initComponents();
        this.boPhim = boPhim;

        //gán giá trị lên giao diện
        ganGiaTri();
    }

    public void ganGiaTri() {
        new Thread(() -> {
            int size = 90;
            ImageIcon anh = utils.layImageIcon(boPhim.getAnhPoster(), size, size);
            lbAnhPhim.setIcon(anh);
        }).start();

        lbTenPhim.setText(boPhim.getTenPhim());
        lbTapPhim.setText("Số tập: " + boPhim.getSoTap());
        lbTheLoai.setText("Thể loại: " + boPhim.getTheLoai());
        lbQuocGia.setText("Quốc gia: " + boPhim.getQuocGia());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAnhPhim = new javax.swing.JLabel();
        lbTenPhim = new javax.swing.JLabel();
        lbTapPhim = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbQuocGia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setMaximumSize(new java.awt.Dimension(32767, 104));

        lbAnhPhim.setBorder(new javax.swing.border.MatteBorder(null));
        lbAnhPhim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAnhPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnhPhimMouseClicked(evt);
            }
        });

        lbTenPhim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenPhim.setForeground(new java.awt.Color(255, 0, 255));
        lbTenPhim.setText("Tên phim 1");

        lbTapPhim.setText("Số tập: 20");

        lbTheLoai.setText("Thể loại: ngôn tình");

        lbQuocGia.setText("Quốc gia: Hàn quốc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAnhPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenPhim)
                    .addComponent(lbTapPhim)
                    .addComponent(lbTheLoai)
                    .addComponent(lbQuocGia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTenPhim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTapPhim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTheLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbQuocGia))
                    .addComponent(lbAnhPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbAnhPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhPhimMouseClicked
        // TODO add your handling code here:

        //mở màn hình chi tiết
        Window parent =  SwingUtilities.getWindowAncestor(ItemPhim.this);//get frame cha
        System.out.println(parent.getClass());
        
        ChiTietPhim manHinhChiTietPhim = new ChiTietPhim(boPhim);
        manHinhChiTietPhim.setVisible(true);
        manHinhChiTietPhim.setLocationRelativeTo(null);
        manHinhChiTietPhim.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                parent.setVisible(true);
            }

        });

        //ẩn frame cha
        parent.setVisible(false);


    }//GEN-LAST:event_lbAnhPhimMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbAnhPhim;
    private javax.swing.JLabel lbQuocGia;
    private javax.swing.JLabel lbTapPhim;
    private javax.swing.JLabel lbTenPhim;
    private javax.swing.JLabel lbTheLoai;
    // End of variables declaration//GEN-END:variables
}
