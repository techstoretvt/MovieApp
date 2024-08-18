/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import admin.QuanLyPhim;
import services.LocalData;
import services.MySql;

/**
 *
 * @author tranv
 */
public class User {

    String Id;
    String TaiKhoan, role, HoTen;
    String MatKhau;

    public User() {
        this.Id = "";
        this.TaiKhoan = "";
        this.MatKhau = "";
    }

    public User(String Id, String TaiKhoan, String MatKhau) {
        this.Id = Id;
        this.MatKhau = MatKhau;
        this.TaiKhoan = TaiKhoan;
    }

    public void UserLogin(String TaiKhoan, String MatKhau) {
        try {
            // kiểm tra du lieu nhập vào có trống không
            if (TaiKhoan.isEmpty() || MatKhau.isEmpty()) {
                return; //dừng chương trinh
            }

            String query = "SELECT * FROM User WHERE TaiKhoan = '" + TaiKhoan + "'";
            ResultSet resultSet = MySql.queryData(query);

            // xử lý khi có kết quả trả về
            while (resultSet != null && resultSet.next()) {
                // lấy thông tin từ kết quả trả về
                String IdDB = resultSet.getString("Id");
                String TaiKhoanDB = resultSet.getString("TaiKhoan");
                String MatKhauDB = resultSet.getString("MatKhau");
                String HoTenDB = resultSet.getString("HoTen");
                String roleDB = resultSet.getString("role");

                // so sánh mật khẩu nhập vào với mật khẩu trong db
                if (MatKhau.equals(MatKhauDB)) {
                    this.Id = IdDB;
                    this.TaiKhoan = TaiKhoanDB;
                    this.MatKhau = MatKhauDB;
                    this.HoTen = HoTenDB;
                    this.role = roleDB;
                }
                // dừng xử lý tại đây
                return;
            }

            // xử lý khi không có kết quả trả về
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LuuUser(User user) {
        //lưu user vào local data
        LocalData.setData("IdUser", String.valueOf(user.getId()));
        LocalData.setData("TaiKhoan", user.getTaiKhoan());
         LocalData.setData("HoTen", user.getHoTen());
          LocalData.setData("role", user.getRole());
    }

    public static void XoaUser() {
        //xóa user khỏi local data
        LocalData.removeData("IdUser");
        LocalData.removeData("TaiKhoan");
         LocalData.removeData("HoTen");
          LocalData.removeData("role");
    }

    public String getId() {
        return Id;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

}
