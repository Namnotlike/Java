/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import tools.MyTool;
/**
 *
 * @author TTC
 */
public class Dealer implements Comparable<Dealer>{
    public static final String ID_FORMAT = "D\\d{3}";
    public static final String PHONE_FORMAT = "\\d{9}|\\d{11}";
    private String id;
    private String name;
    private String addr;
    private String phone;
    private boolean continuing;

    public Dealer(String id, String name, String addr, String phone, boolean continuing) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.continuing = continuing;
    }

    public Dealer(String line) {
        String[] parts = line.split(",");
        id = parts[0].trim();
        name = parts[1].trim();
        addr = parts[2].trim();
        phone = parts[3].trim();
        continuing = MyTool.parseBool(parts[4]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isContinuing() {
        return continuing;
    }

    public void setContinuing(boolean continuing) {
        this.continuing = continuing;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + addr + "," + phone + "," + continuing + "\n";
    }

    @Override
    public int compareTo(Dealer o) {
        return this.id.compareToIgnoreCase(o.id);
    }

}
