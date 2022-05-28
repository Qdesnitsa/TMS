package by.teachmeskills.lesson19_multithreading.task01;

public class Main {
    public static void main(String[] args) {
        System.err.println("Main thread started.");
        new MyThreadExtend("NewThread").start();
        for (int i = 0; i < 100; i++) {
            System.err.println(i + " " + Thread.currentThread().getName());
        }
        System.err.println("Main thread finished.");
    }
}
