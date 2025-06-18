package Model;

public class Cipher {

    private char[] alphabet;
    private int key;

    public Cipher(char[] alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    public String encryptDecrypt(String line, Modes mode) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (!Character.isLetter(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                continue;
            }
            for (int j = 0; j < alphabet.length; j++) {
                if (line.charAt(i) == alphabet[j]) {
                    if (mode == Modes.ENCRYPTION) {
                        stringBuilder.append(
                                alphabet[(j + key % alphabet.length + alphabet.length) % alphabet.length]);
                    }
                    if (mode == Modes.DECRYPTION) {
                        stringBuilder.append(
                                alphabet[(j - key % alphabet.length + alphabet.length) % alphabet.length]);
                    }
                    break;
                }
                if (line.toLowerCase().charAt(i) == alphabet[j]) {
                    if (mode == Modes.ENCRYPTION) {
                        stringBuilder.append(Character.toUpperCase(
                                alphabet[(j + key % alphabet.length + alphabet.length) % alphabet.length]));
                    }
                    if (mode == Modes.DECRYPTION) {
                        stringBuilder.append(Character.toUpperCase(
                                alphabet[(j - key % alphabet.length + alphabet.length) % alphabet.length]));
                    }
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }

}
