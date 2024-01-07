/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.model;

import java.util.Date;

/**
 *
 * @author tuong
 */
public class hoadon {
    Integer mahoadon;
    String manv;
    Date ngaytao;
    Double thanhtien;
    Double khachdua;
    Double thoilai;

    public hoadon( String manv, Date ngaytao, Double thanhtien, Double khachdua, Double thoilai) {
        this.manv = manv;
        this.ngaytao = ngaytao;
        this.thanhtien = thanhtien;
        this.khachdua = khachdua;
        this.thoilai = thoilai;
    }

    public hoadon() {
    }

    public Integer getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Integer mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Double getKhachdua() {
        return khachdua;
    }

    public void setKhachdua(Double khachdua) {
        this.khachdua = khachdua;
    }

    public Double getThoilai() {
        return thoilai;
    }

    public void setThoilai(Double thoilai) {
        this.thoilai = thoilai;
    }
    
    
}
