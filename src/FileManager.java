import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {

    private final String contentFilePath;
    private final String resultFilePath;
    private Cipher cipher;

    public FileManager(Cipher cipher, String contentFilePath, String resultFilePath) {
        this.cipher = cipher;
        this.contentFilePath = contentFilePath;
        this.resultFilePath = resultFilePath;
    }

    public void readAndProcessFile(Modes mode) {
        String line = "";
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Path.of(contentFilePath));
            while ((line = bufferedReader.readLine()) != null) {
                if(mode == Modes.ENCRYPTION) {
                    writeLine(cipher.encrypt(line));
                }
                if(mode == Modes.DECRYPTING) {
                    writeLine(cipher.decrypt(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line) {
        try {
            Files.writeString(Path.of(resultFilePath), line + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
