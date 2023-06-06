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
import model.TaiKhoan;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class TaiKhoanDAO implements ICrud<String, TaiKhoan>{
    List<TaiKhoan> listItems;
    private DBContext db;
    private NhomTaiKhoanDAO nhomtkDao = new NhomTaiKhoanDAO();
    public TaiKhoanDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public TaiKhoanDAO(List<TaiKhoan> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public List<TaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<TaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    @Override
    public List<TaiKhoan> read() {
        List<TaiKhoan> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblTaiKhoan";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tentk = rs.getString("tentk");
                String matkhau = rs.getString("matkhau");
                boolean trangthai = rs.getBoolean("trangthai");
                String email = rs.getString("email");
                NhomTaiKhoan nhomtk = nhomtkDao.details(rs.getString("nhomtk"));
                listItem.add(new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public TaiKhoan details(String id) {
        try {
            String sql = "Select * from tblTaiKhoan where tentk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tentk = rs.getString("tentk");
                String matkhau = rs.getString("matkhau");
                boolean trangthai = rs.getBoolean("trangthai");
                String email = rs.getString("email");
                NhomTaiKhoan nhomtk = nhomtkDao.details(rs.getString("nhomtk"));
                return new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(TaiKhoan newItem) {
        try {
            String sql = "Insert into tblTaiKhoan(tentk, matkhau, trangthai, email, nhomtk) values (?,?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getTentk());
            stmt.setString(2, newItem.getMatkhau());
            stmt.setBoolean(3, newItem.isTrangthai());
            stmt.setString(4, newItem.getEmail());
            stmt.setString(5, newItem.getNhomtk().getNhomtk());            
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan edittedItem) {
        try {
            String sql = "Update tblTaiKhoan Set tentk = ?, matkhau = ?, trangthai = ?, email = ?, nhomtk = ? where tentk = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getTentk());
            stmt.setString(2, edittedItem.getMatkhau());
            stmt.setBoolean(3, edittedItem.isTrangthai());
            stmt.setString(4, edittedItem.getEmail());
            stmt.setString(5, edittedItem.getNhomtk().getNhomtk());
            stmt.setString(6, edittedItem.getTentk());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblTaiKhoan where tentk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        TaiKhoanDAO dmDao = new TaiKhoanDAO();
        dmDao.listItems = dmDao.read();
        for (TaiKhoan dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
}
