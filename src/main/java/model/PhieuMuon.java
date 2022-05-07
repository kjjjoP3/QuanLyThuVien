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
public class PhieuMuon {
    private int ma;
    private String maPhieuMuon;
    private String maSV;
    private String maSach;
    private int soLuong;
    private String ngayMuon;
    private String ngayHenTra;

    public PhieuMuon() {
    }

    public PhieuMuon(int ma, String maPhieuMuon, String maSV, String maSach, int soLuong, String ngayMuon, String ngayHenTra) {
        this.ma = ma;
        this.maPhieuMuon = maPhieuMuon;
        this.maSV = maSV;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(String ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public void setSoLuong(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
