import java.io.FileWriter;
import java.io.IOException;

public final class FileHandler {
    private FileHandler() { } // Prevent instantiation

    public static void saveToFile(String data) {
        String fileName = "expenses.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true); // Append mode
            fileWriter.write(data + "\n"); // Write data with a newline character at the end
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
