import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {
    protected FileServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public byte[] compressFile(byte[] fileData) throws RemoteException {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater();
            try (DeflaterOutputStream deflaterStream = new DeflaterOutputStream(byteStream, deflater)) {
                deflaterStream.write(fileData);
            }
            return byteStream.toByteArray();
        } catch (IOException e) {
            throw new RemoteException("Error compressing file: " + e.getMessage());
        }
    }
}
