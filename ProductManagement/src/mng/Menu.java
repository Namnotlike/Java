/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;
import java.util.ArrayList;
import data.I_Menu;
import tools.MyTool;
/**
 *
 * @author TTC
 */
public class Menu extends ArrayList<String> implements I_Menu{

    public Menu() {
        super();
    }

    
    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public void printMenu() {
        for (String thi : this) {
            System.out.println(thi);
        }
    }

    @Override
    public int getChoice() {
        return MyTool.readInt("Input your choice", 1, this.size());
    }

    @Override
    public boolean confirmYesNo() {
        return MyTool.readBool("Do you want to go back to the main menu");
    }
    
}
