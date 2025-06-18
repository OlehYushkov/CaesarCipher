package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {

    public void readAndProcessFile(Modes mode, String sourceFilePath, String resultFilePath, Cipher cipher) {
        String line;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(sourceFilePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (mode == Modes.ENCRYPTION) {
                    writeLine(cipher.encryptDecrypt(line, Modes.ENCRYPTION), resultFilePath);
                }
                if (mode == Modes.DECRYPTION) {
                    writeLine(cipher.encryptDecrypt(line, Modes.DECRYPTION), resultFilePath);
                }
            }
            Files.writeString(Path.of(resultFilePath), "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line, String resultFilePath) {
        try {
            Files.writeString(Path.of(resultFilePath), line + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
