/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.db.EntityDao;
import com.poly.db.JDBC;
import com.poly.model.hondonchitiet;
import com.poly.model.menu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuong
 */
public class hoadonchitietDAO extends EntityDao<hondonchitiet, Integer> {

    String insert = "insert into hoadonchitiet values (?,?,?)";
    String selectAll = "select * from hoadonchitiet";

    @Override
    public void insert(hondonchitiet entity) {
        JDBC.update(insert, entity.getMahoadon(), entity.getMamon(), entity.getSoluong());
    }

    @Override
    public void update(hondonchitiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<hondonchitiet> selectAll() {
        return select_by_sql(selectAll);
    }

    @Override
    public hondonchitiet select_byID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<hondonchitiet> select_by_sql(String sql, Object... args) {
        List<hondonchitiet> list = new ArrayList<>();
        try {
            ResultSet r = JDBC.query(sql, args);
            while (r.next()) {
                hondonchitiet hdct = new hondonchitiet();
                hdct.setMahoadonct(r.getInt("mahoadonct"));
                hdct.setMahoadon(r.getInt("mahoadon"));
                hdct.setMamon(r.getString("mamon"));
                hdct.setSoluong(r.getInt("soluong"));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<hondonchitiet> getHDCT(Integer mahoadon){
        String sql = "select * from hoadonchitiet where mahoadon = ?";
        return select_by_sql(sql, mahoadon);
    }
}
