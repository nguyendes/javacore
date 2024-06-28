package com.mycompany.coreadvance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.Random;

class Message {
    private final int id;
    private final String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{id=" + id + ", content='" + content + "'}";
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Message> queue;
    private final Random random = new Random();

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Tạo một message
                int messageId = random.nextInt(1000, 9999);
                Message message = new Message(messageId, "Message " + messageId);

                // Đưa message vào queue, chờ nếu queue đầy
                queue.put(message);
                System.out.println("Produced: " + message);

                // Chờ một thời gian ngẫu nhiên để tạo message tiếp theo
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100, 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Message> queue;
    private final Random random = new Random();

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Lấy message từ queue, chờ nếu không có message
                Message message = queue.take();
                System.out.println("Consumed: " + message);

                // Giả lập thời gian xử lý message
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100, 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class baitap3 {
    public static void main(String[] args) {
        // Kích thước giới hạn của message queue
        int queueSizeLimit = 5;

        // Tạo BlockingQueue với kích thước giới hạn
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>(queueSizeLimit);

        // Tạo và khởi động các thread producer và consumer
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            // Đợi các thread kết thúc (trong thực tế các thread này sẽ chạy vô tận)
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
