/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhomTaiKhoan;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class NhomTaiKhoanDAO implements ICrud<String, NhomTaiKhoan>{
    List<NhomTaiKhoan> listItems;
    private DBContext db;

    public NhomTaiKhoanDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public NhomTaiKhoanDAO(List<NhomTaiKhoan> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public List<NhomTaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhomTaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    
    @Override
    public List<NhomTaiKhoan> read() {
        List<NhomTaiKhoan> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblNhomTaiKhoan";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nhomtk = rs.getString("nhomtk");
                String mota = rs.getString("mota");
                boolean trangthai = rs.getBoolean("trangthai");
                listItem.add(new NhomTaiKhoan(nhomtk, mota, trangthai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public NhomTaiKhoan details(String id) {
        try {
            String sql = "Select * from tblNhomTaiKhoan where nhomtk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nhomtk = rs.getString("nhomtk");
                String mota = rs.getString("mota");
                boolean trangthai = rs.getBoolean("trangthai");
                return new NhomTaiKhoan(nhomtk, mota, trangthai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhomTaiKhoan newItem) {
        try {
            String sql = "Insert into tblNhomTaiKhoan(nhomtk, mota, trangthai) values (?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getNhomtk());
            stmt.setString(2, newItem.getMota());
            stmt.setBoolean(3, newItem.isTrangthai());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhomTaiKhoan edittedItem) {
        try {
            String sql = "Update tblNhomTaiKhoan Set mota = ?, trangthai = ? where nhomtk = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getMota());
            stmt.setBoolean(2, edittedItem.isTrangthai());
            stmt.setString(3, edittedItem.getNhomtk());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblNhomTaiKhoan where nhomtk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        NhomTaiKhoanDAO dmDao = new NhomTaiKhoanDAO();
        dmDao.listItems = dmDao.read();
        for (NhomTaiKhoan dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
    
}
