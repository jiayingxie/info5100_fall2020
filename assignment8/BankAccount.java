public class BankAccount {
    private static final int MAX_CHANGE = 100; // the upper bound of depositing and withdrawing.
    private final Object lock = new Object();
    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public void deposit(int amount) throws InterruptedException {
        synchronized (lock) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited "
                    + amount + ", and balance now is $" + balance);
            Thread.sleep(500);
        }
    }

    public void withdraw(int amount) throws InterruptedException {
        synchronized (lock) {
            if (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " wanted to withdraw "
                        + amount +", balance is $" + balance + ". Balance is insufficient, so "
                        + Thread.currentThread().getName() + " failed.");
            } else {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew "
                        + amount + ", and balance now is $" + balance);
            }
            Thread.sleep(500);
        }
    }

    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    // Producer is responsible for deposit money.
    class Producer implements Runnable{
        @Override
        public void run() {
            int count = 0;
            while (count < 5) {
                try {
                    int amount = (int) (Math.random() * MAX_CHANGE);
                    deposit(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count += 1;
            }
        }
    }

    // Consumer is responsible for withdraw money.
    class Consumer implements Runnable{
        @Override
        public void run() {
            int count = 0;
            while (count < 5) {
                try {
                    int amount = (int) (Math.random() * MAX_CHANGE);
                    withdraw(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count += 1;
            }
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Producer p = bankAccount.new Producer();
        Consumer c = bankAccount.new Consumer();

        Thread[] threads = new Thread[10];

        // assign job to different threads.
        for (int i = 0; i < 4; ++i) {
            if (i % 2 == 0) {
                threads[i] = new Thread(p);
            } else {
                threads[i] = new Thread(c);
            }
        }

        // start threads.
        for (int i = 0; i < 4; ++i) {
            threads[i].start();
        }

        // join() will promises the rest code in main() will not execute
        // until all producer and consumer threads finish their job.
        for (int i = 0; i < 4; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Closing. \nThe balance is " + bankAccount.getBalance());
    /*
    * console output:
Thread-0 deposited 35, and balance now is $35.0
Thread-1 withdrew 31, and balance now is $4.0
Thread-2 deposited 54, and balance now is $58.0
Thread-3 wanted to withdraw 94, balance is $58.0. Balance is insufficient, so Thread-3 failed.
Thread-2 deposited 34, and balance now is $92.0
Thread-1 withdrew 12, and balance now is $80.0
Thread-0 deposited 23, and balance now is $103.0
Thread-1 withdrew 23, and balance now is $80.0
Thread-2 deposited 87, and balance now is $167.0
Thread-3 withdrew 52, and balance now is $115.0
Thread-2 deposited 9, and balance now is $124.0
Thread-1 withdrew 45, and balance now is $79.0
Thread-0 deposited 50, and balance now is $129.0
Thread-1 withdrew 0, and balance now is $129.0
Thread-2 deposited 72, and balance now is $201.0
Thread-3 withdrew 28, and balance now is $173.0
Thread-0 deposited 79, and balance now is $252.0
Thread-3 withdrew 1, and balance now is $251.0
Thread-0 deposited 93, and balance now is $344.0
Thread-3 withdrew 13, and balance now is $331.0
Closing.
The balance is 331.0
    * */
    }
}
