package block;
import transaction.Transaction;
import utils.HashingUtils;
import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private List<Transaction> transactions;
    private String previousHash;
    private String hash;
    private int nonce;

    // Constructor
    public Block(int index, long timestamp, List<Transaction> transactions, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.hash = calculateHash(); // Calculate hash when a block is created
        this.nonce = 0; // Initial nonce value
    }

    // Getters and Setters (omitted for brevity)

    // Other methods

    // Method to calculate the hash of the block based on its attributes
    public String calculateHash() {
        String dataToHash = index + timestamp + transactions.toString() + previousHash + nonce;
        return HashingUtils.applySHA256(dataToHash);
    }

    // Other methods related to block functionalities, validation, etc.
}
