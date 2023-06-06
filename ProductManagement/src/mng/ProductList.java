/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import data.Config;
import java.util.ArrayList;
import data.I_List;
import data.Product;
import tools.MyTool;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author TTC
 */
public class ProductList extends ArrayList<Product> implements I_List {

    boolean changed = false;
    String dataFile;

    public ProductList() {
        super();
    }
        private void loadProductFromFile(){
        List<String> list = MyTool.readLinesFromFile(new Config().getProductFile());
        for (String line : list) {
            this.add(new Product(line));
        }
    }
    
    public void initWithFile(){
        Config cR =  new Config();
        dataFile = cR.getProductFile();
        loadProductFromFile();
    }

    private int searchProduct(String idname) {
        for (Product thi : this) {
            if (thi.getProductID().equalsIgnoreCase(idname.trim())||thi.getProductName().equalsIgnoreCase(idname.trim())) {
                return this.indexOf(thi);
            }
        }
        return -1;
    }

    @Override
    public void createProduct() {
        String name = MyTool.readNonBlank("Input ProductName", 5);
        if (searchProduct(name.trim()) >= 0) {
            System.out.println("Duplicated");
        } else {
            this.add(new Product(MyTool.readNonBlank("Input PtroductID", 0), name,
                    MyTool.readDouble("Input UnitPrice", 0, 10000),
                    MyTool.readInt("Input Quantity", 0, 1000),
                    MyTool.readStatus("Input statucs(1 to Available or 0 to Not Available)")));
            System.out.println("Create suceessfull");
            changed = true;
        }
    }

    @Override
    public void checkExistProduct() {
        System.out.println("Input ProductName to check exist: ");
        String name = MyTool.SC.nextLine();
        if (searchProduct(name.trim()) < 0) {
            System.out.println("No Product Found!");
        } else {
            System.out.println("Exist Product");
        }
    }

    @Override
    public void searchProductByName() {
        System.out.println("Input a prt of ProductName to search: ");
        String s = MyTool.SC.nextLine();
        List<String> list = new ArrayList<>();
        for (Product thi : this) {
            if (thi.getProductName().contains(s)) {
                list.add(thi.toString());
            }
        }
        if (list.isEmpty()) {
            System.out.println("Have no any Product");
        }
        else{
            Collections.sort(list);
            for (String product : list) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public void updateProduct() {
        String name;
        System.out.println("Input Id to update: ");
        String id = MyTool.SC.nextLine();
        int x =searchProduct(id);
        if (x < 0) {
            System.out.println("Productname does not exist");
        }
        else{
            do {
                name = MyTool.readNonBlank("Input new name", 5);
            } while (searchProduct(name) > 0);
            this.get(x).setProductName(name);
            this.get(x).setUnitPrice(MyTool.readDouble("Input new unitPrice", 0, 10000, this.get(x).getUnitPrice()));
            this.get(x).setQuantity(MyTool.readInt("Input new quatity", 0, 1000, this.get(x).getQuantity()));
            this.get(x).setStatus(MyTool.readStatus("Input statucs(1 to Available or 0 to Not Available)", this.get(x).getStatus()));
            System.out.println("Update sucessfull");
            changed = true;
        }
    }

    @Override
    public void deleteProduct() {
        String name;
        System.out.println("Input Id to delete: ");
        name = MyTool.SC.nextLine();
        int x = searchProduct(name);
        if (x < 0) {
            System.out.println("Productname does not exist");
        } else{
            this.remove(x);
            System.out.println("Delete sucessful");
            changed = true;
        }
    }

    @Override
    public void saveToFile() {
        MyTool.writeFile(dataFile, this);
        changed =false;
    }

    @Override
    public void printListFromFile() {
        for (Product thi : this) {
            System.out.println(thi.toString());
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }
    
}
