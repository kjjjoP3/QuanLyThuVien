/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanPhamLoi;

import dao.SachDao;
import dao.SinhVienDao;
import helpers.MessageDialogHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;

/**
 *
 * @author ACER NITRO 5
 */
public class QuanLySinhFrNew extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form QuanLySinhFrNew
     */
    public QuanLySinhFrNew() {
        initComponents();
        initTable();
        loadDataToTable();
        buttonGroup1.add(rdoNam);
        buttonGroup1.add(rdoNu);
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Sinh Viên", "Mã Lớp","Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại","Email"});
        tblSinhVien.setModel(tableModel);
    }
    
    private void loadDataToTable() {
        try {
           
            SinhVienDao dao = new SinhVienDao();
            List<SinhVien> list = dao.findAll();
            tableModel.setRowCount(0);
            for (SinhVien it : list) {
                tableModel.addRow(new Object[]{
                    it.getMaSV(), it.getMalop(), it.getHoTen(), it.getNgaySinh(),
                    it.getGioiTinh()== 1 ? "Nam" : "Nữ", it.getDiaChi(), it.getSdt(), it.getEmail()
                });
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    private void loadTen() {
        try {
           
            SinhVienDao dao = new SinhVienDao();
            List<SinhVien> list = dao.SearchTen(txtSreach.getText());
            tableModel.setRowCount(0);
            for (SinhVien it : list) {
                tableModel.addRow(new Object[]{
                    it.getMaSV(), it.getMalop(), it.getHoTen(), it.getNgaySinh(),
                    it.getGioiTinh()== 1 ? "Nam" : "Nữ", it.getDiaChi(), it.getSdt(), it.getEmail()
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
        txtMaSV.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtpassword.setText("");
        txtMaLop.setText("");
        txtSDT.setText("");
        txtHoTen.setText("");
        jDateChooser.setCalendar(null);
        
       
    }
    
    
    public boolean check() {
        if (txtMaSV.getText().equalsIgnoreCase("")) {
            txtMaSV.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Mã Sinh Viên");
            return false;
        }else if (txtpassword.getText().equals("")) {
            txtpassword.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Password");
            return false;
        }else if (!(txtpassword.getText()).matches("\\w{3,50}")) {
            txtpassword.requestFocus();
            JOptionPane.showMessageDialog(this, "Mật khẩu ít nhất 3 kí tự");
            return false;
        }else if (txtHoTen.getText().equalsIgnoreCase("")) {
            txtHoTen.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Họ Tên");
            return false;
        }else if (buttonGroup1.isSelected(null)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Giới Tính");
            return false;
        }else if (txtDiaChi.getText().equalsIgnoreCase("")) {
            txtDiaChi.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập Địa chỉ");
            return false;
        }else if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập SĐT");
            txtSDT.requestFocus();     
            return false;
        }else if (!(txtSDT.getText().matches("\\d{10,11}"))) {
            txtSDT.requestFocus();
            JOptionPane.showMessageDialog(this, "SĐT phải là số, 10 - 11 số");
            return false;
        }else if (txtEmail.getText().equals("")) {
            txtEmail.requestFocus(); 
            JOptionPane.showMessageDialog(this, "Chưa nhập Email");
            return false;
        }else if (!(txtEmail.getText().matches("\\w+@\\w+\\.\\w{1,3}"))) {
            txtEmail.requestFocus(); 
            JOptionPane.showMessageDialog(this, "Nhập Email đúng định dạng");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnTaoMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtSreach = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mã Sinh Viên:");

        txtMaSV.setBackground(new java.awt.Color(102, 102, 102));
        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaSV.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PassWord:");

        txtpassword.setBackground(new java.awt.Color(102, 102, 102));
        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã Lớp:");

        txtMaLop.setBackground(new java.awt.Color(204, 204, 204));
        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaLop.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Họ Tên:");

        txtHoTen.setBackground(new java.awt.Color(204, 204, 204));
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ngày Sinh:");

        jDateChooser.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDateChooser.setDateFormatString("dd-MM-yyyy");
        jDateChooser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Giới Tính:");

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Số Điện Thoại:");

        txtSDT.setBackground(new java.awt.Color(204, 204, 204));
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSDT.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Email:");

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

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

        txtDiaChi.setBackground(new java.awt.Color(204, 204, 204));
        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setBorder(null);
        jScrollPane1.setViewportView(txtDiaChi);

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhVien);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Quản Lý Sinh Viên");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tìm Kiếm:");

        txtSreach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSreach.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSreach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSreachKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtHoTen)
                                        .addComponent(txtMaLop)
                                        .addComponent(txtpassword)
                                        .addComponent(txtMaSV)
                                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnTaoMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoNam)
                                .addComponent(rdoNu))
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaoMoi)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        // tao moi
        clearFrom();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // them
        if (check() == true) {
            SinhVien sv = new SinhVien();
            sv.setMaSV(txtMaSV.getText());
            sv.setPassword(txtpassword.getText());
            sv.setMalop(txtMaLop.getText());
            sv.setHoTen(txtHoTen.getText());
            Date date = jDateChooser.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgaySinh(df);
            sv.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
            sv.setDiaChi(txtDiaChi.getText());
            sv.setSdt(txtSDT.getText());
            sv.setEmail(txtEmail.getText());
            SinhVienDao dao = new SinhVienDao();

            try {
                if (dao.insert(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Sinh Viên Đã Được Lưu", "Thông Báo");

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
        //sua
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn cập nhật hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }

        if (check() == true) {
            SinhVien sv = new SinhVien();
            sv.setMaSV(txtMaSV.getText());
            sv.setPassword(txtpassword.getText());
            sv.setMalop(txtMaLop.getText());
            sv.setHoTen(txtHoTen.getText());
            Date date = jDateChooser.getDate();
            String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
            sv.setNgaySinh(df);
            sv.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
            sv.setDiaChi(txtDiaChi.getText());
            sv.setSdt(txtSDT.getText());
            sv.setEmail(txtEmail.getText());
            SinhVienDao dao = new SinhVienDao();

            try {

                if (dao.update(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Sinh Viên Đã Được Cập Nhật", "Thông Báo");

                    loadDataToTable();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");

                }
            } catch (Exception ex) {
                //                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                JOptionPane.showMessageDialog(this, "Lỗi ");
            }

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Xoa
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn xóa hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }
        try {

            SinhVienDao dao = new SinhVienDao();
            if (dao.delete(txtMaSV.getText())) {
                MessageDialogHelper.showMessageDialog(this, "Sinh Viên Đã Được Xóa", "Thông Báo");
                clearFrom();
                loadDataToTable();
            } else {
                MessageDialogHelper.showConFirmDialog(this, "Sách Không Được Xóa Do Lỗi Sự Kiện", "Cảnh Báo");
            }

        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Lỗi ");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // click va hien thi
        try {
            int row = tblSinhVien.getSelectedRow();

            if (row >= 0) {
                String id = (String) tblSinhVien.getValueAt(row, 0);
                SinhVienDao dao = new SinhVienDao();
                SinhVien sv = dao.findById(id);
                if (sv != null) {
                    txtMaSV.setText(sv.getMaSV());
                    txtpassword.setText(sv.getPassword());
                    txtMaLop.setText(sv.getMalop());
                    txtHoTen.setText(sv.getHoTen());
                    try {
                        DefaultTableModel model = (DefaultTableModel) tblSinhVien.getModel();
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(row, 3));
                        jDateChooser.setDate(date);
                    } catch (ParseException ex) {
                    }
                    rdoNam.setSelected((sv.getGioiTinh() == 1));
                    rdoNu.setSelected((sv.getGioiTinh() == 0));
                    txtDiaChi.setText(sv.getDiaChi());
                    txtSDT.setText(sv.getSdt());
                    txtEmail.setText(sv.getEmail());

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void txtSreachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSreachKeyReleased
        // tim kiem
        loadTen();
    }//GEN-LAST:event_txtSreachKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSreach;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
