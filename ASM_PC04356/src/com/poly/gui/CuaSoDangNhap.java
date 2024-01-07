/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.gui;

import com.formdev.flatlaf.FlatLightLaf;
import com.poly.dao.taikhoanDAO;
import com.poly.model.taikhoan;
import com.poly.utils.XAuth;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tuong
 */
public class CuaSoDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form bai4
     */
    taikhoanDAO dao = new taikhoanDAO();

    public CuaSoDangNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    int i = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Xexit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelRound2 = new UI_libraries.PanelRound();
        lbl_dangnhap = new javax.swing.JLabel();
        txt_manv = new UI_libraries.TextField();
        txt_matkhau = new UI_libraries.PasswordField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_thongbao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(233, 199, 52));
        setUndecorated(true);
        setResizable(false);

        form.setBackground(new java.awt.Color(220, 204, 186));
        form.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        Xexit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Xexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/close_button.png"))); // NOI18N
        Xexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XexitMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(220, 204, 186));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/coffeedesign.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(126, 126, 126))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound2.setBackground(new java.awt.Color(134, 101, 101));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dangnhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dangnhap.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dangnhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dangnhap.setText("Đăng nhập");
        lbl_dangnhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dangnhapMouseClicked(evt);
            }
        });
        panelRound2.add(lbl_dangnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        txt_manv.setBackground(new java.awt.Color(220, 204, 186));
        txt_manv.setFocusCycleRoot(true);
        txt_manv.setFocusTraversalPolicyProvider(true);
        txt_manv.setLabelText("Mã NV");
        txt_manv.setLineColor(new java.awt.Color(0, 0, 0));
        txt_manv.setNextFocusableComponent(txt_matkhau);
        txt_manv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_manvKeyPressed(evt);
            }
        });

        txt_matkhau.setBackground(new java.awt.Color(220, 204, 186));
        txt_matkhau.setFocusCycleRoot(true);
        txt_matkhau.setLabelText("Mật khẩu");
        txt_matkhau.setLineColor(new java.awt.Color(0, 0, 0));
        txt_matkhau.setNextFocusableComponent(lbl_dangnhap);
        txt_matkhau.setShowAndHide(true);
        txt_matkhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_matkhauKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Xexit))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_manv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(formLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addComponent(Xexit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/coffee.gif"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(211, 158, 114));
        jPanel1.setForeground(new java.awt.Color(63, 60, 63));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WELCOME");

        jLabel7.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("...Drink A Cup Coffee...");

        label_thongbao.setBackground(new java.awt.Color(211, 158, 114));
        label_thongbao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label_thongbao.setForeground(new java.awt.Color(255, 255, 255));
        label_thongbao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_thongbao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_thongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMouseClicked
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Thoát", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_XexitMouseClicked

    private void lbl_dangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dangnhapMouseClicked
        if (kiemtra()) {
            dangnhap();
        }
    }//GEN-LAST:event_lbl_dangnhapMouseClicked

    private void txt_manvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_manvKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            txt_matkhau.requestFocus();
        }
    }//GEN-LAST:event_txt_manvKeyPressed

    private void txt_matkhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_matkhauKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
                    if (kiemtra()) {
            dangnhap();
        }
        }
    }//GEN-LAST:event_txt_matkhauKeyPressed

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
            java.util.logging.Logger.getLogger(CuaSoDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuaSoDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuaSoDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuaSoDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuaSoDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Xexit;
    private javax.swing.JPanel form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_thongbao;
    private javax.swing.JLabel lbl_dangnhap;
    private UI_libraries.PanelRound panelRound2;
    private UI_libraries.TextField txt_manv;
    private UI_libraries.PasswordField txt_matkhau;
    // End of variables declaration//GEN-END:variables

    public boolean kiemtra() {
        if (txt_manv.getText().equals("")) {
            txt_manv.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên!!");
            return false;
        }
        if (txt_matkhau.getText().equals("")) {
            txt_matkhau.requestFocus();
            JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu!!");
            return false;
        }
        return true;
    }

    public void dangnhap() {
        String manv = txt_manv.getText();
        String matkhau = txt_matkhau.getText();

        taikhoan tk = dao.select_byID(manv);
        
        if (tk == null) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại!!");
            return;
        } else if (tk.getMatkhau().equals(matkhau)&& tk.getTrangthai()==true) {
                Loading load = new Loading();
                load.setVisible(true);
                XAuth.user = tk;
                this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại thông tin đăng nhập!!");
        }
    }

}
