/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helpers.DatabaseHelper;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import model.Sach;
import model.admin;
import model.vipham;

/**
 *
 * @author ACER NITRO 5
 */
public class viphamDao {
    public boolean insert(vipham sv)
            throws  Exception{
        
        
        String sql = "INSERT INTO [dbo].[ViPham] ([MaViPham],[MaSV],[TrinhTrangSach])"
                + "VALUES(?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, sv.getMaViPham());
            pstmt.setString(2, sv.getMaSV());
            pstmt.setString(3, sv.getTrinhtrang());
            
            
            
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    public boolean update(vipham sv)
            throws  Exception{
        
      
        
        String sql = "UPDATE [dbo].[ViPham] " +
"     SET [MaSV] = ?,[TrinhTrangSach] = ?"
                + " where [MaViPham] = ?  ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(3, sv.getMaViPham());
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTrinhtrang());
            
           
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    public boolean delete(String MaSach)
            throws  Exception{
        
      
       String sql1 = "DELETE FROM [dbo].[ViPham] where [MaViPham] = ?";
               
       //try thu-> chay 
       //duoc -> finally
       //loi -> catch
       //catch(xu ly loi)
       //finally (bat buoc chay(khong duoc phep loi))
      
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql1);
                
                ){
            pstmt.setString(1, MaSach);
          
            return pstmt.executeUpdate()>0;
            
                
            
        } 
       
    }
    
    public vipham findById(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from vipham where MaViPham = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    vipham sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
    
    private vipham createSinhVien(final ResultSet rs) throws SQLException {
        vipham sv = new vipham();
        sv.setMaViPham(rs.getString("MaViPham"));
        sv.setMaSV(rs.getString("MaSV"));
        sv.setTrinhtrang(rs.getString("TrinhTrangSach"));
        
        return sv;
    }
    
    
    
    public List <vipham> findAll()
            throws  Exception{
        
        
        String sql = "select * from  ViPham";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<vipham> list = new ArrayList<>();
                while(rs.next()){
                    vipham sv = new vipham();
        sv.setMaViPham(rs.getString("MaViPham"));
        sv.setMaSV(rs.getString("MaSV"));
        sv.setTrinhtrang(rs.getString("TrinhTrangSach"));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
    
    
    
    public List <vipham> SearchTen(String tenSach)
            throws  Exception{
        
        
        String sql="SELECT * FROM vipham WHERE mavipham like N'%" + tenSach +  "%' or masv like N'%" + tenSach + "%' or TrinhTrangSach like N'%" + tenSach + "%'"  ;
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<vipham> list = new ArrayList<>();
                while(rs.next()){
                    vipham sv = new vipham();
        sv.setMaViPham(rs.getString("MaViPham"));
        sv.setMaSV(rs.getString("MaSV"));
        sv.setTrinhtrang(rs.getString("TrinhTrangSach"));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }

    
    
}
