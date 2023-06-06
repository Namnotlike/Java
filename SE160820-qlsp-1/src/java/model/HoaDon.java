/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author TTC
 */
public class HoaDon {
    private String mahd;
    private Date ngaydh;
    private int trangthaixuli;
    private TaiKhoan makh;

    public HoaDon() {
    }

    public HoaDon(String mahd, Date ngaydh, int trangthaixuli, TaiKhoan makh) {
        this.mahd = mahd;
        this.ngaydh = ngaydh;
        this.trangthaixuli = trangthaixuli;
        this.makh = makh;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgaydh() {
        return ngaydh;
    }

    public void setNgaydh(Date ngaydh) {
        this.ngaydh = ngaydh;
    }

    public int getTrangthaixuli() {
        return trangthaixuli;
    }

    public void setTrangthaixuli(int trangthaixuli) {
        this.trangthaixuli = trangthaixuli;
    }

    public TaiKhoan getMakh() {
        return makh;
    }

    public void setMakh(TaiKhoan makh) {
        this.makh = makh;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "mahd=" + mahd + ", ngaydh=" + ngaydh + ", trangthaixuli=" + trangthaixuli + ", makh=" + makh + '}';
    }
    
}
