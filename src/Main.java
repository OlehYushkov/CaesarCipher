public class Main {

    public static void main(String[] args) {
        final String contentFilePath = "text.txt";
        final String resultFilePathDecryption = "resultDecryption.txt";
        final String resultFilePathEncryption = "resultEncryption.txt";

        Alphabet alphabet = new Alphabet();
        Cipher cipher = new Cipher(alphabet.getALPHABET(), 1);
        FileManager fileManagerEncryption = new FileManager(cipher, contentFilePath, resultFilePathEncryption);
        fileManagerEncryption.readAndProcessFile(Modes.ENCRYPTION);
        FileManager fileManagerDecryption = new FileManager(cipher, resultFilePathEncryption, resultFilePathDecryption);
        fileManagerDecryption.readAndProcessFile(Modes.DECRYPTION);
    }

}