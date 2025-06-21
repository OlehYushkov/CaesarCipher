package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {

    private final String IO_ERROR = "Error reading, writing, or creating file";

    public void readAndProcessFile(Modes mode, String sourceFilePath, String outputFilePath, Cipher cipher) throws IOException {
        String line;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(sourceFilePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (mode == Modes.ENCRYPTION) {
                    writeLine(cipher.encryptDecrypt(line, Modes.ENCRYPTION), outputFilePath);
                }
                if (mode == Modes.DECRYPTION) {
                    writeLine(cipher.encryptDecrypt(line, Modes.DECRYPTION), outputFilePath);
                }
            }
            Files.writeString(Path.of(outputFilePath), "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public void writeLine(String line, String resultFilePath) throws IOException {
        try {
            Files.writeString(Path.of(resultFilePath), line + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IOException();
        }
    }

}
