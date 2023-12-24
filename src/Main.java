import encryption.*;
import signature.*;

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

            SignatureUtils signatureUtils = new SignatureUtils();
            KeyPair signatureKeyPair = signatureUtils.generateKeyPair();

            String originalData = "Blockchain";
            System.out.println("\nOriginal Data: " + originalData);

            byte[] signature = signatureUtils.signData(originalData.getBytes(), signatureKeyPair);
            System.out.println("Signature: " + new String(signature));

            boolean isSignatureValid = signatureUtils.verifySignature(originalData.getBytes(), signature, signatureKeyPair);
            System.out.println("Is Signature Valid? " + isSignatureValid);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
