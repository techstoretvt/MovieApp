/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusXoaPhim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import admin.QuanLyPhim;
import services.MySql;

public class BoPhim {

    String Id, TenPhim, AnhPoster, MoTa, TheLoai, QuocGia, DienVien, DaoDien;
    int SoTap;

    public BoPhim() {

    }

    public BoPhim(String Id, String TenPhim, String AnhPoster, String MoTa, String TheLoai, String QuocGia, String DienVien, String DaoDien, int SoTap) {
        this.Id = Id;
        this.TenPhim = TenPhim;
        this.AnhPoster = AnhPoster;
        this.MoTa = MoTa;
        this.TheLoai = TheLoai;
        this.QuocGia = QuocGia;
        this.DienVien = DienVien;
        this.DaoDien = DaoDien;
        this.SoTap = SoTap;
    }

    public String themBoPhim(String Id, String TenPhim, String AnhPoster, String MoTa, String TheLoai, String QuocGia, String DienVien, String DaoDien, int SoTap) {

        //kiểm tra tồn tại
        if (kiemTraTonTaiPhim(TenPhim)) {
            return "Tên phim đã tồn tại.";
        }

        // chuẩn bị câu lệnh insert trong sql
        String query = String.format("INSERT INTO BoPhim (Id, TenPhim, AnhPoster, SoTap, MoTa, TheLoai, QuocGia, DienVien, DaoDien)"
                + " VALUES ('%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s')", Id, TenPhim, AnhPoster, SoTap,
                MoTa, TheLoai, QuocGia, DienVien, DaoDien);

        // thực thi câu lệnh sql
        int kq = MySql.excuteQuery(query); //trả về sô dòng thay đổi
        if (kq > 0) {
            //gán giá trị cho các thuộc tính
            this.Id = Id;
            this.TenPhim = TenPhim;
            this.AnhPoster = AnhPoster;
            this.MoTa = MoTa;
            this.TheLoai = TheLoai;
            this.QuocGia = QuocGia;
            this.DienVien = DienVien;
            this.DaoDien = DaoDien;
            this.SoTap = SoTap;

            return "OK";
        } else {
            return "Thêm phim thất bại.";
        }

    }

    public boolean kiemTraTonTaiPhim(String TenPhim) {
        try {
            String query = String.format("SELECT * FROM BoPhim WHERE TenPhim = '%s'", TenPhim);
            ResultSet kqTruyVan = MySql.queryData(query);

            // xử lý khi có kết quả trả về
            while (kqTruyVan != null && kqTruyVan.next()) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(BoPhim.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public StatusXoaPhim xoaPhim() {
        // câu lệnh xóa bô phim
        String sqlXoaBoPhim = String.format("DELETE FROM BoPhim WHERE Id = '%s'", Id);
        
        // thực thi câu lệnh
        int kqXoaBoPhim = MySql.excuteQuery(sqlXoaBoPhim); //trả về sô dòng thay đổi
        if (kqXoaBoPhim > 0) {
            //xóa các tập phim của bộ phim
            String sqlXoaTapPhim = String.format("DELETE FROM TapPhim WHERE IdBoPhim = '%s'", Id);

            // thực thi câu lệnh
            MySql.excuteQuery(sqlXoaTapPhim);

            return StatusXoaPhim.SUCCESS;

        } else {
            System.out.println("Xoa phim thất bại.");
            return StatusXoaPhim.ERRORR;
        }
    }

    public boolean suaPhim() {
        // câu lệnh sửa bô phim
        String sqlSuaBoPhim = String.format("UPDATE BoPhim SET TenPhim = '%s',AnhPoster = '%s',SoTap = %d,MoTa = '%s',TheLoai = '%s',QuocGia = '%s',DienVien = '%s',DaoDien = '%s'  WHERE Id = '%s'",
                TenPhim, AnhPoster, SoTap, MoTa, TheLoai, QuocGia, DienVien, DaoDien, Id);
        // thực thi câu lệnh
        int kqSuaBoPhim = MySql.excuteQuery(sqlSuaBoPhim); //trả về sô dòng thay đổi
        if (kqSuaBoPhim > 0) {
            return true;
        } else {
            System.out.println("Sửa phim thất bại.");
            return false;
        }
    }

    public static BoPhim chuyenDoi_ResultSet(ResultSet resultSet) {
        BoPhim bp = null;
        try {
            String Id = resultSet.getString("Id");
            String TenPhim = resultSet.getString("TenPhim");
            String AnhPoster = resultSet.getString("AnhPoster");
            int SoTap = resultSet.getInt("SoTap");
            String MoTa = resultSet.getString("MoTa");
            String TheLoai = resultSet.getString("TheLoai");
            String QuocGia = resultSet.getString("QuocGia");
            String DienVien = resultSet.getString("DienVien");
            String DaoDien = resultSet.getString("DaoDien");

            bp = new BoPhim(Id, TenPhim, AnhPoster, MoTa, TheLoai, QuocGia, DienVien, DaoDien, SoTap);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyPhim.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bp;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public String getAnhPoster() {
        return AnhPoster;
    }

    public void setAnhPoster(String AnhPoster) {
        this.AnhPoster = AnhPoster;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    public String getDienVien() {
        return DienVien;
    }

    public void setDienVien(String DienVien) {
        this.DienVien = DienVien;
    }

    public String getDaoDien() {
        return DaoDien;
    }

    public void setDaoDien(String DaoDien) {
        this.DaoDien = DaoDien;
    }

    public int getSoTap() {
        return SoTap;
    }

    public void setSoTap(int SoTap) {
        this.SoTap = SoTap;
    }

}
