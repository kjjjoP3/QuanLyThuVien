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

/**
 *
 * @author ACER NITRO 5
 */
public class SachDao {
    public boolean insert(Sach sv)
            throws  Exception{
        
        String sql = "INSERT INTO [dbo].[Sach]([MaSach],[TenSach],[MaTheLoai],[TacGia],[SoLuong],[MaNXB],[NgayNhap],[NDTT],[Hinh])"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, sv.getMaSach());
            pstmt.setString(2, sv.getTenSach());
            pstmt.setString(3, sv.getMaTheLoai());
            pstmt.setString(4, sv.getTacGia());
            pstmt.setInt(5, sv.getSoLuong());
            pstmt.setString(6, sv.getNxb());
            pstmt.setString(7, sv.getNgayNhap());
            pstmt.setString(8, sv.getNdtt());
            
            if(sv.getHinh() != null){
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(9, hinh);
            }else{
                Blob hinh = null;
                pstmt.setBlob(9, hinh);
            }
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    
    
    public boolean update(Sach sv)
            throws  Exception{
        
        
        
        String sql = "UPDATE [dbo].[Sach] " +
"     SET [TenSach] = ?,[MaTheLoai] = ?,[TacGia] = ?,[SoLuong] = ?,[MaNXB] = ?,[NgayNhap] = ?,[NDTT] = ?,[Hinh] = ?"
                + " where [MaSach] = ?  ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(9, sv.getMaSach());
            pstmt.setString(1, sv.getTenSach());
            pstmt.setString(2, sv.getMaTheLoai());
            pstmt.setString(3, sv.getTacGia());
            pstmt.setInt(4, sv.getSoLuong());
            pstmt.setString(5, sv.getNxb());
            pstmt.setString(6, sv.getNgayNhap());
            pstmt.setString(7, sv.getNdtt());
            
            if(sv.getHinh() != null){
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(8, hinh);
            }else{
                Blob hinh = null;
                pstmt.setBlob(8, hinh);
            }
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
    
    public boolean delete(String MaSach)
            throws  Exception{
        
      
       String sql1 = "DELETE FROM [dbo].[Sach] where [masach] = ?";
               
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
 
    
      public Sach findById(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from Sach where maSach = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    Sach sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
      
      
      
      

    private Sach createSinhVien(final ResultSet rs) throws SQLException {
        Sach sv = new Sach();
        sv.setMaSach(rs.getString("masach"));
        sv.setTenSach(rs.getString("tensach"));
        sv.setMaTheLoai(rs.getString("matheloai"));
        sv.setTacGia(rs.getString("tacgia"));
        sv.setSoLuong(rs.getInt("soluong"));
        sv.setNxb(rs.getString("manxb"));
        sv.setNgayNhap(rs.getString("ngaynhap"));
        sv.setNdtt(rs.getString("ndtt"));
        Blob blob = rs.getBlob("hinh");
        if(blob != null)
            sv.setHinh(blob.getBytes(1, (int) blob.length()));
        return sv;
    }
    
      public List <Sach> findAll()
            throws  Exception{
        
        
        String sql = "select * from  Sach";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<Sach> list = new ArrayList<>();
                while(rs.next()){
                    Sach sv = new Sach();
        sv.setMaSach(rs.getString("masach"));
        sv.setTenSach(rs.getString("tensach"));
        sv.setMaTheLoai(rs.getString("matheloai"));
        sv.setTacGia(rs.getString("tacgia"));
        sv.setSoLuong(rs.getInt("soluong"));
        sv.setNxb(rs.getString("manxb"));
        sv.setNgayNhap(rs.getString("ngaynhap"));
        sv.setNdtt(rs.getString("ndtt"));
        Blob blob = rs.getBlob("hinh");
        if(blob != null)
            sv.setHinh(blob.getBytes(1, (int) blob.length()));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
      
      public List <Sach> SearchTen(String tenSach)
            throws  Exception{
        
        
        String sql="SELECT * FROM Sach WHERE TenSach like N'%" + tenSach +  "%' or MaTheLoai like N'%" + tenSach + "%' or MaSach like N'%" + tenSach + "%' or TacGia like N'%" + tenSach + "%' or manxb like N'%" + tenSach + "%'"  ;
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<Sach> list = new ArrayList<>();
                while(rs.next()){
                    Sach sv = new Sach();
        sv.setMaSach(rs.getString("MaSach"));
        sv.setMaTheLoai(rs.getString("MaTheLoai"));
        sv.setNdtt(rs.getString("NDTT"));
        sv.setNgayNhap(rs.getString("NgayNhap"));
        sv.setNxb(rs.getString("MaNXB"));
        sv.setSoLuong(rs.getInt("SoLuong"));
        sv.setTacGia(rs.getString("TacGia"));
        sv.setTenSach(rs.getString("TenSach"));
        Blob blob = rs.getBlob("hinh");
        if(blob != null)
            sv.setHinh(blob.getBytes(1, (int) blob.length()));

        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
      
}
