import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompilerService extends Remote {
    byte[] compileAndReturnBytecode(String sourceCode) throws RemoteException;
}
