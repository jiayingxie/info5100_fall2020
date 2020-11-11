public class BankAccount {
    private static final int MAX_CHANGE = 100;
    private final Object lock = new Object();
    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(int amount) throws InterruptedException {
        synchronized (lock) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposits "
                    + amount + " , and balance now is " + balance);
            lock.notify();
            Thread.sleep(500);
        }
    }

    public void withdraw(int amount) throws InterruptedException {
        synchronized (lock) {
            if (balance < amount) {
                System.out.println("Sorry, your balance is insufficient.");
                lock.wait();
            } else {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdraws "
                        + amount + " , and balance now is " + balance);
            }
            Thread.sleep(500);
        }
    }

    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Thread depositThread = new Thread(() -> {
            while (true) {
                try {
                    int amount = (int) (Math.random() * bankAccount.MAX_CHANGE);
                    bankAccount.deposit(amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            while (true) {
                try {
                    int amount = (int) (Math.random() * bankAccount.MAX_CHANGE);
                    bankAccount.withdraw(amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();
        withdrawThread.start();
    }
}
