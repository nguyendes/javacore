package com.mycompany.coreadvance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class bai1advance {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread writeThread = new Thread(new WriteTask());
        Thread readThread = new Thread(new ReadTask());

        writeThread.start();
        readThread.start();

        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class WriteTask implements Runnable {
        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\maytinh\\Downloads\\bl.txt"))) {
                Random random = new Random();
                while (running) {
                    int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
                    writer.write(Integer.toString(randomNumber));
                    writer.newLine();
                    writer.flush();
                    Thread.sleep(1000); // Sleep for 1 second before generating the next number
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReadTask implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (running) {
                String input = scanner.nextLine();
                if ("stop".equalsIgnoreCase(input.trim())) {
                    running = false;
                }
            }
            scanner.close();
        }
    }
}


