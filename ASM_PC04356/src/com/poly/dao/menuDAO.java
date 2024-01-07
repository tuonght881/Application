/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.db.EntityDao;
import com.poly.db.JDBC;
import com.poly.model.menu;
import com.poly.model.taikhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuong
 */
public class menuDAO extends EntityDao<menu, String>{

    String insert = "insert into menu values (?,?,?,?,?)";
    String update = "update menu set tenmon = ?, gia = ?, trangthai = ?, hinhanh = ? where mamon = ?";
    String delete = "delete menu where mamon = ?";
    String selectAll = "select * from menu order by trangthai asc";
    String selectAlldangban = "select * from menu where trangthai = 1";
    String select_byID = "select * from menu where mamon = ?";
    String timmamon = "select mamon from menu where tenmon like ?";
    String timtenmon = "select tenmon from menu where mamon like ?";
    String timgia = "select gia from menu where mamon like ?";
    
    @Override
    public void insert(menu entity) {
        JDBC.update(insert, entity.getMamon(), entity.getTenmon(), entity.getGia(),entity.getTrangthai(),entity.getHinhanh());
    }

    @Override
    public void update(menu entity) {
        JDBC.update(update, entity.getTenmon(), entity.getGia(),entity.getTrangthai(),entity.getHinhanh(),entity.getMamon());
    }

    @Override
    public void delete(String entity) {
        JDBC.update(delete, entity);
    }

    @Override
    public List<menu> selectAll() {
        return select_by_sql(selectAll);
    }
    
    public List<menu> selectAlldangban() {
        return select_by_sql(selectAlldangban);
    }
    
    @Override
    public menu select_byID(String entity) {
        List<menu> list = this.select_by_sql(select_byID, entity);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<menu> select_by_sql(String sql, Object... args) {
        List<menu> list = new ArrayList<>();
        try {
            ResultSet r = JDBC.query(sql, args);
            while (r.next()) {
                menu mn = new menu();
                mn.setMamon(r.getString("mamon"));
                mn.setTenmon(r.getString("tenmon"));
                mn.setGia(r.getDouble("gia"));
                mn.setTrangthai(r.getBoolean("trangthai"));
                mn.setHinhanh(r.getString("hinhanh"));
                list.add(mn);
            }

            r.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String toMamon(String tenmon){
        ResultSet rs = JDBC.query(timmamon, "%"+tenmon+"%");
        List<String> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getString("mamon"));
            }
        return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String toTenmon(String mamon){
        ResultSet rs = JDBC.query(timtenmon, "%"+mamon+"%");
        List<String> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getString("tenmon"));
            }
        return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public Double toGia(String mamon){
        ResultSet rs = JDBC.query(timgia, "%"+mamon+"%");
        List<Double> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getDouble("gia"));
            }
        return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<menu> timtenmon(String tenmon){
        String sql= "select * from menu where tenmon like ?";
        return this.select_by_sql(sql, "%"+tenmon+"%");
    }
}
