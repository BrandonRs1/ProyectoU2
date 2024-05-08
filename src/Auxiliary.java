import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Auxiliary{
    Scanner scanner = new Scanner(System.in);
    public static String hashString(String input) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Calculate the SHA-256 hash value
            byte[] hash = md.digest(input.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not found.");
            return null;
        }
    }

    /**
     * Check if the username is already registered
     * @param userName is the username
     * @return if is registered
     */
    public boolean checkPass(String userName) {
        for (User user : UserRepository.users) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
