package com.example.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            final Message message = new Message("" + i);
            try {
                Thread.sleep(i);
                queue.put(message);
                System.out.println("produced :" + message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // adding exit message
        final Message message = new Message("exist");
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
