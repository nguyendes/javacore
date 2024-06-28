import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GiaoDich {
    private String loaigd;
    private int sotien;

    public GiaoDich(String loaigd, int sotien) {
        this.loaigd = loaigd;
        this.sotien = sotien;
    }

    public String getLoaigd() {
        return loaigd;
    }

    public int getSotien() {
        return sotien;
    }

    @Override
    public String toString() {
        return "Giao dich {loai gd: " + loaigd + ", so tien: " + sotien + "}";
    }
}

class Tk {
    private int sodu = 0;

    public synchronized void deposit(int sotien) {
        sodu += sotien;
        System.out.println("Nap " + sotien + ", so du moi: " + sodu);
    }

    public synchronized void withdraw(int sotien) {
        if (sodu >= sotien) {
            sodu -= sotien;
            System.out.println("Rut " + sotien + ", so du moi: " + sodu);
        } else {
            System.out.println("So du khong du de rut " + sotien + ", so du hien tai: " + sodu);
        }
    }
}

public class threadpool {
    public static void main(String[] args) {
        Tk tk = new Tk();

        // Tạo thread pool với số luồng cố định là 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit các giao dịch nạp/rút tiền vào thread pool
        executor.submit(() -> tk.deposit(100));
        executor.submit(() -> tk.withdraw(50));
        executor.submit(() -> tk.deposit(200));
        executor.submit(() -> tk.withdraw(80));

        // Đóng thread pool sau khi hoàn thành
        executor.shutdown();
    }
}

