package Service;

import Model.Alphabet;
import Model.Cipher;
import Model.FileManager;
import Model.Modes;
import UI.Menu;

import java.util.Scanner;

public class ConsoleInputHendler {

    public void showMenu () {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        String inputString;

        while(true) {
            menu.showMainMenu();
            inputString = scanner.nextLine();

            if (inputString.equals("1")) {
                encryptWithKeyOption(menu, scanner);
            }
            if (inputString.equals("2")){

            }
            if (inputString.equals("3")){

            }
            if (inputString.equals("4")){

            }
            if (inputString.equals("0")){
                break;
            }

        }
        scanner.close();
    }

    private static void encryptWithKeyOption(Menu menu, Scanner scanner) {
        menu.showEnterSourceFileMenu();
        String sourceFilePath = scanner.nextLine();

        menu.showEnterResultFileMenu();
        String resultFilePath = scanner.nextLine();

        menu.showEnterKeyMenu();
        int key = Integer.parseInt(scanner.nextLine());

        Cipher cipher = new Cipher(Alphabet.getALPHABET(), key);
        FileManager fileManager = new FileManager();
        fileManager.readAndProcessFile(Modes.ENCRYPTION,sourceFilePath,resultFilePath, cipher);
        menu.showProcessCompletedMenu();
    }

}
