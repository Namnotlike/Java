/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;
import model.NhaCungCap;
import model.SanPham;
import util.DBContext;

/**
 *
 * @author TTC
 */
public class SanPhamDAO implements ICrud<String, SanPham>{
    private boolean errorDelete = false;
    List<SanPham> listItems;
    private DBContext db;
    NhaCungCapDAO nccDao = new NhaCungCapDAO();
    DanhMucDAO dmDao = new DanhMucDAO();

    public SanPhamDAO() {
        errorDelete = false;
        listItems = new ArrayList<>();
        this.db = new DBContext();
    }

    public SanPhamDAO(List<SanPham> listItems) {
        errorDelete = false;
        this.listItems = listItems;
        this.db = new DBContext();
    }
    
    @Override
    public List<SanPham> read() {
        List<SanPham> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblSanPham";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");
                DanhMuc madm = dmDao.details(rs.getString("madm"));
                NhaCungCap mancc = nccDao.details(rs.getString("mancc"));
                listItem.add(new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }
    public List<SanPham> search(String search) {
        List<SanPham> listItem = new ArrayList<>();
        try {
            String sql = "Select * from tblSanPham where tensp like '%" + search +"%'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
//            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");
                DanhMuc madm = dmDao.details(rs.getString("madm"));
                NhaCungCap mancc = nccDao.details(rs.getString("mancc"));
                listItem.add(new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItem;
    }
    @Override
    public SanPham details(String id) {
        try {
            String sql = "Select * from tblSanPham where masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String mota = rs.getString("mota");
                int soluong = rs.getInt("soluong");
                float dongia = rs.getFloat("dongia");
                String hinhanh = rs.getString("hinhanh");
                boolean trangthai = rs.getBoolean("trangthai");
                DanhMuc madm = dmDao.details(rs.getString("madm"));
                NhaCungCap mancc = nccDao.details(rs.getString("mancc"));
                return new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(SanPham newItem) {
        try {
            String sql = "Insert into tblSanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMasp());
            stmt.setString(2, newItem.getTensp());
            stmt.setString(3, newItem.getMota());
            stmt.setInt(4, newItem.getSoluong());
            stmt.setFloat(5, newItem.getDongia());
            stmt.setString(6, newItem.getHinhanh());
            stmt.setBoolean(7, newItem.isTrangthai());
            stmt.setString(8, newItem.getDanhmuc().getMadm());
            stmt.setString(9, newItem.getNhacungcap().getMancc());
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham edittedItem) {
        try {
            String sql = "Update tblSanPham Set tensp = ?, mota = ?, soluong = ?, dongia = ?, hinhanh = ?, trangthai = ?, madm = ?, mancc = ? where masp = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            
            stmt.setString(1, edittedItem.getTensp());
            stmt.setString(2, edittedItem.getMota());
            stmt.setInt(3, edittedItem.getSoluong());
            stmt.setFloat(4, edittedItem.getDongia());
            stmt.setString(5, edittedItem.getHinhanh());
            stmt.setBoolean(6, edittedItem.isTrangthai());
            stmt.setString(7, edittedItem.getDanhmuc().getMadm());
            stmt.setString(8, edittedItem.getNhacungcap().getMancc());
            stmt.setString(9, edittedItem.getMasp());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "Delete from tblSanPham where masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            errorDelete = true;
        }
    }
    
    public String checkMasp(String masp){
        String checkMasp = "";
        if (masp.length() != 3) {
            checkMasp = "Mã sản phẩm phải có 3 kí tự";
        } else if (masp.charAt(0) != 'A') {
            checkMasp = "Kí tự đầu tiên phải là A";
        }else if (!("0123456789".contains(masp.substring(1, 2))&&"0123456789".contains(masp.substring(2, 3)))){
            checkMasp = "kí tự thứ 2 và kí tự thứ 3 phải là số";
        }
        return checkMasp;
    }

    public boolean isErrorDelete() {
        return errorDelete;
    }

    public void setErrorDelete(boolean errorDelete) {
        this.errorDelete = errorDelete;
    }

    
    
    public static void main(String[] args) {
        SanPhamDAO dmDao = new SanPhamDAO();
        dmDao.listItems = dmDao.read();
        for (SanPham dm : dmDao.listItems) {
            System.out.println(dm.toString());
        }
    }
}
