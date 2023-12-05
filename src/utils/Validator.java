package utils;


import base.Mode;
import base.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.Calendar;

public class Validator {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static final int MIN_YEAR_PUBLICATION = 1900;

    public static String validateString(String message) {
        System.out.println(message);
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

    public static int validateYearPublication() {
        int year;
        while (true) {
            year = getIntNumber("Input year of publication (must be greater than " + MIN_YEAR_PUBLICATION);
            if (year >= MIN_YEAR_PUBLICATION  && year <= Year.now().getValue()) {
                return year;
            } else {
                System.out.println("Invalid year: " + year);
            }
        }
    }

    public static boolean getYesOrNo(String message) {
        System.out.println(message);
        String str;
        while (true) {
            try {
                str = READER.readLine().trim().toUpperCase();
                if (str.equals("Y") || str.equals("N")) {
                    return str.equals("Y");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Invalid input: " + message);
        }
    }
}



