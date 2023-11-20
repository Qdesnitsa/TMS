package by.tms.lesson19_multithreading.other.cafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Visitor implements Runnable {

    private Semaphore sem;
    private AtomicInteger count = new AtomicInteger();

    public Visitor(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            increment();
            sleep(300);
            decrement();
            sem.release();
            sleep(300);
        } catch (InterruptedException e) {
            System.out.println("Smth wrong");
        }
    }

    private synchronized AtomicInteger increment() {
        count.incrementAndGet();
        System.out.println("гость садится за стол. " + count + " столов занято.");
        return count;
    }
    private synchronized AtomicInteger decrement() {
        count.decrementAndGet();
        System.out.println("гость поел и выходит из-за стола. " + count + " столов занято.");
        return count;
    }
}
