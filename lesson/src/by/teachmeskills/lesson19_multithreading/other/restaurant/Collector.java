package by.teachmeskills.lesson19_multithreading.other.restaurant;

public class Collector implements Runnable{
    private Restaurant restaurant;

    public Collector(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        restaurant.collect();
    }
}
