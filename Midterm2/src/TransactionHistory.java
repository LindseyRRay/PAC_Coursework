/**
 * Created by lrraymond13 on 11/18/14.
 */
public class TransactionHistory {

    long[] transaction = new long[100];
    int transactionPointer = 0;

    public TransactionHistory() {
    }
    public TransactionHistory(long firstTrans) {
        transaction[0] = firstTrans;
        transactionPointer += 1;
    }
    public void addTransaction(long amt) {
        if (transactionPointer < 100) {
            transaction[transactionPointer] = amt;
            transactionPointer += 1;
        }
        else {
            System.out.println("Cannot add transaction, at limit");
        }
    }

    public long[] getTransaction() {
        return transaction;
    }

}
