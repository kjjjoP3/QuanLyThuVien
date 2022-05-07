/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiQuanLy;

import dao.SachDao;
import dao.SinhVienDao;
import dao.adminDao;
import helpers.MessageDialogHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import model.admin;

/**
 *
 * @author ACER NITRO 5
 */
public class QuanLyNhanVienCuaQuanLy extends javax.swing.JDialog {
private DefaultTableModel tableModel;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form QuanLyNhanVienCuaQuanLy
     */
    public QuanLyNhanVienCuaQuanLy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTable();
        loadDataToTable();
        setLocationRelativeTo(null);
        txtChucVu1.setEditable(false);
        
    }
    
    
    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Tên Đăng Nhập", "Mật Khẩu","Họ Tên", "Chức Vụ"});
        tblNhanVien1.setModel(tableModel);
    }
    
    private void loadDataToTable() {
        try {
           
            adminDao dao = new adminDao();
            List<admin> list = dao.load();
            tableModel.setRowCount(0);
            for (admin it : list) {
                tableModel.addRow(new Object[]{
                    it.getUsername(), it.getPassword(), it.getTen(), it.getVaitro(),
                });
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    public boolean check() {

        if (txtDangNhap1.getText().equals("") || txtMatKhau1.getText().equals("") || txtChucVu1.getText().equals("")
                || txtHoTen1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ dữ liệu sau đó ấn Save");

            return false;
        }else if (!txtChucVu1.getText().equalsIgnoreCase("Quản Lý Thủ Thư") && !txtChucVu1.getText().equalsIgnoreCase("Quản Lý Thủ Thư")                ) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập Quản Lý Thủ Thư");
            txtChucVu1.requestFocus();
            return false;
        }
        return true;
    }
    
    public void clear(){
        txtDangNhap1.setText("");
        txtMatKhau1.setText("");
        txtHoTen1.setText("");
        
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
        jLabel15 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDangNhap1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHoTen1 = new javax.swing.JTextField();
        txtMatKhau1 = new javax.swing.JTextField();
        txtChucVu1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnTaoMoi1 = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(45, 118, 232));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group_52px_1.png"))); // NOI18N
        jLabel15.setText("Quản Lý Nhân Viên");

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel15)
                .addContainerGap(646, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(exit)
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblNhanVien1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mật Khẩu:");

        txtDangNhap1.setBackground(new java.awt.Color(102, 102, 102));
        txtDangNhap1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDangNhap1.setForeground(new java.awt.Color(255, 255, 255));
        txtDangNhap1.setBorder(null);
        txtDangNhap1.setFocusTraversalPolicyProvider(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tên Đăng Nhập:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Họ Tên:");

        txtHoTen1.setBackground(new java.awt.Color(204, 204, 204));
        txtHoTen1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtHoTen1.setBorder(null);
        txtHoTen1.setFocusTraversalPolicyProvider(true);

        txtMatKhau1.setBackground(new java.awt.Color(102, 102, 102));
        txtMatKhau1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau1.setForeground(new java.awt.Color(255, 255, 255));
        txtMatKhau1.setBorder(null);
        txtMatKhau1.setFocusTraversalPolicyProvider(true);

        txtChucVu1.setBackground(new java.awt.Color(204, 204, 204));
        txtChucVu1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtChucVu1.setText("Quản Lý Thủ Thư");
        txtChucVu1.setBorder(null);
        txtChucVu1.setFocusTraversalPolicyProvider(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Chức Vụ:");

        btnTaoMoi1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTaoMoi1.setText("Tạo Mới");
        btnTaoMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoi1ActionPerformed(evt);
            }
        });

        btnThem1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSua1.setText("Sửa ");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhau1)
                            .addComponent(txtHoTen1)
                            .addComponent(txtChucVu1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(txtDangNhap1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTaoMoi1)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua1)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDangNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtChucVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaoMoi1)
                            .addComponent(btnThem1)
                            .addComponent(btnSua1)
                            .addComponent(btnXoa1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 141, 1025, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     int xx,xy;
    
    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitMousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);  
    }//GEN-LAST:event_jPanel1MouseDragged

    private void tblNhanVien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien1MouseClicked
        // click
        try {
            int row = tblNhanVien1.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblNhanVien1.getValueAt(row, 0);
                adminDao dao = new adminDao();
                admin sv = dao.findById(id);
                if (sv != null) {
                    txtDangNhap1.setText(sv.getUsername());
                    txtMatKhau1.setText(sv.getPassword());
                    txtHoTen1.setText(sv.getTen());
                    txtChucVu1.setText(sv.getVaitro());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblNhanVien1MouseClicked

    private void btnTaoMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoi1ActionPerformed
        // tạo mơi
        clear();
    }//GEN-LAST:event_btnTaoMoi1ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
         // them
        if (check() == true) {
            admin sv = new admin();
            sv.setUsername(txtDangNhap1.getText());
            sv.setPassword(txtMatKhau1.getText());
            sv.setTen(txtHoTen1.getText());
            sv.setVaitro(txtChucVu1.getText());

            adminDao dao = new adminDao();

            try {
                if (dao.insert(sv) > 0) {
                    MessageDialogHelper.showMessageDialog(this, " Đã Được Lưu", "Thông Báo");

                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");

                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");

            }

        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        //sua
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn cập nhật hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }

        if (check() == true) {
            admin sv = new admin();
            sv.setUsername(txtDangNhap1.getText());
            sv.setPassword(txtMatKhau1.getText());
            sv.setTen(txtHoTen1.getText());
            sv.setVaitro(txtChucVu1.getText());

            adminDao dao = new adminDao();

            try {

                if (dao.updateNhanVien(sv)>0) {
                    MessageDialogHelper.showMessageDialog(this, "Đã Được Cập Nhật", "Thông Báo");

                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");

                }
            } catch (Exception ex) {
                //                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                                 MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
            }

        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
         // Xoa
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn xóa hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }
        try {

            adminDao dao = new adminDao();
            if (dao.delete(txtDangNhap1.getText())) {
                MessageDialogHelper.showMessageDialog(this, "Đã Được Xóa", "Thông Báo");
                clear();
                loadDataToTable();
            } else {
                MessageDialogHelper.showMessageDialog(this, "Không Được Xóa Do Lỗi Sự Kiện", "Cảnh Báo");
            }

        } catch (Exception e) {
                             MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVienCuaQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVienCuaQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVienCuaQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVienCuaQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyNhanVienCuaQuanLy dialog = new QuanLyNhanVienCuaQuanLy(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnTaoMoi1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblNhanVien1;
    private javax.swing.JTextField txtChucVu1;
    private javax.swing.JTextField txtDangNhap1;
    private javax.swing.JTextField txtHoTen1;
    private javax.swing.JTextField txtMatKhau1;
    // End of variables declaration//GEN-END:variables
}
