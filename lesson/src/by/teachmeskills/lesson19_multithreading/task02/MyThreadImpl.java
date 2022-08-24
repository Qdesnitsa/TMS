package by.teachmeskills.lesson19_multithreading.task02;

public class MyThreadImpl implements Runnable {
    @Override
    public void run() {
        System.err.printf("%s started \n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted.");
        }
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.err.println(i + " " + Thread.currentThread().getName());
            }
        }
        System.err.printf("%s finished \n", Thread.currentThread().getName());
    }
}
