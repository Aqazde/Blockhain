package signature;

import java.security.*;

public class DigitalSignature {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        // Generate KeyPair for digital signature (public/private key pair)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
        // Sign data using the provided private key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verifySignature(byte[] data, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        // Verify the signature using the provided public key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signatureBytes);
    }
}
