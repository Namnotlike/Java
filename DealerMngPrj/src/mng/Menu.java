/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;
import java.util.ArrayList;
import tools.MyTool;
/**
 *
 * @author TTC
 */
public class Menu extends ArrayList<String>{

    public Menu() {
        super();
    }
    public Menu(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }
    
    public int getChoice(String title){
        int count = 0;
        for (String string : this) {
            System.out.println(++count + ". " + string);
        }
        int x = MyTool.readInt(title, 0, this.size());
        return x;
    }
}
