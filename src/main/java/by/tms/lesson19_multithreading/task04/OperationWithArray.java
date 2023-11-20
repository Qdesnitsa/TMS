package by.tms.lesson19_multithreading.task04;

import java.util.Scanner;

public class OperationWithArray implements Runnable {
    private int[] array;
    public int minValue;
    public int maxValue;
    private boolean isMin;

    public OperationWithArray(boolean isMin, int[] array) {
        this.isMin = isMin;
        this.array = array;
    }

    public static int[] initArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size");
        int arrayLength = scan.nextInt();
        if (arrayLength <= 0) {
            throw new RuntimeException("Array size should be greater than zero.");
        }
        int[] array = new int[arrayLength];
        System.out.println("Insert array elements integers only");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scan.nextInt();
        }
        return array;
    }

    public int findMaxElement(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int findMinElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread " + Thread.currentThread().getName() + "was interrupted.");
        }
        if (this.isMin) {
            this.minValue = this.findMinElement(this.array);
        } else {
            this.maxValue = this.findMaxElement(this.array);
        }
    }
}
