/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tranv
 */
public class TapPhimManager {
    ArrayList<TapPhim> dsTapPhim;
    BoPhim boPhim;

    public TapPhimManager(ArrayList<TapPhim> dsTapPhim) {
        this.dsTapPhim = dsTapPhim;
    }

    public TapPhimManager(ArrayList<TapPhim> dsTapPhim, BoPhim boPhim) {
        this.dsTapPhim = dsTapPhim;
        this.boPhim = boPhim;
    }
    
    

    public ArrayList<TapPhim> getDsTapPhim() {
        return dsTapPhim;
    }

    public void setDsTapPhim(ArrayList<TapPhim> dsTapPhim) {
        this.dsTapPhim = dsTapPhim;
    }

    public BoPhim getBoPhim() {
        return boPhim;
    }

    public void setBoPhim(BoPhim boPhim) {
        this.boPhim = boPhim;
    }
    
    
}
