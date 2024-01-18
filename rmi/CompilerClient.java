import java.nio.file.Files;
import java.nio.file.Path;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CompilerClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("serverHostname", 1099);
            CompilerService compilerService = (CompilerService) registry.lookup("CompilerService");

            // Read the Java source file into a String
            Path sourceFilePath = Path.of("path/to/your/FileToCompile.java");
            String sourceCode = Files.readString(sourceFilePath);

            // Send the source code to the server for compilation
            byte[] compiledBytecode = compilerService.compileAndReturnBytecode(sourceCode);

            // Handle the compiled bytecode as needed
            // For example, you can save it to a .class file
            Path compiledFilePath = Path.of("path/to/your/CompiledClass.class");
            Files.write(compiledFilePath, compiledBytecode);

            System.out.println("Java file compiled and saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
