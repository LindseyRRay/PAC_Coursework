/**
 * Created by lrraymond13 on 11/18/14.
 */
import java.lang.*;

public class TestDigitalWallet {
    public static void main(String[] args) {
        DigitalWallet w1 = new DigitalWallet(1);
        DigitalWallet w2 = new DigitalWallet(2, 200);

        w1.deposit(100);
        w1.withdraw(50);
        w1.setMax(0.75);
        System.out.println(w1.canWithdraw(4000));

        w2.withdraw(50);
        w2.withdraw(50);

        long bal = w2.balance;

        System.out.println(bal);

        long[] w2Trans = w2.transactions.getTransaction();
        int W2pointer = w2.transactions.transactionPointer;
        long W2sum = 0;

        for (int i= 0; i <= W2pointer; i++){
            W2sum += w2Trans[i];
        }

        System.out.println(W2sum);

        if (W2sum== bal) {
            System.out.println("True"); }
        else {
            System.out.println("False");
        }
        System.out.println(w1.balance);
        System.out.println(w2.balance);

        w1.transferFunds(w2, 25);
        System.out.println(w1.balance);
        System.out.println(w2.balance);

    }
}
