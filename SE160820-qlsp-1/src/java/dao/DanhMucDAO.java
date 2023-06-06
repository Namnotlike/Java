/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import util.DBContext;

/**
 *
 * @author Admin
 */
public class DanhMucDAO implements ICrud<String,DanhMuc>{
    List<DanhMuc> listItems;
    private DBContext db;

    public DanhMucDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public DanhMucDAO(List<DanhMuc> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<DanhMuc> getListItems() {
        return listItems;
    }

    public void setListItems(List<DanhMuc> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<DanhMuc> read() {
        List<DanhMuc> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblDanhMuc";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String madm = rs.getString("madm");
                String tendm = rs.getString("tendm");
                boolean trangthai = rs.getBoolean("trangthai");
                listItem.add(new DanhMuc(madm, tendm, trangthai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public DanhMuc details(String id) {
        try {
            String sql = "Select * from tblDanhMuc where madm=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String madm = rs.getString("madm");
                String tendm = rs.getString("tendm");
                boolean trangthai = rs.getBoolean("trangthai");
                return new DanhMuc(madm, tendm, trangthai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(DanhMuc newItem) {
        try {
            String sql = "Insert into tblDanhMuc(madm, tendm, trangthai) values (?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMadm());
            stmt.setString(2, newItem.getTendm());
            stmt.setBoolean(3, newItem.isTrangthai());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DanhMuc edittedItem) {
        try {
            String sql = "Update tblDanhMuc Set tendm = ?, trangthai = ? where madm = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getTendm());
            stmt.setBoolean(2, edittedItem.isTrangthai());
            stmt.setString(3, edittedItem.getMadm());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblDanhMuc where madm=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String checkMadm(String madm){
        String s = "";
        if (madm.length() != 3) {
            return "Mã danh mục phải có 3 kí tự";
        }else if (!"QWERTYUIOPASDFGHJKLZXCVBNM".contains(madm.substring(0, 1))) {
            return "Kí tự đầu tiên phải là chữ viết hoa";
        }else if (!("1234567890".contains(madm.substring(1, 2)) && "1234567890".contains(madm.substring(2, 3)))) {
            return "Kí tự thứ 2 và 3 phải là số";
        }
        
        return s;
    }
    public static void main(String[] args) {
        DanhMucDAO dmDao = new DanhMucDAO();
        dmDao.listItems = dmDao.read();
        for (DanhMuc dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
}
