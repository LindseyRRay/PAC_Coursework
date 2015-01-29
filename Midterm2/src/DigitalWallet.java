/**
 * Created by lrraymond13 on 11/18/14.
 */
public class DigitalWallet {
    private long accountID ;
    long balance = 0;
    public TransactionHistory transactions = new TransactionHistory();
    private static double maxWithdrawalPct = .5;

    //Constructors
    public DigitalWallet(long accountID) {
        this.accountID = accountID;
    }
    public DigitalWallet(long accountID, long initialDeposit) {
        this(accountID);
        balance = initialDeposit;
        transactions.addTransaction(initialDeposit);
    }

    //Getter and Setter Methods
    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
    public long getAccountID() {
        return accountID;
    }
    public void setMax(double maxWithdrawalPct) {
        this.maxWithdrawalPct = maxWithdrawalPct;
    }
    public double getMax() {
        return maxWithdrawalPct;
    }

    private boolean amounterrorcheck(long amount) {
        return (amount >= 0);
    }
    public boolean canWithdraw(long amount) {
        return ( (amount <= balance) && (amounterrorcheck(amount)) && (amount <= DigitalWallet.maxWithdrawalPct*balance));
    }

    public void withdraw(long amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
            transactions.addTransaction((-1*amount));
            System.out.println("Successfully withdrew "+amount);
        }
        else {
            System.out.println("Cannot withdraw "+amount);
        }
    }

    public void deposit(long amount){
        if (amount >= 0) {
            balance += amount;
            transactions.addTransaction(amount);
            System.out.println("Successfully deposited "+amount);}
        else {
            System.out.println("Cannot deposit "+amount);

        }
    }

    public void transferFunds(DigitalWallet wallet, long amount) {
      //check if you can withdraw money from this instance and deposit in wallet
        if (canWithdraw(amount)) {
            this.withdraw(amount);
            wallet.deposit(amount);
            System.out.println("Successful transfer of " + amount) ; }
        else {
            System.out.println("Cannot transfer funds");
        }
    }

}
