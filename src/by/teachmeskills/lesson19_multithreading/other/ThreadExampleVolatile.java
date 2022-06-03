package by.teachmeskills.lesson19_multithreading.other;

public class ThreadExampleVolatile {
    static volatile boolean ready = false;
    static int data = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            sleep(1000);
            data = 1;
            ready = true;
        }).start();

        new Thread(() -> {
            while (!ready) Thread.onSpinWait();
            System.out.println(data);
        }).start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
