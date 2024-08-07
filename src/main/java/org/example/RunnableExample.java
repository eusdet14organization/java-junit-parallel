package org.example;

public class RunnableExample {
    public static void main(String[] args) {
        System.out.println("Начало потока main");
        Thread myThread = new Thread(new MyThread(), "MyThread");
        Thread myThread1 = new Thread(new MyThread(), "MyThread 1");
        Thread myThread2 = new Thread(new MyThread(), "MyThread 2");
        myThread.start();
        myThread1.start();
        myThread2.start();
        System.out.println("Окончание потока main");
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " Запуск потока: " + Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis() + " Окончание потока " + Thread.currentThread().getName());
    }
}
