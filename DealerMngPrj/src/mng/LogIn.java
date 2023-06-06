/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;

import data.Account;
import data.AccountChecker;
import data.DealerList;
import tools.MyTool;

/**
 *
 * @author TTC
 */
public class LogIn {

    private Account acc;

    public LogIn(Account acc) {
        this.acc = acc;
    }

    public static Account inputAccount() {
        Account acc = new Account(MyTool.readNonBlank("Input acccount: "),
                MyTool.readNonBlank("Input pwd: "),
                MyTool.readNonBlank("Input role: "));
        return acc;
    }

    public Account getAcc() {
        return acc;
    }

    public static void main(String[] args) {
        Account acc = null;
        boolean cont = false;
        boolean valid = false;
        do {
            cont = false;
            AccountChecker accChk = new AccountChecker();
            acc = inputAccount();
            valid = accChk.check(acc);
            if (!valid) {
                cont = MyTool.readBool("Invalid account - Try aganin$$$(Y/N)");
            }
            if (!valid && !cont) {
                System.exit(0);
            }
        } while (cont);
        LogIn loginObj = new LogIn(acc);
        if (acc.getRole().equalsIgnoreCase("acc-1")) {
            String[] option = {"Add new dealer", "Search a dealer",
                "Remove a dealer", "Update a dealer",
                "Print all dealers", "Print continuing dealers",
                "Print unContinuing dealers", "Write to file"
            };
            Menu mn = new Menu(option);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            int choice = 0;
            do {
                choice = mn.getChoice("Managing dealers");
                switch (choice) {
                    case 1:
                        dList.addDealer();
                        break;
                    case 2:
                        dList.searchDealer();
                        break;
                    case 3:
                        dList.removeDealer();
                        break;
                    case 4:
                        dList.updateDealer();
                        break;
                    case 5:
                        dList.printAllDealer();
                        break;
                    case 6:
                        dList.printContinuingDealers();
                        break;
                    case 7:
                        dList.printUnContinuingDealers();
                        break;
                    case 8:
                        dList.writeToFile();
                        break;
                    default:
                        if(dList.isChange()) {
                            boolean res = MyTool.readBool("Data change. Do you want write to file....");
                            if(res == true) dList.writeToFile();
                        }
                }
            } while (choice > 0 && choice <= mn.size());
            System.out.println("Bye.");
        }
    }
}
