package by.teachmeskills.lesson19_multithreading.task05;

public class Main {
    private static final String FILE_PATH = "src/by/teachmeskills/lesson19_multithreading/task05/output_file.txt";

    public static void main(String[] args) throws InterruptedException {
        SaveAsThread.cleanFile(FILE_PATH);

        Thread th1 = new Thread(new SaveAsThread(FILE_PATH, 5));
        Thread th2 = new Thread(new SaveAsThread(FILE_PATH, 10));
        Thread th3 = new Thread(new SaveAsThread(FILE_PATH, 15));

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println("Successfully");
    }
}

