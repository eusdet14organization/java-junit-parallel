package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                TimeUnit.SECONDS.sleep(1);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Имя потока: " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        thread.start();
        thread1.start();

        System.out.println("Финиш");

    }
}