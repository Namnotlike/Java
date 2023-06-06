/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

/**
 *
 * @author TTC
 */
public interface I_Menu {
    void addItem(String s);
    void printMenu();
    int getChoice();
    boolean confirmYesNo();
}
