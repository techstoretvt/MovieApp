/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import admin.QuanLyTapPhim;
import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author tranv
 */
public class utils {
    
    public static String randomId() {
        int length = 10;
        // Chuỗi chứa các ký tự mà bạn muốn sử dụng
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Tạo một đối tượng SecureRandom để tạo số ngẫu nhiên
        SecureRandom random = new SecureRandom();

        // Tạo một StringBuilder để xây dựng chuỗi ngẫu nhiên
        StringBuilder sb = new StringBuilder(length);

        // Tạo chuỗi ngẫu nhiên với độ dài cho trước
        for (int i = 0; i < length; i++) {
            // Lấy một ký tự ngẫu nhiên từ chuỗi characters
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);

            // Thêm ký tự ngẫu nhiên vào chuỗi
            sb.append(randomChar);
        }

        // Trả về chuỗi ngẫu nhiên
        return sb.toString();
    }
    
    public static ImageIcon layImageIcon(String url, int w, int h) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(url);
        } catch (MalformedURLException ex) {
            System.out.println("loi url");
        }
        ImageIcon originalIcon = new ImageIcon(imageUrl);

        // Thu nhỏ ảnh
        Image scaledImage = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }
    
    public static JFrame layFrameCha(Component c) {
        JFrame frame = (QuanLyTapPhim) SwingUtilities.getWindowAncestor(c);
        return frame;
    }
    
    public static boolean kiemTraDangNhap() {
         String IdUser = LocalData.getData("IdUser");
        if (IdUser != null) {
            return true;
        }

        return false;
    }
    
}
