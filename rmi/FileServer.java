import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1091);
            FileService fileService = new FileServiceImpl();
            registry.rebind("FileService", fileService);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
