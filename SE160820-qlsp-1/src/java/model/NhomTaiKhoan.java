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
public class NhomTaiKhoan {
    private String nhomtk;
    private String mota;
    private boolean trangthai;

    public NhomTaiKhoan() {
    }

    public NhomTaiKhoan(String nhomtk, String mota, boolean trangthai) {
        this.nhomtk = nhomtk;
        this.mota = mota;
        this.trangthai = trangthai;
    }

    public String getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(String nhomtk) {
        this.nhomtk = nhomtk;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "NhomTaiKhoan{" + "nhomtk=" + nhomtk + ", mota=" + mota + ", trangthai=" + trangthai + '}';
    }
    
}
