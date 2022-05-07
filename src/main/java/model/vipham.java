/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ACER NITRO 5
 */
public class vipham {
    public String maViPham;
    public String maSV;
    public String trinhtrang;

    public vipham() {
    }

    public vipham(String maViPham, String maSV, String trinhtrang) {
        this.maViPham = maViPham;
        this.maSV = maSV;
        this.trinhtrang = trinhtrang;
    }

    public String getMaViPham() {
        return maViPham;
    }

    public void setMaViPham(String maViPham) {
        this.maViPham = maViPham;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTrinhtrang() {
        return trinhtrang;
    }

    public void setTrinhtrang(String trinhtrang) {
        this.trinhtrang = trinhtrang;
    }
    
    
    
}
