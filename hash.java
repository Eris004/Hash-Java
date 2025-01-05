import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashGenerator {
    public static String generateHash(String text, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(text.getBytes());
        StringBuilder hash = new StringBuilder();
        for (byte b : hashBytes) {
            hash.append(String.format("%02x", b));
        }
        return hash.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to hash: ");
        String text = scanner.nextLine();

        System.out.print("Enter hash algorithm (default sha-256): ");
        String algorithm = scanner.nextLine();
        if (algorithm.isEmpty()) algorithm = "SHA-256";

        try {
            System.out.println("Hash: " + generateHash(text, algorithm));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm: " + algorithm);
        }
    }
}
