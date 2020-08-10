package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
public class ProducerConsumerService {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        final Producer producer = new Producer(queue);
        final Consumer consumer = new Consumer(queue);


        new Thread(producer).start();


        new Thread(consumer).start();

        System.out.println("Producer and Consumer has been started");

    }
}
