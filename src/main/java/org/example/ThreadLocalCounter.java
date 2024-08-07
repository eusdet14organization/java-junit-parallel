package org.example;

public class ThreadLocalCounter {
    private ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 0);

    public void increment(){
        integerThreadLocal.set(integerThreadLocal.get() + 1);
    }

    public int getCounter(){
        return integerThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalCounter counter = new ThreadLocalCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<1000; i++){
                    counter.increment();
                }
                System.out.println(Thread.currentThread().getName() + " counter = " + counter.getCounter());
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Значение счетчика = " + counter.getCounter());

    }
}
