package UI;

public class Menu {

    public void showMainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("The program that allows you to encrypt and decrypt text using the Caesar cipher");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1. Encryption with key");
        System.out.println("2. Decryption with key");
        System.out.println("3. Brute force");
        System.out.println("4. Statistical analysis");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Select an option: ");
    }

    public void showEmptyLine() {
        System.out.println();
    }

    public void showEnterSourceFileMenu() {
        System.out.print("Enter a Path to Source file: ");
    }

    public void showEnterResultFileMenu() {
        System.out.print("Enter a Path to Output file: ");
    }

    public void showEnterKeyMenu() {
        System.out.print("Enter a Encryption key: ");
    }

    public void showProcessCompletedMenu() {
        System.out.println();
        System.out.println("------------------");
        System.out.println("Process completed.");
        System.out.println("------------------");
        System.out.println();
    }

    public void showEncryptWithKeyIntroMenu() {
        System.out.println("Encryption with key:");
        System.out.println("--------------------");
    }

    public void showDecriptWithKeyIntroMenu() {
        System.out.println("Decryption with key:");
        System.out.println("--------------------");
    }

    public void showBrutForceIntroMenu() {
        System.out.println("Brute force:");
        System.out.println("--------------------");
    }
}
