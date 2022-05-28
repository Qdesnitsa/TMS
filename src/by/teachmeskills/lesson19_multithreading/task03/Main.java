package by.teachmeskills.lesson19_multithreading.task03;

public class Main {
    public static void main(String[] args) {
        StringBuilder stb = new StringBuilder("a");
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MyThreadImpl(stb));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
