package Model;

import java.util.Scanner;

public class Validator {

    public void isValidKey(int key, char[] alphabet) {
        while(key > alphabet.length){

        }
    }

    public boolean isFileExists(String filePath) {
        return false;
    }

    public static String checkEmptyLine(Scanner scanner, String line) {
        while(true) {
            if (line.equals("")) {
                System.out.println("The line should not be empty.");
                System.out.print("Enter correct line: ");
                line = scanner.nextLine();
            } else {
                break;
            }
        }
        return line;
    }

    public static int parseToNumber(Scanner scanner, String line) {
        int num;
        while(true) {
            try {
                num = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Enter correct number: ");
                line = scanner.nextLine();
            }
        }
        return num;
    }

}
