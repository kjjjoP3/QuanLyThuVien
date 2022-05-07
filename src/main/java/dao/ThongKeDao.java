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
import model.PhieuMuon;
import model.Sach;
import model.SinhVien;
import helpers.Connect;
import helpers.jdbcHelper;

/**
 *
 * @author ACER NITRO 5
 */
public class ThongKeDao {
    // Thống kê SINH VIÊN    
    
    public List<Object[]> SVDayDu() {    //sv chua muon sach
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from SinhVien";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
//                        rs.getString("Nam"),
//                        rs.getString("SoLuong"),
//                        rs.getDate("DauTien"),
//                        rs.getDate("CuoiCung")
                            rs.getString("MaSV"),
                            rs.getString("Password"),
                            rs.getString("HoTen"),
                            rs.getDate("NgaySinh"),
                            rs.getInt("GioiTinh")== 1 ? "Nam" : "Nữ",
                            rs.getString("DiaChi"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL")
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
    
    
    public List<Object[]> SVChuaMuonSach() {    //sv chua muon sach
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_SVChuaMuonSach";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
//                        rs.getString("Nam"),
//                        rs.getString("SoLuong"),
//                        rs.getDate("DauTien"),
//                        rs.getDate("CuoiCung")
                            rs.getString("MaSV"),
                            rs.getString("Password"),
                            rs.getString("HoTen"),
                            rs.getDate("NgaySinh"),
                            rs.getInt("GioiTinh")== 1 ? "Nam" : "Nữ",
                            rs.getString("DiaChi"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL")
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
    
    
    
    public List<Object[]> SVChuaDaMuonSach() {    //sv da muon sach
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_SVDaMuonSach";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
//                        rs.getString("Nam"),
//                        rs.getString("SoLuong"),
//                        rs.getDate("DauTien"),
//                        rs.getDate("CuoiCung")
                            rs.getString("MaSV"),
                            rs.getString("Password"),
                            rs.getString("HoTen"),
                            rs.getDate("NgaySinh"),
                            rs.getInt("GioiTinh")== 1 ? "Nam" : "Nữ",
                            rs.getString("DiaChi"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL")
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
    
     public List<Object[]> SVGioiTinhNam() {    //sv gioi tinh gi
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_GioiTinhSV '1'";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
//                        rs.getString("Nam"),
//                        rs.getString("SoLuong"),
//                        rs.getDate("DauTien"),
//                        rs.getDate("CuoiCung")
                            rs.getString("MaSV"),
                            rs.getString("Password"),
                            rs.getString("HoTen"),
                            rs.getDate("NgaySinh"),
                            rs.getInt("GioiTinh")== 1 ? "Nam" : "Nữ",
                            rs.getString("DiaChi"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL")
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> SVGioiTinhNu() {    //sv gioi tinh gi
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_GioiTinhSV '0'";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
//                        rs.getString("Nam"),
//                        rs.getString("SoLuong"),
//                        rs.getDate("DauTien"),
//                        rs.getDate("CuoiCung")
                            rs.getString("MaSV"),
                            rs.getString("Password"),
                            rs.getString("HoTen"),
                            rs.getDate("NgaySinh"),
                            rs.getInt("GioiTinh")== 1 ? "Nam" : "Nữ",
                            rs.getString("DiaChi"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL")
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     
     //Thong Ke Sach
     
     public List<Object[]> SachDayDu() {    //sv SAch
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from Sach";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                        rs.getString("masach"),
                        rs.getString("tensach"),
                        rs.getString("matheloai"),
                        rs.getString("tacgia"),
                        rs.getInt("soluong"),
                        rs.getString("manxb"),
                        rs.getString("ngaynhap"),
                        rs.getString("ndtt"),
                        rs.getBytes("Hinh")== null? "Không hình" :"Có Hình Ảnh Đại Diện",
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> SachSoLuongTangDan() {    //sv SAch
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from Sach order by SoLuong ASC";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                        rs.getString("masach"),
                        rs.getString("tensach"),
                        rs.getString("matheloai"),
                        rs.getString("tacgia"),
                        rs.getInt("soluong"),
                        rs.getString("manxb"),
                        rs.getString("ngaynhap"),
                        rs.getString("ndtt"),
                        rs.getBytes("Hinh")== null? "Không hình" :"Có Hình Ảnh Đại Diện",
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     public List<Object[]> SachSoLuongGiamDan() {    //sv SAch
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from Sach order by SoLuong desc ";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                        rs.getString("masach"),
                        rs.getString("tensach"),
                        rs.getString("matheloai"),
                        rs.getString("tacgia"),
                        rs.getInt("soluong"),
                        rs.getString("manxb"),
                        rs.getString("ngaynhap"),
                        rs.getString("ndtt"),
                        rs.getBytes("Hinh")== null? "Không hình" :"Có Hình Ảnh Đại Diện",
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
    
    //Thong Ke Phieu Muon
     public List<Object[]> ThongKePhieuMuon() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra" +
"	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV" +
"	join Sach s on pm.MaSach = s.MaSach" +
"	where pm.soluong is not null";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeSinhVienMuonNhieuSach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_SVMuonNhieuSachNhat";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getInt("SVMuonNhieuSachNhat"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeSinhVienMuonItSach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select  pm.MaSV, sv.HoTen, sum(pm.SoLuong) SVMuonItSachNhat" +
"	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV" +
"	join Sach s on pm.MaSach = s.MaSach" +
"	group by pm.MaSV, sv.HoTen" +
"	order by sum(pm.SoLuong) asc";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getInt("SVMuonItSachNhat"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeMuonNhieuSach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_SachMuonNhieuNhat";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SachMuonNhieuNhat"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     public List<Object[]> ThongKeMuonItSach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select  pm.MaSach, s.TenSach, sum(pm.SoLuong) SachMuonItNhat" +
"	from PhieuMuon pm join Sach s on pm.MaSach = s.MaSach" +
"	group by pm.MaSach,  s.TenSach" +
"	order by sum(pm.SoLuong) asc";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SachMuonItNhat"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }

     public List<Object[]> ThongKeConHanTraSachPM() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra" +
"	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV" +
"	join Sach s on pm.MaSach = s.MaSach" +
"	where NgayHenTra > (select GETDATE()) and pm.soluong is not null";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     public List<Object[]> ThongKeQuaHanTraSachPM() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra" +
"	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV" +
"	join Sach s on pm.MaSach = s.MaSach" +
"	where NgayHenTra < (select GETDATE()) and pm.soluong is not null";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     
     public List<Object[]> ThongKeViPham() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from vipham";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaViPham"),
                    rs.getString("MaSV"),
                    rs.getString("TrinhTrangSach"),
                   
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeViPhamMatSach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from vipham where trinhtrangsach = N'mất sách'";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaViPham"),
                    rs.getString("MaSV"),
                    rs.getString("TrinhTrangSach"),
                   
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeViPhamSachRach() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from vipham where trinhtrangsach = N'Sách Rách'";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaViPham"),
                    rs.getString("MaSV"),
                    rs.getString("TrinhTrangSach"),
                   
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     public List<Object[]> ThongKeViPhamTreHen() {    //sv toan bo phieu muon
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select * from vipham where trinhtrangsach = N'Trễ Hẹn'";
                rs = jdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {                    
                    rs.getString("MaViPham"),
                    rs.getString("MaSV"),
                    rs.getString("TrinhTrangSach"),
                   
                        
                        
                    };
                    list.add(model);

                }
            } finally {
//                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);

        }
        return list;

    }
     
     
     
     
     
    
    
}
