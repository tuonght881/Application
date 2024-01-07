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
public class taikhoan {
    String manv;
    String matkhau;
    Boolean vaitro;
    Boolean trangthai;
    String hoten;
    Boolean gioitinh;
    String sdt;
    String email;
    Date ngaysinh;
    String diachi;
    String anh;

    public taikhoan(String manv, String matkhau, Boolean vaitro, Boolean trangthai, String hoten, Boolean gioitinh, String sdt, String email, Date ngaysinh, String diachi, String anh) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
        this.trangthai = trangthai;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.email = email;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.anh = anh;
    }

    public taikhoan() {
    }
    
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getVaitro() {
        return vaitro;
    }

    public void setVaitro(Boolean vaitro) {
        this.vaitro = vaitro;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
