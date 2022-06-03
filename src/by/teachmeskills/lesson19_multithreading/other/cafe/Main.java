package by.teachmeskills.lesson19_multithreading.other.cafe;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(10);
        Visitor visitor = new Visitor(sem);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(visitor);
            thread.start();
        }
    }
}
