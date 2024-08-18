/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import admin.QuanLyPhim;
import admin.ThemTapPhim;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.MySql;

/**
 *
 * @author tranv
 */
public class TapPhim {

    String Id, IdBoPhim, TenTap, urlVideo;
    int stt;

    public TapPhim(String Id, String IdBoPhim, String TenTap, String urlVideo, int stt) {
        this.Id = Id;
        this.IdBoPhim = IdBoPhim;
        this.TenTap = TenTap;
        this.urlVideo = urlVideo;
        this.stt = stt;
    }
    
    
    

    public static int themTapPhim(String Id, String IdBoPhim, String TenTap, String urlVideo, int stt) {

        String sqlThemTapPhim = String.format("INSERT INTO TapPhim (Id, IdBoPhim, TenTap, urlVideo, stt) VALUES ('%s','%s','%s','%s',%d)", Id, IdBoPhim, TenTap, urlVideo, stt);
        int kqThem = MySql.excuteQuery(sqlThemTapPhim);

        return kqThem;
    }

    public static boolean checkTapPhim(String tenTap, int tap, String IdBoPhim) {
        try {
            String sql = String.format("SELECT * FROM TapPhim WHERE IdBoPhim = '%s' and (TenTap = '%s' or stt = %d)", IdBoPhim, tenTap, tap);
            ResultSet kq = MySql.queryData(sql);
            if (kq != null && kq.next()) {
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ThemTapPhim.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean checkTapPhimSua(String tenTap, int tap, String IdBoPhim) {
        try {
            String sql = String.format("SELECT * FROM TapPhim WHERE IdBoPhim = '%s' and TenTap = '%s' and stt = %d", IdBoPhim, tenTap, tap);
            ResultSet kq = MySql.queryData(sql);
            if (kq != null && kq.next()) {
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ThemTapPhim.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static int xoaTapPhim(String Id) {
        String sqlXoaTapPhim = String.format("DELETE FROM TapPhim WHERE Id = '%s'",Id);
        int kqXoa = MySql.excuteQuery(sqlXoaTapPhim);
        return kqXoa;
    }
    
     public boolean suaTapPhim() {
        // câu lệnh sửa tập phim
        String sqlSuaTapPhim = String.format("UPDATE TapPhim SET TenTap = '%s',urlVideo = '%s',stt = %d  WHERE Id = '%s'",
                TenTap, urlVideo, stt, Id);
        // thực thi câu lệnh
        int kqSuaBoPhim = MySql.excuteQuery(sqlSuaTapPhim); //trả về sô dòng thay đổi
        if (kqSuaBoPhim > 0) {
            return true;
        } else {
            System.out.println("Sửa tập phim thất bại.");
            return false;
        }
    }
    

    public static TapPhim chuyenDoi_ResultSet(ResultSet resultSet) {
        TapPhim bp = null;
        try {
            String Id = resultSet.getString("Id");
            String IdBoPhim = resultSet.getString("IdBoPhim");
            String TenTap = resultSet.getString("TenTap");
            int stt = resultSet.getInt("stt");
            String urlVideo = resultSet.getString("urlVideo");

            bp = new TapPhim(Id, IdBoPhim, TenTap, urlVideo, stt);
            
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

    public String getIdBoPhim() {
        return IdBoPhim;
    }

    public void setIdBoPhim(String IdBoPhim) {
        this.IdBoPhim = IdBoPhim;
    }

    public String getTenTap() {
        return TenTap;
    }

    public void setTenTap(String TenTap) {
        this.TenTap = TenTap;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

}
