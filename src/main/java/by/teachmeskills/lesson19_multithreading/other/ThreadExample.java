package by.teachmeskills.lesson19_multithreading.other;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main started");
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("th1 running");
                for (int i = 0; i < 10; i++) {
                    System.out.println("1");
                }
                System.out.println("th1 finished");
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("th2 waiting for th1");
                for (int i = 0; i < 10; i++) {
                    System.out.println("2");
                }
                try {
                    th1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("th2 finished");
            }
        });
        th2.start();
        th1.start();
        System.out.println("Main finished");
    }
}
