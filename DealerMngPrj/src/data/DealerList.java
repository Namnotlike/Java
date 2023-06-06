/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.List;
import java.util.ArrayList;
import tools.MyTool;
import mng.LogIn;
/**
 *
 * @author TTC
 */
public class DealerList extends ArrayList<Dealer>{
    private LogIn logInObj = null;
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean change = false;

    public DealerList(LogIn logInObj) {
        super();
        this.logInObj = logInObj;
    }
    
    private void loadDerlerFromFile(){
        List<String> list = MyTool.readLinesFromFile(new Config().getDealerFile());
        for (String line : list) {
            this.add(new Dealer(line));
        }
    }
    
    public void initWithFile(){
        Config cR =  new Config();
        dataFile = cR.getDealerFile();
        loadDerlerFromFile();
    }
    
    public DealerList getContinuingList(){
        DealerList list = new DealerList(logInObj);
        for (Dealer d : this) {
            if (d.isContinuing() == true) list.add(d);
        }
        return list;
    }
    
    public DealerList getUnContinuingList(){
        DealerList list = new DealerList(logInObj);
        for (Dealer d : this) {
            if (d.isContinuing() == false) list.add(d);
        }
        return list;
    }
    
    private int searchDealer(String ID){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }
    
    public void searchDealer(){
        String ID = MyTool.readPattern("Input ID to search", Dealer.ID_FORMAT);
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Not found.");
        } else
            System.out.println(this.get(pos).toString());
    }
    
    public void addDealer(){
        String ID;
        int pos;
        do {
            ID = MyTool.readPattern("ID of new dealer", Dealer.ID_FORMAT).toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated!");
            }
        } while (pos >= 0);
        this.add(new Dealer(ID, MyTool.readNonBlank("Name of new dealer:"), 
                            MyTool.readNonBlank("Address of new dealer: "), 
                            MyTool.readPattern("Phone number: ", Dealer.PHONE_FORMAT), 
                            true));
        System.out.println("New dealer has been added.");
        change = true;
    }
    
    public void removeDealer(){
        int pos = searchDealer(MyTool.readPattern("What Id do you want to remove: ", Dealer.ID_FORMAT));
        if (pos < 0) {
            System.out.println("Not found");
        } else{
            this.get(pos).setContinuing(false);
            System.out.println("Remove successful");
            change = true;
        }
    }
    
    public void updateDealer(){
        String ID = MyTool.readPattern("What Id do you want to update: ", Dealer.ID_FORMAT);
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found");
        }
        else{
            Dealer d = this.get(pos);
            d.setName(MyTool.readNonBlank("New name: "));
            d.setAddr(MyTool.readNonBlank("New addr: "));
            d.setPhone(MyTool.readPattern("New phone: ", PHONEPATTERN));
            change = true;
        }
    }
    
    public void printAllDealer(){
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else
            System.out.println(this);
    }
    
    public void printContinuingDealers(){
        this.getContinuingList().printAllDealer();
    }
    
    public void printUnContinuingDealers(){
        this.getUnContinuingList().printAllDealer();
    }
    
    public void writeToFile(){
        if (change) {
            MyTool.writeFile(dataFile, this);
            change = false;
        }
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }
    
}
