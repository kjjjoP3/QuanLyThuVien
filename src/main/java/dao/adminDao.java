/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helpers.Connect;
import helpers.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Sach;
import model.SinhVien;
import model.admin;

/**
 *
 * @author ACER NITRO 5
 */
public class adminDao extends Connect {
    public admin dangnhap(String username, String password){
    admin ad = null;
    try{
        String sql = "Select * from Admin where Username=? and Password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            ad = new admin();
            ad.setUsername(rs.getString(1));
            ad.setPassword(rs.getString(2));
            ad.setTen(rs.getString(3));
        }
    }catch(Exception e){
        e.getMessage();
    }
        return ad;   
    }
    
    public ArrayList<admin> load(){
        ArrayList<admin> lists = new ArrayList<admin>();
        try{
            String sql="select * from Admin" +
" where Username not in (Select Username from Admin where vaitro = 'admin')";
            Statement stm = con.createStatement();
            ResultSet rs= stm.executeQuery(sql);
            lists.clear();
            while(rs.next()){
                admin sv = new admin(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));
                lists.add(sv); 
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    return lists;
    }
    
    public int insert(admin sv)
    {
        try
        {
            String sql="Insert into admin values (?,?,?,?)";
            PreparedStatement ps =con.prepareStatement(sql);
                ps.setString(1, sv.getUsername());
                ps.setString(2, sv.getPassword());
                ps.setString(3, sv.getTen());
                ps.setString(4, sv.getVaitro());
             return ps.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
        return -1;
    }
    
    public int updateNhanVien(admin ad)
    {
        try
        {
            String sql="Update Admin set Password = ?, [Ten] = ?,Vaitro=? WHERE Username=?";
            PreparedStatement ps =con.prepareStatement(sql);
                ps.setString(1, ad.getPassword());
                ps.setString(2, ad.getTen());
                ps.setString(3, ad.getVaitro());
                ps.setString(4, ad.getUsername());
             return ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    
    
    
    
        public ArrayList<admin> LoadMa(String username)
    {
        ArrayList<admin> lists = new ArrayList<admin>();
        try
        {
            String sql="SELECT * FROM ADMIN WHERE Username=?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
          while(rs.next())
          {
            admin ad = new admin();
            ad.setUsername(rs.getString(1));
            ad.setPassword(rs.getString(2));
            ad.setTen(rs.getString(3));
            lists.add(ad);          
          }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return lists;
    }
        
        public int update(admin ad)
    {
        try
        {
            String sql="Update Admin set Password=? WHERE Username=?";
            PreparedStatement ps =con.prepareStatement(sql);
                ps.setString(1, ad.getPassword());
                ps.setString(2, ad.getUsername());
             return ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
        
        public admin findById(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from admin where [Username] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    admin sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
        
        
        public admin findById1(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from Admin where Username not in (Select Username from Admin where vaitro = N'Quản Lý Thủ Thư') and username = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    admin sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
        
        
        public admin findByIdKhongCoAdmin(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from Admin where Username not in (Select Username from Admin where vaitro = 'admin') and username = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    admin sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
        
        
        public boolean delete(String maSV) {
        try {
            String sql = "DELETE FROM Admin WHERE Username=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maSV);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        
        private admin createSinhVien(final ResultSet rs) throws SQLException {
        admin sv = new admin();
        sv.setUsername(rs.getString("Username"));
        sv.setPassword(rs.getString("Password"));
        sv.setTen(rs.getString("Ten"));
        sv.setVaitro(rs.getString("VaiTro"));
        return sv;
    }
    
}
