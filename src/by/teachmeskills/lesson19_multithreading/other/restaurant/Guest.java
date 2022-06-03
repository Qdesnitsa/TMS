package by.teachmeskills.lesson19_multithreading.other.restaurant;

public class Guest implements Runnable {
    Restaurant restaurant;

    public Guest(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (restaurant.currentOrders < restaurant.totalOrders) {
            restaurant.reserveTable();
        }
        System.out.println("Guest is sent to go home.");
        Thread.currentThread().interrupt();
    }
}


