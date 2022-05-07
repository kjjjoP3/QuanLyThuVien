/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import dao.SinhVienDao;
import dao.adminDao;
import helpers.dialogHelper;
import helpers.shareHelper;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.SinhVien;
import model.admin;
import ui.MainThuThu;
import uiQuanLy.Home;
import uiSinhVien.Home15;
import uiSinhVien.SinhVienFR;

/**
 *
 * @author ACER NITRO 5
 */
public class DangNhapjDG extends javax.swing.JDialog {
    public static String us;
    public static String ps;
    admin ad ;
    adminDao addao = new adminDao();
    SinhVien sv = new SinhVien();
    SinhVienDao svdao = new SinhVienDao();
//    SinhVienDAO svdao = new SinhVienDAO();
    /**
     * Creates new form home
     */
    public DangNhapjDG(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setLocationRelativeTo(null);
        buttonGroup1.add(rdoAdmin);
        buttonGroup1.add(rdoSinhVien);
        buttonGroup1.add(rdoThuThu);
        
    }
    
    
    
     public boolean check() {
        if (txtUser.getText().equals("") || txtPass.getPassword().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ các thông tin","Error",1);
            return false;
        }else 
        return true;
    };
    
    
    public String getUser(){
    return  us;
    }
    public String getPass(){
    return  ps;
    }
    
    adminDao dao = new adminDao();
    SinhVienDao daosv = new SinhVienDao();
    public void DangNhap(){
         if(check()==true){
        String manv = txtUser.getText();
        String matKhau = new String(txtPass.getPassword());
                 try {
                     
            if(rdoAdmin.isSelected()==true){
                admin ad = dao.findById1(manv); 
            if(ad != null){    //nếu manv đúng
                String matKhau2 = ad.getPassword();
                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
                    shareHelper.adminDangNhap = ad;
                    dialogHelper.alert(this, "Đăng nhập thành công!");
                    Home ql = new Home();
                    ql.setVisible(true);
                    this.dispose();
                    
                }
                else{
                    dialogHelper.alert(this, "Sai mật khẩu!");
                }
            }
            else{
                dialogHelper.alert(this, "Sai tên đăng nhập!");
            }
        } else if(rdoThuThu.isSelected()==true){
            admin thuthu = dao.findByIdKhongCoAdmin(manv); 
            if(thuthu != null){    //nếu manv đúng
                String matKhau2 = thuthu.getPassword();
                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
                    shareHelper.adminDangNhap = thuthu;
                    dialogHelper.alert(this, "Đăng nhập thành công!");
                    MainThuThu ql = new MainThuThu();
                    ql.setVisible(true);
                    this.dispose();
                    
                }
                else{
                    dialogHelper.alert(this, "Sai mật khẩu!");
                }
            }
            else{
                dialogHelper.alert(this, "Sai tên đăng nhập!");
            }
        }
        else if(rdoSinhVien.isSelected()==true){
            SinhVien sv = daosv.findById(manv); 
            if(sv != null){    //nếu manv đúng
                String matKhau2 = sv.getPassword();
                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
                    shareHelper.sinhVienDangNhap = sv;
                    dialogHelper.alert(this, "Đăng nhập thành công!");
                    Home15 ql = new Home15();
                    ql.setVisible(true);
                    this.dispose();
                    
                }
                else{
                    dialogHelper.alert(this, "Sai mật khẩu!");
                }
            }
            else{
                dialogHelper.alert(this, "Sai tên đăng nhập!");
            }
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn vai trò của bạn");
        }
        }
        catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        } 

       
        }
    }
//    adminDao dao = new adminDao();
//    void login() {
//        String manv = txtUser.getText();
//        String matKhau = new String(txtPass.getPassword());
//        try {
//            admin nhanVien = dao.findById(manv); 
//            /*
//            manv là tên đăng nhập
//            nhanVien findbyId(String manv)
//            */
//            if(nhanVien != null){    //nếu manv đúng
//                String matKhau2 = nhanVien.getPassword();
//                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
//                    shareHelper.adminDangNhap = nhanVien;
//                    dialogHelper.alert(this, "Đăng nhập thành công!");
//                    this.dispose();
//                }
//                else{
//                    dialogHelper.alert(this, "Sai mật khẩu!");
//                }
//            }
//            else{
//                dialogHelper.alert(this, "Sai tên đăng nhập!");
//            }
//        }
//        catch (Exception e) {
//            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
//        }
//// }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        lblChuyenDangKi = new javax.swing.JLabel();
        chkMatkhau = new javax.swing.JCheckBox();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoSinhVien = new javax.swing.JRadioButton();
        rdoThuThu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setName(""); // NOI18N
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

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon 1_1.png"))); // NOI18N
        jLabel1.setText("Người Dùng Đăng Nhập");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon2_1.png"))); // NOI18N

        txtUser.setBackground(new java.awt.Color(102, 102, 102));
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setText("thanhbtt");
        txtUser.setBorder(null);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon333.png"))); // NOI18N

        txtPass.setBackground(new java.awt.Color(102, 102, 102));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setText("113");
        txtPass.setBorder(null);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("     Đăng Nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("         Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThoatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        lblChuyenDangKi.setBackground(new java.awt.Color(255, 255, 255));
        lblChuyenDangKi.setForeground(new java.awt.Color(255, 255, 255));
        lblChuyenDangKi.setText("Chưa Có Tài Khoản, Đăng Kí Tại Đây ?");
        lblChuyenDangKi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblChuyenDangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChuyenDangKiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChuyenDangKiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChuyenDangKiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChuyenDangKi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChuyenDangKi)
        );

        chkMatkhau.setBackground(new java.awt.Color(102, 102, 102));
        chkMatkhau.setForeground(new java.awt.Color(255, 255, 255));
        chkMatkhau.setText("Hiện Mật Khẩu");
        chkMatkhau.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        chkMatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMatkhauActionPerformed(evt);
            }
        });

        rdoAdmin.setBackground(new java.awt.Color(102, 102, 102));
        rdoAdmin.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rdoAdmin.setForeground(new java.awt.Color(255, 255, 255));
        rdoAdmin.setText("ADMIN");

        rdoSinhVien.setBackground(new java.awt.Color(102, 102, 102));
        rdoSinhVien.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rdoSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoSinhVien.setText("Người Đọc");

        rdoThuThu.setBackground(new java.awt.Color(102, 102, 102));
        rdoThuThu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rdoThuThu.setForeground(new java.awt.Color(255, 255, 255));
        rdoThuThu.setText("Thủ Thư");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdoAdmin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdoThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoSinhVien))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                                .addGap(12, 12, 12)
                                .addComponent(chkMatkhau)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(164, 164, 164))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(chkMatkhau))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(txtPass))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAdmin)
                    .addComponent(rdoSinhVien)
                    .addComponent(rdoThuThu))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        //txt dang nhap
        
        
    }//GEN-LAST:event_txtUserFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        // txt Mat Khau
        

    }//GEN-LAST:event_txtPassFocusGained

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        //Thoát
        System.exit(0);
    }//GEN-LAST:event_btnThoatMouseClicked

   // chuyen mau button   
    
    public void setColor(JPanel p){
            p.setBackground(new Color(204,204,204));
    }
    
    public void resetColor(JPanel p1){
            p1.setBackground(new Color(102,102,102));
    }
    // chuye mau chu
     public void setColor1(JPanel l){
            l.setBackground(new Color(204,204,204));
    }
     public void resetColor1(JPanel l1){
            l1.setBackground(new Color(102,102,102));
    }
    
    private void btnDangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseEntered
        // hover chuyen mau ddang nhap
        setColor(jPanel4);
        
    }//GEN-LAST:event_btnDangNhapMouseEntered

    private void btnDangNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseExited
        // hover tra ve dang nhap
        resetColor(jPanel4);
    }//GEN-LAST:event_btnDangNhapMouseExited

    private void btnThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseEntered
        // hover chuyen mau thoat
        setColor(jPanel3);
    }//GEN-LAST:event_btnThoatMouseEntered

    private void btnThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseExited
       // hover tra ve thoat
       resetColor(jPanel3);
    }//GEN-LAST:event_btnThoatMouseExited

    private void lblChuyenDangKiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuyenDangKiMouseEntered
        // hover chuyen mau dang ki
        setColor1(jPanel5);
    }//GEN-LAST:event_lblChuyenDangKiMouseEntered

    private void lblChuyenDangKiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuyenDangKiMouseExited
        // hover tra ve mau dang ki
        resetColor1(jPanel5);
    }//GEN-LAST:event_lblChuyenDangKiMouseExited

    private void btnDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseClicked
        // dang nhap
DangNhap();
    }//GEN-LAST:event_btnDangNhapMouseClicked

    private void lblChuyenDangKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChuyenDangKiMouseClicked
        // chuyen toi dang kí
//        JOptionPane.showMessageDialog(this, "Đang Cải Tiến Vui Lòng Đợi Bản Cập Nhập Tiếp Theo Và Nó Chỉ Dùng Cho Admin");
//            DangKiNeww dk = new DangKiNeww (new javax.swing.JFrame(), true);
//        dk.setVisible(true);
      
        
       
    }//GEN-LAST:event_lblChuyenDangKiMouseClicked

    private void chkMatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMatkhauActionPerformed
        // hien mat khau
        if (chkMatkhau.isSelected()) {
            txtPass.setEchoChar((char)0);
        }else{
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_chkMatkhauActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
         xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    int xx;
    int xy;
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
            java.util.logging.Logger.getLogger(DangNhapjDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapjDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapjDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapjDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapjDG dialog = new DangNhapjDG(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btnDangNhap;
    private javax.swing.JLabel btnThoat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkMatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblChuyenDangKi;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoSinhVien;
    private javax.swing.JRadioButton rdoThuThu;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
