/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author tuong
 */
public class Loading extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Loading() {
        initComponents();
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        open();
    }
    javax.swing.Timer t;
    int thoigian = 5;
    int thoigian2 = thoigian;

    void open() {
        prog_load.setForeground(new java.awt.Color(178, 117, 83));//màu progressbar
        prog_load.setBackground(new java.awt.Color(224, 224, 224));

        //Đổi màu text khi progressbar chạy qua
        prog_load.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return Color.black;
            }

            protected Color getSelectionForeground() {
                return Color.white;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Xexit = new javax.swing.JLabel();
        prog_load = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Xexit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Xexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/close_button.png"))); // NOI18N
        Xexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XexitMouseClicked(evt);
            }
        });
        getContentPane().add(Xexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        prog_load.setStringPainted(true);
        getContentPane().add(prog_load, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 740, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/coffee-04.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doTask("Loading", 0);
                    doTask("Connect database", 5);
                    doTask("Loading", 10);
                    doTask("Loading.", 15);
                    doTask("Loading..", 20);
                    doTask("Check User", 25);
                    doTask("Check Role", 35);
                    doTask("Loading...", 45);
                    doTask("Loading....", 75);
                    doTask("Done", 100);
                    dispose();
                    CuaSoChinh csc = new CuaSoChinh();
                    csc.setVisible(true);
                } catch (Exception e) {
                }
            }
        }).start();

    }//GEN-LAST:event_formWindowOpened

    private void XexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMouseClicked
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát không?", "Thoát", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_XexitMouseClicked
    private void doTask(String taskName, int progress) throws Exception {
        prog_load.setString(taskName);
        prog_load.setValue(progress);
        Thread.sleep(100);
    }

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Xexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar prog_load;
    // End of variables declaration//GEN-END:variables
}
