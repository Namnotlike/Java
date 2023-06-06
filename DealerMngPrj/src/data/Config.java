/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.List;
import tools.MyTool;
/**
 *
 * @author TTC
 */
public class Config {
    private static final String CONFIG_FILE = "DealerData/config.txt";
    private String accountFile;
    private String dealerFile;
    private String deliveryFile;
    
    private void readData(){
        List<String> lines = MyTool.readLinesFromFile(CONFIG_FILE);
        for (String line : lines) {
            line = line.toUpperCase();
            String[] parts = line.split(":");
            if (parts[0].contains("ACCOUNT")) {
                accountFile = "DealerData/" + parts[1].trim();
            }
            else if (parts[0].contains("DEALER")) {
                dealerFile = "DealerData/" + parts[1].trim();
            }
            else if (parts[0].contains("Delivery".toUpperCase())) {
                deliveryFile = "DealerData/" + parts[1].trim();
            }
        }
    }

    public Config() {
        readData();
    }

    public String getAccountFile() {
        return accountFile;
    }

    public String getDealerFile() {
        return dealerFile;
    }

    public String getDeliveryFile() {
        return deliveryFile;
    }
}
