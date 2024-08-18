/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import services.utils;
import model.BoPhim;

/**
 *
 * @author tranv
 */
public class SuaBoPhim extends javax.swing.JFrame {

    private boolean loading = false;
    BoPhim boPhim;

    /**
     * Creates new form MovieManager
     */
    public SuaBoPhim(BoPhim bophim) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//chế độ đóng (chỉ đóng màn hình hiện tại)
        this.boPhim = bophim;
        
        //gán dữ liệu lên form
        ganDuLieu();
    }
    
    public void ganDuLieu() {
        tfTenPhim.setText(boPhim.getTenPhim());
        tfDienVien.setText(boPhim.getDienVien());
        tfAnhPoster.setText(boPhim.getAnhPoster());
        tfDaodien.setText(boPhim.getDaoDien());
        tfSoTap.setValue(boPhim.getSoTap());
        tfQuocGia.setText(boPhim.getQuocGia());
        tfMoTa.setText(boPhim.getMoTa());
        tfTheLoai.setText(boPhim.getTheLoai());
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
        tfTenPhim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAnhPoster = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTheLoai = new javax.swing.JTextField();
        tfSoTap = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        tfQuocGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfDienVien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfDaodien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfMoTa = new javax.swing.JTextArea();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cập nhật phim");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tên phim");

        tfTenPhim.setText("phim 1");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ảnh Poster");

        tfAnhPoster.setText("https://res.cloudinary.com/dultkpqjp/image/upload/v1696586175/music/pqegjeip6jf5o5lk0pbv.jpg");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Số tập");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Thể loại");

        tfTheLoai.setText("the loai 1");

        tfSoTap.setValue(4);

        jLabel6.setText("Quốc gia");

        tfQuocGia.setText("quoc gia 1");

        jLabel7.setText("Diễn viên");

        tfDienVien.setText("dien vien 1");

        jLabel8.setText("Đạo diễn");

        tfDaodien.setText("dao dien 1");

        jLabel9.setText("Mô tả");

        tfMoTa.setColumns(20);
        tfMoTa.setLineWrap(true);
        tfMoTa.setRows(5);
        tfMoTa.setText("mo ta 1");
        tfMoTa.setWrapStyleWord(true);
        jScrollPane1.setViewportView(tfMoTa);

        btnLuu.setText("Lưu");
        btnLuu.setFocusPainted(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfSoTap, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfQuocGia))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfTenPhim)
                                            .addComponent(tfAnhPoster))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDaodien)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAnhPoster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDaodien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSoTap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        xuLySuaPhim();
    }//GEN-LAST:event_btnLuuActionPerformed

    public void xuLySuaPhim() {

        //kiểm tra có đang loading
        if (loading) {
            return;
        }

        // lấy các trường dữ liệu nhập vào
        String IdBoPhim = boPhim.getId();
        String TenPhimNhapVao = tfTenPhim.getText();
        String AnhPosterNhapVao = tfAnhPoster.getText();
        int SoTapNhapVao = tfSoTap.getValue().hashCode();
        String MoTaNhapVao = tfMoTa.getText();
        String TheLoaiNhapVao = tfTheLoai.getText();
        String QuocGiaNhapVao = tfQuocGia.getText();
        String DienVienNhapVao = tfDienVien.getText();
        String DaoDienNhapVao = tfDaodien.getText();

        // kiểm tra dữ liệu nhập vào
        if (TenPhimNhapVao.isEmpty() || AnhPosterNhapVao.isEmpty() || SoTapNhapVao < 0 || MoTaNhapVao.isEmpty()
                || TheLoaiNhapVao.isEmpty() || QuocGiaNhapVao.isEmpty() || DienVienNhapVao.isEmpty() || DaoDienNhapVao.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin"); // in ra thông báo

            return; //dừng chương trình
        }
        //cập nhật giá trị mới vào class
        boPhim.setTenPhim(TenPhimNhapVao);
        boPhim.setAnhPoster(AnhPosterNhapVao);
        boPhim.setSoTap(SoTapNhapVao);
        boPhim.setMoTa(MoTaNhapVao);
        boPhim.setTheLoai(TheLoaiNhapVao);
        boPhim.setQuocGia(QuocGiaNhapVao);
        boPhim.setDienVien(DienVienNhapVao);
        boPhim.setDaoDien(DaoDienNhapVao);

        // ghi nhận đang loading
        startLoading();

        // thêm bộ phim vào db
        new Thread(() -> {
            boolean kqSua = boPhim.suaPhim();
            if (kqSua) {
                JOptionPane.showMessageDialog(null, "Đã cập nhật.");//thông báo thành công
            } else {
                JOptionPane.showMessageDialog(null, "Sửa phim thất bại.", "", JOptionPane.ERROR_MESSAGE);
            }

            //ghi nhận dừng loading
            stopLoading();

        }).start();

    }

    public void startLoading() {
        loading = true;
        btnLuu.setText("Đang thêm...");
    }

    public void stopLoading() {
        loading = false;
        btnLuu.setText("Thêm");
    }

    public void resetForm() {
        tfTenPhim.setText("");
        tfAnhPoster.setText("");
        tfSoTap.setValue(0);
        tfMoTa.setText("");
        tfTheLoai.setText("");
        tfQuocGia.setText("");
        tfDienVien.setText("");
        tfDaodien.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfAnhPoster;
    private javax.swing.JTextField tfDaodien;
    private javax.swing.JTextField tfDienVien;
    private javax.swing.JTextArea tfMoTa;
    private javax.swing.JTextField tfQuocGia;
    private javax.swing.JSpinner tfSoTap;
    private javax.swing.JTextField tfTenPhim;
    private javax.swing.JTextField tfTheLoai;
    // End of variables declaration//GEN-END:variables
}