/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TTC
 */
public class ChiTietHoaDon {
    private HoaDon mahd;
    private SanPham masp;
    private int soluong;
    private float dongia;
    private float khuyenmai;
    private float giaitri;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon mahd, SanPham masp, int soluong, float dongia, float khuyenmai, float giaitri) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.khuyenmai = khuyenmai;
        this.giaitri = giaitri;
    }

    public HoaDon getMahd() {
        return mahd;
    }

    public void setMahd(HoaDon mahd) {
        this.mahd = mahd;
    }

    public SanPham getMasp() {
        return masp;
    }

    public void setMasp(SanPham masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(float khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public float getGiaitri() {
        return giaitri;
    }

    public void setGiaitri(float giaitri) {
        this.giaitri = giaitri;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", dongia=" + dongia + ", khuyenmai=" + khuyenmai + ", giaitri=" + giaitri + '}';
    }
    
}
