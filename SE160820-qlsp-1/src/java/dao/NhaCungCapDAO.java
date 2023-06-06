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
import model.NhaCungCap;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class NhaCungCapDAO implements ICrud<String, NhaCungCap>{
    List<NhaCungCap> listItems;
    private DBContext db;

    public NhaCungCapDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public NhaCungCapDAO(List<NhaCungCap> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<NhaCungCap> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhaCungCap> listItems) {
        this.listItems = listItems;
    }
    @Override
    public List<NhaCungCap> read() {
        List<NhaCungCap> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblNhaCungCap";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                boolean trangthai = rs.getBoolean("trangthai");
                listItem.add(new NhaCungCap(mancc, tenncc, diachi, trangthai));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public NhaCungCap details(String id) {
        try {
            String sql = "Select * from tblNhaCungCap where mancc=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                boolean trangthai = rs.getBoolean("trangthai");
                return new NhaCungCap(mancc, tenncc, diachi, trangthai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhaCungCap newItem) {
        try {
            String sql = "Insert into tblNhaCungCap(mancc, tenncc, diachi, trangthai) values (?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMancc());
            stmt.setString(2, newItem.getTenncc());
            stmt.setString(3, newItem.getDiachi());
            stmt.setBoolean(4, newItem.isTrangthai());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhaCungCap edittedItem) {
        try {
            String sql = "Update tblNhaCungCap Set tenncc = ?, diachi = ?, trangthai = ? where mancc = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getTenncc());
            stmt.setString(2, edittedItem.getDiachi());            
            stmt.setBoolean(3, edittedItem.isTrangthai());
            stmt.setString(4, edittedItem.getMancc());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblNhaCungCap where mancc=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String checkMancc(String mancc){
        String s = "";
        if (mancc.length() != 3) {
            return "Mã nhà cung cấp phải có 3 kí tự";
        }
        if (!("0123456789".contains(mancc.subSequence(0, 1)) && 
                "0123456789".contains(mancc.subSequence(1, 2))&&
                "0123456789".contains(mancc.subSequence(2, 3)))) {
            return "Tất cả kí tự phải là số";
        }
        return s;
    }
    public static void main(String[] args) {
        NhaCungCapDAO dmDao = new NhaCungCapDAO();
        dmDao.listItems = dmDao.read();
        for (NhaCungCap dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
}
