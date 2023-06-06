/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.io.IOException;

/**
 *
 * @author TTC
 */
public class MyTool {

    public static final Scanner SC = new Scanner(System.in);

    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);
    }

    public static boolean validPassword(String str, int minLen) {
        if (str.length() < minLen) {
            return false;
        }
        return str.matches(".*[A-Za-z]+.*") && str.matches(".*[\\d]+.*") && str.matches(".*[\\W]+.*");
    }

    public static Date parseDate(String dateStr, String dateFormat) {
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        try {
            long t = dF.parse(dateStr).getTime();
            return new Date(t);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return null;
    }

    public static String dataToStr(Date date, String dateFormat) {
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        return dF.format(date);
    }

    public static boolean parseBool(String boolStr) {
        char c = boolStr.trim().toLowerCase().charAt(0);
        return (c == '1' || c == 'y' || c == 't');
    }

    public static String readStatus(String message) {
        int x = readInt(message + ": ", 0, 1);
        if (x == 1) {
            return "Available";
        } else {
            return "Not Available";
        }
    }

    public static String readStatus(String message, String oldData) {
        System.out.println(message + ": ");
        String x = SC.nextLine();
        if (x.isEmpty()) {
            return oldData;
        } else {
            int a = Integer.parseInt(x);
            if (a == 0) {
                return "Available";
            } else {
                return "Not Available";
            }
        }
    }

    public static int readInt(String message, int a, int b) {
        int x;
        while (true) {
            try {
                System.out.println(message + " from " + a + " to " + b + ": ");
                x = Integer.parseInt(SC.nextLine());
                if (x < a || x > b) {
                    System.out.println("Not in range " + a + ", " + b);
                } else {
                    return x;
                }
            } catch (Exception e) {
                System.out.println("Not number, try again.");
            }
        }

    }

    public static double readDouble(String message, double a, double b) {
        double x;
        while (true) {
            try {
                System.out.println(message + " from " + a + " to " + b + ": ");
                x = Double.parseDouble(SC.nextLine());
                if (x < a || x > b) {
                    System.out.println("Not in range " + a + ", " + b);
                } else {
                    return x;
                }
            } catch (Exception e) {
                System.out.println("Not number, try again.");
            }
        }

    }

    public static String readString(String message, String oldData) {
        String result = oldData;
        System.out.print(message);
        String tmp = SC.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int readInt(String message, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                System.out.print(message + ": ");
                String tmp = SC.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double readDouble(String message, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                System.out.print(message + ": ");
                String tmp = SC.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static String readNonBlank(String message, int minLen) {
        String input = "";
        while (input.isEmpty()) {
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            if (input.length() < minLen/* || input.contains(" ")*/) {
                input = "";
            }
        }
        return input;
    }

    public static String readPattern(String message, String pattern) {
        String input = "";
        boolean valid;
        do {
            System.out.println(message + ": ");
            input = SC.nextLine().trim();
            valid = validStr(input, pattern);
        } while (!valid);
        return input;
    }

    public static boolean readBool(String message) {
        String input;
        System.out.println(message + "[1/0-Y/N-T/F]: ");
        input = SC.nextLine().trim().toLowerCase();
        if (input.isEmpty()) {
            return false;
        }
        char c = input.charAt(0);
        return (c == '1' || c == 'y' || c == 't');
    }

    public static List<String> readLinesFromFile(String fileName) {
        List<String> list = new ArrayList<String>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        list.add(line);
                    }
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public static void writeFile(String fileName, List list) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            for (Object object : list) {
                pw.println(object);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
