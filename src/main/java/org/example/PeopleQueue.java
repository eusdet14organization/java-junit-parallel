package org.example;

public class PeopleQueue extends Thread {

    private String[] names;

    PeopleQueue(String... names) {
        this.names = names;
    }

    @Override
    public void run(){
        for (int i = 0; i <names.length; i++){
            System.out.println("Выдана справка: " + names[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}


class Hospital{
    public static void main(String[] args) {
        PeopleQueue queue1 = new PeopleQueue("Иван","Сергей","Николай","Фердинанд","Василий");
        PeopleQueue queue2 = new PeopleQueue("Мария","Людмила","Алиса","Карина","Ольга");

        System.out.println("Начало работы");
        queue1.start();
        queue2.start();

    }
}