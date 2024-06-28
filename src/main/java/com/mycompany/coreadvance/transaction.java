package com.mycompany.coreadvance;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
        return "giao dich{loai gd:" + loaigd + ", so tien " + sotien + "}";
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

class TransactionProcessor implements Runnable {
    private Tk tk;
    private BlockingQueue<GiaoDich> transactionQueue;

    public TransactionProcessor(Tk tk) {
        this.tk = tk;
        this.transactionQueue = new LinkedBlockingQueue<>();
    }

    public void addTransaction(GiaoDich gd) {
        try {
            transactionQueue.put(gd);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                GiaoDich gd = transactionQueue.take(); // Blocking call
                processTransaction(gd);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    private void processTransaction(GiaoDich gd) {
        if (gd.getLoaigd().equals("nap")) {
            tk.deposit(gd.getSotien());
        } else if (gd.getLoaigd().equals("rut")) {
            tk.withdraw(gd.getSotien());
        }
    }
}

public class transaction {
    public static void main(String[] args) {
        Tk tk = new Tk();
        TransactionProcessor processor = new TransactionProcessor(tk);
        Thread processorThread = new Thread(processor);
        processorThread.start();

        // Simulate adding transactions
        processor.addTransaction(new GiaoDich("nap", 100));
        processor.addTransaction(new GiaoDich("rut", 50));
        processor.addTransaction(new GiaoDich("nap", 200));
        processor.addTransaction(new GiaoDich("rut", 80));

        // Wait for threads to finish (not necessary in this case since the processor runs indefinitely)
        // You can use a loop to add more transactions or interrupt the thread when needed

        System.out.println("Tat ca giao dich da hoan thanh.");
    }
}