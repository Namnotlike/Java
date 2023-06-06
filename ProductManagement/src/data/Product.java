/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author TTC
 */
public class Product implements Comparable<Product>{
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;

    public Product(String line) {
        String[] parts = line.split(",");
        this.productID = parts[0];
        this.productName = parts[1];
        this.unitPrice = Double.parseDouble(parts[2]);
        this.quantity = Integer.parseInt(parts[3]);
        this.status = parts[4];
    }
    
    public Product(String productID, String productName, double unitPrice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return productID + "," + productName + "," + unitPrice + "," + quantity + "," + status;
    }

    @Override
    public int compareTo(Product o) {
        return this.productName.compareTo(o.getProductName());
    }
    
}
