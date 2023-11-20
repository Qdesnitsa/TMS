package by.tms.lesson19_multithreading.other.restaurant;

public class Restaurant {
    public final int capacity = 10;
    public final int totalOrders = 20;
    private int cash = 100;
    public int reservedTables;
    public int currentOrders;

    public Restaurant(int reservedTables) {
        this.reservedTables = reservedTables;
    }

    public void reserveTable() {
        synchronized (this) {
            while (reservedTables == capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (cash == 1000) {
                try {
                    Thread thread = new Thread(new Collector(this));
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cash += 50;
            ++reservedTables;
            ++currentOrders;
            System.out.println("Заказ " + currentOrders + ", количество свободных столиков - " + (capacity - reservedTables) + " денег в кассе: " + cash);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }
    }


    public synchronized void releaseTable() {
        while (reservedTables < 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Waiter was interrupted.");
            }
        }
        --reservedTables;
        System.out.println("Минус столик, свободных столиков - " + (capacity - reservedTables));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }


    public void collect() {
        cash = 0;
        System.out.println("Кассу увезли. В кассе денег " + cash);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

