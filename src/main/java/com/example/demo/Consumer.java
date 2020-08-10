package com.example.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
public class Consumer implements Runnable {
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message message;
        try {
            while ((message = queue.take()).getMessage() != "exist") {
                Thread.sleep(10);
                System.out.println("Consumed : " + message.getMessage());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
