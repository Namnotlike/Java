/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import tools.MyTool;
import java.util.List;
/**
 *
 * @author TTC
 */
public class AccountChecker {
    private String accFile;

    public AccountChecker() {
        accFile = new Config().getAccountFile();
    }
    
    public boolean check(Account acc){
        List<String> list = MyTool.readLinesFromFile(accFile);
        for (String line : list) {
            if (line.equalsIgnoreCase(acc.toString())) {
                return true;
            }
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        AccountChecker aChk = new AccountChecker();
//        Account acc;
//        int x = 1;
//        while (x != 0) {      
//            System.out.println("x = 0: quit");
//            System.out.println("accName, pwd, role");
//            acc = new Account(MyTool.SC.nextLine(), MyTool.SC.nextLine(), MyTool.SC.nextLine());
//            System.out.println(aChk.check(acc));
//            x = MyTool.SC.nextInt();
//        }
//    }
}
