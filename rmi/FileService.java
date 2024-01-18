import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileService extends Remote {
    byte[] compressFile(byte[] fileData) throws RemoteException;
}
