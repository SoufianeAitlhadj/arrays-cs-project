package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;

    // 1. Initialize an Array with 1000 in size that stores Double called 'transactions'
    double[] transactions = new double[1000];
    int transactionCount = 0;


    public BankAccount(String name, int startingBalance) {
        this.name = name;
        this.currentBalance = startingBalance;
        transactions[transactionCount++] = startingBalance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            transactions[transactionCount++] = amount;
            System.out.println(name + " deposited $" + amount + ". New balance: $" + currentBalance);
        } else {
            System.out.println("Invalid deposit amount: $" + amount + ". Deposit unsuccessful.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            transactions[transactionCount++] = -amount;
            System.out.println(name + " withdrew $" + amount + ". New balance: $" + currentBalance);
        } else {
            System.out.println("Invalid withdrawal amount: $" + amount + ". Withdrawal unsuccessful.");
        }
    }

    public void displayTransactions() {
        System.out.println("\nTransaction history for " + name + ":");
        for (int i = 0; i < transactionCount; i++) {
            double transaction = transactions[i];
            if (transaction > 0) {
                System.out.println("Deposit: $" + transaction);
            } else if (transaction < 0) {
                System.out.println("Withdrawal: $" + (-transaction));
            } else {
                System.out.println("Starting Balance: $" + transaction);
            }
        }
    }

    public void displayBalance() {
        System.out.println("\nCurrent balance for " + name + ": $" + currentBalance);
    }


    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();
        // ----- DO NOT CHANGE -----
    }
}
