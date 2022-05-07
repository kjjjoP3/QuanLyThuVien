/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanPhamLoi;
import dao.PhieuMuonDAO;
import dao.SachDao;
import helpers.ImageHelper;
import helpers.MessageDialogHelper;
import helpers.shareHelper;
import java.awt.Color;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhieuMuon;
import model.Sach;
import uiSinhVien.Home15;
/**
 *
 * @author ACER NITRO 5
 */
public class QuanLyPhieuMuonNewFr extends javax.swing.JPanel {
private DefaultTableModel tableModel;
private DefaultTableModel tableModel2;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form QuanLyPhieuMuonNewFr
     */
    public QuanLyPhieuMuonNewFr() {
        initComponents();
        initTable();
        loadDataToTable();
        initTable3();
        loadPhieuMuonSinhVien();
    }
    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID Phiếu Mượn","Tên Phiếu Mượn", "Mã Sinh Viên", "Mã Sách", "Số Lượng", "Ngày Mượn", "Ngày Hẹn Trả"});
        tblPhieuMuon3.setModel(tableModel);
    }
    private void loadDataToTable() {
        try {
           
            PhieuMuonDAO dao = new PhieuMuonDAO();
            List<PhieuMuon> list = dao.findAll();
            tableModel.setRowCount(0);
            for (PhieuMuon it : list) {
                tableModel.addRow(new Object[]{
                    it.getMa(),it.getMaPhieuMuon(), it.getMaSV(), it.getMaSach(), it.getSoLuong(),
                    it.getNgayMuon(), it.getNgayHenTra()
                });
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    private void initTable3() {
        tableModel2 = new DefaultTableModel();
        tableModel2.setColumnIdentifiers(new String[]{"Mã" ,"Mã Sinh Viên","Mã Sách", "Mã Phiếu Mượn"});
        tblPhieuMuon2.setModel(tableModel2);
    }
    
    
    private void loadPhieuMuonSinhVien() {
        try {
           
            PhieuMuonDAO dao = new PhieuMuonDAO();
            List<PhieuMuon> list = dao.findAllNgaNgu();
            tableModel2.setRowCount(0);
            for (PhieuMuon it : list) {
                tableModel2.addRow(new Object[]{
                     it.getMa(),it.getMaSV(), it.getMaSach(),it.getMaPhieuMuon(),
                   
                });
            }
            tableModel2.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    private void loadDataSach() {
        try {
           
            PhieuMuonDAO dao = new PhieuMuonDAO();
            List<PhieuMuon> list = dao.SearchMaSVMaPhieu(txtSreach.getText());
            tableModel.setRowCount(0);
            for (PhieuMuon it : list) {
                tableModel.addRow(new Object[]{
                    it.getMaPhieuMuon(), it.getMaSV(), it.getMaSach(), it.getSoLuong(),
                    it.getNgayMuon(), it.getNgayHenTra()
                });
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    public void clearFrom(){
           // Tao Moi
        txtMaSach.setText("");
        txtMaPhieuMuon.setText("");
        txtMaSV.setText("");
        txtSoLuong.setText("");
        jDateChooser1.setCalendar(null);
        jDateChooser2.setCalendar(null);
        
       
    }
    
    public boolean check() {
        if (txtMaPhieuMuon.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Phiếu Mượn");
            txtMaPhieuMuon.requestFocus();
            return false;
        }else if (txtMaSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Sinh Viên");
            txtMaSV.requestFocus();
            return false;
        }else if (jDateChooser1.isValid()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày Mượn Sách","Error",1);
            return false;
        }else if (jDateChooser2.isValid()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày Hẹn Trả Sách","Error",1);
            return false;
        }else 
        return true;
    };
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMaSachDaThem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhieuMuon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnTaoMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhieuMuon3 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtSreach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuMuon2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tên Phiếu Mượn:");

        txtMaPhieuMuon.setBackground(new java.awt.Color(102, 102, 102));
        txtMaPhieuMuon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaPhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        txtMaPhieuMuon.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã Sinh Viên:");

        txtMaSV.setBackground(new java.awt.Color(102, 102, 102));
        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaSV.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã Sách");

        txtMaSach.setBackground(new java.awt.Color(204, 204, 204));
        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSach.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Số Lượng");

        txtSoLuong.setBackground(new java.awt.Color(204, 204, 204));
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoLuong.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ngày Mượn:");

        jDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ngày Trả:");

        jDateChooser2.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnTaoMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaoMoi.setText("Tạo Mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblPhieuMuon3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPhieuMuon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuon3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPhieuMuon3);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Quản Lý Phiếu Mượn");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tìm Kiếm:");

        txtSreach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSreachKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblPhieuMuon2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPhieuMuon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuon2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuMuon2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Những Sinh Viên Đang Chờ Mượn Sách:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(33, 33, 33)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(46, 46, 46)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaoMoi)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        // tao moi
        clearFrom();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // them
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn thêm hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }
        if (check() == true) {
            PhieuMuon sv = new PhieuMuon();
            sv.setMaPhieuMuon(txtMaPhieuMuon.getText());
            sv.setMaSV(txtMaSV.getText());
            sv.setMaSach(txtMaSach.getText());
            sv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            Date date = jDateChooser1.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgayMuon(df);
            Date date1 = jDateChooser2.getDate();
            String df1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
            sv.setNgayHenTra(df1);

            PhieuMuonDAO dao = new PhieuMuonDAO();

            try {
                if (dao.insert(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Phiếu Mượn Đã Được Lưu", "Thông Báo");
                    loadPhieuMuonSinhVien();
                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");

                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");

            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Sua
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn cập nhật hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }

        if (check() == true) {
            PhieuMuon sv = new PhieuMuon();
            
            sv.setMaPhieuMuon(txtMaPhieuMuon.getText());
            sv.setMaSV(txtMaSV.getText());
            sv.setMaSach(txtMaSach.getText());
            sv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            Date date = jDateChooser1.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgayMuon(df);
            Date date1 = jDateChooser2.getDate();
            String df1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
            sv.setNgayHenTra(df1);

            PhieuMuonDAO dao = new PhieuMuonDAO();

            try {

                if (dao.update(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Phiếu Mượn Đã Được Cập Nhật", "Thông Báo");
                    loadPhieuMuonSinhVien();
                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");

                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");

            }

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Xóa
//        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn xóa hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
//            return;
//        }
//        try {
//
//            PhieuMuonDAO dao = new PhieuMuonDAO();
//            if (dao.deletesinhvien(txtMaSachDaThem.getText())) {
//                MessageDialogHelper.showMessageDialog(this, "Phiếu Đã Được Xóa", "Thông Báo");
//                clearFrom();
//                loadDataToTable();
//            } else {
//                MessageDialogHelper.showConFirmDialog(this, "Phiếu Không Được Xóa Do Lỗi Sự Kiện", "Cảnh Báo");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
//        }

try {
        //xóa
        String strID = JOptionPane.showInputDialog(this, "Nhập Mã Xóa?");
        if (strID == null ) {       
               return;
            }
        PhieuMuonDAO dao = new PhieuMuonDAO();
        if(dao.deletesinhvien(strID)){
            JOptionPane.showMessageDialog(this, "Xóa Thành Công ");
            loadDataToTable();
            loadPhieuMuonSinhVien();
            clearFrom();
        }else{
            JOptionPane.showMessageDialog(this, "ID Không Tồn Tại ");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "ID Không Tồn Tại ");
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblPhieuMuon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuon3MouseClicked
        // Click hien thị
        try {
            int row = tblPhieuMuon3.getSelectedRow();

            if (row >= 0) {
                String id = (String.valueOf(tblPhieuMuon3.getValueAt(row, 0))) ;
                PhieuMuonDAO dao = new PhieuMuonDAO();
                PhieuMuon sv = dao.findByma(id);
                if (sv != null) {
                    txtMaSachDaThem.setText(String.valueOf(sv.getMa()));
                    txtMaPhieuMuon.setText(sv.getMaPhieuMuon());
                    txtMaSV.setText(sv.getMaSV());
                    txtMaSach.setText(sv.getMaSach());
                    txtSoLuong.setText(String.valueOf(sv.getSoLuong()));
                    try {
                        DefaultTableModel model = (DefaultTableModel) tblPhieuMuon3.getModel();
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String.valueOf(model.getValueAt(row, 5))));
                        jDateChooser1.setDate(date);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        DefaultTableModel model = (DefaultTableModel) tblPhieuMuon3.getModel();
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String.valueOf(model.getValueAt(row, 6))));
                        jDateChooser2.setDate(date);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                        loadPhieuMuonSinhVien();
                }
                
                
            }

        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_tblPhieuMuon3MouseClicked

    private void txtSreachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSreachKeyReleased
        // tìm kiếm
//        loadDataSach();
    }//GEN-LAST:event_txtSreachKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Tim Kiem
        try {
            PhieuMuonDAO dao = new PhieuMuonDAO();
                PhieuMuon sv = dao.findByma(txtSreach.getText());
            if(sv != null){
                    txtMaSachDaThem.setText(String.valueOf(sv.getMa()));
                    txtMaPhieuMuon.setText(sv.getMaPhieuMuon());
                    txtMaSV.setText(sv.getMaSV());
                    txtMaSach.setText(sv.getMaSach());
                    txtSoLuong.setText(String.valueOf(sv.getSoLuong()));
                    
                    try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sv.getNgayMuon());
            jDateChooser1.setDate(date);
            } catch (ParseException ex) {   
            }
                    try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sv.getNgayHenTra());
            jDateChooser2.setDate(date);
            } catch (ParseException ex) {   
            }
                    
//                    try {
//                        DefaultTableModel model = (DefaultTableModel) tblPhieuMuon3.getModel();
//                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(4, 5));
//                        jDateChooser1.setDate(date);
//                    } catch (ParseException ex) {
//                    }
//                    try {
//                        DefaultTableModel model = (DefaultTableModel) tblPhieuMuon3.getModel();
//                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(5, 5));
//                        jDateChooser2.setDate(date);
//                    } catch (ParseException ex) { 
//                        ex.printStackTrace();
//                    }
            }else{
                MessageDialogHelper.showMessageDialog(this, "Không Tìm Thấy Sinh Viên Theo Mã Yêu Cầu", "Thông Báo");
            }
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblPhieuMuon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuon2MouseClicked
        // Click hien thị
        try {
            int row = tblPhieuMuon2.getSelectedRow();

            if (row >= 0) {
                String id = (String.valueOf(tblPhieuMuon2.getValueAt(row, 3))) ;
                PhieuMuonDAO dao = new PhieuMuonDAO();
                PhieuMuon sv = dao.findBySinhVien(id);
                if (sv != null) {
                    
                    txtMaSV.setText(sv.getMaSV());
                    txtMaSach.setText(sv.getMaSach());
                    txtMaPhieuMuon.setText(sv.getMaPhieuMuon());
                    
                    jDateChooser1.setCalendar(null);
                    jDateChooser2.setCalendar(null);
                    txtSoLuong.setText("");
                    
                    loadDataToTable();
                }
                
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_tblPhieuMuon2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPhieuMuon2;
    private javax.swing.JTable tblPhieuMuon3;
    private javax.swing.JTextField txtMaPhieuMuon;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaSachDaThem;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSreach;
    // End of variables declaration//GEN-END:variables
}
