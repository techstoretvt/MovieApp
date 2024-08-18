/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author tranv
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySql {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(AppConstant.DB_URL + "?useUnicode=true&characterEncoding=utf-8",
                        AppConstant.USER_NAME, AppConstant.PASSWORD);
                System.out.println("connect successful!");
            }

        } catch (Exception er) {
            System.out.println("connect failure!");
            er.printStackTrace();
        }
        return conn;
    }

    public static ResultSet queryData(String sql) {
        ResultSet resultSet = null;
        try {
            // Kết nối tới MySQL Database
            Connection conn = (Connection) MySql.getConnection();

            // truy vấn user trong db
            Statement statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn");
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public static int excuteQuery(String sql) {
        int soDongCapNhat = 0;
        try {
            Connection conn = MySql.getConnection();//kết nối db
            
            // thực thi sql
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            soDongCapNhat = preparedStatement.executeUpdate(); //trả về sô dòng thay đổi
            
        } catch (SQLException ex) {
            System.out.println("Lỗi thực thi câu lệnh sql.");
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return soDongCapNhat;
    }
}
