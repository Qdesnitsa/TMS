package by.tms.lesson19_multithreading.task02;

public class Main {
    public static void main(String[] args) {
        System.err.println("Main thread started.");
        for (int i = 1; i < 4; i++) {
            Thread myThread = new Thread(new MyThreadImpl(), "MyThreadImpl_" + i);
            myThread.start();
        }
        System.err.println("Main thread finished.");
    }
}
