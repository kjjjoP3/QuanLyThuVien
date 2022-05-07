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
import model.PhieuMuon;
import model.Sach;

/**
 *
 * @author ACER NITRO 5
 */
public class PhieuMuonDAO {
    public boolean insert(PhieuMuon pm)
            throws  Exception{
        
        
        
        
        String sql = "INSERT INTO [dbo].[PhieuMuon]([MaPhieuMuon],[MaSV],[MaSach],[SoLuong],[NgayMuon],[NgayHenTra])" +
"     VALUES(?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,pm.getMaPhieuMuon());
                pstmt.setString(2, pm.getMaSV());
                pstmt.setString(3, pm.getMaSach());
                pstmt.setInt(4, pm.getSoLuong());
                pstmt.setString(5, pm.getNgayMuon());
                pstmt.setString(6, pm.getNgayHenTra());
            return pstmt.executeUpdate()>0;
  
        }
       
    }
    
    public boolean insertSinhVien(PhieuMuon pm)
            throws  Exception{
        
        
        
        
        String sql = "INSERT INTO [dbo].[PhieuMuon]([Maphieumuon],[MaSV],[MaSach])" +
"     VALUES(?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, pm.getMaPhieuMuon());
                pstmt.setString(2, pm.getMaSV());
                pstmt.setString(3, pm.getMaSach());
                
            return pstmt.executeUpdate()>0;
  
        }
       
    }
    
    public boolean updateSinhVien(PhieuMuon pm)
            throws  Exception{

        String sql = "UPDATE [dbo].[PhieuMuon] " +
"     Set masv = ?,MaSach = ?"
                + " WHERE MaPhieuMuon = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                
                
                pstmt.setString(1, pm.getMaSV());
                pstmt.setString(2, pm.getMaSach());
                pstmt.setString(3, pm.getMaPhieuMuon());
                
                
           
            return pstmt.executeUpdate()>0;
                
            
        } 
       
    }
    
    
    
    public boolean update(PhieuMuon pm)
            throws  Exception{

        String sql = "UPDATE [dbo].[PhieuMuon] " +
"     SET [MaSV] = ?,[MaSach] = ?,[SoLuong] = ?,[NgayMuon] = ?,[NgayHenTra] = ?"
                + " where [MaPhieuMuon] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(6,pm.getMaPhieuMuon());
                pstmt.setString(1, pm.getMaSV());
                pstmt.setString(2, pm.getMaSach());
                pstmt.setInt(3, pm.getSoLuong());
                pstmt.setString(4, pm.getNgayMuon());
                pstmt.setString(5, pm.getNgayHenTra());
                
                
           
            return pstmt.executeUpdate()>0;
                
            
        }
       
    }
    
     public boolean delete(String pm)
            throws  Exception{
        
      
       String sql1 = "DELETE FROM [dbo].[PhieuMuon] where [id] = ?";
               
       //try thu-> chay 
       //duoc -> finally
       //loi -> catch
       //catch(xu ly loi)
       //finally (bat buoc chay(khong duoc phep loi))
      
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql1);
                
                ){
            pstmt.setString(1, pm);
          
            return pstmt.executeUpdate()>0;
            
                
            
        } 
       
    }
     
     
     
     public boolean deletesinhvien(String pm)
            throws  Exception{
        
      
       String sql1 = "DELETE FROM [dbo].[PhieuMuon] where [id] = ?";
               
       //try thu-> chay 
       //duoc -> finally
       //loi -> catch
       //catch(xu ly loi)
       //finally (bat buoc chay(khong duoc phep loi))
      
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql1);
                
                ){
            pstmt.setString(1, pm);
          
            return pstmt.executeUpdate()>0;
            
                
            
        } 
       
    }
     
     public PhieuMuon findById(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from PhieuMuon where [MaPhieuMuon] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    PhieuMuon sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
     
     
     public PhieuMuon findByma(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from PhieuMuon where id not in (select id from phieumuon where soluong is null ) and [id] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    PhieuMuon sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
     
     
     
     
     public PhieuMuon findByma999999(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from PhieuMuon where [maphieumuon] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    PhieuMuon sv = createSinhVien(rs);
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }
     
     
     
     public PhieuMuon findBySinhVien(String maSinhVien)
            throws  Exception{
        
        
        String sql = "select * from phieumuon where id not in (select id from phieumuon where soluong is not null ) and  MaPhieuMuon = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, maSinhVien);
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    
                    return sv;
                }
            }
            return null;
                
            
        }
       
    }

     
     private PhieuMuon createSinhVien(final ResultSet rs) throws SQLException {
        PhieuMuon sv = new PhieuMuon();
        sv.setMa(rs.getInt("id")); 
        sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
        sv.setMaSV(rs.getString("MaSV"));
        sv.setMaSach(rs.getString("MaSach"));
        sv.setSoLuong(rs.getInt("SoLuong"));
        sv.setNgayMuon(rs.getString("NgayMuon"));
        sv.setNgayHenTra(rs.getString("NgayHenTra"));
        return sv;
    }
     
     
     
     public List <PhieuMuon> findAll()
            throws  Exception{
        
        
        String sql = "select * from phieumuon where soluong is not Null order by maphieumuon ASC";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMa(rs.getInt("id"));
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     public List <PhieuMuon> findAllMuon(String ma)
            throws  Exception{
        
        
        String sql = "select * from phieumuon where id not in (select id from phieumuon where soluong is null ) and masv = ? order by maphieumuon ASC";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, ma);
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     
     
     public List <PhieuMuon> findAllMuonSach(String ma)
            throws  Exception{
        
        
        String sql = "select * from phieumuon where id not in (select id from phieumuon where soluong is not null ) and masv = ? order by maphieumuon ASC";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, ma);
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMa(rs.getInt("id"));
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     
     
     public List <PhieuMuon> findAllNgaNgu()
            throws  Exception{
        
        
        String sql = "select * from phieumuon where id not in (select id from phieumuon where SoLuong is not null )";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMa(rs.getInt("id"));
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
                    
                    
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     public List <PhieuMuon> SearchMaSVMaPhieu(String ma)
            throws  Exception{ 
        
        
        String sql = "SELECT * FROM PhieuMuon WHERE id not in (select id from phieumuon where maphieumuon is not null) and MaSach like N'%" + ma +  "%' or MaphieuMuon like N'%" + ma + "%' or MaSV like N'%" + ma + "%' or SoLuong like N'%" + ma + "%' or NgayMuon like N'%" + ma +  "%' or NgayHenTra like N'%" + ma + "%'";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     
     public List <PhieuMuon> SearchMaSVMaPhieuLoi(String ma)
            throws  Exception{
        
        
        String sql = "SELECT * FROM PhieuMuon WHERE id not in (select id from phieumuon where maphieumuon is null ) and MaSV like N'%" + ma +  "%'  or MaPhieuMuon like N'%" + ma + "%'  or Masach like N'%" + ma + "%' and masv = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            
            try(ResultSet rs = pstmt.executeQuery();){
                List<PhieuMuon> list = new ArrayList<>();
                while(rs.next()){
                    PhieuMuon sv = new PhieuMuon();
                    sv.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setMaSach(rs.getString("MaSach"));
                    sv.setSoLuong(rs.getInt("SoLuong"));
                    sv.setNgayMuon(rs.getString("NgayMuon"));
                    sv.setNgayHenTra(rs.getString("NgayHenTra"));
        
        list.add(sv);
        
                }
                return list;
            }
           
                
            
        }
       
    }
     
     
    
}
