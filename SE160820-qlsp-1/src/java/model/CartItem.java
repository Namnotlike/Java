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
public class CartItem {
    private SanPham sp;
    private int amount;

    public CartItem() {
    }

    public CartItem(SanPham sp, int amount) {
        this.sp = sp;
        this.amount = amount;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartItem{" + "sp=" + sp + ", amount=" + amount + '}';
    }
    
}
