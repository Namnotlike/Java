/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.CartItem;

/**
 *
 * @author TTC
 */
public class CartItemDao{
    List<CartItem> list;

    public CartItemDao() {
        list = new ArrayList<>();
    }

    public CartItemDao(List<CartItem> list) {
        this.list = list;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    
    
    
}
