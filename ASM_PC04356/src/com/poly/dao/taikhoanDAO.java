/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.db.EntityDao;
import com.poly.db.JDBC;
import com.poly.model.taikhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuong
 */
public class taikhoanDAO extends EntityDao<taikhoan, String> {

    String insert = "insert into taikhoan values (?,?,?,?,?,?,?,?,?,?,?)";
    String update = "update taikhoan set matkhau = ?, vaitro = ?, trangthai = ?, hoten = ?"
            + ",gioitinh = ?, sdt = ?, email = ?, ngaysinh = ?, diaChi = ?, anh = ? where manv = ?";
    String delete = "delete taikhoan where manv = ?";
    String selectAll = "select * from taikhoan order by trangthai asc";
    String selectAlldanglam = "select * from taikhoan where trangthai = 1";
    String select_byID = "select * from taikhoan where manv = ?";

    @Override
    public void insert(taikhoan entity) {
        JDBC.update(insert, entity.getManv(), entity.getMatkhau(), entity.getVaitro(), entity.getTrangthai(), entity.getHoten(),
                entity.getGioitinh(), entity.getSdt(), entity.getEmail(), entity.getNgaysinh(), entity.getDiachi(), entity.getAnh());
    }

    @Override
    public void update(taikhoan entity) {
        JDBC.update(update, entity.getMatkhau(), entity.getVaitro(), entity.getTrangthai(), entity.getHoten(),
                entity.getGioitinh(), entity.getSdt(), entity.getEmail(), entity.getNgaysinh(), entity.getDiachi(), entity.getAnh(), entity.getManv());
    }

    @Override
    public void delete(String entity) {
        JDBC.update(delete, entity);
    }

    @Override
    public List<taikhoan> selectAll() {
        return select_by_sql(selectAll);
    }

    public List<taikhoan> selectAlldanglam() {
        return select_by_sql(selectAlldanglam);
    }
    
    @Override
    public taikhoan select_byID(String entity) {
        List<taikhoan> list = this.select_by_sql(select_byID, entity);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<taikhoan> select_by_sql(String sql, Object... args) {
        List<taikhoan> list = new ArrayList<>();
        try {
            ResultSet r = JDBC.query(sql, args);
            while (r.next()) {
                taikhoan nv = new taikhoan();
                nv.setManv(r.getString("manv"));
                nv.setMatkhau(r.getString("matkhau"));
                nv.setVaitro(r.getBoolean("vaitro"));
                nv.setTrangthai(r.getBoolean("trangthai"));
                nv.setHoten(r.getString("hoten"));
                nv.setGioitinh(r.getBoolean("gioitinh"));
                nv.setSdt(r.getString("sdt"));
                nv.setEmail(r.getString("email"));
                nv.setNgaysinh(r.getDate("ngaysinh"));
                nv.setDiachi(r.getString("diachi"));
                nv.setAnh(r.getString("anh"));
                list.add(nv);
            }

            r.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
