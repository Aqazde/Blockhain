package transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {
    private static List<Transaction> transactions = new ArrayList<>();

    // Method to create a new transaction and add it to the list
    public static Transaction createTransaction(String sender, String recipient, double amount) {
        Transaction newTransaction = new Transaction(sender, recipient, amount);
        transactions.add(newTransaction);
        return newTransaction;
    }

    // Method to get all transactions in the list
    public static List<Transaction> getAllTransactions() {
        return transactions;
    }


    // Other utility methods for transaction management, validation, etc.
}
