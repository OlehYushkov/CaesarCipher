package Model;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {

    private static final String FILE_NOT_EXIST = "ERROR: File does not exist.";
    private static final String ENTER_CORRECT_PATH_TO_FILE = "Enter correct Path to File: ";
    private static final String LINE_SHOULD_NOT_EMPTY = "ERROR: The line should not be empty.";
    private static final String ENTER_NUMBER = "Enter correct number: ";
    private static final String INVALID_PATH =
            "ERROR: Path string cannot be converted into a Path because the path string contains invalid characters.";
    private static final String OUTPUT_FILE_NOT_EQUALS_SOURCE_FILE =
            "ERROR: Output File must not be equal to Source File.";

    public static String isLineConvertedIntoPath(Scanner scanner, String line) {
        while (true) {
            try {
                Path.of(line);
                break;
            } catch (InvalidPathException e) {
                System.out.println(INVALID_PATH);
                System.out.print(ENTER_CORRECT_PATH_TO_FILE);
                line = scanner.nextLine();
                line = checkEmptyLine(scanner, line);
            }
        }
        return line;
    }

    public static String isFileExists(Scanner scanner, String filePath) {
        while(true) {
            if (!Files.exists(Path.of(filePath))) {
                System.out.println(FILE_NOT_EXIST);
                System.out.print(ENTER_CORRECT_PATH_TO_FILE);
                filePath = scanner.nextLine();
                filePath = checkEmptyLine(scanner, filePath);
                filePath = isLineConvertedIntoPath(scanner, filePath);
            } else {
                break;
            }
        }
        return filePath;
    }

    public static String checkEmptyLine(Scanner scanner, String line) {
        while(true) {
            if (line.isEmpty()) {
                System.out.println(LINE_SHOULD_NOT_EMPTY);
                System.out.print(ENTER_CORRECT_PATH_TO_FILE);
                line = scanner.nextLine();
            } else {
                break;
            }
        }
        return line;
    }

    public static String isOutputFileEqualseSourceFile(Scanner scanner, String outputFile, String sourceFile) {
        while(true) {
            if (outputFile.equals(sourceFile)) {
                System.out.println(OUTPUT_FILE_NOT_EQUALS_SOURCE_FILE);
                System.out.print(ENTER_CORRECT_PATH_TO_FILE);
                outputFile = scanner.nextLine();
                outputFile = checkEmptyLine(scanner, outputFile);
                outputFile = isLineConvertedIntoPath(scanner, outputFile);
            } else {
                break;
            }
        }
        return outputFile;
    }

    public static int parseToNumber(Scanner scanner, String line) {
        int num;
        while(true) {
            try {
                num = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.print(ENTER_NUMBER);
                line = scanner.nextLine();
            }
        }
        return num;
    }

}
