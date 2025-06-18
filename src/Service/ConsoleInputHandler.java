package Service;

import Model.Alphabet;
import Model.Cipher;
import Model.FileManager;
import Model.Modes;
import UI.Menu;

import java.util.Scanner;

public class ConsoleInputHandler {

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

        menu.showEnterSourceFileMenu();
        String sourceFilePath = scanner.nextLine();

        menu.showEnterResultFileMenu();
        String resultFilePath = scanner.nextLine();

        menu.showEnterKeyMenu();
        int key = Integer.parseInt(scanner.nextLine());

        Cipher cipher = new Cipher(Alphabet.getALPHABET(), key);
        FileManager fileManager = new FileManager();
        fileManager.readAndProcessFile(Modes.ENCRYPTION, sourceFilePath, resultFilePath, cipher);

        menu.showProcessCompletedMenu();
    }

    private void decryptWithKeyOption(Menu menu, Scanner scanner) {
        menu.showEmptyLine();
        menu.showDecryptWithKeyIntroMenu();

        menu.showEnterSourceFileMenu();
        String sourceFilePath = scanner.nextLine();

        menu.showEnterResultFileMenu();
        String resultFilePath = scanner.nextLine();

        menu.showEnterKeyMenu();
        int key = Integer.parseInt(scanner.nextLine());

        Cipher cipher = new Cipher(Alphabet.getALPHABET(), key);
        FileManager fileManager = new FileManager();
        fileManager.readAndProcessFile(Modes.DECRYPTION, sourceFilePath, resultFilePath, cipher);

        menu.showProcessCompletedMenu();
    }

    private void BruteForceOption(Menu menu, Scanner scanner) {
        menu.showEmptyLine();
        menu.showBrutForceIntroMenu();

        menu.showEnterSourceFileMenu();
        String sourceFilePath = scanner.nextLine();

        menu.showEnterResultFileMenu();
        String resultFilePath = scanner.nextLine();

        FileManager fileManager = new FileManager();
        for (int i = 0; i < Alphabet.getALPHABET().length; i++) {
            Cipher cipher = new Cipher(Alphabet.getALPHABET(), i + 1);
            fileManager.readAndProcessFile(Modes.DECRYPTION, sourceFilePath, resultFilePath, cipher);
        }

        menu.showProcessCompletedMenu();
    }

}
