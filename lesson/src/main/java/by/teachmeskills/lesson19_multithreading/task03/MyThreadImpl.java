package by.teachmeskills.lesson19_multithreading.task03;

public class MyThreadImpl implements Runnable {
    private StringBuilder stringBuilder;

    public MyThreadImpl(StringBuilder stb) {
        this.stringBuilder = stb;
    }
    @Override
    public void run() {
        synchronized (stringBuilder) {
            for (int i = 0; i < 100; i++) {
                System.out.printf("%d %s %s \n", i, Thread.currentThread().getName(),stringBuilder.charAt(0));
                //System.out.println(stringBuilder.append(i).append(" ").append(stringBuilder.charAt(0)));
            }
            char two = stringBuilder.charAt(0);
            System.out.printf("%s %s \n", Thread.currentThread().getName(),++two);
        }
    }
}
