/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanPhamLoi;

import dao.PhieuMuonDAO;
import dao.SachDao;
import dao.SinhVienDao;
import dao.ThongKeDao;
import helpers.MessageDialogHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.PhieuMuon;
import model.Sach;
import model.SinhVien;

/**
 *
 * @author ACER NITRO 5
 */
public class ThongKeNewFr extends javax.swing.JPanel {
private DefaultTableModel tableModel;
    ThongKeDao dao4 = new ThongKeDao();
    List<SinhVien> listsv;
    SinhVienDao svdao = new SinhVienDao();
    /**
     * Creates new form ThongKeNewFr
     */
    public ThongKeNewFr() {
        initComponents();
        fillTableSinhVien();
       fillTableSach();
       fillTablePhieuMuon();
       fillTableViPham();
    }
    
    
    void fillTableSinhVien() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SVDayDu();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    
    void fillTableSinhVienChuaMuonSach() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SVChuaMuonSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableSinhVienDaMuonSach() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SVChuaDaMuonSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableSinhVienGioiTinhNam() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SVGioiTinhNam();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableSinhVienGioiTinhNu() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SVGioiTinhNu();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    
    void fillTableSach() {
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SachDayDu();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableSoLuongSachTangDan() {
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SachSoLuongTangDan();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableSoLuongSachGiamDan() {
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.SachSoLuongGiamDan();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuon() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKePhieuMuon();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuonSinhVienMuonSachNhieu() {
        DefaultTableModel model = (DefaultTableModel) tblPM2.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeSinhVienMuonNhieuSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuonSinhVienMuonSachIt() {
        DefaultTableModel model = (DefaultTableModel) tblPM2.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeSinhVienMuonItSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    
    void fillTablePhieuMuonSachMuonSachNhieu() {
        DefaultTableModel model = (DefaultTableModel) tblPM1.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeMuonNhieuSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuonSachMuonSachIt() {
        DefaultTableModel model = (DefaultTableModel) tblPM1.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeMuonItSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuonConHan() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeConHanTraSachPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTablePhieuMuonQuaHan() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeQuaHanTraSachPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    
    void fillTableViPham() {
        DefaultTableModel model = (DefaultTableModel) tlbViPham.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeViPham();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
        void fillTableViPhamMatsach() {
        DefaultTableModel model = (DefaultTableModel) tlbViPham.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeViPhamMatSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
        
        void fillTableViPhamsachRach() {
        DefaultTableModel model = (DefaultTableModel) tlbViPham.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeViPhamSachRach();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
        
        void fillTableViPhamTreHen() {
        DefaultTableModel model = (DefaultTableModel) tlbViPham.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao4.ThongKeViPhamTreHen();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        cboGioiTinhSV = new javax.swing.JComboBox<>();
        cboSapXepSV = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboSapXepPM = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        ThongKeFull = new javax.swing.JScrollPane();
        tblPM = new javax.swing.JTable();
        ThongKeSach = new javax.swing.JScrollPane();
        tblPM1 = new javax.swing.JTable();
        ThongKeSinhVien = new javax.swing.JScrollPane();
        tblPM2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboSach = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cboViPham = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbViPham = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Giới tính: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Thống kê theo:");

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "PassWord", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại ", "Email"
            }
        ));
        jScrollPane1.setViewportView(tblSV);

        cboGioiTinhSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cboGioiTinhSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhSVActionPerformed(evt);
            }
        });

        cboSapXepSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sinh Viên Chưa Mượn Sách", "Sinh Viên Đã Mượn Sách" }));
        cboSapXepSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGioiTinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSapXepSV, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboGioiTinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboSapXepSV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sinh Viên", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Thống kê theo:");

        cboSapXepPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phiếu Mượn còn hạn trả sách", "Phiếu Mượn quá hạn trả sách", "Sinh Viên mượn nhiều sách nhất", "Sinh Viên mượn ít sách nhất", "Sách mượn nhiều nhất", "Sách mượn ít nhất" }));
        cboSapXepPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepPMActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.CardLayout());

        tblPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Sinh Viên", "Họ Tên", "Mã Sách", "Tên Sách", "Số Lượng", "Ngày Mượn", "Ngày Trả"
            }
        ));
        ThongKeFull.setViewportView(tblPM);

        jPanel5.add(ThongKeFull, "card2");

        tblPM1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sách ", "Tên Sách", "Số Lượng"
            }
        ));
        ThongKeSach.setViewportView(tblPM1);

        jPanel5.add(ThongKeSach, "card3");

        tblPM2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Tên Sinh Viên", "Số Lượng"
            }
        ));
        ThongKeSinhVien.setViewportView(tblPM2);

        jPanel5.add(ThongKeSinhVien, "card4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSapXepPM, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXepPM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phiếu Mượn", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Sắp xếp theo: ");

        cboSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Số lượng Sách giảm dần", "Số lượng Sách tăng dần" }));
        cboSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSachActionPerformed(evt);
            }
        });

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Mã Thể Loại", "Tác Giả", "Số Lượng", "Mã Nhà Xuất Bản", "Ngày Nhập", "Ghi Chú", "Hình"
            }
        ));
        jScrollPane4.setViewportView(tblSach);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Sách", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Sắp xếp theo: ");

        cboViPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mất Sách", "Sách Rách", "Trễ Hẹn" }));
        cboViPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboViPhamActionPerformed(evt);
            }
        });

        tlbViPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Vi Phạm", "Mã Sinh Viên", "Trình Trạng Sách"
            }
        ));
        jScrollPane2.setViewportView(tlbViPham);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cboViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vi Phạm", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboGioiTinhSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhSVActionPerformed
        // theo luot sap xep gioi tinh
        if(cboGioiTinhSV.getSelectedItem().equals("Tất cả")){
            fillTableSinhVien();
        }else if(cboGioiTinhSV.getSelectedItem().equals("Nữ")){
            cboSapXepSV.setSelectedIndex(0);
            fillTableSinhVienGioiTinhNu();
        }else{
            cboSapXepSV.setSelectedIndex(0);
            fillTableSinhVienGioiTinhNam();
        }
    }//GEN-LAST:event_cboGioiTinhSVActionPerformed

    private void cboSapXepSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepSVActionPerformed
        // theo Luot Sap Xep sinh vien muon hoac chua muon sach
        if(cboSapXepSV.getSelectedItem().equals("Tất cả")){
            fillTableSinhVien();
        }else if(cboSapXepSV.getSelectedItem().equals("Sinh Viên Chưa Mượn Sách")){
            cboGioiTinhSV.setSelectedIndex(0);
            fillTableSinhVienChuaMuonSach();
        }else{
            cboGioiTinhSV.setSelectedIndex(0);
            fillTableSinhVienDaMuonSach();
        }
    }//GEN-LAST:event_cboSapXepSVActionPerformed

    private void cboSapXepPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepPMActionPerformed
        //cbosuper
        if(cboSapXepPM.getSelectedItem().equals("Phiếu Mượn còn hạn trả sách")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(true);
            fillTablePhieuMuonConHan();

        }else if(cboSapXepPM.getSelectedItem().equals("Phiếu Mượn quá hạn trả sách")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(true);
            fillTablePhieuMuonQuaHan();
        }else if(cboSapXepPM.getSelectedItem().equals("Sinh Viên mượn nhiều sách nhất")){
            ThongKeSinhVien.setVisible(true);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSinhVienMuonSachNhieu();

        }else if(cboSapXepPM.getSelectedItem().equals("Sinh Viên mượn ít sách nhất")){
            ThongKeSinhVien.setVisible(true);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSinhVienMuonSachIt();
        }else if(cboSapXepPM.getSelectedItem().equals("Sách mượn nhiều nhất")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(true);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSachMuonSachNhieu();
        }else if(cboSapXepPM.getSelectedItem().equals("Sách mượn ít nhất")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(true);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSachMuonSachIt();
        }else{
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(true);
            fillTablePhieuMuon();
        }
    }//GEN-LAST:event_cboSapXepPMActionPerformed

    private void cboSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSachActionPerformed
        // theo So Luong

        if(cboSach.getSelectedItem().equals("Tất cả")){
            fillTableSach();
        }else if(cboSach.getSelectedItem().equals("Số lượng Sách giảm dần")){

            fillTableSoLuongSachGiamDan();
        }else{

            fillTableSoLuongSachTangDan();
        }
    }//GEN-LAST:event_cboSachActionPerformed

    private void cboViPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViPhamActionPerformed
         if(cboViPham.getSelectedItem().equals("Tất cả")){
            fillTableViPham();
        }else if(cboViPham.getSelectedItem().equals("Mất Sách")){

            fillTableViPhamMatsach();
        }else if(cboViPham.getSelectedItem().equals("Sách Rách")){

            fillTableViPhamsachRach();
        }else{

            fillTableViPhamTreHen();
        }
    }//GEN-LAST:event_cboViPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ThongKeFull;
    private javax.swing.JScrollPane ThongKeSach;
    private javax.swing.JScrollPane ThongKeSinhVien;
    private javax.swing.JComboBox<String> cboGioiTinhSV;
    private javax.swing.JComboBox<String> cboSach;
    private javax.swing.JComboBox<String> cboSapXepPM;
    private javax.swing.JComboBox<String> cboSapXepSV;
    private javax.swing.JComboBox<String> cboViPham;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPM;
    private javax.swing.JTable tblPM1;
    private javax.swing.JTable tblPM2;
    private javax.swing.JTable tblSV;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tlbViPham;
    // End of variables declaration//GEN-END:variables
}
