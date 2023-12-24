package transaction;
import utils.HashingUtils;

public class Transaction {
    private String sender;
    private String recipient;
    private double amount;
    private String transactionId; // This will be a hash of the transaction

    // Constructor
    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.transactionId = calculateTransactionId();
    }

    // Getters and setters (omitted for brevity)

    // Method to calculate a unique transaction ID (using SHA-256 hash)
    private String calculateTransactionId() {
        String data = sender + recipient + Double.toString(amount);
        return HashingUtils.applySHA256(data);
    }

    // Other methods and functionalities related to transactions
}
