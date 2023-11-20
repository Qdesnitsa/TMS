package by.tms.lesson19_multithreading.other.restaurant;

public class Waiter implements Runnable {
    Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (restaurant.currentOrders < restaurant.totalOrders) {
            restaurant.releaseTable();
        }
        System.out.println("Waiter is sent to go home.");
        Thread.currentThread().interrupt();
    }
}

