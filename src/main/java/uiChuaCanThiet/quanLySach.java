/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiChuaCanThiet;

import dao.SachDao;
import helpers.ImageHelper;
import helpers.MessageDialogHelper;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import model.Sach;

/**
 *
 * @author ACER NITRO 5
 */
public class quanLySach extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form quanLySach
     */
    public quanLySach() {
        initComponents();
        initTable();
        loadDataToTable();
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Sách", "Tên Sách", "Mã Thể Loại", "Tác Giả", "Số Lượng", "Mã NXB", "Ngày Nhập","Ghi Chú","Hình"});
        tblStudens.setModel(tableModel);
    }
    private void loadDataToTable() {
        try {
           
            SachDao dao = new SachDao();
            List<Sach> list = dao.findAll();
            tableModel.setRowCount(0);
            for (Sach it : list) {
                tableModel.addRow(new Object[]{
                    it.getMaSach(), it.getTenSach(), it.getMaTheLoai(), it.getTacGia(),
                    it.getSoLuong(), it.getNxb(),it.getNgayNhap(),it.getNdtt() ,it.getHinh() == null? "Không hình" :"Có Hình Ảnh Đại Diện", 
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
        txtTenSach.setText("");
        txtTheLoai.setText("");
        txtTacGia.setText("");
        txtSoLuong.setText("");
        txtNhaXuatBan.setText("");
//        jDateChooser.setDateFormatString("");
        txtNoiDung.setText("");
        //xoa anh
        personalImage = null;
        ImageIcon icon = new ImageIcon(getClass().getResource(""));
        lblImage.setIcon(icon);
    }
    
    
    public boolean check() {
        if (txtMaSach.getText().equals("")) {
            txtMaSach.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Sách");
            return false;
        }else if (txtTenSach.getText().equals("")) {
            txtTenSach.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Tên Sách");
            return false;
        }else if (txtSoLuong.getText().equals("")) {
            txtSoLuong.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Số lượng");
            return false;
        }else if (!(txtSoLuong.getText().matches("\\d{1,3}"))) {
            txtSoLuong.requestFocus();
            JOptionPane.showMessageDialog(this, "Số lượng phải là số, lớn hơn 0");
            return false;
        }else if ((!(Integer.parseInt(txtSoLuong.getText())> 0))) {
            txtSoLuong.requestFocus();
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            return false;
        }else if (jDateChooser.isValid()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày nhập Sách","Error",1);
            return false;
        }else if (txtNoiDung.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Nội dung Sách","Error",1);
            txtNoiDung.requestFocus(); 
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        btnTaoMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ma Sach");

        jLabel2.setText("Ten Sach");

        jLabel3.setText("Ma The Loai");

        jLabel4.setText("Tac Gia");

        jLabel5.setText("So Luong");

        jLabel6.setText("Ngay Nhap");

        jLabel7.setText("NDTT");

        jLabel8.setText("Hinh");

        jLabel9.setText("MaNXB");

        jDateChooser.setDateFormatString("dd-MM-yyyy");

        btnTaoMoi.setText("Tao Moi");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xoa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        tblStudens.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudens);

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane2.setViewportView(txtNoiDung);

        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnBrowse.setText("Mo Hinh");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBrowse)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTheLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                                    .addComponent(txtMaSach)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaoMoi)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnxoa)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        // xoa het
        clearFrom();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // them
        if (check() == true) {
            Sach sv = new Sach();
            sv.setMaSach(txtMaSach.getText());
            sv.setTenSach(txtTenSach.getText());
            sv.setMaTheLoai(txtTheLoai.getText());
            sv.setTacGia(txtTacGia.getText());
            sv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            sv.setNxb(txtNhaXuatBan.getText());
            Date date = jDateChooser.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgayNhap(df);
            sv.setNdtt(txtNoiDung.getText());
            sv.setHinh(personalImage);
            SachDao dao = new SachDao();

            try {
                if (dao.insert(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Sách Đã Được Lưu", "Thông Báo");
                    
                    
                    
                    
                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");
                    
                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");
                
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // them anh
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");

                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });

        if (chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
            return;

        }

        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 140, 160);
            ImageIcon resizedIcon = new ImageIcon(img);
            lblImage.setIcon(resizedIcon);
            personalImage = ImageHelper.toByArray(img, "jpg");

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // sua
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn cập nhật hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }

        if (check() == true) {
            Sach sv = new Sach();
            sv.setMaSach(txtMaSach.getText());
            sv.setTenSach(txtTenSach.getText());
            sv.setMaTheLoai(txtTheLoai.getText());
            sv.setTacGia(txtTacGia.getText());
            sv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            sv.setNxb(txtNhaXuatBan.getText());
            Date date = jDateChooser.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgayNhap(df);
            sv.setNdtt(txtNoiDung.getText());
            sv.setHinh(personalImage);
            SachDao dao = new SachDao();

            try {

                if (dao.update(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Sách Đã Được Cập Nhật", "Thông Báo");
                    

                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                   
                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                
            }

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblStudensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudensMouseClicked
        //click hien thi
        try {
            int row = tblStudens.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblStudens.getValueAt(row, 0);
                SachDao dao = new SachDao();
                Sach sv = dao.findById(id);
                if (sv != null) {
                    txtMaSach.setText(sv.getMaSach());
                    txtTenSach.setText(sv.getTenSach());
                    txtTheLoai.setText(sv.getMaTheLoai());
                    txtTacGia.setText(sv.getTacGia());
                    txtSoLuong.setText(String.valueOf(sv.getSoLuong()));
                    txtNhaXuatBan.setText(sv.getNxb());
                    try {
            DefaultTableModel model = (DefaultTableModel) tblStudens.getModel();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(row, 6));
            jDateChooser.setDate(date);
            } catch (ParseException ex) {   
        }
                    txtNoiDung.setText(sv.getNdtt());

                    if (sv.getHinh() != null) {
                        Image img = ImageHelper.createImageFromVyteArray(sv.getHinh(), "jpg");
                        lblImage.setIcon(new ImageIcon(img));
                        personalImage = sv.getHinh();
                    } else {
                        personalImage = sv.getHinh();
                        ImageIcon icon = new ImageIcon(
                                getClass().getResource(""));
                        lblImage.setIcon(icon);
                    }
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblStudensMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // xoa
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn xóa hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }
        try {

            SachDao dao = new SachDao();
            if (dao.delete(txtMaSach.getText())) {
                MessageDialogHelper.showMessageDialog(this, "Sách Đã Được Xóa", "Thông Báo");
                clearFrom();
                loadDataToTable();
            } else {
                MessageDialogHelper.showConFirmDialog(this, "Sách Không Được Xóa Do Lỗi Sự Kiện", "Cảnh Báo");
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanLySach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnxoa;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblStudens;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    // End of variables declaration//GEN-END:variables
}
