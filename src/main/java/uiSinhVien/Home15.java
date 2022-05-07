/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiSinhVien;

import dao.PhieuMuonDAO;
import dao.SachDao;
import dao.SinhVienDao;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhieuMuon;
import model.Sach;
import model.SinhVien;
import ui.DangNhapjDG;

/**
 *
 * @author proxc
 */
public class Home15 extends javax.swing.JFrame {
private DefaultTableModel tableModel;
private DefaultTableModel tableModel2;
private DefaultTableModel tableModel3;
    private byte[] personalImage;
    SachDao sinhvien;
    /**
     * Creates new form Home15
     */
    public Home15() {
        initComponents();
        setLocationRelativeTo(null);
         buttonGroup1.add(rdoNam);
        buttonGroup1.add(rdoNu);
        init();
        lblTen.setText(shareHelper.sinhVienDangNhap.getHoTen());
         initTable();
        loadDataToTable();
        initTable2();
        loadSachMuon();
        initTable3();
        loadPhieuMuonSinhVien();
        txtMaSVPhieuMuon.setText(shareHelper.sinhVienDangNhap.getMaSV());
        txtMaSVPhieuMuon.setEditable(false);
        txtMaSV.setEditable(false);
        txtMaLop.setEditable(false);
        
    }
    
    
    private void initTable() {
        tableModel2 = new DefaultTableModel();
        tableModel2.setColumnIdentifiers(new String[]{"Mã Sách", "Tên Sách", "Mã Thể Loại", "Tác Giả", "Số Lượng", "Mã NXB", "Ngày Nhập","Ghi Chú","Hình"});
        tblStudens.setModel(tableModel2);
    }
    
    private void loadDataToTable() {
        try {
           
            SachDao dao = new SachDao();
            List<Sach> list = dao.findAll();
            tableModel2.setRowCount(0);
            for (Sach it : list) {
                tableModel2.addRow(new Object[]{
                    it.getMaSach(), it.getTenSach(), it.getMaTheLoai(), it.getTacGia(),
                    it.getSoLuong(), it.getNxb(),it.getNgayNhap(),it.getNdtt() ,it.getHinh() == null? "Không hình" :"Có Hình Ảnh Đại Diện", 
                });
            }
            tableModel2.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    SinhVienDao dao = new SinhVienDao();
    public void init(){
        txtMaSV.setText(shareHelper.sinhVienDangNhap.getMaSV());
        txtpassword.setText(shareHelper.sinhVienDangNhap.getPassword());
        txtHoTen.setText(shareHelper.sinhVienDangNhap.getHoTen());
        txtMaLop.setText(shareHelper.sinhVienDangNhap.getMalop());
//        txtNgaySinh.setText(shareHelper.sinhVienDangNhap.getNgaySinh());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(shareHelper.sinhVienDangNhap.getNgaySinh());
            jDateChooser1.setDate(date);
            } catch (ParseException ex) {   
            }

        rdoNam.setSelected(shareHelper.sinhVienDangNhap.getGioiTinh() == 1);
        rdoNu.setSelected(shareHelper.sinhVienDangNhap.getGioiTinh() == 0 );
        txtSDT.setText(shareHelper.sinhVienDangNhap.getSdt());
        txtEmail.setText(shareHelper.sinhVienDangNhap.getEmail());
        txtDiaChi.setText(shareHelper.sinhVienDangNhap.getDiaChi());
    }
    
    
    
    public boolean check() {

        if (txtMaSV.getText().equals("") || txtpassword.getText().equals("") || txtMaLop.getText().equals("")
                || txtHoTen.getText().equals("") || txtEmail.getText().equals("") || txtDiaChi.getText().equals("") || txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ dữ liệu sau đó ấn Save");

            return false;
        }else if (jDateChooser1.isValid()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày Sinh","Error",1);
            return false;
        }else if (buttonGroup1.isSelected(null)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Giới Tính");
            return false;
        }
        return true;
    }

    private void loadTen() {
        try {
           
            SachDao dao = new SachDao();
            List<Sach> list = dao.SearchTen(txtSearch.getText());
            tableModel2.setRowCount(0);
            for (Sach it : list) {
                tableModel2.addRow(new Object[]{
                    it.getMaSach(), it.getTenSach(), it.getMaTheLoai(), it.getTacGia(),
                    it.getSoLuong(), it.getNxb(),it.getNgayNhap(),it.getNdtt() ,it.getHinh() == null? "Không hình" :"Có Hình Ảnh Đại Diện", 
                });
            }
            tableModel2.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    private void initTable2() {
        tableModel3 = new DefaultTableModel();
        tableModel3.setColumnIdentifiers(new String[]{"Mã Phiếu Mượn", "Mã Sinh Viên", "Mã Sách", "Số Lượng", "Ngày Mượn", "Ngày Hẹn Trả"});
        tblPhieuMuon.setModel(tableModel3);
    }
    
    private void loadSachMuon() {
        try {
            PhieuMuonDAO dao = new PhieuMuonDAO();
            List<PhieuMuon> list = dao.findAllMuon(shareHelper.sinhVienDangNhap.getMaSV());
            tableModel3.setRowCount(0);
            for (PhieuMuon it : list) {
                tableModel3.addRow(new Object[]{
                    it.getMaPhieuMuon(), it.getMaSV(), it.getMaSach(), it.getSoLuong(),
                    it.getNgayMuon(), it.getNgayHenTra()
                });
            }
            tableModel3.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
    
    
    private void initTable3() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã" ,"Mã Sinh Viên","Mã Sách", "Mã Phiếu Mượn"});
        tblPhieuMuon2.setModel(tableModel);
    }
    
    
    private void loadPhieuMuonSinhVien() {
        try {
           
            PhieuMuonDAO dao = new PhieuMuonDAO();
            List<PhieuMuon> list = dao.findAllMuonSach(shareHelper.sinhVienDangNhap.getMaSV());
            tableModel.setRowCount(0);
            for (PhieuMuon it : list) {
                tableModel.addRow(new Object[]{
                     it.getMa(),it.getMaSV(), it.getMaSach(),it.getMaPhieuMuon(),
                   
                });
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }
    
//   private void loadDataSach() {
//        try {
//           
//            PhieuMuonDAO dao = new PhieuMuonDAO();
//            List<PhieuMuon> list = dao.SearchMaSVMaPhieuLoi(txtSearch1.getText());
//            tableModel3.setRowCount(0);
//            for (PhieuMuon it : list) {
//                tableModel3.addRow(new Object[]{
//                    it.getMaPhieuMuon(), it.getMaSV(), it.getMaSach(), it.getSoLuong(),
//                    it.getNgayMuon(), it.getNgayHenTra()
//                });
//            }
//            tableModel3.fireTableDataChanged();
//        } catch (Exception e) {
//            e.printStackTrace();
//            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
//        }
//    }
    
    public boolean check3() {

        if (txtMaSVPhieuMuon.getText().equals("") || txtMaSachPhieuMuon.getText().equals("")
                ) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ dữ liệu sau đó ấn Save");

            return false;
        }
        return true;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        main = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_students = new javax.swing.JLabel();
        btn_staff = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_phieuMuon = new javax.swing.JLabel();
        btn_DangXuat = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        students = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtHoTen = new javax.swing.JTextField();
        txtMaLop = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        phieumuon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMaSVPhieuMuon = new javax.swing.JTextField();
        txtMaSachPhieuMuon = new javax.swing.JTextField();
        txtSoluongPhieuMuon = new javax.swing.JTextField();
        btnlapPhieu = new javax.swing.JButton();
        btnQuetSach = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhieuMuon2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        staff = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudens = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuMuon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(1, 198, 83));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thư Viện Nhà Trường");

        lblTen.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTen.setText("KeepToo");

        jLabel3.setBackground(new java.awt.Color(0, 150, 62));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_students.setBackground(new java.awt.Color(0, 150, 62));
        btn_students.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_students.setForeground(new java.awt.Color(255, 255, 255));
        btn_students.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_students.setText("Thông Tin");
        btn_students.setOpaque(true);
        btn_students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_studentsMouseClicked(evt);
            }
        });

        btn_staff.setBackground(new java.awt.Color(1, 198, 83));
        btn_staff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_staff.setForeground(new java.awt.Color(255, 255, 255));
        btn_staff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_staff.setText("Sách");
        btn_staff.setOpaque(true);
        btn_staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_staffMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Chào:");

        btn_phieuMuon.setBackground(new java.awt.Color(1, 198, 83));
        btn_phieuMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_phieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        btn_phieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_phieuMuon.setText("Mượn Sách Online");
        btn_phieuMuon.setOpaque(true);
        btn_phieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_phieuMuonMouseClicked(evt);
            }
        });

        btn_DangXuat.setBackground(new java.awt.Color(1, 198, 83));
        btn_DangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_DangXuat.setText("Đăng Xuất");
        btn_DangXuat.setOpaque(true);
        btn_DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_DangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_DangXuatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_DangXuatMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addGroup(headerLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btn_students, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_phieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblTen)
                            .addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_students, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_phieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        home.setLayout(new java.awt.CardLayout());

        students.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Mã Sinh Viên:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PassWord:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mã Lớp:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Họ Tên:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ngày Sinh:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giới Tính:");

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");

        jDateChooser1.setBackground(new java.awt.Color(204, 204, 204));

        txtHoTen.setBackground(new java.awt.Color(204, 204, 204));
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setBorder(null);

        txtMaLop.setBackground(new java.awt.Color(204, 204, 204));
        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaLop.setBorder(null);

        txtpassword.setBackground(new java.awt.Color(102, 102, 102));
        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);

        txtMaSV.setBackground(new java.awt.Color(102, 102, 102));
        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaSV.setBorder(null);
        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Số Điện Thoại:");

        txtSDT.setBackground(new java.awt.Color(204, 204, 204));
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSDT.setBorder(null);

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Email:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Địa Chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Cập Nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentsLayout = new javax.swing.GroupLayout(students);
        students.setLayout(studentsLayout);
        studentsLayout.setHorizontalGroup(
            studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentsLayout.createSequentialGroup()
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentsLayout.createSequentialGroup()
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(studentsLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        studentsLayout.setVerticalGroup(
            studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(studentsLayout.createSequentialGroup()
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentsLayout.createSequentialGroup()
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(studentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        home.add(students, "card3");

        phieumuon.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Mã Sinh Viên:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Mã Sách:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Mã Phiếu Mượn:");

        txtMaSVPhieuMuon.setBackground(new java.awt.Color(102, 102, 102));
        txtMaSVPhieuMuon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSVPhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        txtMaSVPhieuMuon.setBorder(null);

        txtMaSachPhieuMuon.setBackground(new java.awt.Color(204, 204, 204));
        txtMaSachPhieuMuon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSachPhieuMuon.setBorder(null);

        txtSoluongPhieuMuon.setBackground(new java.awt.Color(204, 204, 204));
        txtSoluongPhieuMuon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoluongPhieuMuon.setBorder(null);

        btnlapPhieu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnlapPhieu.setText("Lập Phiếu");
        btnlapPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlapPhieuActionPerformed(evt);
            }
        });

        btnQuetSach.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnQuetSach.setText("Tạo Mới");
        btnQuetSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetSachActionPerformed(evt);
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
        jScrollPane4.setViewportView(tblPhieuMuon2);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Danh Sách Đang Chờ Duyêt:");

        javax.swing.GroupLayout phieumuonLayout = new javax.swing.GroupLayout(phieumuon);
        phieumuon.setLayout(phieumuonLayout);
        phieumuonLayout.setHorizontalGroup(
            phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phieumuonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(phieumuonLayout.createSequentialGroup()
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoluongPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtMaSachPhieuMuon)
                            .addComponent(txtMaSVPhieuMuon))
                        .addGap(125, 125, 125)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnlapPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQuetSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(phieumuonLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        phieumuonLayout.setVerticalGroup(
            phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phieumuonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSVPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phieumuonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtMaSachPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtSoluongPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(phieumuonLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnlapPhieu)
                            .addComponent(btnQuetSach))
                        .addGap(18, 18, 18)
                        .addGroup(phieumuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        home.add(phieumuon, "card4");

        staff.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPane2.setViewportView(tblStudens);

        jLabel2.setText("Tìm Kiếm:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sách Có Trong Thư Viện", jPanel1);

        tblPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPhieuMuon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sách Đã Mượn", jPanel2);

        javax.swing.GroupLayout staffLayout = new javax.swing.GroupLayout(staff);
        staff.setLayout(staffLayout);
        staffLayout.setHorizontalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        staffLayout.setVerticalGroup(
            staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        home.add(staff, "card3");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
       
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_headerMouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studentsMouseClicked
        // TODO add your handling code here:
        
        setLblColor(btn_students);
        resetLblColor(btn_staff);
        resetLblColor(btn_phieuMuon);
        //switch bettween Jpanels
         staff.setVisible(false);
         phieumuon.setVisible(false);
        students.setVisible(true);
      
    }//GEN-LAST:event_btn_studentsMouseClicked

    private void btn_staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_staffMouseClicked
        // TODO add your handling code here: 
        
        setLblColor(btn_staff);
        resetLblColor(btn_students);
        resetLblColor(btn_phieuMuon);
        staff.setVisible(true);
        phieumuon.setVisible(false);
        students.setVisible(false);
    }//GEN-LAST:event_btn_staffMouseClicked

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            Date date = jDateChooser1.getDate();
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

                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");

                }
            } catch (Exception ex) {
                                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_phieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieuMuonMouseClicked
        // TODO add your handling code here:
        setLblColor(btn_phieuMuon);
        resetLblColor(btn_students);
        resetLblColor(btn_staff);
        phieumuon.setVisible(true);
        staff.setVisible(false);
        students.setVisible(false);
    }//GEN-LAST:event_btn_phieuMuonMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadTen();
    }//GEN-LAST:event_txtSearchKeyReleased

    public void clear(){
        txtMaSachPhieuMuon.setText("");
        txtSoluongPhieuMuon.setText("");
        
    }
    
    private void btnlapPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlapPhieuActionPerformed
        //them
        if (check3() == true) {
            PhieuMuon sv = new PhieuMuon();
            sv.setMaSV(txtMaSVPhieuMuon.getText());
            sv.setMaSach(txtMaSachPhieuMuon.getText());
            sv.setMaPhieuMuon(txtSoluongPhieuMuon.getText());
            
            
            PhieuMuonDAO dao = new PhieuMuonDAO();

            try {
                if (dao.insertSinhVien(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Phiếu Mượn Đã Được Lưu", "Thông Báo");
                    
                    
                    
                    
                    loadPhieuMuonSinhVien();
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");
                    
                }
            } catch (Exception ex) {
                MessageDialogHelper.showMessageDialog(this, "Lỗi Khi Thêm", "Cảnh Báo");
                
            }

        }
    }//GEN-LAST:event_btnlapPhieuActionPerformed

    private void btnQuetSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetSachActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnQuetSachActionPerformed

    private void tblPhieuMuon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuon2MouseClicked
        // Click hien thị
        try {
            int row = tblPhieuMuon2.getSelectedRow();

            if (row >= 0) {
                String id = (String.valueOf(tblPhieuMuon2.getValueAt(row, 3))) ;
                PhieuMuonDAO dao = new PhieuMuonDAO();
                PhieuMuon sv = dao.findByma999999(id);
                if (sv != null) {    
                    txtSoluongPhieuMuon.setText(sv.getMaPhieuMuon());
                    txtMaSVPhieuMuon.setText(sv.getMaSV());
                    txtMaSachPhieuMuon.setText(sv.getMaSach());
                    
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(this, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblPhieuMuon2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        //xóa
        String strID = JOptionPane.showInputDialog(this, "Nhập Mã Xóa?");
        PhieuMuonDAO dao = new PhieuMuonDAO();
        if(dao.deletesinhvien(strID)){
            JOptionPane.showMessageDialog(this, "Xóa Thành Công ");
            clear();
            loadPhieuMuonSinhVien();
        }else{
            JOptionPane.showMessageDialog(this, "ID Không Tồn Tại ");
        }
    } catch (Exception ex) {
        Logger.getLogger(Home15.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //sua
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn cập nhật hay không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }

        if (check3() == true) {
            PhieuMuon sv = new PhieuMuon();
            
            
            sv.setMaSach(txtMaSachPhieuMuon.getText());
            sv.setMaSV(txtMaSVPhieuMuon.getText());
            sv.setMaPhieuMuon(txtSoluongPhieuMuon.getText());
            
            

            PhieuMuonDAO dao = new PhieuMuonDAO();

            try {

                if (dao.updateSinhVien(sv)) {
                    MessageDialogHelper.showMessageDialog(this, "Đã Được Cập Nhật", "Thông Báo");
                loadPhieuMuonSinhVien();
                clear();
                    
                } else {
                    MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                    
                }
            } catch (Exception ex) {
                //                MessageDialogHelper.showMessageDialog(this, "Có Lỗi Xảy Ra", "Cảnh Báo");
                ex.printStackTrace();
                MessageDialogHelper.showErrorDialog(this, ex.getMessage(), "Lỗi");
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangXuatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_DangXuatMouseClicked

    private void btn_DangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangXuatMouseEntered
        // TODO add your handling code here:
        setLblColor(btn_DangXuat);
    }//GEN-LAST:event_btn_DangXuatMouseEntered

    private void btn_DangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangXuatMouseExited
        // TODO add your handling code here:
        resetLblColor(btn_DangXuat);
    }//GEN-LAST:event_btn_DangXuatMouseExited

    private void btn_DangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangXuatMousePressed
        // TODO add your handling code here:
        if (MessageDialogHelper.showConFirmDialog(this, "Bạn có muốn đăng xuất không?", "Hỏi") != JOptionPane.YES_OPTION) {
            return;
        }
        dispose();
        DangNhapjDG dn = new DangNhapjDG(this, true);
        dn.setVisible(true);
    }//GEN-LAST:event_btn_DangXuatMousePressed
    
    // ------------switch between colors for Active/Inactive color
    public void setLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(0,150,62));
    }
    
      public void resetLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(1,198,83));
    }
      
           
      
      //-----------End --------
      
     //Let's create staff options and Avoid data
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //Change UI look of table.
        
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
            java.util.logging.Logger.getLogger(Home15.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home15.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home15.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home15.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home15().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuetSach;
    private javax.swing.JLabel btn_DangXuat;
    private javax.swing.JLabel btn_phieuMuon;
    private javax.swing.JLabel btn_staff;
    private javax.swing.JLabel btn_students;
    private javax.swing.JButton btnlapPhieu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel header;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel main;
    private javax.swing.JPanel phieumuon;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JPanel staff;
    private javax.swing.JPanel students;
    private javax.swing.JTable tblPhieuMuon;
    private javax.swing.JTable tblPhieuMuon2;
    private javax.swing.JTable tblStudens;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMaSVPhieuMuon;
    private javax.swing.JTextField txtMaSachPhieuMuon;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoluongPhieuMuon;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
