/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author tranv
 */
public class YeuThich {
    String Id, IdBoPhim, IdUser;

    public YeuThich(String Id, String IdBoPhim, String IdUser) {
        this.Id = Id;
        this.IdBoPhim = IdBoPhim;
        this.IdUser = IdUser;
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

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }
    
     public static YeuThich chuyenDoi_ResultSet(ResultSet resultSet) {
        YeuThich yt = null;
        try {
            String id = resultSet.getString("Id");
            String idBoPhim = resultSet.getString("IdBoPhim");
            String idUser = resultSet.getString("IdUser");

            yt = new YeuThich(id, idBoPhim,idUser);
        } catch (SQLException ex) {
            
        }
        return yt;
    }
}
