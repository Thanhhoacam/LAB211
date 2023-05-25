package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    private static final Scanner input = new Scanner(System.in);
    private Pattern pName = Pattern.compile("^[A-Z][a-zA-Z]+$");

    private String getInputValue() {
        return input.nextLine().trim();
    }

//    public int inputChoice() {
//        while (true) {
//            try {
//                System.out.println("Enter your choice:");
//                return Integer.parseInt(getInputValue());
//            } catch (NumberFormatException e) {
//                System.err.println("Enter a number (Integer) !!!");
//            }
//        }
//    }
    public String getName(String msg){
        System.out.println(msg);
        String name = getInputValue();
        while (true) {            
            if (pName.matcher(name).find()) {
                return name;
            
        }else{
                System.err.println("invalid name format, plz try again");
                name = getInputValue();
            }
        }
        
        
    }
    // get choice, get int
    public int getInt(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        while (true) {
            try {
                System.out.println(msg);
                int n = Integer.parseInt(getInputValue());
                if (min <= n && n <= max) {
                    return n;
                }
                System.err.println("PLEASE INPUT A NUMBER IN RANGE " + min + "->" + max);

            } catch (NumberFormatException e) {
            }
            System.err.println("WRONG FORMAT!");
        }
    }

    public double getDouble(String mess) {
        System.out.println(mess);
        String sc = getInputValue();
        double value = Double.parseDouble(sc);
        return value;
    }
    
    public String getString(String msg) {
        while (true) {
            System.out.println(msg);
            String s = getInputValue();
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println("EMPTY STRING IS NOT ALLOWED !");
        }
    }

    public boolean getYN(String msg) {
        while (true) {
            System.out.println(msg);
            String s = getInputValue();
            if (s.equalsIgnoreCase("y")) {
                return true;
            } else if (s.equalsIgnoreCase("n")) {
                return false;
            }
            System.err.println("PLEASE INPUT ONLY Y/N");
        }
    }

}
