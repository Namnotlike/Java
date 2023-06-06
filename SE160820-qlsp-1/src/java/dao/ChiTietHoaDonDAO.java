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
import model.ChiTietHoaDon;
import model.HoaDon;
import model.SanPham;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class ChiTietHoaDonDAO implements ICrud<String, ChiTietHoaDon>{
    List<ChiTietHoaDon> listItems;
    private DBContext db;
    private HoaDonDAO hdDao = new HoaDonDAO();
    private SanPhamDAO spDao = new SanPhamDAO();

    public ChiTietHoaDonDAO() {
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public ChiTietHoaDonDAO(List<ChiTietHoaDon> listItems) {
        this.listItems = listItems;
        this.db = new DBContext();
    }

    public List<ChiTietHoaDon> getListItems() {
        return listItems;
    }

    public void setListItems(List<ChiTietHoaDon> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    

    @Override
    public List<ChiTietHoaDon> read() {
        List<ChiTietHoaDon> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblChiTietHoaDon";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HoaDon mahd = hdDao.details(rs.getString("mahd"));
                SanPham masp = spDao.details(rs.getString("masp"));
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                float khuyenmai = rs.getFloat("khuyenmai");
                float giatri = rs.getFloat("giatri");
                
                listItem.add(new ChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }

    @Override
    public ChiTietHoaDon details(String id) {
        try {
            String sql = "Select * from tblChiTietHoaDon where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HoaDon mahd = hdDao.details(rs.getString("mahd"));
                SanPham masp = spDao.details(rs.getString("masp"));
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                float khuyenmai = rs.getFloat("khuyenmai");
                float giatri = rs.getFloat("giatri");
                return new ChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<ChiTietHoaDon> details1(String id) {
        List<ChiTietHoaDon> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblChiTietHoaDon where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HoaDon mahd = hdDao.details(rs.getString("mahd"));
                SanPham masp = spDao.details(rs.getString("masp"));
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                float khuyenmai = rs.getFloat("khuyenmai");
                float giatri = rs.getFloat("giatri");
                listItem.add(new ChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }
    
    public ChiTietHoaDon details(String idhd, String idsp) {
        try {
            String sql = "Select * from tblChiTietHoaDon where mahd=? and masp = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, idhd);
            stmt.setString(2, idsp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HoaDon mahd = hdDao.details(rs.getString("mahd"));
                SanPham masp = spDao.details(rs.getString("masp"));
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                float khuyenmai = rs.getFloat("khuyenmai");
                float giatri = rs.getFloat("giatri");
                return new ChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(ChiTietHoaDon newItem) {
        try {
            String sql = "Insert into tblChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri) values (?,?,?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMahd().getMahd());
            stmt.setString(2, newItem.getMasp().getMasp());
            stmt.setInt(3, newItem.getSoluong());
            stmt.setFloat(4, newItem.getDongia());
            stmt.setFloat(5, newItem.getKhuyenmai());
            stmt.setFloat(6, newItem.getGiaitri());            
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiTietHoaDon edittedItem) {
        try {
            String sql = "Update tblChiTietHoaDon Set mahd=?, masp=?, soluong=?, dongia=?, khuyenmai=?, giatri=? where mahd=? and masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getMahd().getMahd());
            String masp = edittedItem.getMasp().getMasp();
            stmt.setString(2, edittedItem.getMasp().getMasp());
            stmt.setInt(3, edittedItem.getSoluong());
            stmt.setFloat(4, edittedItem.getDongia());
            stmt.setFloat(5, edittedItem.getKhuyenmai());
            stmt.setFloat(6, edittedItem.getGiaitri());
            stmt.setString(7, edittedItem.getMahd().getMahd());
            stmt.setString(8, edittedItem.getMasp().getMasp());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update1(ChiTietHoaDon edittedItem) {
        try {
            String sql = "Update tblChiTietHoaDon Set mahd=? where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, edittedItem.getMahd().getMahd());
            stmt.setString(2, edittedItem.getMahd().getMahd());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblChiTietHoaDon where mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteByMasp(String id) {
        try {
            String sql = "Delete from tblChiTietHoaDon where masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String idhd, String idsp) {
        try {
            String sql = "Delete from tblChiTietHoaDon where mahd=? and masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, idhd);
            stmt.setString(2, idsp);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ChiTietHoaDonDAO dmDao = new ChiTietHoaDonDAO();
        dmDao.listItems = dmDao.read();
        for (ChiTietHoaDon dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
        System.out.println("\n\n\n\nDetail");
        System.out.println(dmDao.details("H11"));
    }
    
}
