package MenuNav;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputListener {

    public static void printText(String text) {
        System.out.println(text + " ");
        System.out.flush();
    }
    public static void scanFlush() {
        int temp;
        try {
            while ((System.in.available()) != 0)
                temp = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }
    public static String IntToString() {
        int aChar;
        String text = "";
        boolean finished = false;
        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n') {
                    finished = true;
                } else if ((char) aChar != '\r') {
                    text = text + (char) aChar;
                }
            } catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return text;
    }
    static boolean numberOrNot(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException ex) {
            return false;
        } return true;
    }
    public static int scanInt(String text) {
        while (true) {
            scanFlush();
            printText(text);
            try {
                return Integer.parseInt(IntToString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static String readString(String text) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            printText(text);
            input = scanner.nextLine();
            return input;
        }
    }
    public static int readPassword(String text) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            scanFlush();
            printText(text);
            input = scanner.next();
            if (numberOrNot(input) && input.length() == 4) {
                return Integer.parseInt(input);
            } else  {
                System.out.println(input + " is not a valid 4-digit password. Please try again.");
            }
        }
    }
    public static int readContactNumber(String text) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            scanFlush();
            printText(text);
            input = scanner.next();
            if (numberOrNot(input) && input.length() == 10) {
                return Integer.parseInt(input);
            } else  {
                System.out.println(input + " is not a valid mobile number. Please try again.");
            }
        }
    }
    public static String readGenre(String text) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            printText(text);
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Drama") || input.equalsIgnoreCase("Adventure") ||
                    input.equalsIgnoreCase("Family") || input.equalsIgnoreCase("Action") ||
                    input.equalsIgnoreCase("Sci-Fi") ||
                    input.equalsIgnoreCase("Comedy") || input.equalsIgnoreCase("Animated") ||
                    input.equalsIgnoreCase("Thriller") || input.equalsIgnoreCase("Other")) {
                    String uppercaseLetter = input.substring(0, 1).toUpperCase();
                    String inputCapitalised = uppercaseLetter + input.substring(1);
                    return inputCapitalised;
            } else {
                System.out.println(input + " is not a valid option. Please try again.");
            }
        }
    }
    public static String readClassification(String text) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            printText(text);
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("G") || input.equalsIgnoreCase("PG") ||
                    input.equalsIgnoreCase("M") || input.equalsIgnoreCase("MA")) {
                return input.toUpperCase();
            } else {
                System.out.println(input + " is not a valid option. Please try again.");
            }
        }
    }
    public static String readDate(String text) {
        SimpleDateFormat simpledate = new SimpleDateFormat("DD-MM-YY");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            scanFlush();
            printText(text);
            try {
                input = scanner.nextLine();
                Date date = simpledate.parse(input);
                return input;
            } catch (ParseException e) {
                System.out.println("Invalid format. Please enter date like DD-MM-YY");
            }
        }
    }

}
