package org.example;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Counter1000Thread thread1 = new Counter1000Thread(counter);
        Counter1000Thread thread2 = new Counter1000Thread(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Значение счетчика: " + counter.getCount());

    }
}

class Counter{
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class Counter1000Thread extends Thread{
    private Counter counter;

    public Counter1000Thread(Counter counter){
        this.counter = counter;
    }

    public void run(){
        for (int i = 0; i <1000; i++){
            counter.increment();
        }
    }
}
