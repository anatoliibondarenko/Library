package utils;


import base.Mode;
import base.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String validateString(String message) {
        String str;
        while (true) {
            try {
                if (!(str = READER.readLine().trim()).isEmpty()) {
                    return str;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Empty " + message);
        }
    }

    public static Subject validateSubject() {
        int choice = getIntNumber();
        if (choice > 0 && choice <= Subject.values().length) {
            return Subject.values()[choice - 1];
        } else {
            System.out.println("Invalid choice!");
            return validateSubject();
        }
    }

    public static Mode validateMode() {
        int choice = getIntNumber();
        if (choice > 0 && choice <= Mode.values().length) {
            return Mode.values()[choice - 1];
        } else {
            System.out.println("Invalid choice!");
            return validateMode();
        }
    }

    public static int getIntNumber() {
        try {
            String str = READER.readLine();
            return Integer.parseInt(str);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return getIntNumber();
        }

    }

    public static int getIntNumber(String inputMessage) {
        try {
            System.out.println(inputMessage);
            String str = READER.readLine();
            return Integer.parseInt(str);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return getIntNumber(inputMessage);
        }
    }

}



