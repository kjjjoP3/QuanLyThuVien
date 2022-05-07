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
public class admin {
    private String username;
    private String password;
    private String ten;
    private String vaitro;

    public admin() {
    }

    
    
    public admin(String username, String password, String ten, String vaitro) {
        this.username = username;
        this.password = password;
        this.ten = ten;
        this.vaitro = vaitro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    
    
}
