import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("serverHostname", 1099);
            FileService fileService = (FileService) registry.lookup("FileService");

            // Read the file into a byte array
            Path filePath = Path.of("path/to/your/file.txt");
            byte[] fileData = Files.readAllBytes(filePath);

            // Send the file to the server for compression
            byte[] compressedFile = fileService.compressFile(fileData);

            // Handle the compressed file as needed
            // For example, you can write it to a new file
            Path compressedFilePath = Path.of("path/to/your/compressed_file.zip");
            Files.write(compressedFilePath, compressedFile);

            System.out.println("File compressed and saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
