/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;

/**
 *
 * @author tuong
 */
public class menu {
    String mamon;
    String tenmon;
    Double gia;
    Boolean trangthai;
    String hinhanh;

    public menu(String mamon, String tenmon, Double gia, Boolean trangthai, String hinhanh) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.gia = gia;
        this.trangthai = trangthai;
        this.hinhanh = hinhanh;
    }

    public menu() {
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
    
    
}
