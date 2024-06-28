class Account {
    private int balance = 0;

    // Phương thức nạp tiền
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
        notify(); // Thông báo cho các thread đang đợi rằng tiền đã được nạp
    }

    // Phương thức rút tiền
    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            try {
                System.out.println("Waiting to withdraw: " + amount + ", Current balance: " + balance);
                wait(); // Chờ đến khi có đủ số dư để rút
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ", Balance: " + balance);
    }
}

class DepositTask implements Runnable {
    private Account account;

    public DepositTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.deposit(100);
    }
}

class WithdrawTask implements Runnable {
    private Account account;

    public WithdrawTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(50);
    }
}

public class waitnotify {
    public static void main(String[] args) {
        Account account = new Account();

        // Tạo và khởi chạy các thread để thực hiện nạp và rút tiền
        Thread depositThread = new Thread(new DepositTask(account));
        Thread withdrawThread = new Thread(new WithdrawTask(account));

        withdrawThread.start();
        depositThread.start();

        try {
            withdrawThread.join();
            depositThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All transactions completed.");
    }
}


