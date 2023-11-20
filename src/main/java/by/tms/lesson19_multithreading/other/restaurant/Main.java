package by.tms.lesson19_multithreading.other.restaurant;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = new Restaurant(2);
        Thread thread1;
        Thread thread2;
        for (int i = 0; i < 500; i++) {
            thread1 = new Thread(new Guest(restaurant));
            thread2 = new Thread(new Waiter(restaurant));
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        }
    }
}
