package utils;


import base.Mode;

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

    public static Mode validateMode() {

        int mode = getIntNumber("");

        if (mode < 0 || mode >= Mode.values().length ) {
            getIntNumber("Invalid input!");
        }
            try {
            mode = Integer.parseInt(READER.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
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



