/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.TaiKhoan;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class HoaDonDAO implements ICrud<String, HoaDon>{
    List<HoaDon> listItems;
    private DBContext db;
    private TaiKhoanDAO tkDao = new TaiKhoanDAO();

    public HoaDonDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public HoaDonDAO(List<HoaDon> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public List<HoaDon> getListItems() {
        return listItems;
    }

    public void setListItems(List<HoaDon> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    @Override
    public List<HoaDon> read() {
        List<HoaDon> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblHoaDon";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("mahd");
                Date ngaydh = rs.getDate("ngaydh");
                int trangthaixuly = rs.getInt("trangthaixuly");
                TaiKhoan makh = tkDao.details(rs.getString("makh"));
                listItem.add(new HoaDon(mahd, ngaydh, trangthaixuly, makh));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public HoaDon details(String id) {
        try {
            String sql = "Select * from tblHoaDon where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("mahd");
                Date ngaydh = rs.getDate("ngaydh");
                int trangthaixuly = rs.getInt("trangthaixuly");
                TaiKhoan makh = tkDao.details(rs.getString("makh"));
                return new HoaDon(mahd, ngaydh, trangthaixuly, makh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(HoaDon newItem) {
        try {
            String sql = "Insert into tblHoaDon(mahd, ngaydh, trangthaixuly, makh) values (?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMahd());
            stmt.setDate(2, newItem.getNgaydh());
            stmt.setInt(3, newItem.getTrangthaixuli());
            stmt.setString(4, newItem.getMakh().getTentk());            
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void update(HoaDon edittedItem) {
        try {
            String sql = "Update tblHoaDon Set ngaydh = ?, trangthaixuly = ? ,makh = ? where mahd = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setDate(1, edittedItem.getNgaydh());
            stmt.setInt(2, edittedItem.getTrangthaixuli());
            stmt.setString(3, edittedItem.getMakh().getTentk());
            stmt.setString(4, edittedItem.getMahd());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblHoaDon where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String randomMahd(){
        String a = "QWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        char c = a.charAt(random.nextInt(a.length()));
        int d = random.nextInt(10);
        int e = random.nextInt(10);
        return ""+ c +d +e;
    }
    public static void main(String[] args) {
        HoaDonDAO dmDao = new HoaDonDAO();
        dmDao.listItems = dmDao.read();
        for (HoaDon dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
}
