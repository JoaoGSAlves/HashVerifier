import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FileIntegrityChecker {

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\jgabriel\\Downloads\\JavaSecurityHash-main\\JavaSecurityHash-main\\src\\testeHash"; // Insira o caminho para a pasta aqui

        Map<String, String> knownHashes = getKnownHashes(); // Obtenha a lista de hashes conhecidos

        try {
            checkIntegrity(folderPath, knownHashes);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getKnownHashes() {
        // Crie um mapa de hashes conhecidos, onde a chave é o nome do arquivo e o valor é o hash correspondente
        Map<String, String> knownHashes = new HashMap<>();
        knownHashes.put("Hino1.txt", "b46de7870e2986f455e3f350bb655b8b03463258c0c1fbc65f46d58d008dd910");
        knownHashes.put("Hino2.txt", "c4561b67033b663bb87ce37d04e1772d9251fccb7a0eaf0118019f0d2ade7ed8");
        // Adicione mais hashes conhecidos conforme necessário

        return knownHashes;
    }

    public static void checkIntegrity(String folderPath, Map<String, String> knownHashes)
            throws IOException, NoSuchAlgorithmException {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Pasta inválida.");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("A pasta está vazia.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String expectedHash = knownHashes.get(fileName);

                if (expectedHash == null) {
                    System.out.println("Arquivo desconhecido: " + fileName);
                    continue;
                }

                String actualHash = calculateSHA256(file);

                if (expectedHash.equalsIgnoreCase(actualHash)) {
                    System.out.println("Arquivo íntegro: " + fileName);
                } else {
                    System.out.println("Arquivo modificado ou infectado: " + fileName);
                }
            }
        }
    }

    public static String calculateSHA256(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] hashBytes = md.digest(fileBytes);

        StringBuilder sb = new StringBuilder();
        for (byte hashByte : hashBytes) {
            sb.append(String.format("%02x", hashByte));
        }

        return sb.toString();
    }
}
