/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.db.EntityDao;
import com.poly.db.JDBC;
import com.poly.model.hoadon;
import com.poly.model.hondonchitiet;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author tuong
 */
public class hoadonDAO extends EntityDao<hoadon, Integer> {

    String insert = "insert into hoadon values (?,?,?,?,?)";
    String mahoadon = "select top 1 * from hoadon order by mahoadon desc";
    String selectAll = "select * from hoadon";
    String khachdua = "select khachdua from hoadon where mahoadon = ?";
    String thoilai="select thoilai from hoadon where mahoadon = ?";
    
    @Override
    public void insert(hoadon entity) {
        JDBC.update(insert, entity.getManv(), entity.getNgaytao(), entity.getThanhtien(),
                entity.getKhachdua(), entity.getThoilai());
    }

    @Override
    public void update(hoadon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<hoadon> selectAll() {
        return select_by_sql(selectAll);
    }
    
    @Override
    public hoadon select_byID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<hoadon> select_by_sql(String sql, Object... args) {
        List<hoadon> list = new ArrayList<>();
        try {
            ResultSet r = JDBC.query(sql, args);
            while (r.next()) {
                hoadon hd = new hoadon();
                hd.setMahoadon(r.getInt("mahoadon"));
                hd.setManv(r.getString("manv"));
                hd.setNgaytao(r.getDate("ngaytao"));
                hd.setThanhtien(r.getDouble("thanhtien"));
                hd.setKhachdua(r.getDouble("khachdua"));
                hd.setThoilai(r.getDouble("thoilai"));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getmaHD() {
        ResultSet rs = JDBC.query(mahoadon);
        int mahoadon = 0;
        try {
            while (rs.next()) {
                mahoadon = rs.getInt("mahoadon");
            }
            rs.getStatement().getConnection().close();
            return mahoadon;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<hoadon> getHD_LOC(String ngaybatdau, String ngayketthuc){
        String sql = "select * from hoadon where ngaytao between ? and  ?";
        return select_by_sql(sql, ngaybatdau, ngayketthuc);
    }
    
    public Double toKhachdua(Integer mahoadon){
        ResultSet rs = JDBC.query(khachdua, mahoadon);
        List<Double> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getDouble("khachdua"));
            }
        return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Double toThoiLai(Integer mahoadon){
        ResultSet rs = JDBC.query(thoilai, mahoadon);
        List<Double> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getDouble("thoilai"));
            }
        return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
