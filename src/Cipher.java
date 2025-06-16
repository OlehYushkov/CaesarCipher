public class Cipher {

    private char[] alphabet;
    private int key = 0;

    public Cipher(char[] alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    public String encrypt(String line) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (!Character.isLetter(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                continue;
            }
            for (int j = 0; j < alphabet.length; j++) {
                if (line.charAt(i) == alphabet[j]) {
                    stringBuilder.append(
                            alphabet[(j + key % alphabet.length + alphabet.length) % alphabet.length]);
                    break;
                }
                if (line.toLowerCase().charAt(i) == alphabet[j]) {
                    stringBuilder.append(Character.toUpperCase(
                            alphabet[(j + key % alphabet.length + alphabet.length) % alphabet.length]));
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }

    public String decrypt(String line) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (!Character.isLetter(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
                continue;
            }
            for (int j = 0; j < alphabet.length; j++) {
                if (line.charAt(i) == alphabet[j]) {
                    stringBuilder.append(
                            alphabet[(j - key % alphabet.length + alphabet.length) % alphabet.length]);
                    break;
                }
                if (line.toLowerCase().charAt(i) == alphabet[j]) {
                    stringBuilder.append(Character.toUpperCase(
                            alphabet[(j - key % alphabet.length + alphabet.length) % alphabet.length]));
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }

//    public String encryptLine(String line) {
//        StringBuilder stringBuilder = new StringBuilder();
//        String[] words = line.split(" ");
//        for (String word : words) {
//            stringBuilder.append(encrypt(word) + " ");
//        }
//
//        return stringBuilder.toString().trim();
//    }
//
//    public String decryptLine(String line) {
//        StringBuilder stringBuilder = new StringBuilder();
//        String[] words = line.split(" ");
//        for (String word : words) {
//            stringBuilder.append(decrypt(word) + " ");
//        }
//
//        return stringBuilder.toString().trim();
//    }

}
