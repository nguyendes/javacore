package com.mycompany.coreadvance;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class baitap2 {

    private static volatile boolean running = true;

    public static void main(String[] args) {
        int intervalSeconds = 2; // khoảng thời gian giữa các số ngẫu nhiên (n giây)
        int durationMinutes = 1; // thời gian chạy chương trình (n phút)

        Thread printerThread = new Thread(new RandomNumberTask(intervalSeconds));
        Thread stopperThread = new Thread(new StopperTask(durationMinutes));

        printerThread.start();
        stopperThread.start();

        try {
            stopperThread.join();
            running = false; // Stop the printer thread after the duration is over
            printerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Program has stopped.");
    }

    static class RandomNumberTask implements Runnable {
        private final int intervalSeconds;

        public RandomNumberTask(int intervalSeconds) {
            this.intervalSeconds = intervalSeconds;
        }

        @Override
        public void run() {
            Random random = new Random();

            while (running) {
                int randomNumber = random.nextInt(1000);
                System.out.println("Random number: " + randomNumber);

                try {
                    TimeUnit.SECONDS.sleep(intervalSeconds);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class StopperTask implements Runnable {
        private final int durationMinutes;

        public StopperTask(int durationMinutes) {
            this.durationMinutes = durationMinutes;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MINUTES.sleep(durationMinutes);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            running = false; // Signal the printer thread to stop
        }
    }
}
