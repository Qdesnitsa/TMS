package by.teachmeskills.lesson19_multithreading.task01;

public class MyThreadExtend extends Thread {

    public MyThreadExtend(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.err.printf("%s started \n", Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.err.println(i + " " + Thread.currentThread().getName());
        }
        System.err.printf("%s finished \n", Thread.currentThread().getName());
    }
}
