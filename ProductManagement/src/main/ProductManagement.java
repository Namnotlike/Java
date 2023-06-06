/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import mng.Menu;
import mng.ProductList;
import tools.MyTool;

/**
 *
 * @author TTC
 */
public class ProductManagement {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("1. Create Product");
        menu.add("2. Chect exist Product");
        menu.add("3. Delete Product");
        menu.add("4. Search Product");
        menu.add("5. Update Product");
        menu.add("6. Save Product to File");
        menu.add("7. Print List");
        ProductList pList = new ProductList();
        pList.initWithFile();
        boolean a = false;
        do {
            menu.printMenu();
            int x = menu.getChoice();
            switch (x) {
                case 1:
                    pList.createProduct();
                    break;
                case 2:
                    pList.checkExistProduct();
                    break;
                case 3:
                    pList.deleteProduct();
                    break;
                case 4:
                    pList.searchProductByName();
                    break;
                case 5:
                    pList.updateProduct();
                    break;
                case 6:
                    pList.saveToFile();
                    break;
                case 7:
                    pList.printListFromFile();
                    break;
            }
            a = menu.confirmYesNo();
            if (pList.isChanged() && !a) {
                boolean res = MyTool.readBool("Data change. Do you want write to file....");
                if (res == true) {
                    pList.saveToFile();
                }
            }
        } while (a);
    }

}
