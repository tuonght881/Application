/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.gui;

import UI_libraries.TableCustom;
import com.formdev.flatlaf.FlatLightLaf;
import com.poly.dao.hoadonDAO;
import com.poly.dao.hoadonchitietDAO;
import com.poly.dao.menuDAO;
import com.poly.dao.taikhoanDAO;
import com.poly.model.hoadon;
import com.poly.model.menu;
import com.poly.model.taikhoan;
import com.poly.model.hondonchitiet;
import com.poly.utils.XAuth;
import com.poly.utils.Ximg;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author r.kumbara
 */
public class CuaSoChinh extends javax.swing.JFrame {

    DecimalFormat format = new DecimalFormat("0.#");
    taikhoanDAO dao = new taikhoanDAO();
    menuDAO mnDAO = new menuDAO();
    hoadonDAO hdDAO = new hoadonDAO();
    hoadonchitietDAO hdctDAO = new hoadonchitietDAO();

    int index = -1;
    DefaultTableModel modelMENU_dn, model_dn;

    private DrawerController drawer;

    public CuaSoChinh() {
        initComponents();

        setAnhdaidien();
        loaddataNV();
        loaddataMENU();
        loaddataMENU_DATNUOC();
        loaddataHD();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane5, TableCustom.TableType.MULTI_LINE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        simpleTitleBar2.init(this);
        drawer = Drawer.newDrawer(this)
                .drawerBackground(new Color(134, 101, 101))
                .drawerWidth(280)
                .duration(350)
                .addChild(Sidemenu)
                .build();
    }

    int rongMenu = 0;
    int a = 0;

    void openMenu() {
        if (rongMenu == 0) {
            Sidemenu.setSize(rongMenu, 625);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= rongMenu; i++) {
                            Thread.sleep(1);
                            Sidemenu.setSize(i, 625);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            rongMenu = 210;
        }
    }

    void closeMenu() {
        if (rongMenu == 210) {
            Sidemenu.setSize(210, 625);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {

                        for (int i = 210; i >= 0; i--) {
                            Thread.sleep(1);
                            Sidemenu.setSize(i, 625);

                            a++;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            rongMenu = 0;
        }
    }

    void changeColorHover(JPanel panel) {
        panel.setBackground(new java.awt.Color(210, 158, 158));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(184, 136, 136));
    }

    void changeColorHover2(JPanel panel, JLabel label) {
        panel.setBackground(new java.awt.Color(172, 129, 129));
        label.setBackground(new java.awt.Color(172, 129, 129));
    }

    void resetColor2(JPanel panel, JLabel label) {
        panel.setBackground(new java.awt.Color(134, 101, 101));
        label.setBackground(new java.awt.Color(134, 101, 101));
    }

    //Check input DATNUOC
    boolean checkDATNUOC() {
        String loi = "";
        if (model_dn == null) {
            loi += "Chưa chọn món!\n";
        }
        if (txt_khachdua.getText().equalsIgnoreCase("")) {
            loi += "Chưa nhập khách đưa!\n";
        }
        if (txt_thoilai.getText().equalsIgnoreCase("")) {
            loi += "Chưa tính tiền thối!\n";
        }
        if (khachdua < tongcong) {
            loi += "Kiểm tra lại khách đưa!";
        }
        if (!loi.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, loi);
            return false;
        }
        return true;
    }
    //Check input DATNUOC

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_trangthaimenu = new javax.swing.ButtonGroup();
        buttonGroup_gioitinh = new javax.swing.ButtonGroup();
        btnG_gioitinhNV = new javax.swing.ButtonGroup();
        btnG_trangthaiNV = new javax.swing.ButtonGroup();
        btnG_vaitro = new javax.swing.ButtonGroup();
        dateChooser_batdau = new com.raven.datechooser.DateChooser();
        dateChooser_kethuc = new com.raven.datechooser.DateChooser();
        dateChooser = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        menusidebar = new javax.swing.JPanel();
        jbl_sidemenu = new javax.swing.JLabel();
        Sidemenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_anhdaidien = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panel_nhanvien = new UI_libraries.PanelRound();
        jbl_nv = new javax.swing.JLabel();
        panel_datnuoc = new UI_libraries.PanelRound();
        jbl_datnuoc = new javax.swing.JLabel();
        panel_menu = new UI_libraries.PanelRound();
        jbl_menu = new javax.swing.JLabel();
        panel_dangxuat = new UI_libraries.PanelRound();
        jbl_dangxuat = new javax.swing.JLabel();
        panel_hoadon = new UI_libraries.PanelRound();
        jbl_hoadon = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lbl_xinchao = new javax.swing.JLabel();
        lbl_vaitro = new javax.swing.JLabel();
        workspace = new javax.swing.JPanel();
        Tab = new javax.swing.JTabbedPane();
        DATNUOC = new javax.swing.JPanel();
        panelRound1 = new UI_libraries.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_tongcong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_khachdua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_thoilai = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        panel_thanhtoan = new UI_libraries.PanelRound();
        jbl_thanhtoan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_mnv = new javax.swing.JLabel();
        lbl_ngaydatnuoc = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_menu_datnc = new javax.swing.JTable();
        btn_removeALL = new javax.swing.JButton();
        btn_removeALLselect = new javax.swing.JButton();
        txt_timDATNUOC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        QLmenu = new javax.swing.JPanel();
        panelRound4 = new UI_libraries.PanelRound();
        lbl_hinhmenu = new javax.swing.JLabel();
        btn_themMN = new javax.swing.JButton();
        btn_capnhatMN = new javax.swing.JButton();
        btn_lammoiMN = new javax.swing.JButton();
        txt_mamon = new UI_libraries.TextField();
        txt_tenmon = new UI_libraries.TextField();
        txt_gia = new UI_libraries.TextField();
        jLabel13 = new javax.swing.JLabel();
        rdo_dangban = new javax.swing.JRadioButton();
        rdo_ngungban = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_menu = new javax.swing.JTable();
        txt_timmenu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_tatcaNV1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        QLNV = new javax.swing.JPanel();
        panelRound3 = new UI_libraries.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        rdo_danghi = new javax.swing.JRadioButton();
        rdo_danglam = new javax.swing.JRadioButton();
        lbl_hinhanh = new javax.swing.JLabel();
        btn_capnhat = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        rdo_quanly = new javax.swing.JRadioButton();
        rdo_nhanvien = new javax.swing.JRadioButton();
        txt_email = new UI_libraries.TextField();
        txt_diachi = new UI_libraries.TextField();
        txt_matkhau = new UI_libraries.PasswordField();
        txt_manv = new UI_libraries.TextField();
        txt_hoten = new UI_libraries.TextField();
        txt_sdt = new UI_libraries.TextField();
        btn_ngaysinh = new javax.swing.JButton();
        txt_ngaysinh = new UI_libraries.TextField();
        tableScrollButton1 = new UI_libraries.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        btn_tatcaNV = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        HOADON = new javax.swing.JPanel();
        panelRound5 = new UI_libraries.PanelRound();
        btn_ketthuc = new javax.swing.JButton();
        text_ketthuc = new UI_libraries.TextField();
        btn_batdau = new javax.swing.JButton();
        text_batdau = new UI_libraries.TextField();
        tab_hoadon = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_hdct = new javax.swing.JTable();
        lbl_mahoadon = new javax.swing.JLabel();
        btn_loc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        simpleTitleBar2 = new UI_libraries.SimpleTitleBar();

        dateChooser_batdau.setForeground(new java.awt.Color(0, 153, 255));
        dateChooser_batdau.setDateFormat("yyyy-MM-dd");
        dateChooser_batdau.setTextRefernce(text_batdau);

        dateChooser_kethuc.setForeground(new java.awt.Color(0, 153, 255));
        dateChooser_kethuc.setDateFormat("yyyy-MM-dd");
        dateChooser_kethuc.setTextRefernce(text_ketthuc);

        dateChooser.setForeground(new java.awt.Color(0, 153, 255));
        dateChooser.setDateFormat("yyyy-MM-dd");
        dateChooser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateChooser.setTextRefernce(txt_ngaysinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menusidebar.setBackground(new java.awt.Color(108, 80, 80));
        menusidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menusidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menusidebarMouseClicked(evt);
            }
        });

        jbl_sidemenu.setBackground(new java.awt.Color(108, 80, 80));
        jbl_sidemenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_sidemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/menu-white.png"))); // NOI18N
        jbl_sidemenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_sidemenu.setOpaque(true);
        jbl_sidemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_sidemenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menusidebarLayout = new javax.swing.GroupLayout(menusidebar);
        menusidebar.setLayout(menusidebarLayout);
        menusidebarLayout.setHorizontalGroup(
            menusidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidebarLayout.createSequentialGroup()
                .addComponent(jbl_sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menusidebarLayout.setVerticalGroup(
            menusidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbl_sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(585, Short.MAX_VALUE))
        );

        jPanel1.add(menusidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 625));

        Sidemenu.setBackground(new java.awt.Color(134, 101, 101));
        Sidemenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Sidemenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 260, 10));
        Sidemenu.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 260, 10));

        lbl_anhdaidien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhdaidien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/add-button (Custom).png"))); // NOI18N
        lbl_anhdaidien.setPreferredSize(new java.awt.Dimension(100, 100));
        Sidemenu.add(lbl_anhdaidien, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 100, 100));
        Sidemenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 260, 10));

        panel_nhanvien.setBackground(new java.awt.Color(184, 136, 136));
        panel_nhanvien.setRoundBottomLeft(20);
        panel_nhanvien.setRoundBottomRight(20);
        panel_nhanvien.setRoundTopLeft(20);
        panel_nhanvien.setRoundTopRight(20);
        panel_nhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_nv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_nv.setForeground(new java.awt.Color(255, 255, 255));
        jbl_nv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_nv.setText("Nhân viên");
        jbl_nv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_nvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_nvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_nvMouseExited(evt);
            }
        });
        panel_nhanvien.add(jbl_nv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        Sidemenu.add(panel_nhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 220, -1));

        panel_datnuoc.setBackground(new java.awt.Color(184, 136, 136));
        panel_datnuoc.setRoundBottomLeft(20);
        panel_datnuoc.setRoundBottomRight(20);
        panel_datnuoc.setRoundTopLeft(20);
        panel_datnuoc.setRoundTopRight(20);
        panel_datnuoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_datnuoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_datnuoc.setForeground(new java.awt.Color(255, 255, 255));
        jbl_datnuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_datnuoc.setText("Đặt nước");
        jbl_datnuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_datnuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_datnuocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_datnuocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_datnuocMouseExited(evt);
            }
        });
        panel_datnuoc.add(jbl_datnuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        Sidemenu.add(panel_datnuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 220, -1));

        panel_menu.setBackground(new java.awt.Color(184, 136, 136));
        panel_menu.setRoundBottomLeft(20);
        panel_menu.setRoundBottomRight(20);
        panel_menu.setRoundTopLeft(20);
        panel_menu.setRoundTopRight(20);
        panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_menu.setForeground(new java.awt.Color(255, 255, 255));
        jbl_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_menu.setText("Menu");
        jbl_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_menuMouseExited(evt);
            }
        });
        panel_menu.add(jbl_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        Sidemenu.add(panel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 220, -1));

        panel_dangxuat.setBackground(new java.awt.Color(184, 136, 136));
        panel_dangxuat.setRoundBottomLeft(20);
        panel_dangxuat.setRoundBottomRight(20);
        panel_dangxuat.setRoundTopLeft(20);
        panel_dangxuat.setRoundTopRight(20);
        panel_dangxuat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_dangxuat.setForeground(new java.awt.Color(255, 255, 255));
        jbl_dangxuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_dangxuat.setText("Đăng xuất");
        jbl_dangxuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseExited(evt);
            }
        });
        panel_dangxuat.add(jbl_dangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        Sidemenu.add(panel_dangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 220, -1));

        panel_hoadon.setBackground(new java.awt.Color(184, 136, 136));
        panel_hoadon.setRoundBottomLeft(20);
        panel_hoadon.setRoundBottomRight(20);
        panel_hoadon.setRoundTopLeft(20);
        panel_hoadon.setRoundTopRight(20);
        panel_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_hoadonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_hoadonMouseExited(evt);
            }
        });
        panel_hoadon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_hoadon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_hoadon.setForeground(new java.awt.Color(255, 255, 255));
        jbl_hoadon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_hoadon.setText("Hoá đơn");
        jbl_hoadon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_hoadonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_hoadonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_hoadonMouseExited(evt);
            }
        });
        panel_hoadon.add(jbl_hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        Sidemenu.add(panel_hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 220, -1));
        Sidemenu.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, 10));

        lbl_xinchao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_xinchao.setForeground(new java.awt.Color(255, 255, 255));
        lbl_xinchao.setText("Xin chào ");
        Sidemenu.add(lbl_xinchao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lbl_vaitro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaitro.setText("Vai trò");
        Sidemenu.add(lbl_vaitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, -1));

        jPanel1.add(Sidemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 280, 625));

        workspace.setBackground(new java.awt.Color(220, 204, 186));
        workspace.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tab.setBackground(new java.awt.Color(220, 204, 186));

        DATNUOC.setBackground(new java.awt.Color(220, 204, 186));
        DATNUOC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_dn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_dn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Đơn giá", "SL", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_dn);
        if (tbl_dn.getColumnModel().getColumnCount() > 0) {
            tbl_dn.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 378, 350));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Tổng cộng:");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, -1));

        txt_tongcong.setEditable(false);
        txt_tongcong.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_tongcong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panelRound1.add(txt_tongcong, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Khách đưa:");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, -1));

        txt_khachdua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_khachdua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_khachdua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_khachduaKeyPressed(evt);
            }
        });
        panelRound1.add(txt_khachdua, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Thối lại:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, -1));

        txt_thoilai.setEditable(false);
        txt_thoilai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_thoilai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panelRound1.add(txt_thoilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 110, -1));
        panelRound1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 378, 10));

        panel_thanhtoan.setBackground(new java.awt.Color(184, 136, 136));
        panel_thanhtoan.setRoundBottomLeft(20);
        panel_thanhtoan.setRoundBottomRight(20);
        panel_thanhtoan.setRoundTopLeft(20);
        panel_thanhtoan.setRoundTopRight(20);
        panel_thanhtoan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbl_thanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbl_thanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        jbl_thanhtoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_thanhtoan.setText("Thanh toán");
        jbl_thanhtoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_thanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_thanhtoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_thanhtoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_thanhtoanMouseExited(evt);
            }
        });
        panel_thanhtoan.add(jbl_thanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        panelRound1.add(panel_thanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 220, -1));

        jLabel4.setText("Nhân viên:");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        lbl_mnv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_mnv.setText("jLabel5");
        panelRound1.add(lbl_mnv, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 100, -1));

        lbl_ngaydatnuoc.setText("Ngày:");
        panelRound1.add(lbl_ngaydatnuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 130, -1));

        tbl_menu_datnc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_menu_datnc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_menu_datncMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_menu_datnc);

        panelRound1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 450, 490));

        btn_removeALL.setText("<<");
        btn_removeALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeALLActionPerformed(evt);
            }
        });
        panelRound1.add(btn_removeALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 343, 50, 40));

        btn_removeALLselect.setText("<");
        btn_removeALLselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeALLselectActionPerformed(evt);
            }
        });
        panelRound1.add(btn_removeALLselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 50, 40));

        txt_timDATNUOC.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timDATNUOCCaretUpdate(evt);
            }
        });
        panelRound1.add(txt_timDATNUOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, -1));

        jLabel5.setText("Tìm kiếm:");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jButton4.setText("ENTER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelRound1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 70, -1));

        DATNUOC.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 940, 600));

        Tab.addTab("tab2", DATNUOC);

        QLmenu.setBackground(new java.awt.Color(220, 204, 186));
        QLmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_hinhmenu.setText("hìnhảnh");
        lbl_hinhmenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_hinhmenu.setPreferredSize(new java.awt.Dimension(100, 100));
        lbl_hinhmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhmenuMouseClicked(evt);
            }
        });
        panelRound4.add(lbl_hinhmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        btn_themMN.setText("Thêm");
        btn_themMN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMNActionPerformed(evt);
            }
        });
        panelRound4.add(btn_themMN, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 80, 50));

        btn_capnhatMN.setText("Cập nhật");
        btn_capnhatMN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatMNActionPerformed(evt);
            }
        });
        panelRound4.add(btn_capnhatMN, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 440, 90, 50));

        btn_lammoiMN.setText("Làm mới");
        btn_lammoiMN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiMNActionPerformed(evt);
            }
        });
        panelRound4.add(btn_lammoiMN, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 90, 50));

        txt_mamon.setLabelText("Mã món");
        txt_mamon.setLineColor(new java.awt.Color(0, 0, 0));
        panelRound4.add(txt_mamon, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 170, 350, -1));

        txt_tenmon.setLabelText("Tên món");
        txt_tenmon.setLineColor(new java.awt.Color(0, 0, 0));
        panelRound4.add(txt_tenmon, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 348, -1));

        txt_gia.setLabelText("Giá");
        txt_gia.setLineColor(new java.awt.Color(0, 0, 0));
        panelRound4.add(txt_gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 348, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Trạng thái");
        panelRound4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        buttonGroup_trangthaimenu.add(rdo_dangban);
        rdo_dangban.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_dangban.setText("Đang bán");
        panelRound4.add(rdo_dangban, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, -1, -1));

        buttonGroup_trangthaimenu.add(rdo_ngungban);
        rdo_ngungban.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_ngungban.setText("Ngưng bán");
        panelRound4.add(rdo_ngungban, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, -1, -1));

        tbl_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "Tên món", "Đơn giá", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_menuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_menu);
        if (tbl_menu.getColumnModel().getColumnCount() > 0) {
            tbl_menu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_menu.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        panelRound4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 450, 430));

        txt_timmenu.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timmenuCaretUpdate(evt);
            }
        });
        panelRound4.add(txt_timmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 340, -1));

        jLabel6.setText("Tìm kiếm:");
        panelRound4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        btn_tatcaNV1.setText("Hiện tất cả");
        btn_tatcaNV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tatcaNV1ActionPerformed(evt);
            }
        });
        panelRound4.add(btn_tatcaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 90, -1));

        jButton3.setText("Đang bán");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, -1, -1));

        QLmenu.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 940, 600));

        Tab.addTab("tab3", QLmenu);

        QLNV.setBackground(new java.awt.Color(220, 204, 186));
        QLNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Giới tính:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 78, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Vai trò:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 83, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Trạng thái:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        btnG_gioitinhNV.add(rdo_nam);
        rdo_nam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_nam.setText("Nam");
        rdo_nam.setNextFocusableComponent(rdo_nu);
        jPanel4.add(rdo_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        btnG_gioitinhNV.add(rdo_nu);
        rdo_nu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_nu.setText("Nữ");
        rdo_nu.setNextFocusableComponent(rdo_danglam);
        jPanel4.add(rdo_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        btnG_trangthaiNV.add(rdo_danghi);
        rdo_danghi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_danghi.setText("Đã nghĩ");
        rdo_danghi.setNextFocusableComponent(txt_sdt);
        jPanel4.add(rdo_danghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        btnG_trangthaiNV.add(rdo_danglam);
        rdo_danglam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_danglam.setText("Đang làm");
        rdo_danglam.setNextFocusableComponent(rdo_danghi);
        jPanel4.add(rdo_danglam, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        lbl_hinhanh.setText("Hình ảnh");
        lbl_hinhanh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_hinhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhanhMouseClicked(evt);
            }
        });
        jPanel4.add(lbl_hinhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 100, 100));

        btn_capnhat.setText("Cập nhật");
        btn_capnhat.setPreferredSize(new java.awt.Dimension(80, 40));
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });
        jPanel4.add(btn_capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 100, -1));

        btn_them.setText("Thêm");
        btn_them.setPreferredSize(new java.awt.Dimension(72, 40));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel4.add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 100, 40));

        btn_lammoi.setText("Làm mới");
        btn_lammoi.setPreferredSize(new java.awt.Dimension(80, 40));
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        jPanel4.add(btn_lammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 100, -1));

        btnG_vaitro.add(rdo_quanly);
        rdo_quanly.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_quanly.setText("Quản lý");
        rdo_quanly.setNextFocusableComponent(rdo_nam);
        jPanel4.add(rdo_quanly, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        btnG_vaitro.add(rdo_nhanvien);
        rdo_nhanvien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdo_nhanvien.setText("Nhân viên");
        rdo_nhanvien.setNextFocusableComponent(rdo_quanly);
        jPanel4.add(rdo_nhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        txt_email.setLabelText("Email");
        txt_email.setLineColor(new java.awt.Color(0, 0, 0));
        txt_email.setNextFocusableComponent(txt_ngaysinh);
        jPanel4.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, -1));

        txt_diachi.setLabelText("Địa chỉ");
        txt_diachi.setLineColor(new java.awt.Color(0, 0, 0));
        txt_diachi.setNextFocusableComponent(txt_manv);
        jPanel4.add(txt_diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 300, -1));

        txt_matkhau.setText("passwordField1");
        txt_matkhau.setLabelText("Mật khẩu");
        txt_matkhau.setLineColor(new java.awt.Color(0, 0, 0));
        txt_matkhau.setNextFocusableComponent(txt_email);
        txt_matkhau.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_matkhau.setShowAndHide(true);
        jPanel4.add(txt_matkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, -1));

        txt_manv.setLabelText("Mã NV");
        txt_manv.setLineColor(new java.awt.Color(0, 0, 0));
        txt_manv.setNextFocusableComponent(txt_matkhau);
        txt_manv.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_manv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        txt_hoten.setLabelText("Họ tên");
        txt_hoten.setLineColor(new java.awt.Color(0, 0, 0));
        txt_hoten.setNextFocusableComponent(btn_batdau);
        txt_hoten.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 300, -1));

        txt_sdt.setLabelText("SDT");
        txt_sdt.setLineColor(new java.awt.Color(0, 0, 0));
        txt_sdt.setNextFocusableComponent(txt_diachi);
        txt_sdt.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 300, -1));

        btn_ngaysinh.setBackground(new java.awt.Color(242, 242, 242));
        btn_ngaysinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/calendar (Custom).png"))); // NOI18N
        btn_ngaysinh.setBorder(null);
        btn_ngaysinh.setOpaque(true);
        btn_ngaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ngaysinhActionPerformed(evt);
            }
        });
        jPanel4.add(btn_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 30, 30));

        txt_ngaysinh.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_ngaysinh.setLabelText("Ngày sinh");
        txt_ngaysinh.setLineColor(new java.awt.Color(0, 0, 0));
        txt_ngaysinh.setNextFocusableComponent(txt_hoten);
        jPanel4.add(txt_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 300, -1));

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNV", "Họ tên", "Giới tính", "SDT", "Email", "Ngày sinh", "Vai trò", "Trạng thái", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_nhanvien);
        if (tbl_nhanvien.getColumnModel().getColumnCount() > 0) {
            tbl_nhanvien.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_nhanvien.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbl_nhanvien.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_nhanvien.getColumnModel().getColumn(5).setPreferredWidth(50);
            tbl_nhanvien.getColumnModel().getColumn(6).setPreferredWidth(35);
            tbl_nhanvien.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        tableScrollButton1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btn_tatcaNV.setText("Hiện tất cả");
        btn_tatcaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tatcaNVActionPerformed(evt);
            }
        });

        jButton2.setText("Đang làm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tatcaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tatcaNV)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        QLNV.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 940, 600));

        Tab.addTab("tab1", QLNV);

        HOADON.setBackground(new java.awt.Color(220, 204, 186));
        HOADON.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(20);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(20);
        panelRound5.setRoundTopRight(20);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/calendar (Custom).png"))); // NOI18N
        btn_ketthuc.setBorder(null);
        btn_ketthuc.setOpaque(true);
        btn_ketthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ketthucActionPerformed(evt);
            }
        });
        panelRound5.add(btn_ketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 30, 30));

        text_ketthuc.setLabelText("Ngày kết thúc");
        text_ketthuc.setLineColor(new java.awt.Color(0, 0, 0));
        panelRound5.add(text_ketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 210, -1));

        btn_batdau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/calendar (Custom).png"))); // NOI18N
        btn_batdau.setBorder(null);
        btn_batdau.setOpaque(true);
        btn_batdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batdauActionPerformed(evt);
            }
        });
        panelRound5.add(btn_batdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 30, 30));

        text_batdau.setLabelText("Ngày bắt đầu");
        text_batdau.setLineColor(new java.awt.Color(0, 0, 0));
        panelRound5.add(text_batdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, -1));

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Mã nhân viên", "Ngày tạo", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoadon);

        tab_hoadon.addTab("Hoá đơn", jScrollPane3);

        tbl_hdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Giá", "Số lượng", "Khách đưa", "Thối lại", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tbl_hdct);

        tab_hoadon.addTab("HDCT", jScrollPane6);

        panelRound5.add(tab_hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 900, -1));

        lbl_mahoadon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_mahoadon.setText("Mã hoá đơn:");
        panelRound5.add(lbl_mahoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 240, 30));

        btn_loc.setText("Lọc");
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });
        panelRound5.add(btn_loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jButton1.setText("Hiện tất cả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelRound5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        HOADON.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 940, 600));

        Tab.addTab("tab4", HOADON);

        workspace.add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 960, 680));

        jPanel1.add(workspace, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 960, 625));

        simpleTitleBar2.setBackground(new java.awt.Color(255, 239, 215));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(simpleTitleBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(simpleTitleBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbl_sidemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_sidemenuMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jbl_sidemenuMouseClicked

    private void jbl_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_nvMouseClicked
        Tab.setSelectedIndex(2);
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jbl_nvMouseClicked

    private void jbl_datnuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_datnuocMouseClicked
        Tab.setSelectedIndex(0);
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jbl_datnuocMouseClicked

    private void jbl_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_menuMouseClicked
        Tab.setSelectedIndex(1);
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jbl_menuMouseClicked

    private void jbl_dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseClicked
        CuaSoDangNhap csdn = new CuaSoDangNhap();
        csdn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbl_dangxuatMouseClicked

    private void menusidebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusidebarMouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_menusidebarMouseClicked

    private void jbl_datnuocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_datnuocMouseEntered
        changeColorHover(panel_datnuoc);
    }//GEN-LAST:event_jbl_datnuocMouseEntered

    private void jbl_datnuocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_datnuocMouseExited
        resetColor(panel_datnuoc);
    }//GEN-LAST:event_jbl_datnuocMouseExited

    private void jbl_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_menuMouseExited
        resetColor(panel_menu);
    }//GEN-LAST:event_jbl_menuMouseExited

    private void jbl_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_menuMouseEntered
        changeColorHover(panel_menu);
    }//GEN-LAST:event_jbl_menuMouseEntered

    private void jbl_nvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_nvMouseEntered
        changeColorHover(panel_nhanvien);
    }//GEN-LAST:event_jbl_nvMouseEntered

    private void jbl_nvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_nvMouseExited
        resetColor(panel_nhanvien);
    }//GEN-LAST:event_jbl_nvMouseExited

    private void jbl_dangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseEntered
        changeColorHover(panel_dangxuat);
    }//GEN-LAST:event_jbl_dangxuatMouseEntered

    private void jbl_dangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseExited
        resetColor(panel_dangxuat);
    }//GEN-LAST:event_jbl_dangxuatMouseExited

    private void jbl_thanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_thanhtoanMouseClicked
        if (checkDATNUOC()) {
            hoadon();
        }
    }//GEN-LAST:event_jbl_thanhtoanMouseClicked

    private void jbl_thanhtoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_thanhtoanMouseEntered
        changeColorHover(panel_thanhtoan);
    }//GEN-LAST:event_jbl_thanhtoanMouseEntered

    private void jbl_thanhtoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_thanhtoanMouseExited
        resetColor(panel_thanhtoan);
    }//GEN-LAST:event_jbl_thanhtoanMouseExited

    private void jbl_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_hoadonMouseClicked
        Tab.setSelectedIndex(3);
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jbl_hoadonMouseClicked

    private void jbl_hoadonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_hoadonMouseEntered
        changeColorHover(panel_hoadon);
    }//GEN-LAST:event_jbl_hoadonMouseEntered

    private void jbl_hoadonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_hoadonMouseExited
        resetColor(panel_hoadon);
    }//GEN-LAST:event_jbl_hoadonMouseExited

    private void panel_hoadonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_hoadonMouseEntered

    }//GEN-LAST:event_panel_hoadonMouseEntered

    private void panel_hoadonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_hoadonMouseExited

    }//GEN-LAST:event_panel_hoadonMouseExited

    private void btn_ngaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ngaysinhActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_btn_ngaysinhActionPerformed

    private void btn_batdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batdauActionPerformed
        dateChooser_batdau.showPopup();
    }//GEN-LAST:event_btn_batdauActionPerformed

    private void btn_ketthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ketthucActionPerformed
        dateChooser_kethuc.showPopup();
    }//GEN-LAST:event_btn_ketthucActionPerformed

    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        if (evt.getClickCount() == 2) {
            index = tbl_nhanvien.getSelectedRow();
            editNV();
            btn_capnhat.setEnabled(true);
            btn_them.setEnabled(false);
        }
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addNV();
    }//GEN-LAST:event_btn_themActionPerformed

    private void lbl_hinhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hinhanhMouseClicked
        try {
            JFileChooser fc = new JFileChooser("image\\");

            //	    lọc file hình ảnh
            FileFilter filter = new FileNameExtensionFilter("Image Files", "png", "GIF", "jpg");
            fc.setFileFilter(filter);
            //	    Mở hộp thoại
            fc.showOpenDialog(null);
            File f = fc.getSelectedFile();
            Ximg.save_img(f);
            ImageIcon icon = Ximg.read_img(f.getName());
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            lbl_hinhanh.setIcon(new ImageIcon(imgScale));
            lbl_hinhanh.setToolTipText(f.getName());
        } catch (IllegalArgumentException e) {
            //            Msg_Box.alert(this, "Bạn chưa chọn hình ảnh");
        } catch (NullPointerException e) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_lbl_hinhanhMouseClicked

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        resetformNV();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        updateNV();
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void tbl_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_menuMouseClicked
        if (evt.getClickCount() == 2) {
            index = tbl_menu.getSelectedRow();
            editMN();
            btn_capnhatMN.setEnabled(true);
            btn_themMN.setEnabled(false);
        }
    }//GEN-LAST:event_tbl_menuMouseClicked

    private void btn_lammoiMNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiMNActionPerformed
        resetformMENU();
    }//GEN-LAST:event_btn_lammoiMNActionPerformed

    private void btn_themMNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMNActionPerformed
        addMN();
    }//GEN-LAST:event_btn_themMNActionPerformed

    private void btn_capnhatMNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatMNActionPerformed
        updateMN();
    }//GEN-LAST:event_btn_capnhatMNActionPerformed

    private void lbl_hinhmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hinhmenuMouseClicked
        try {
            JFileChooser fc = new JFileChooser("image\\");

            //	    lọc file hình ảnh
            FileFilter filter = new FileNameExtensionFilter("Image Files", "png", "GIF", "jpg");
            fc.setFileFilter(filter);
            //	    Mở hộp thoại
            fc.showOpenDialog(null);
            File f = fc.getSelectedFile();
            Ximg.save_img(f);
            ImageIcon icon = Ximg.read_img(f.getName());
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            lbl_hinhmenu.setText("");
            lbl_hinhmenu.setIcon(new ImageIcon(imgScale));
            lbl_hinhmenu.setToolTipText(f.getName());
        } catch (IllegalArgumentException e) {
            //            Msg_Box.alert(this, "Bạn chưa chọn hình ảnh");
        } catch (NullPointerException e) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_lbl_hinhmenuMouseClicked

    Double tongcong = 0.0;
    Double khachdua = 0.0;
    Double thoilai = 0.0;

    private void tbl_menu_datncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_menu_datncMouseClicked
        datnuocNEW(evt);
    }//GEN-LAST:event_tbl_menu_datncMouseClicked
    public void datnuocNEW(MouseEvent evt) throws NumberFormatException, HeadlessException {
        if (evt.getClickCount() == 2) {
            index = tbl_menu_datnc.getSelectedRow();
            String sl = JOptionPane.showInputDialog(this, "Nhập số lượng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            try {
                while (sl.equalsIgnoreCase("")) {
                    sl = JOptionPane.showInputDialog(this, "Nhập số lượng", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                }
            } catch (NullPointerException e) {
                return;
            }
            Object[] row = new Object[4];
            for (int i = 0; i < modelMENU_dn.getColumnCount(); i++) {
                row[i] = modelMENU_dn.getValueAt(index, i);
            }
            model_dn = (DefaultTableModel) tbl_dn.getModel();
            if (index != -1) {
                String selectFood = modelMENU_dn.getValueAt(index, 0).toString();
                if (tbl_dn.getRowCount() <= 0) {
                    row[2] = sl;
                    Double thanhtien = (Double.parseDouble(sl) * Double.parseDouble(row[1].toString()));
                    row[3] = format.format(thanhtien);
                    model_dn.addRow(row);
                    tinhtien();
                } else {
                    int hang = -1;
                    for (int i = 0; i < model_dn.getRowCount(); i++) {
                        if (selectFood.equalsIgnoreCase(tbl_dn.getValueAt(i, 0).toString())) {
                            hang = i;
                            break;
                        } else {
                            hang = -1;
                        }
                    }
                    if (hang == -1) {
                        row[2] = sl;
                        Double thanhtien = (Double.parseDouble(sl) * Double.parseDouble(row[1].toString()));
                        row[3] = format.format(thanhtien);
                        model_dn.addRow(row);
                        tinhtien();
                    } else {
                        int sl2 = Integer.parseInt(tbl_dn.getValueAt(hang, 2).toString()) + Integer.parseInt(sl);
                        tbl_dn.setValueAt(sl2, hang, 2);
                        Double thanhtien = (Double.parseDouble(sl) * Double.parseDouble(row[1].toString()));
                        Double thanhtien2 = Double.parseDouble(tbl_dn.getValueAt(hang, 3).toString()) + thanhtien;
                        tbl_dn.setValueAt(thanhtien2, hang, 3);
                        tinhtien();
                    }
                }
            }
        }
    }

    void tinhtien() {
        tongcong = 0.0;
        for (int i = 0; i < tbl_dn.getRowCount(); i++) {
            tongcong += Double.parseDouble(tbl_dn.getValueAt(i, 3).toString());
        }

        txt_tongcong.setText(format.format(tongcong));
    }

    private void txt_khachduaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_khachduaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txt_khachdua.getText().equalsIgnoreCase("")) {
            khachdua = Double.parseDouble(txt_khachdua.getText());
            if (khachdua >= tongcong) {
                thoilai = khachdua - tongcong;
                txt_thoilai.setText(format.format(thoilai));
            } else {
                JOptionPane.showMessageDialog(this, "Kiểm tra lại khách đưa!");
            }
        }
    }//GEN-LAST:event_txt_khachduaKeyPressed

    private void tbl_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonMouseClicked
        if (evt.getClickCount() == 2) {
            loadHDCT();
        }
    }//GEN-LAST:event_tbl_hoadonMouseClicked

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        loc();
    }//GEN-LAST:event_btn_locActionPerformed

    private void btn_removeALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeALLActionPerformed
        try {
            model_dn.setRowCount(0);
            tinhtien();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn món cần xoá!!");
        }
    }//GEN-LAST:event_btn_removeALLActionPerformed

    private void btn_removeALLselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeALLselectActionPerformed
        try {
            int dem = tbl_dn.getSelectedRow();
            model_dn.removeRow(dem);
            tinhtien();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn món cần xoá!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn món cần xoá!!");
        }
    }//GEN-LAST:event_btn_removeALLselectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loaddataHD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_timDATNUOCCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timDATNUOCCaretUpdate
        timdatnuoc();
    }//GEN-LAST:event_txt_timDATNUOCCaretUpdate

    private void txt_timmenuCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timmenuCaretUpdate
        timmenu();
    }//GEN-LAST:event_txt_timmenuCaretUpdate

    private void btn_tatcaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tatcaNVActionPerformed
        hientatcaNV();
    }//GEN-LAST:event_btn_tatcaNVActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        danglam();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_tatcaNV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tatcaNV1ActionPerformed
        hientatcaMN();
    }//GEN-LAST:event_btn_tatcaNV1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dangban();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (checkDATNUOC()) {
            khachdua = Double.parseDouble(txt_khachdua.getText());
            if (khachdua >= tongcong) {
                thoilai = khachdua - tongcong;
                txt_thoilai.setText(format.format(thoilai));
            } else {
                JOptionPane.showMessageDialog(this, "Khách đưa chưa đủ!");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuaSoChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DATNUOC;
    private javax.swing.JPanel HOADON;
    private javax.swing.JPanel QLNV;
    private javax.swing.JPanel QLmenu;
    private javax.swing.JPanel Sidemenu;
    private javax.swing.JTabbedPane Tab;
    private javax.swing.ButtonGroup btnG_gioitinhNV;
    private javax.swing.ButtonGroup btnG_trangthaiNV;
    private javax.swing.ButtonGroup btnG_vaitro;
    private javax.swing.JButton btn_batdau;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_capnhatMN;
    private javax.swing.JButton btn_ketthuc;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_lammoiMN;
    private javax.swing.JButton btn_loc;
    private javax.swing.JButton btn_ngaysinh;
    private javax.swing.JButton btn_removeALL;
    private javax.swing.JButton btn_removeALLselect;
    private javax.swing.JButton btn_tatcaNV;
    private javax.swing.JButton btn_tatcaNV1;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themMN;
    private javax.swing.ButtonGroup buttonGroup_gioitinh;
    private javax.swing.ButtonGroup buttonGroup_trangthaimenu;
    private com.raven.datechooser.DateChooser dateChooser;
    private com.raven.datechooser.DateChooser dateChooser_batdau;
    private com.raven.datechooser.DateChooser dateChooser_kethuc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jbl_dangxuat;
    private javax.swing.JLabel jbl_datnuoc;
    private javax.swing.JLabel jbl_hoadon;
    private javax.swing.JLabel jbl_menu;
    private javax.swing.JLabel jbl_nv;
    private javax.swing.JLabel jbl_sidemenu;
    private javax.swing.JLabel jbl_thanhtoan;
    private javax.swing.JLabel lbl_anhdaidien;
    private javax.swing.JLabel lbl_hinhanh;
    private javax.swing.JLabel lbl_hinhmenu;
    private javax.swing.JLabel lbl_mahoadon;
    private javax.swing.JLabel lbl_mnv;
    private javax.swing.JLabel lbl_ngaydatnuoc;
    private javax.swing.JLabel lbl_vaitro;
    private javax.swing.JLabel lbl_xinchao;
    private javax.swing.JPanel menusidebar;
    private UI_libraries.PanelRound panelRound1;
    private UI_libraries.PanelRound panelRound3;
    private UI_libraries.PanelRound panelRound4;
    private UI_libraries.PanelRound panelRound5;
    private UI_libraries.PanelRound panel_dangxuat;
    private UI_libraries.PanelRound panel_datnuoc;
    private UI_libraries.PanelRound panel_hoadon;
    private UI_libraries.PanelRound panel_menu;
    private UI_libraries.PanelRound panel_nhanvien;
    private UI_libraries.PanelRound panel_thanhtoan;
    private javax.swing.JRadioButton rdo_dangban;
    private javax.swing.JRadioButton rdo_danghi;
    private javax.swing.JRadioButton rdo_danglam;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_ngungban;
    private javax.swing.JRadioButton rdo_nhanvien;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JRadioButton rdo_quanly;
    private UI_libraries.SimpleTitleBar simpleTitleBar2;
    private javax.swing.JTabbedPane tab_hoadon;
    private UI_libraries.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tbl_dn;
    private javax.swing.JTable tbl_hdct;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTable tbl_menu;
    private javax.swing.JTable tbl_menu_datnc;
    private javax.swing.JTable tbl_nhanvien;
    private UI_libraries.TextField text_batdau;
    private UI_libraries.TextField text_ketthuc;
    private UI_libraries.TextField txt_diachi;
    private UI_libraries.TextField txt_email;
    private UI_libraries.TextField txt_gia;
    private UI_libraries.TextField txt_hoten;
    private javax.swing.JTextField txt_khachdua;
    private UI_libraries.TextField txt_mamon;
    private UI_libraries.TextField txt_manv;
    private UI_libraries.PasswordField txt_matkhau;
    private UI_libraries.TextField txt_ngaysinh;
    private UI_libraries.TextField txt_sdt;
    private UI_libraries.TextField txt_tenmon;
    private javax.swing.JTextField txt_thoilai;
    private javax.swing.JTextField txt_timDATNUOC;
    private javax.swing.JTextField txt_timmenu;
    private javax.swing.JTextField txt_tongcong;
    private javax.swing.JPanel workspace;
    // End of variables declaration//GEN-END:variables

    //FORM NHÂN VIÊN
    public void loaddataNV() {
        resetformNV();
        DefaultTableModel modelNV = (DefaultTableModel) tbl_nhanvien.getModel();
        modelNV.setRowCount(0);
        try {
            List<taikhoan> list = dao.selectAlldanglam();
            for (taikhoan tk : list) {
                Object[] row = {tk.getManv(), tk.getHoten(), tk.getGioitinh() ? "Nam" : "Nữ",
                    tk.getSdt(), tk.getEmail(), tk.getNgaysinh(), tk.getVaitro() ? "Quản lý" : "Nhân viên", tk.getTrangthai() ? "Đang làm" : "Đã nghĩ",
                    tk.getDiachi()};
                modelNV.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void setformNV(taikhoan tk) {
        txt_manv.setText(tk.getManv());
        txt_matkhau.setText(tk.getMatkhau());
        txt_email.setText(tk.getEmail());
        txt_ngaysinh.setText(tk.getNgaysinh().toString());
        txt_hoten.setText(tk.getHoten());
        if (tk.getVaitro() == true) {
            rdo_quanly.setSelected(true);
        } else {
            rdo_nhanvien.setSelected(true);
        }
        if (tk.getGioitinh() == true) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }
        if (tk.getTrangthai() == true) {
            rdo_danglam.setSelected(true);
        } else {
            rdo_danghi.setSelected(true);
        }
        txt_sdt.setText(tk.getSdt());
        txt_diachi.setText(tk.getDiachi());
        if (tk.getAnh() == null) {
            lbl_hinhanh.setIcon(null);
        } else {

            ImageIcon icon = Ximg.read_img(tk.getAnh());
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            lbl_hinhanh.setToolTipText(tk.getAnh());
            lbl_hinhanh.setIcon(new ImageIcon(imgScale));
        }
    }

    public taikhoan getformNV() throws ParseException {
        taikhoan tknew = new taikhoan();
        Date ngay = new SimpleDateFormat("yyyy-MM-dd").parse(txt_ngaysinh.getText());
        tknew.setManv(txt_manv.getText());
        tknew.setMatkhau(txt_matkhau.getText());
        tknew.setEmail(txt_email.getText());
        tknew.setNgaysinh(ngay);
        tknew.setHoten(txt_hoten.getText());
        tknew.setVaitro(rdo_quanly.isSelected());
        tknew.setGioitinh(rdo_nam.isSelected());
        tknew.setTrangthai(rdo_danglam.isSelected());
        tknew.setSdt(txt_sdt.getText());
        tknew.setDiachi(txt_diachi.getText());
        tknew.setAnh(lbl_hinhanh.getToolTipText());

        return tknew;
    }

    public void editNV() {
        txt_manv.setEditable(false);
        String manv = (String) tbl_nhanvien.getValueAt(index, 0);
        taikhoan tk = dao.select_byID(manv);
        setformNV(tk);
    }

    public void addNV() {
        if (batloif_NV()) {
            try {
                taikhoan tknew = getformNV();
                dao.insert(tknew);
                loaddataNV();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                e.printStackTrace();
            }
        }
    }

    public void updateNV() {
        if (batloif_NV()) {
            try {
                taikhoan tknew = getformNV();
                dao.update(tknew);
                loaddataNV();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }

    public void resetformNV() {
        txt_manv.setEditable(true);
        txt_manv.setText("");
        txt_matkhau.setText("");
        txt_email.setText("");
        txt_ngaysinh.setText("");
        txt_hoten.setText("");
        rdo_nhanvien.setSelected(true);
        rdo_nam.setSelected(true);
        rdo_danglam.setSelected(true);
        txt_sdt.setText("");
        txt_diachi.setText("");
        lbl_hinhanh.setIcon(null);

        btn_capnhat.setEnabled(false);
        btn_them.setEnabled(true);
    }

    public void setAnhdaidien() {
        try {
            if (XAuth.user.getAnh() == null) {
                lbl_anhdaidien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/pictures/user-white.png")));
            } else {
                ImageIcon icon = Ximg.read_img(XAuth.user.getAnh());
                Image img = icon.getImage();
                Image imgScale = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                lbl_anhdaidien.setToolTipText(XAuth.user.getAnh());
                lbl_anhdaidien.setIcon(new ImageIcon(imgScale));
            }
            //ẩn nút
            if (XAuth.user.getVaitro() == false) {
                panel_menu.setVisible(false);
                panel_nhanvien.setVisible(false);
                jSeparator3.setVisible(false);
                jSeparator5.setVisible(false);
            }

            lbl_xinchao.setText("Xin chào: " + XAuth.user.getHoten());
            lbl_vaitro.setText(XAuth.user.getVaitro() ? "Vai trò: Quản lý" : "Vai trò: Nhân viên");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void danglam() {
        loaddataNV();
    }

    public void hientatcaNV() {
        List<taikhoan> tk = dao.selectAll();

        DefaultTableModel modelNV = (DefaultTableModel) tbl_nhanvien.getModel();
        modelNV.setRowCount(0);
        try {
            for (taikhoan tk2 : tk) {
                Object[] row = {tk2.getManv(), tk2.getHoten(), tk2.getGioitinh() ? "Nam" : "Nữ",
                    tk2.getSdt(), tk2.getEmail(), tk2.getNgaysinh(), tk2.getVaitro() ? "Quản lý" : "Nhân viên", tk2.getTrangthai() ? "Đang làm" : "Đã nghĩ",
                    tk2.getDiachi()};
                modelNV.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public boolean batloif_NV() {
        String manv = txt_manv.getText();
        String email = txt_email.getText();
        String matkhau = txt_matkhau.getText();
        String hoten = txt_hoten.getText();
        String sdt = txt_sdt.getText();
        String ngaysinh = txt_ngaysinh.getText();
        String diachi = txt_diachi.getText();
        String gioitinh;
        String chucvu;
        String trangthai;
        if (rdo_nam.isSelected()) {
            gioitinh = "Nam";
        } else {
            gioitinh = "Nữ";
        }

        if (rdo_danglam.isSelected()) {
            trangthai = "Đang làm";
        } else {
            trangthai = "Đã nghĩ";
        }

        if (rdo_quanly.isSelected()) {
            chucvu = "Quản lý";
        } else {
            chucvu = "Nhân viên";
        }

        String loi = "";

        if (manv.equalsIgnoreCase("")) {
            loi += "Mã nhân viên\n";
        }
        if (manv.length() > 5) {
            loi += "Mã nhân viên tối đa 5 ký tự\n";
        }
        if (email.equalsIgnoreCase("")) {
            loi += "Email\n";
        } else {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
            Matcher regexMatcher = pattern.matcher(email);
            if (!regexMatcher.matches()) {
                loi += "Sai định dạng Email\n";
            }
        }
        if (matkhau.equalsIgnoreCase("")) {
            loi += "Mật khẩu\n";
        }
        if (matkhau.length() > 30) {
            loi += "Mật khẩu tối đa 30 ký tự\n";
        }
        if (hoten.equalsIgnoreCase("")) {
            loi += "Họ tên\n";
        }
        if (sdt.equalsIgnoreCase("")) {
            loi += "SDT\n";
        } else {
            Pattern pattern = Pattern.compile("^0[1-9]{9}+$");
            Matcher regexMatcher = pattern.matcher(sdt);
            if (!regexMatcher.matches()) {
                loi += "Không đúng định dang SDT, SDT không nhập chữ, SDT có 10 số\n";
            }
        }
        if (ngaysinh.equalsIgnoreCase("")) {
            loi += "Ngày sinh\n";
        }
        if (diachi.equalsIgnoreCase("")) {
            loi += "Địa chỉ\n";
        }
        if (!loi.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "--Kiểm tra lại thông tin!!--\n" + loi);
            return false;
        } else {
            String thongtin = ("Mã nhân viên:" + manv + "\nHọ tên: " + hoten + "\nGiới tính: " + gioitinh + "\nSĐT: " + sdt + "\nNgày sinh: " + ngaysinh + "\nVai trò: " + chucvu + "\nTrạng thái: " + trangthai + "\nĐịa chỉ: " + diachi);
            JOptionPane.showMessageDialog(this, thongtin);
            return true;
        }
    }
    //FORM NHÂN VIÊN

    //FORM MENU
    public void loaddataMENU() {
        resetformMENU();
        DefaultTableModel modelMENU = (DefaultTableModel) tbl_menu.getModel();
        modelMENU.setRowCount(0);
        try {
            List<menu> list = mnDAO.selectAlldangban();
            for (menu mn : list) {
                Object[] row = {mn.getMamon(), mn.getTenmon(), format.format(mn.getGia()), mn.getTrangthai() ? "Đang bán" : "Ngưng bán"};
                modelMENU.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void dangban() {
        loaddataMENU();
    }

    public void hientatcaMN() {
        List<menu> mn = mnDAO.selectAll();

        DefaultTableModel modelMN = (DefaultTableModel) tbl_menu.getModel();
        modelMN.setRowCount(0);

        try {
            for (menu mn2 : mn) {
                Object[] row = {mn2.getMamon(), mn2.getTenmon(), format.format(mn2.getGia()), mn2.getTrangthai() ? "Đang bán" : "Ngưng bán"};
                modelMN.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void resetformMENU() {
        txt_mamon.setEditable(true);
        txt_mamon.setText("");
        txt_tenmon.setText("");
        txt_gia.setText("");
        rdo_dangban.setSelected(true);
        lbl_hinhmenu.setToolTipText("");
        lbl_hinhmenu.setIcon(null);
        lbl_hinhmenu.setText("Hình ảnh");

        btn_capnhatMN.setEnabled(false);
        btn_themMN.setEnabled(true);
    }

    public void editMN() {
        txt_mamon.setEditable(false);
        String mamon = (String) tbl_menu.getValueAt(index, 0);
        menu mn = mnDAO.select_byID(mamon);
        setformMN(mn);
    }

    public void setformMN(menu mn) {
        txt_mamon.setText(mn.getMamon());
        txt_tenmon.setText(mn.getTenmon());

        txt_gia.setText(format.format(mn.getGia()));
        if (mn.getTrangthai() == true) {
            rdo_dangban.setSelected(true);
        } else {
            rdo_ngungban.setSelected(true);
        }

        if (mn.getHinhanh() == null) {
            lbl_hinhmenu.setIcon(null);
        } else {
            ImageIcon icon = Ximg.read_img(mn.getHinhanh());
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            lbl_hinhmenu.setToolTipText(mn.getHinhanh());
            lbl_hinhmenu.setIcon(new ImageIcon(imgScale));
            lbl_hinhmenu.setText("");
        }
    }

    public menu getformMN() throws ParseException {
        menu mnnew = new menu();

        mnnew.setMamon(txt_mamon.getText());
        mnnew.setTenmon(txt_tenmon.getText());
        mnnew.setGia(Double.valueOf(txt_gia.getText()));
        mnnew.setTrangthai(rdo_dangban.isSelected());
        mnnew.setHinhanh(lbl_hinhmenu.getToolTipText());

        return mnnew;
    }

    public void addMN() {
        if (batloif_MENU()) {
            String mamon = txt_mamon.getText();
            for (int i = 0; i < tbl_menu.getRowCount(); i++) {
                if (mamon.equalsIgnoreCase(tbl_menu.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "Mã món bị trùng!");
                    return;
                }
            }

            try {
                menu mnnew = getformMN();
                mnDAO.insert(mnnew);
                loaddataMENU();
                loaddataMENU_DATNUOC();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                e.printStackTrace();
            }
        }
    }

    public void updateMN() {
        if (batloif_MENU()) {
            try {
                menu mnnew = getformMN();
                mnDAO.update(mnnew);
                loaddataMENU();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }

    public boolean batloif_MENU() {
        String mamon = txt_mamon.getText();
        String tenmon = txt_tenmon.getText();
        String gia = txt_gia.getText();

        String loi = "";

        if (mamon.equalsIgnoreCase("")) {
            loi += "Mã món\n";
        }
        if (mamon.length() > 5) {
            loi += "Mã món tối đa 5 ký tự\n";
        }
        if (tenmon.equalsIgnoreCase("")) {
            loi += "Tên món\n";
        }
        if (mamon.length() > 30) {
            loi += "Tên món tối đa 30 ký tự\n";
        }
        if (gia.equalsIgnoreCase("")) {
            loi += "Giá\n";
        } else {
            Pattern pattern = Pattern.compile("^[0-9]+$");
            Matcher regexMatcher = pattern.matcher(gia);
            if (!regexMatcher.matches()) {
                loi += "Giá phải nhập số";
            } else {
                if (Integer.parseInt(gia) == 0) {
                    loi += "Giá = 0 ??";
                }
            }
        }
        if (!loi.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "--Kiểm tra lại thông tin!!--\n" + loi);
            return false;
        }
        return true;
    }

    public void timmenu() {
        String tenmon = txt_timmenu.getText();

        List<menu> mn = mnDAO.timtenmon(tenmon);
        DefaultTableModel modelMENU = (DefaultTableModel) tbl_menu.getModel();
        modelMENU.setRowCount(0);
        try {
            for (menu mn2 : mn) {
                Object[] row = {mn2.getMamon(), mn2.getTenmon(), mn2.getGia(), mn2.getTrangthai()};
                modelMENU.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //FORM MENU

    //FORM DATNUOC
    public void loaddataMENU_DATNUOC() {
//        resetformMENU();  
        modelMENU_dn = (DefaultTableModel) tbl_menu_datnc.getModel();
        modelMENU_dn.setRowCount(0);
        try {
            lbl_mnv.setText(XAuth.user.getHoten());

            Date ngay = new Date();
            SimpleDateFormat formatN = new SimpleDateFormat("yyyy-mm-dd");
            lbl_ngaydatnuoc.setText("Ngày: " + formatN.format(ngay));

            List<menu> list = mnDAO.selectAlldangban();
            for (menu mn : list) {
                Object[] row = {mn.getTenmon(), format.format(mn.getGia())};
                modelMENU_dn.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void hoadon() {
        hoadon hd = new hoadon(XAuth.user.getManv(), new Date(), tongcong, khachdua, thoilai);
        hdDAO.insert(hd);

        for (int i = 0; i < tbl_dn.getRowCount(); i++) {
            hondonchitiet hdct = new hondonchitiet();
            hdct.setMahoadon(hdDAO.getmaHD());
            String mamon = mnDAO.toMamon(tbl_dn.getValueAt(i, 0).toString());
            hdct.setMamon(mamon);
            hdct.setSoluong(Integer.parseInt(tbl_dn.getValueAt(i, 2).toString()));
            hdctDAO.insert(hdct);
        }
        loaddataHD();
        JOptionPane.showMessageDialog(this, "Thành công!");
        model_dn.setRowCount(0);
        txt_tongcong.setText("");
        txt_khachdua.setText("");
        txt_thoilai.setText("");
    }

    public void timdatnuoc() {
        String tenmon = txt_timDATNUOC.getText();

        List<menu> mn = mnDAO.timtenmon(tenmon);
        modelMENU_dn = (DefaultTableModel) tbl_menu_datnc.getModel();
        modelMENU_dn.setRowCount(0);
        try {
            for (menu mn2 : mn) {
                Object[] row = {mn2.getTenmon(), mn2.getGia()};
                modelMENU_dn.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //FORM DATNUOC 

    //FORM HOADON
    public void loaddataHD() {
        DefaultTableModel modelHD = (DefaultTableModel) tbl_hoadon.getModel();
        modelHD.setRowCount(0);
        try {
            List<hoadon> list = hdDAO.selectAll();
            for (hoadon hd : list) {
                Object[] row = {hd.getMahoadon(), hd.getManv(), hd.getNgaytao(), format.format(hd.getThanhtien())};
                modelHD.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadHDCT() {
        int index = tbl_hoadon.getSelectedRow();
        tab_hoadon.setSelectedIndex(1);
        int mahoadon = (Integer) (tbl_hoadon.getValueAt(index, 0));

        DefaultTableModel modelHDCT = (DefaultTableModel) tbl_hdct.getModel();
        modelHDCT.setRowCount(0);

        List<hondonchitiet> hdct = hdctDAO.getHDCT(mahoadon);

        lbl_mahoadon.setText("Mã hoá đơn: " + mahoadon);
        for (hondonchitiet hdct2 : hdct) {
            String tenmon = mnDAO.toTenmon(hdct2.getMamon());
            Double gia = mnDAO.toGia(hdct2.getMamon());
            Double khachdua = hdDAO.toKhachdua(mahoadon);
            Double thoilai = hdDAO.toThoiLai(mahoadon);
            Double thanhtien = gia * (hdct2.getSoluong());
            
            Object[] row = {tenmon, gia, hdct2.getSoluong(),format.format(khachdua),format.format(thoilai), format.format(thanhtien)};
            modelHDCT.addRow(row);
        }
    }

    public void loc() {
        String ngaybatdau = text_batdau.getText();
        String ngayketthuc = text_ketthuc.getText();

        List<hoadon> hd = hdDAO.getHD_LOC(ngaybatdau, ngayketthuc);

        DefaultTableModel modelHD = (DefaultTableModel) tbl_hoadon.getModel();
        modelHD.setRowCount(0);

        for (hoadon hd2 : hd) {
            Object[] row = {hd2.getMahoadon(), hd2.getManv(), hd2.getNgaytao(), hd2.getThanhtien()};
            modelHD.addRow(row);
        }
    }
    //FORM HOADON
}
