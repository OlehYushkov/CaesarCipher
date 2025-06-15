//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Cipher cipher = new Cipher(alphabet.getALPHABET(), 1);
        FileManager fileManager = new FileManager(cipher, "result.txt", "text.txt");
        fileManager.readAndProcessFile(Modes.DECRYPTING);

    }
}