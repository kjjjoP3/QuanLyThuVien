/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanPhamLoi;

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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class QuanLySachFrNew extends javax.swing.JPanel {
 private DefaultTableModel tableModel;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form QuanLySachFrNew
     */
    public QuanLySachFrNew() {
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
    
    
    private void loadTen() {
        try {
           
            SachDao dao = new SachDao();
            List<Sach> list = dao.SearchTen(txtSearch.getText());
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
        jDateChooser.setCalendar(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudens = new javax.swing.JTable();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNhaXuatBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        btnTaoMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

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

        txtMaSach.setBackground(new java.awt.Color(102, 102, 102));
        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSach.setForeground(new java.awt.Color(255, 255, 255));
        txtMaSach.setBorder(null);

        txtTenSach.setBackground(new java.awt.Color(102, 102, 102));
        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenSach.setForeground(new java.awt.Color(255, 255, 255));
        txtTenSach.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mã Sách:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên Sách:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã Thể Loại:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tác Giả:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Số Lượng:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã NXB:");

        txtNhaXuatBan.setBackground(new java.awt.Color(204, 204, 204));
        txtNhaXuatBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNhaXuatBan.setBorder(null);

        txtSoLuong.setBackground(new java.awt.Color(204, 204, 204));
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoLuong.setBorder(null);

        txtTacGia.setBackground(new java.awt.Color(204, 204, 204));
        txtTacGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTacGia.setBorder(null);

        txtTheLoai.setBackground(new java.awt.Color(204, 204, 204));
        txtTheLoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTheLoai.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ngày Nhập:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ghi Chú:");

        txtNoiDung.setBackground(new java.awt.Color(204, 204, 204));
        txtNoiDung.setColumns(20);
        txtNoiDung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNoiDung.setRows(5);
        txtNoiDung.setBorder(null);
        jScrollPane2.setViewportView(txtNoiDung);

        jDateChooser.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser.setDateFormatString("dd-MM-yyyy");
        jDateChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

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

        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Hình:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(0, 255, 0)));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnBrowse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBrowse.setText("Mở Hình");
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
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnBrowse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowse)
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Quản Lý Sách");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tìm Kiếm:");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTacGia)
                            .addComponent(txtSoLuong)
                            .addComponent(txtNhaXuatBan)
                            .addComponent(txtTheLoai, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSach)
                            .addComponent(txtMaSach)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTaoMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSearch))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(309, 309, 309))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTaoMoi)
                                    .addComponent(btnThem)
                                    .addComponent(btnSua)
                                    .addComponent(btnxoa))))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
            try {
                int row = tblStudens.getSelectedRow();
                String id = (String) tblStudens.getValueAt(row, 0);
                SachDao dao = new SachDao();
                Sach sv = dao.findById(id);
                e.printStackTrace();
                personalImage = sv.getHinh();
                ImageIcon icon = new ImageIcon(
                        getClass().getResource(""));
                lblImage.setIcon(icon);
                MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
            } catch (Exception ex) {
                Logger.getLogger(QuanLySachFrNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblStudensMouseClicked

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
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

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
           JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

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
            Image img = ImageHelper.resize(icon.getImage(), 200, 160);
            ImageIcon resizedIcon = new ImageIcon(img);
            lblImage.setIcon(resizedIcon);
            personalImage = ImageHelper.toByArray(img, "jpg");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        //tim kiem
        loadTen();
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnxoa;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblStudens;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    // End of variables declaration//GEN-END:variables
}
