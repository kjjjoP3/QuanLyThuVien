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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import model.Sach;
import model.SinhVien;
import model.admin;

/**
 *
 * @author ACER NITRO 5
 */
public class SinhVienDao {
    public boolean insert(SinhVien sv)
            throws  Exception{
        
        
        
        
        String sql = "INSERT INTO [dbo].[SinhVien]([MaSV],[Password],[MaLop],[HoTen],[NgaySinh],[GioiTinh],[DiaChi],[SDT],[Email])"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getPassword());
            pstmt.setString(3, sv.getMalop());
            pstmt.setString(4, sv.getHoTen());
            pstmt.setString(5, sv.getNgaySinh());
            pstmt.setInt(6, sv.getGioiTinh());
            pstmt.setString(7, sv.getDiaChi());
            pstmt.setString(8, sv.getSdt());
            pstmt.setString(9, sv.getEmail());
            
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    
    
    public boolean update(SinhVien sv)
            throws  Exception{
         
        
        String sql = "UPDATE [dbo].[SinhVien]" +
"     SET [Password] = ?,[MaLop] = ?,[HoTen] = ?,[NgaySinh] = ?,[GioiTinh] = ?,[DiaChi] = ?,[SDT] = ?,[Email] = ?"
                + " where [MaSV] = ?  ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(9, sv.getMaSV());
            pstmt.setString(1, sv.getPassword());
            pstmt.setString(2, sv.getMalop());
            pstmt.setString(3, sv.getHoTen());
            pstmt.setString(4, sv.getNgaySinh());
            pstmt.setInt(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());
            pstmt.setString(7, sv.getSdt());
            pstmt.setString(8, sv.getEmail());
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    
    public boolean delete(String MaSach)
            throws  Exception{
        
      
       String sql1 = "DELETE FROM [dbo].[SinhVien] where [MaSV] = ? ";
               
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
 
    
      public SinhVien findById(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from SinhVien where [MaSV] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    SinhVien sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
      
      
      public SinhVien findById1(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from SinhVien where MaSV = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    SinhVien sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
      public List <SinhVien> findAll()
            throws  Exception{
        
        
        String sql = "select * from  SinhVien";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<SinhVien> list = new ArrayList<>();
                while(rs.next()){
                    SinhVien sv = new SinhVien();
        sv.setMaSV(rs.getString("maSV"));
        sv.setPassword(rs.getString("password"));
        sv.setMalop(rs.getString("malop"));
        sv.setHoTen(rs.getString("hoten"));
        sv.setNgaySinh(rs.getString("ngaySinh"));
        sv.setGioiTinh(rs.getInt("gioitinh"));
        sv.setDiaChi(rs.getString("diachi"));
        sv.setSdt(rs.getString("Sdt"));
        sv.setEmail(rs.getString("Email"));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
      
      
      
      
      

    private SinhVien createSinhVien(final ResultSet rs) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSV(rs.getString("maSV"));
        sv.setPassword(rs.getString("password"));
        sv.setMalop(rs.getString("malop"));
        sv.setHoTen(rs.getString("hoten"));
        sv.setNgaySinh(rs.getString("ngaySinh"));
        sv.setGioiTinh(rs.getInt("gioitinh"));
        sv.setDiaChi(rs.getString("diachi"));
        sv.setSdt(rs.getString("Sdt"));
        sv.setEmail(rs.getString("Email"));
        return sv;
    }
    
      
      
      
      public List <SinhVien> SearchTen(String tenSV)
            throws  Exception{
        
        
        String sql = "SELECT * FROM SINHVIEN WHERE HOTEN like N'%" + tenSV +  "%' or MaSV like N'%" + tenSV + "%' or Malop like N'%" + tenSV + "%'";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<SinhVien> list = new ArrayList<>();
                while(rs.next()){
                    SinhVien sv = new SinhVien();
        sv.setMaSV(rs.getString("maSV"));
        sv.setPassword(rs.getString("password"));
        sv.setMalop(rs.getString("malop"));
        sv.setHoTen(rs.getString("hoten"));
        sv.setNgaySinh(rs.getString("ngaySinh"));
        sv.setGioiTinh(rs.getInt("gioitinh"));
        sv.setDiaChi(rs.getString("diachi"));
        sv.setSdt(rs.getString("Sdt"));
        sv.setEmail(rs.getString("Email"));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
      
      
}
