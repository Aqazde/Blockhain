import encryption.AsymmetricEncryption;
import encryption.EncryptionUtils;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        try {
            EncryptionUtils encryptionUtils = new EncryptionUtils();
            KeyPair keyPair = AsymmetricEncryption.generateKeyPair();

            String originalMessage = "Hello, world!";
            System.out.println("Original Message: " + originalMessage);

            byte[] encryptedMessage = encryptionUtils.encryptMessage(originalMessage, keyPair);
            System.out.println("Encrypted message: " + new String(encryptedMessage));

            String decryptedMessage = encryptionUtils.decryptMessage(encryptedMessage, keyPair);
            System.out.println("Decrypted message: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
