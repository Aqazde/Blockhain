import encryption.*;
import signature.*;
import consensus.ProofOfWork;
import block.*;
import transaction.Transaction;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Example of Asymmetric Encryption
            EncryptionUtils encryptionUtils = new EncryptionUtils();
            KeyPair keyPair = AsymmetricEncryption.generateKeyPair();

            String originalMessage = "Hello, world!";
            System.out.println("Original Message: " + originalMessage);

            byte[] encryptedMessage = encryptionUtils.encryptMessage(originalMessage, keyPair);
            System.out.println("Encrypted message: " + new String(encryptedMessage));

            String decryptedMessage = encryptionUtils.decryptMessage(encryptedMessage, keyPair);
            System.out.println("Decrypted message: " + decryptedMessage);

            // Example of Digital Signature
            SignatureUtils signatureUtils = new SignatureUtils();
            KeyPair signatureKeyPair = signatureUtils.generateKeyPair();

            String originalData = "Blockchain";
            System.out.println("\nOriginal Data: " + originalData);

            byte[] signature = signatureUtils.signData(originalData.getBytes(), signatureKeyPair);
            System.out.println("Signature: " + new String(signature));

            boolean isSignatureValid = signatureUtils.verifySignature(originalData.getBytes(), signature, signatureKeyPair);
            System.out.println("Is Signature Valid? " + isSignatureValid);

            // Example of Proof of Work (PoW) Consensus Mechanism
            int index = 1;
            long timestamp = System.currentTimeMillis();
            String previousHash = "0";
            String data = "Sample Block Data";

            String minedHash = ProofOfWork.mineBlock(index, timestamp, previousHash, data);

            // Creating a list of transactions (for example purposes)
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(new Transaction("Sender1", "Receiver1", 10.0));
            transactions.add(new Transaction("Sender2", "Receiver2", 20.0));

            // Creating a block with the updated constructor
            Block block = new Block(index, timestamp, transactions, previousHash, minedHash);

            System.out.println("\nMined Block:");
            System.out.println("Index: " + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Mined Hash: " + block.getHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
