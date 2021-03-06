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
        jLabel2.setText("Gi???i t??nh: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Th???ng k?? theo:");

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
                "M?? Sinh Vi??n", "PassWord", "H??? V?? T??n", "Ng??y Sinh", "Gi???i T??nh", "?????a Ch???", "S??? ??i???n Tho???i ", "Email"
            }
        ));
        jScrollPane1.setViewportView(tblSV);

        cboGioiTinhSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "Nam", "N???" }));
        cboGioiTinhSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhSVActionPerformed(evt);
            }
        });

        cboSapXepSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "Sinh Vi??n Ch??a M?????n S??ch", "Sinh Vi??n ???? M?????n S??ch" }));
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

        jTabbedPane1.addTab("Sinh Vi??n", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Th???ng k?? theo:");

        cboSapXepPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "Phi???u M?????n c??n h???n tr??? s??ch", "Phi???u M?????n qu?? h???n tr??? s??ch", "Sinh Vi??n m?????n nhi???u s??ch nh???t", "Sinh Vi??n m?????n ??t s??ch nh???t", "S??ch m?????n nhi???u nh???t", "S??ch m?????n ??t nh???t" }));
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
                "M?? Phi???u M?????n", "M?? Sinh Vi??n", "H??? T??n", "M?? S??ch", "T??n S??ch", "S??? L?????ng", "Ng??y M?????n", "Ng??y Tr???"
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
                "M?? S??ch ", "T??n S??ch", "S??? L?????ng"
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
                "M?? Sinh Vi??n", "T??n Sinh Vi??n", "S??? L?????ng"
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

        jTabbedPane1.addTab("Phi???u M?????n", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("S???p x???p theo: ");

        cboSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "S??? l?????ng S??ch gi???m d???n", "S??? l?????ng S??ch t??ng d???n" }));
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
                "M?? S??ch", "T??n S??ch", "M?? Th??? Lo???i", "T??c Gi???", "S??? L?????ng", "M?? Nh?? Xu???t B???n", "Ng??y Nh???p", "Ghi Ch??", "H??nh"
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

        jTabbedPane1.addTab("S??ch", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("S???p x???p theo: ");

        cboViPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "M???t S??ch", "S??ch R??ch", "Tr??? H???n" }));
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
                "M?? Vi Ph???m", "M?? Sinh Vi??n", "Tr??nh Tr???ng S??ch"
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

        jTabbedPane1.addTab("Vi Ph???m", jPanel6);

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
        if(cboGioiTinhSV.getSelectedItem().equals("T???t c???")){
            fillTableSinhVien();
        }else if(cboGioiTinhSV.getSelectedItem().equals("N???")){
            cboSapXepSV.setSelectedIndex(0);
            fillTableSinhVienGioiTinhNu();
        }else{
            cboSapXepSV.setSelectedIndex(0);
            fillTableSinhVienGioiTinhNam();
        }
    }//GEN-LAST:event_cboGioiTinhSVActionPerformed

    private void cboSapXepSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepSVActionPerformed
        // theo Luot Sap Xep sinh vien muon hoac chua muon sach
        if(cboSapXepSV.getSelectedItem().equals("T???t c???")){
            fillTableSinhVien();
        }else if(cboSapXepSV.getSelectedItem().equals("Sinh Vi??n Ch??a M?????n S??ch")){
            cboGioiTinhSV.setSelectedIndex(0);
            fillTableSinhVienChuaMuonSach();
        }else{
            cboGioiTinhSV.setSelectedIndex(0);
            fillTableSinhVienDaMuonSach();
        }
    }//GEN-LAST:event_cboSapXepSVActionPerformed

    private void cboSapXepPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepPMActionPerformed
        //cbosuper
        if(cboSapXepPM.getSelectedItem().equals("Phi???u M?????n c??n h???n tr??? s??ch")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(true);
            fillTablePhieuMuonConHan();

        }else if(cboSapXepPM.getSelectedItem().equals("Phi???u M?????n qu?? h???n tr??? s??ch")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(true);
            fillTablePhieuMuonQuaHan();
        }else if(cboSapXepPM.getSelectedItem().equals("Sinh Vi??n m?????n nhi???u s??ch nh???t")){
            ThongKeSinhVien.setVisible(true);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSinhVienMuonSachNhieu();

        }else if(cboSapXepPM.getSelectedItem().equals("Sinh Vi??n m?????n ??t s??ch nh???t")){
            ThongKeSinhVien.setVisible(true);
            ThongKeSach.setVisible(false);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSinhVienMuonSachIt();
        }else if(cboSapXepPM.getSelectedItem().equals("S??ch m?????n nhi???u nh???t")){
            ThongKeSinhVien.setVisible(false);
            ThongKeSach.setVisible(true);
            ThongKeFull.setVisible(false);
            fillTablePhieuMuonSachMuonSachNhieu();
        }else if(cboSapXepPM.getSelectedItem().equals("S??ch m?????n ??t nh???t")){
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

        if(cboSach.getSelectedItem().equals("T???t c???")){
            fillTableSach();
        }else if(cboSach.getSelectedItem().equals("S??? l?????ng S??ch gi???m d???n")){

            fillTableSoLuongSachGiamDan();
        }else{

            fillTableSoLuongSachTangDan();
        }
    }//GEN-LAST:event_cboSachActionPerformed

    private void cboViPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViPhamActionPerformed
         if(cboViPham.getSelectedItem().equals("T???t c???")){
            fillTableViPham();
        }else if(cboViPham.getSelectedItem().equals("M???t S??ch")){

            fillTableViPhamMatsach();
        }else if(cboViPham.getSelectedItem().equals("S??ch R??ch")){

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
