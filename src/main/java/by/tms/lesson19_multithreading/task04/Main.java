package by.tms.lesson19_multithreading.task04;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        var array = OperationWithArray.initArray();
        OperationWithArray min = new OperationWithArray(true, array);
        Thread thr1 = new Thread(min);
        OperationWithArray max = new OperationWithArray(false, array);
        Thread thr2 = new Thread(max);

        thr1.start();
        thr2.start();

        thr1.join();
        thr2.join();

        System.out.println(min.minValue);
        System.out.println(max.maxValue);
    }
}
