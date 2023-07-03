import java.io.IOException;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCheckup {

    public static String calculateFileHash(String filePath) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] hashBytes = md.digest(fileBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void checkFilesInFolder(String folderPath) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(folderPath))) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    try {
                        String filePath = path.toString();
                        String fileHash = calculateFileHash(filePath);
                        System.out.println("\nFile: " + filePath + "\n"+"Hash: " + fileHash);
                    } catch (NoSuchAlgorithmException | IOException e) {
                        System.err.println("Error calculating hash for file: " + path);
                    }
                } else if (Files.isDirectory(path)) {
                    checkFilesInFolder(path.toString());
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing folder: " + folderPath);
        }
    }

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\jgabriel\\Downloads\\JavaSecurityHash-main\\JavaSecurityHash-main\\src\\testeHash";
        checkFilesInFolder(folderPath);
    }
}
