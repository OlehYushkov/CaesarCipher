package Service;

import Model.*;
import UI.Menu;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleInputHandler {

    private final String IO_ERROR = "Error reading, writing, or creating file";
    private final String IN_DEVELOPMENT = "\nFeature in development";

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        String inputString;

        while (true) {
            menu.showMainMenu();
            inputString = scanner.nextLine();

            if (inputString.equals("1")) {
                encryptWithKeyOption(menu, scanner);
            }
            if (inputString.equals("2")) {
                decryptWithKeyOption(menu, scanner);
            }
            if (inputString.equals("3")) {
                BruteForceOption(menu, scanner);
            }
            if (inputString.equals("4")) {
                System.out.println(IN_DEVELOPMENT);
            }
            if (inputString.equals("0")) {
                break;
            }

        }
        scanner.close();
    }

    private void encryptWithKeyOption(Menu menu, Scanner scanner) {
        menu.showEmptyLine();
        menu.showEncryptWithKeyIntroMenu();

        String sourceFilePath = sourceFilePathInput(menu, scanner);
        String outputFilePath = outputFilePathInput(menu, scanner, sourceFilePath);
        int key = keyInput(menu, scanner);

        Cipher cipher = new Cipher(Alphabet.getALPHABET(), key);
        FileManager fileManager = new FileManager();
        try {
            fileManager.readAndProcessFile(Modes.ENCRYPTION, sourceFilePath, outputFilePath, cipher);
            menu.showProcessCompletedMenu();
        } catch (IOException e) {
            System.err.println(IO_ERROR);
            e.printStackTrace();
        }
    }

    private void decryptWithKeyOption(Menu menu, Scanner scanner) {
        menu.showEmptyLine();
        menu.showDecryptWithKeyIntroMenu();

        String sourceFilePath = sourceFilePathInput(menu, scanner);
        String outputFilePath = outputFilePathInput(menu, scanner, sourceFilePath);
        int key = keyInput(menu, scanner);

        Cipher cipher = new Cipher(Alphabet.getALPHABET(), key);
        FileManager fileManager = new FileManager();

        try {
            fileManager.readAndProcessFile(Modes.DECRYPTION, sourceFilePath, outputFilePath, cipher);
            menu.showProcessCompletedMenu();
        } catch (IOException e) {
            System.err.println(IO_ERROR);
            e.printStackTrace();
        }
    }

    private void BruteForceOption(Menu menu, Scanner scanner) {
        menu.showEmptyLine();
        menu.showBrutForceIntroMenu();

        String sourceFilePath = sourceFilePathInput(menu, scanner);
        String outputFilePath = outputFilePathInput(menu, scanner, sourceFilePath);

        FileManager fileManager = new FileManager();
        try {
            for (int i = 0; i < Alphabet.getALPHABET().length; i++) {
                Cipher cipher = new Cipher(Alphabet.getALPHABET(), i + 1);
                fileManager.readAndProcessFile(Modes.DECRYPTION, sourceFilePath, outputFilePath, cipher);
            }
            menu.showProcessCompletedMenu();
        } catch (IOException e) {
            System.err.println(IO_ERROR);
            e.printStackTrace();
        }
    }

    private String sourceFilePathInput(Menu menu, Scanner scanner) {
        String inputLine;

        menu.showEnterSourceFileMenu();
        inputLine = scanner.nextLine();
        inputLine = Validator.checkEmptyLine(scanner, inputLine);
        inputLine = Validator.isLineConvertedIntoPath(scanner, inputLine);
        inputLine = Validator.isFileExists(scanner, inputLine);

        return inputLine;
    }

    private String outputFilePathInput(Menu menu, Scanner scanner, String sourceFile) {
        String inputLine;

        menu.showEnterResultFileMenu();
        inputLine = scanner.nextLine();
        inputLine = Validator.checkEmptyLine(scanner, inputLine);
        inputLine = Validator.isLineConvertedIntoPath(scanner, inputLine);
        inputLine = Validator.isOutputFileEqualseSourceFile(scanner, inputLine, sourceFile);

        return inputLine;
    }

    private int keyInput(Menu menu, Scanner scanner) {
        String inputLine;

        menu.showEnterKeyMenu();
        inputLine = scanner.nextLine();

        return Validator.parseToNumber(scanner, inputLine);
    }

}
