/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author tranv
 */
public class LocalData {

    public static void setData(String key, String data) {
        Properties properties = new Properties();
        File file = new File("data.properties");
        try {
            // Đọc dữ liệu từ file vào đối tượng Properties
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();

            // Thêm dữ liệu mới
            properties.setProperty(key, data);

            // Ghi đối tượng Properties đã cập nhật vào file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, "Data");
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getData(String key) {
        Properties properties = new Properties();

        // Đọc dữ liệu từ file
        File file = new File("data.properties");
        try {
            properties.load(new FileInputStream(file));
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
        }

        // Lấy dữ liệu
        String value = properties.getProperty(key);
        return value;
    }
    
     public static void removeData(String key) {
        Properties properties = new Properties();
        properties.remove(key);
        File file = new File("data.properties");
        try {
            properties.store(new FileOutputStream(file), "Data");
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }
    
}
