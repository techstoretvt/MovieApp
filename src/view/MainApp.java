/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import admin.QuanLyPhim;
import admin.QuanLyTapPhim;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.MySql;

/**
 *
 * @author tranv
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TrangChu frame = new TrangChu();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        QuanLyPhim frame = new QuanLyPhim();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    // hiện màn hình hiện tại
                    Connection conn = (Connection) MySql.getConnection();
                    conn.close();
                    System.out.println("connect close!");
                } catch (SQLException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
