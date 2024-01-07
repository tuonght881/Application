/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;

/**
 *
 * @author tuong
 */
public class hondonchitiet {
    Integer mahoadonct;
    Integer mahoadon;
    String mamon;
    Integer soluong;

    public hondonchitiet( Integer mahoadon, String mamon, Integer soluong) {
        this.mahoadon = mahoadon;
        this.mamon = mamon;
        this.soluong = soluong;
    }

    public hondonchitiet() {
    }

    public Integer getMahoadonct() {
        return mahoadonct;
    }

    public void setMahoadonct(Integer mahoadonct) {
        this.mahoadonct = mahoadonct;
    }

    public Integer getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Integer mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }
    
    
}
